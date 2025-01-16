package net.engineersdigest.journal.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.engineersdigest.journal.app.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> weatherResponseClass){
        try {
            Object o = redisTemplate.opsForValue().get(key);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonValue = objectMapper.writeValueAsString(o);
            return objectMapper.readValue(jsonValue,weatherResponseClass);
        }catch (Exception e){
            log.error("Exception ,",e);
            return null;
        }

    }
    public void set (String key, Object o, Long ttl ){

         try{
             redisTemplate.opsForValue().set(key,o,ttl, TimeUnit.SECONDS);
         }catch (Exception e){
             log.error("Exception "+e);
         }


    }
}
