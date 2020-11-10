package com.ameng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ameng.mapper")
public class Day03CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day03CodeApplication.class, args);
    }

}
