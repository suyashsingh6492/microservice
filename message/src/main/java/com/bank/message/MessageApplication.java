package com.bank.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class MessageApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MessageApplication.class, args);
		String date = "2020-12-23 12:34:56 +00:00".replace(" +","+").replace(" ","T") ;

		OffsetDateTime dateTime = OffsetDateTime.parse(date);
		System.out.println(dateTime);

	}

}
