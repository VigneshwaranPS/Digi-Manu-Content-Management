package com.digimenu.Content.Management;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class ContentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentManagementApplication.class, args);
	}

}
