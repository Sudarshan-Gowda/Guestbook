package com.guestbook.constants;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {

		String encode = new BCryptPasswordEncoder().encode("P@ssword123");
		System.out.println(encode);
		

	}

}
