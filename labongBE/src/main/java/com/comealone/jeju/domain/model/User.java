package com.comealone.jeju.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{
	Long id;
	String userId;
	String userPw;
	String nickName;
	String email;
	String profileImg;
	int gradePoints;
}
