package com.dto.user;

import com.dto.userdetail.UserDetailDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<UserDetailDto> userDetailDtoList;
}
