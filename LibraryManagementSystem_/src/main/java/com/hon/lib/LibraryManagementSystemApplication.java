package com.hon.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("*** Starting Application ***");
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

}
