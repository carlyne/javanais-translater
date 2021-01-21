package com.example.testtechnique;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class TestTechniqueApplication {

	public static void main(String[] args) {
		Scanner promptReader = new Scanner(System.in);

		System.out.println("Entrez une phrase");
		String input = promptReader.nextLine();

		String translatedContent = translater(input);

		System.out.println(translatedContent);

		promptReader.close();
		//SpringApplication.run(TestTechniqueApplication.class, args);
	}

	public static String translater(String input) {
		return input;
	}
}
