package com.dto.userdetail;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto {

    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postCode;
}
