package com.n11.loanapplication.user.dto.converter;


import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserResponseDto userResponseDto);
    User convertToUser(UserRequestDto userRequestDto);
    UserResponseDto convertToUserDto(User user);
    List<UserResponseDto> convertAllToUserDto(List<User> users);
    List<User> convertAllToUser(List<UserResponseDto> users);
}
