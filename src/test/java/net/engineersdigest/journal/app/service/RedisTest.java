package net.engineersdigest.journal.app.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    public void testSendMail(){
        redisTemplate.opsForValue().set("email","sambhashinde01@gmail.com");
        Object email = redisTemplate.opsForValue().get("salary");
    }
}
