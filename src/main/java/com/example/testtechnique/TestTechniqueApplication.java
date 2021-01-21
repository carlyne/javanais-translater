package com.example.testtechnique;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class TestTechniqueApplication {

	public static void main(String[] args) {
		Boolean userHasQuit = false;

		Scanner promptReader = new Scanner(System.in);
		System.out.println("Bienvenue dans le traducteur français / javanais ! Entrez une phrase");

		while (!userHasQuit) {
			String userInput = promptReader.nextLine();
			String translatedContent = translater(userInput);

			if ( translatedContent.equals(userInput) ) {
				System.out.println("La phrase n'est pas valide, veuillez réessayer avec une nouvelle phrase");

			} else {
				System.out.println(translatedContent);
				System.out.println("Souhaitez-vous traduire une autre phase ? (Y)/(N)");
				String userResponse = promptReader.nextLine();

				if ( userResponse.toLowerCase().equals("n") ) {
					userHasQuit = true;

				} else {
					System.out.println("Entrez une nouvelle phrase");
				}
			}
		}

		System.out.println("Bonne journée ! N'hésitez pas à faire un tour sur https://github.com/carlyne");
		promptReader.close();
	}

	public static String translater(String userInput) {
		Boolean javaToFrench = false;

		if ( userInput.isEmpty() ) {
			return userInput;
		}

		String [] splitInput = userInput.split("\\s+");

		if (!javaToFrench) {

			for (int i = 0; i < splitInput.length; i++) {

				Pattern pattern = Pattern.compile("((?![aàeioâuéèôöüy])[a-z])([aàeiouéâèôöüy])", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(splitInput[i]);

				if (matcher.find()) {
					String matcherWord = matcher.replaceAll(matchResult -> matchResult.group(1) + "av" + matchResult.group(2));
					splitInput[i] = matcherWord.toLowerCase();
				}

				Pattern exceptionPattern = Pattern.compile("^([aàeioâuéèôöüy])", Pattern.CASE_INSENSITIVE);
				Matcher matcherException = exceptionPattern.matcher(splitInput[i]);

				if (matcherException.find()) {
					String matcherExceptionWord = matcherException.replaceFirst(matchResult -> "av" + matchResult.group(1));
					splitInput[i] = matcherExceptionWord.toLowerCase();
				}
			}
		}

		return String.join(" ", splitInput);
	}
}
