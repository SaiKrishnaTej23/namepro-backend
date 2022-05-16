package com.wf.nameprobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = { "com.wf.nameprobackend"})
public class NameproBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameproBackendApplication.class, args);
    }

}
