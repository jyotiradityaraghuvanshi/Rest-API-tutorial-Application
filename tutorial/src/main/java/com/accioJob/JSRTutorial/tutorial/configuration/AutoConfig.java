package com.accioJob.JSRTutorial.tutorial.configuration;

import com.accioJob.JSRTutorial.tutorial.DB;
import com.accioJob.JSRTutorial.tutorial.DevDB;
import com.accioJob.JSRTutorial.tutorial.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "production")
    public DB getPBBean(){
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "development")
    public DB getDBBean(){
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
