package com.acme.hospedaje.hospe.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public HotelMapper hotelMapper() {
        return new HotelMapper();
    }


}
