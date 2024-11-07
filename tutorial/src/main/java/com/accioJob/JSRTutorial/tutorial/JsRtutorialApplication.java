package com.accioJob.JSRTutorial.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsRtutorialApplication implements CommandLineRunner {

	@Autowired  // It connects the object with bean.
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(JsRtutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		db = new ProdDB();
		System.out.println(db.getData());
	}
}
