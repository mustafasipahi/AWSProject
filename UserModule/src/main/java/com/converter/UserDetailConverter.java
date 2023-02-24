package com.converter;

import com.dto.userdetail.UserDetailDto;
import com.model.UserDetail;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDetailConverter {

    public static UserDetailDto convertToUserDetailDto(UserDetail userDetail) {
        return UserDetailDto.builder()
            .phoneNumber(userDetail.getPhoneNumber())
            .address(userDetail.getAddress())
            .city(userDetail.getCity())
            .country(userDetail.getCountry())
            .postCode(userDetail.getPostCode())
            .build();
    }

    public static List<UserDetailDto> convertToUserDetailDto(List<UserDetail> userDetail) {
        return userDetail.stream()
            .map(UserDetailConverter::convertToUserDetailDto)
            .collect(Collectors.toList());
    }
}
