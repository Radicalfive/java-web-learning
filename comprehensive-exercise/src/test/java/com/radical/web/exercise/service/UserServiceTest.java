package com.radical.web.exercise.service;

import com.radical.web.exercise.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class UserServiceTest {

    @Test
    void login() {
        UserService userService = new UserService();
        User user = userService.login("radical", "123");
        if (user != null) {
            log.info(String.valueOf(user));
        }
    }
}