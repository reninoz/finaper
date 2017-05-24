package com.zm.finaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@Configuration
@EnableAutoConfiguration
@ComponentScan("com.zm.finaper")*/

@SpringBootApplication
public class WebAppInitializer{

    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebAppInitializer.class, args);
    }
}

