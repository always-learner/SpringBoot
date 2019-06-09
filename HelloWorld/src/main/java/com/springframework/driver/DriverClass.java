package com.springframework.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sam on 9/6/19.
 */
@SpringBootApplication(scanBasePackages = "com.springframework")
public class DriverClass {

    public static void main(String[] args) {
        SpringApplication.run(DriverClass.class, args);
    }
}
