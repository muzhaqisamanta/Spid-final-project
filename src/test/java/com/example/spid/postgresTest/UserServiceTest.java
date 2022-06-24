package com.example.spid.postgresTest;

import com.example.spid.SpidApplication;
import com.example.spid.entities.User;
import com.example.spid.repositories.UserRepository;
import com.example.spid.service.SpidService;
import com.example.spid.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = {SpidApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SpidService spidService;
    @Autowired
    UserRepository userRepository;

    //creates a new user
    @Test
    public void createUserTest() {
        System.out.println(userService.createUser(new User(
                "name", "surname", "no1", "username", "pass", "email@yahoo.com")
        ));
    }

    @Test
    //finds user with id 1
    public void getUserTest() throws Exception {
        System.out.println(userService.getUser(1L));
    }

    //edits user with id 1, from surname=example to surname=updated
    @Test
    public void editUserTest() throws Exception {
        User user = new User("example", "example", "example", "example", "example", "example");
        userService.editUser(1, user);
        user.setSurname("updated");
        System.out.println(user);
    }
}
