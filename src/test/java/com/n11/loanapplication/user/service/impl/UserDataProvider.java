package com.n11.loanapplication.user.service.impl;

import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDataProvider {
    
    public static User getUser(){
        User user = User.builder()
                .id(100L)
                .name("testname")
                .surname("testsurname")
                .dateOfBirthday(LocalDate.now())
                .identificationNumber("11111111111")
                .phone("05555555555")
                .salary(BigDecimal.valueOf(5000))
                .guarantee(BigDecimal.valueOf(5000))
                .build();
        return user;
    }

    public static UserRequestDto getUserCreateDto(){
        UserRequestDto userCreateDto = UserRequestDto.builder()
              //  .id(100L)
                .name("testname")
                .surname("testsurname")
                .dateOfBirthday(LocalDate.now())
                .identificationNumber("11111111111")
                .phone("05555555555")
                .salary(BigDecimal.valueOf(5000))
                .guarantee(BigDecimal.valueOf(5000))
                .build();
        return userCreateDto;
    }

    public static UserResponseDto getUserDto(){
        UserResponseDto userDto = UserResponseDto.builder()
                .id(100L)
                .name("testname")
                .surname("testsurname")
                .dateOfBirthday(LocalDate.now())
                .identificationNumber("11111111111")
                .phone("05555555555")
                .salary(BigDecimal.valueOf(5000))
                .guarantee(BigDecimal.valueOf(5000))
                .build();
        return userDto;
    }

    public static List<UserResponseDto> getAllUserDto(){
        List<UserResponseDto> users = new ArrayList<>();

        for(int i =1;i<10;i++){
            UserResponseDto userDto = UserResponseDto.builder()
                    .id(100L+i)
                    .name("testname"+i)
                    .surname("testsurname"+i)
                    .dateOfBirthday(LocalDate.now())
                    .identificationNumber("1111111111"+i)
                    .phone("0555555555"+i)
                    .salary(BigDecimal.valueOf(5000))
                    .guarantee(BigDecimal.valueOf(5000))
                    .build();
            users.add(userDto);
        }
        return users;
    }
    public static List<User> getAllUser(){
        List<User> users = new ArrayList<>();

        for(int i =1;i<10;i++){
            User user = User.builder()
                    .id(100L+i)
                    .name("testname"+i)
                    .surname("testsurname"+i)
                    .dateOfBirthday(LocalDate.now())
                    .identificationNumber("1111111111"+i)
                    .phone("0555555555"+i)
                    .salary(BigDecimal.valueOf(5000))
                    .guarantee(BigDecimal.valueOf(5000))
                    .build();
            users.add(user);
        }
        return users;
    }
}
