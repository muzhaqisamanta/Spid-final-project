package com.example.spid.postgresTest;

import com.example.spid.SpidApplication;
import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import com.example.spid.entities.enums.Status;
import com.example.spid.entities.enums.Type;
import com.example.spid.service.SpidService;
import com.example.spid.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpidApplication.class})
public class SpidServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    SpidService spidService;

    //creates a new spid connected to the user with id=1
    @Test
    public void createSpidTest() throws Exception {
        User firstUser = userService.getUser(1L);
        Spid newSpid = spidService.createSpid(new Spid(Status.PENDING, Type.LEVEL_1, firstUser));
    }

    //test the list of all spids
    @Test
    public void retrieveAllSpidsTest() throws Exception {
        System.out.println(spidService.retrieveAllSpids());
    }


}
