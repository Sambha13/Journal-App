package net.engineersdigest.journal.app.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    private Current current;

    @Getter
    @Setter
    public class Current{

    @JsonProperty("observation_time")
    private String observationTime;

    private int temperature;
    @JsonProperty("weather_descriptions")
    private List<String> weatherDescriptions;


    @Override
        public String toString(){
        return "current{" +
                "observationTime='" + observationTime + '\'' +
                ", temperature=" + temperature +
                '}';
    }

}





}











