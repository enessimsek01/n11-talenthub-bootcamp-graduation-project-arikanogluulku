package com.n11.loanapplication.user.service.impl;

import com.n11.loanapplication.gen.exception.UserNotFound;
import com.n11.loanapplication.user.dto.converter.UserMapper;
import com.n11.loanapplication.user.repository.UserRepository;
import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.model.User;
import com.n11.loanapplication.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        logger.info("Users listed");
        return UserMapper.INSTANCE.convertAllToUserDto(users);
    }
    @Override
    public UserResponseDto getOneUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFound("User with id :"+ id +" could not be found."));
        UserResponseDto userResponseDto = UserMapper.INSTANCE.convertToUserDto(user);
        logger.info("User : {} " ,userResponseDto);
        return userResponseDto;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User newUser = UserMapper.INSTANCE.convertToUser(userRequestDto);
        newUser= userRepository.save(newUser);
        UserResponseDto userResponseDto = UserMapper.INSTANCE.convertToUserDto(newUser);
        logger.info("User Created : {} " ,userResponseDto);
        return userResponseDto;
    }

    @Override
    public void deleteUser(Long userId) {
        getOneUser(userId);
        userRepository.deleteById(userId);
        logger.info("User Deleted ID: {} " ,userId);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
      UserResponseDto user = getOneUser(userId);
      User toUpdate= UserMapper.INSTANCE.convertToUser(userRequestDto);
      toUpdate.setId(user.getId());
      userRepository.save(toUpdate);
      logger.info("User Updated : {} " ,userId);
      return UserMapper.INSTANCE.convertToUserDto(toUpdate);
    }

    @Override
    public UserResponseDto getUserByIdentificationNumber(String identificationNumber) {
        User user = userRepository.findByIdentificationNumber(identificationNumber);
        UserResponseDto userResponseDto = UserMapper.INSTANCE.convertToUserDto(user);
        logger.info("Fetch by user identification number : {} " ,userResponseDto);
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateByUserSalaryAndGuaranteeAndPhone(Long userId,BigDecimal salary, BigDecimal guarante, String phone) {
        UserResponseDto user = getOneUser(userId);
        user.setSalary(salary);
        user.setPhone(phone);
        user.setGuarantee(guarante);
        User toUpdate = UserMapper.INSTANCE.convertToUser(user);
        userRepository.save(toUpdate);
        logger.info("User salary,guarante and phone updated.");
        return UserMapper.INSTANCE.convertToUserDto(toUpdate);
    }


}
