package com.n11.loanapplication.user.controller;

import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "get all users")
    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
     List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
     return ResponseEntity.status(200).body(userResponseDtoList);
    }

    @ApiOperation(value = "get one user")
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseDto> getOneUser(@PathVariable Long userId){
        UserResponseDto userResponseDto = userService.getOneUser(userId);
        return ResponseEntity.status(200).body(userResponseDto);
    }

    @ApiOperation(value = "create a user")
    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto);
        return ResponseEntity.status(201).body(user);
    }

    @ApiOperation(value = "delete a user")
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(value = "update a user")
    @PutMapping("/{userId}" )
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId , @Valid @RequestBody UserRequestDto userRequestDto){
        UserResponseDto updatedUser = userService.updateUser(userId, userRequestDto);
        return ResponseEntity.status(200).body(updatedUser);
    }
}
