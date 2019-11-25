package com.aakashkumar.microservices.config;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @EnableAutoConfiguration
@Configuration
@EntityScan({"com.aakashkumar.microservices.db.entity"})
@EnableJpaRepositories("com.aakashkumar.microservices.db.repository")
@PropertySource(value={"classpath:application-db.properties"})
public class PersistenceConfig {
	
}
