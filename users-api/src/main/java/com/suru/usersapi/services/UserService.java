package com.suru.usersapi.services;

import com.suru.usersapi.domain.models.User;
import com.suru.usersapi.domain.requests.UserCreateRequest;
import com.suru.usersapi.domain.responses.EntityResponse;
import com.suru.usersapi.domain.responses.UserRepository;
import com.suru.usersapi.domain.responses.UserResponse;
import com.suru.usersapi.exceptions.UserAlreadyRegisteredException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public EntityResponse createUser(UserCreateRequest request) throws UserAlreadyRegisteredException {
        User userByEmail = userRepository.findFirstByEmail(request.getEmail());
        if (userByEmail == null) {
            UUID userId = UUID.randomUUID();
            User user = new User();
            user.setEmail(request.getEmail());
            user.setName(request.getName());
            user.setPhone(request.getPhone());
            user.setUuid(userId);

            User save = userRepository.save(user);

            return new EntityResponse(save.getUuid());
        } else {
            throw new UserAlreadyRegisteredException();
        }
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findUserByDeletedFalse();

        return users.stream().map(user -> {
            var response = new UserResponse();
            response.setUuid(user.getUuid());
            response.setEmail(user.getEmail());
            response.setName(user.getName());
            response.setPhone(user.getPhone());
            response.setActive(user.getActive());
            return response;
        }).collect(Collectors.toList());
    }
}
