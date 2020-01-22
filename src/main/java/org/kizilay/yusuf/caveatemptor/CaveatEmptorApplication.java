package org.kizilay.yusuf.caveatemptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class CaveatEmptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaveatEmptorApplication.class, args);
    }

}
