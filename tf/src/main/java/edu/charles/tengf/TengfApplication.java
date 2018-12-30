package edu.charles.tengf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan({"edu.charles.tengf.mapper"})
public class TengfApplication {

    public static void main(String[] args) {
        SpringApplication.run(TengfApplication.class, args);
    }

}

