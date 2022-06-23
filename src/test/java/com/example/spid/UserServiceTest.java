package com.example.spid;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import com.example.spid.entities.enums.Status;
import com.example.spid.entities.enums.Type;
import com.example.spid.service.SpidService;
import com.example.spid.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpidApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SpidService spidService;

    @Test
    public void createUserTest() {
        System.out.println(userService.createUser(new User(
                "name", "surname", "no1", "username", "pass", "email@yahoo.com")
        ));
    }

    @Test
    public void createSpidTest() {
        System.out.println(spidService.createSpid(new Spid(Status.PENDING, Type.LEVEL_1, new User())));
    }

    @Test
    public void editUser() throws Exception {
        User user = new User("example", "example", "example", "example", "example", "example");
        userService.editUser(1, user);
        user.setSurname("updated");
        System.out.println(user);
    }

}
