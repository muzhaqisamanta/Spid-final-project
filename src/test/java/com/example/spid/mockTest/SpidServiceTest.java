package com.example.spid.mockTest;

import com.example.spid.SpidApplication;
import com.example.spid.entities.Spid;
import com.example.spid.entities.enums.Status;
import com.example.spid.service.SpidService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpidApplication.class})

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SpidServiceTest {

    @Mock
    SpidService spidService;

    @BeforeAll
    public void setup() throws Exception {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(Status.READY_FOR_REVIEW);

        when(spidService.changeStatus(spid.getId())).thenReturn(spid);
    }

    @Test
    public void testDatabaseRetrievalForSpids() throws Exception {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(Status.READY_FOR_REVIEW);
        assertEquals(spid, spidService.changeStatus(spid.getId()));
    }
}
