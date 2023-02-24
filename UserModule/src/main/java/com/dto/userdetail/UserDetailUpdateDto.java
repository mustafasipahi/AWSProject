package com.dto.userdetail;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailUpdateDto {

    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postCode;
}
