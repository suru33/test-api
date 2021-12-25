package com.suru.usersapi.controllers;

import com.suru.usersapi.domain.requests.UserCreateRequest;
import com.suru.usersapi.domain.responses.EntityResponse;
import com.suru.usersapi.domain.responses.UserResponse;
import com.suru.usersapi.exceptions.UserAlreadyRegisteredException;
import com.suru.usersapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EntityResponse createUser(@RequestBody UserCreateRequest request) throws UserAlreadyRegisteredException {
        return userService.createUser(request);
    }

    @GetMapping
    @RequestMapping(path = "/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

}
