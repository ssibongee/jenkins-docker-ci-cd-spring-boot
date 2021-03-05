package com.ssibongee.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args)
    }

}
