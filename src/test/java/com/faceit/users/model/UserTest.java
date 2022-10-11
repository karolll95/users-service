package com.faceit.users.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {

    @Test
    void newUserHaveGeneratedId() {
        //given
        var user = new User();

        //when
        var userId = user.getId();

        //then
        assertNotNull(userId);
    }
}