package com.n11.loanapplication.user.service;

import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto getOneUser(Long userId);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    void deleteUser(Long userId);

    UserResponseDto updateUser(Long userId , UserRequestDto userRequestDto);

    UserResponseDto getUserByIdentificationNumber(String identificationNumber);

    UserResponseDto updateByUserSalaryAndGuaranteeAndPhone(Long userId,BigDecimal salary, BigDecimal guarante , String phone);

}
