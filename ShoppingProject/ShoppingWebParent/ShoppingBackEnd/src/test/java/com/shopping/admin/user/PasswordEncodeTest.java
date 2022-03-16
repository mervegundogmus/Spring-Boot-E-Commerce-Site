package com.shopping.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeTest {
	@Test
	public void testEncodePassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "merve2022";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		passwordEncoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
		boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertThat(matches).isTrue();
	}

}
