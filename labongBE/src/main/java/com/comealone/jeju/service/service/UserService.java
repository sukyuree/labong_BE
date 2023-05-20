package com.comealone.jeju.service.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comealone.jeju.domain.model.User;
import com.comealone.jeju.domain.repository.UserRepository;
import com.comealone.jeju.service.dto.TokenDto;
import com.comealone.jeju.service.request.LoginReq;
import com.comealone.jeju.service.request.SignUpReq;
import com.comealone.jeju.util.jwt.TokenProvider;
import com.comealone.jeju.util.security.SecurityUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    private User findCurrentUser(){
        User user = userRepository.findById(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        return user;
    }
    
    public boolean isExistEmail(String email) {
        User byEmail = userRepository.findByEmail(email).orElse(null);
        return byEmail != null;
    }

    public boolean isExistUserId(String userId) {
        User byUserId = userRepository.findByUserId(userId).orElse(null);
        return byUserId != null;
    }

    public boolean isExistNickName(String nickName) {
        User byNickName = userRepository.findByNickName(nickName).orElse(null);
        return byNickName != null;
    }
    
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
    
    public boolean matchPassword(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElse(null);
        return passwordEncoder.matches(password, user.getUserPw());
    }
    
    @Transactional
    public void save(SignUpReq signUpReq) {
        userRepository.save(signUpReq.toUserModel());
    }
    
    public TokenDto createToken(LoginReq loginReq) {
        // 1. Longin Id/pw 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginReq.getUserId(), loginReq.getUserPw());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이루어지는 부분
        // authenticate 메서드가 실행이 될 때 CustomUserDetailService 에서 만들었던 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

//        // 4. RefreshToken 저장
//        RefreshToken refreshToken = RefreshToken.builder()
//                .key(authentication.getName())
//                .value(tokenDto.getRefreshToken())
//                .build();
//        refreshTokenRepository.save(refreshToken);
        
        // 5. 토큰 발금
        return tokenDto;
    }
}
