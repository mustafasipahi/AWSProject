package com.converter;

import com.dto.user.UserCreateDto;
import com.dto.user.UserDto;
import com.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .userDetailDtoList(UserDetailConverter.convertToUserDetailDto(user.getUserDetailList()))
            .build();
    }

    public static User convertToUser(UserCreateDto userCreateDto) {
        return User.builder()
            .firstName(userCreateDto.getFirstName())
            .lastName(userCreateDto.getLastName())
            .email(userCreateDto.getEmail())
            .build();
    }
}
