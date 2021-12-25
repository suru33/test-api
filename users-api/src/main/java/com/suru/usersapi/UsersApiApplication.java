package com.suru.usersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApiApplication.class, args);
    }

}


//FE/any service -> (HTTP req)controller -> Service -> (repo)

// 1. create
// 2. all users
// 3. update
// 4. delete
// 5. activate or deactivate
