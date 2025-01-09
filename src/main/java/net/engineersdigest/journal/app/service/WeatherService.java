package net.engineersdigest.journal.app.service;

import net.engineersdigest.journal.app.api.response.WeatherResponse;
import net.engineersdigest.journal.app.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    AppCache appCache;




    @Autowired
    private RestTemplate restTemplate;
     public WeatherResponse getWeather(String city){

          String finalAPI = appCache.APP_CACHE.get("weather_api").replace("<city>",city).replace("<apikey>",apikey);
          ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
         WeatherResponse body = response.getBody();
         return body;
     }
}
