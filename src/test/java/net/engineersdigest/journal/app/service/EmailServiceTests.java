package net.engineersdigest.journal.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;
    @Test
    void testSendEmail(){

        emailService.sendEmail("sambhashinde01@gmail.com","testing Java mail Sender","Hi");
    }

}
