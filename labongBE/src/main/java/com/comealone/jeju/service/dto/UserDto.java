package com.comealone.jeju.service.dto;

import com.comealone.jeju.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    Long id;
    String userId;
    String nickName;
    String email;
    String profileImg;
    int gradePoints;
    List<String> follower;
    List<String> following;

    public UserDto(User user, List<String> follower, List<String> following){
        this.id = user.getId();
        this.userId = user.getUserId();
        this.nickName = user.getNickName();
        this.email = user.getEmail();
        this.profileImg = user.getProfileImg();
        this.gradePoints = user.getGradePoints();
        this.follower = follower;
        this.following = following;
    }
}
