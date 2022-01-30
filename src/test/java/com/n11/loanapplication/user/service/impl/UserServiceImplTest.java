package com.n11.loanapplication.user.service.impl;

import com.n11.loanapplication.gen.exception.UserNotFound;
import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.dto.converter.UserMapper;
import com.n11.loanapplication.user.model.User;
import com.n11.loanapplication.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.n11.loanapplication.user.service.impl.UserDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    private UserMapper mapper;

    @Test
     void shouldGetAllUsers() {
        List<UserResponseDto> userDtoList = getAllUserDto();
        List<User> userList = getAllUser();

        when(userRepository.findAll()).thenReturn(userList);

        List<UserResponseDto> resultList = userService.getAllUsers();
        assertEquals(userDtoList, resultList);

        verify(userRepository).findAll();
    }

    @Test
    void shouldGetOneUser() {
        UserResponseDto userResponseDto = getUserDto();
        User user = getUser();

        when(userRepository.findById(100L)).thenReturn(Optional.ofNullable(user));

        UserResponseDto result = userService.getOneUser(100L);

        assertEquals(result, userResponseDto);
    }

    @Test
    void shouldNotGetOneUserWhenUserNotExist() {
        when(userRepository.findById(0L)).thenThrow(new UserNotFound("User Not Found."));

        assertThrows(RuntimeException.class, () -> userService.getOneUser(0L));

        verify(userRepository).findById(0L);

        verifyNoInteractions(mapper);
    }

    @Test
    void shouldCreateUser() {
        UserRequestDto createUser = getUserCreateDto();
        User userSaved = getUser();
        UserResponseDto userDto = getUserDto();

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(userSaved);

        UserResponseDto result = userService.createUser(createUser);

        assertEquals(userDto, result);

    }

    @Test
    void shouldDeleteUser() {
        User user = getUser();
        when(userRepository.findById(100L)).thenReturn(Optional.ofNullable(user));
        userService.deleteUser(100L);
        verify(userRepository).deleteById(100L);
    }

    @Test
    void shouldNotDeleteWhenUserNotExist() {
        when(userRepository.findById(100L)).thenThrow(new UserNotFound("User Not Found."));
        assertThrows(UserNotFound.class, () -> userService.deleteUser(100L));
        verify(userRepository).findById(100L);
    }

    @Test
    void shouldUpdateUser() {
        UserRequestDto userRequestDto = getUserCreateDto();
        User user = getUser();
        UserResponseDto userResponseDto = getUserDto();

        when(userRepository.findById(100L)).thenReturn(Optional.ofNullable(user));
        when(userRepository.save(user)).thenReturn(user);
        when(mapper.convertToUserDto(user)).thenReturn(userResponseDto);

        UserResponseDto result = userService.updateUser(100L, userRequestDto);

        assertEquals(userResponseDto, result);

    }

    @Test
    void shouldNotUpdateUserWhenUserNotExist() {
        UserRequestDto userRequestDto = getUserCreateDto();

        when(userRepository.findById(100L)).thenThrow(new UserNotFound("User Not Found."));

        assertThrows(UserNotFound.class, () -> userService.updateUser(100L, userRequestDto));

        verify(userRepository).findById(100L);
    }

    @Test
    void shouldUpdateByUserSalaryAndGuaranteeAndPhone() {
        UserResponseDto userResponseDto = getUserDto();
        User user = getUser();

        userResponseDto.setPhone("05415414141");
        userResponseDto.setGuarantee(BigDecimal.valueOf(1000));
        userResponseDto.setSalary(BigDecimal.valueOf(1000));

        when(userRepository.findById(100L)).thenReturn(Optional.ofNullable(user));
        when(userRepository.save(ArgumentMatchers.any())).thenReturn(user);
        when(mapper.convertToUserDto(user)).thenReturn(userResponseDto);

        UserResponseDto result = userService.updateByUserSalaryAndGuaranteeAndPhone(100L,
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000),
                "05415414141");

        assertEquals(result, userResponseDto);
    }

    @Test
    void shouldNotshouldUpdateByUserSalaryAndGuaranteeAndPhoneWhenUserNotExist() {

        when(userRepository.findById(100L)).thenThrow(new UserNotFound("User Not Found."));

        assertThrows(UserNotFound.class, () -> userService.updateByUserSalaryAndGuaranteeAndPhone(100L, BigDecimal.valueOf(1000),BigDecimal.valueOf(1000), "05415414141"));

        verify(userRepository).findById(100L);
    }

    @Test
    void shouldGetUserByIdentificationNumber() {
        UserResponseDto userResponseDto = getUserDto();
        User user = getUser();

        when(userRepository.findByIdentificationNumber("11111111111")).thenReturn(user);
        when(mapper.convertToUserDto(user)).thenReturn(userResponseDto);

        UserResponseDto result = userService.getUserByIdentificationNumber("11111111111");

        assertEquals(result, userResponseDto);
    }


}