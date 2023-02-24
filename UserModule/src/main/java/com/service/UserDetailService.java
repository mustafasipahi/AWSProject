package com.service;

import com.advice.exception.UserDetailNotFoundException;
import com.converter.UserDetailConverter;
import com.dto.userdetail.UserDetailCreateDto;
import com.dto.userdetail.UserDetailDto;
import com.dto.userdetail.UserDetailUpdateDto;
import com.model.User;
import com.model.UserDetail;
import com.repository.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailService {

    private final UserService userService;
    private final UserDetailRepository userDetailRepository;

    @Transactional
    public UserDetailDto create(UserDetailCreateDto userDetailCreateDto) {
        final User user = userService.findById(userDetailCreateDto.getUserId());

        final UserDetail userDetail = UserDetail.builder()
            .phoneNumber(userDetailCreateDto.getPhoneNumber())
            .address(userDetailCreateDto.getAddress())
            .city(userDetailCreateDto.getCity())
            .country(userDetailCreateDto.getCountry())
            .postCode(userDetailCreateDto.getPostCode())
            .user(user)
            .build();

        return UserDetailConverter.convertToUserDetailDto(userDetailRepository.save(userDetail));
    }

    @Transactional
    public UserDetailDto update(Long userDetailId, UserDetailUpdateDto userDetailUpdateDto) {
        final UserDetail userDetail = findById(userDetailId);

        final UserDetail updateUserDetail = UserDetail.builder()
            .id(userDetail.getId())
            .phoneNumber(userDetailUpdateDto.getPhoneNumber())
            .address(userDetailUpdateDto.getAddress())
            .city(userDetailUpdateDto.getCity())
            .country(userDetailUpdateDto.getCountry())
            .postCode(userDetailUpdateDto.getPostCode())
            .user(userDetail.getUser())
            .build();

        return UserDetailConverter.convertToUserDetailDto(userDetailRepository.save(updateUserDetail));
    }

    public void delete(Long userDetailId) {
        final UserDetail userDetail = findById(userDetailId);
        userDetailRepository.delete(userDetail);
    }

    private UserDetail findById(Long userDetailId) {
        return userDetailRepository.findById(userDetailId)
            .orElseThrow(UserDetailNotFoundException::new);
    }
}
