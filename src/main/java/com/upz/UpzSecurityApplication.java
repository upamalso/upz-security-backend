package com.upz;


import com.upz.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class UpzSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpzSecurityApplication.class, args);
    }

}
