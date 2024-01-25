package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void encryptTest(){
		String plainPassword = "1231231231231";
		String encodedPassword = passwordEncoder.encode(plainPassword);

		System.out.println("=================== EncryptPassword ====================");
		System.out.println(encodedPassword);
		System.out.println("=================== EncryptPassword ====================");

		assertAll(
				() -> assertNotEquals(plainPassword, encodedPassword),
				() -> assertTrue(passwordEncoder.matches(plainPassword, encodedPassword))
		);
	}

}
