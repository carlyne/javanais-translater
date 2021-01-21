package com.example.testtechnique;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class TestTechniqueApplication {

	static String vowels = "aàâeéèêëiïoôöüûuy";
	static String prefix = "av";

	public static void main(String[] args) {
		Boolean userHasQuit = false;

		Scanner promptReader = new Scanner(System.in);
		System.out.println("Bienvenue dans le traducteur français / javanais !\n");

		while (!userHasQuit) {
			String translatedContent =  new String();

			System.out.println("Souhaitez-vous traduire : \n - français <-> javanais (f) \n - javanais <-> français (j)\n");
			String translatorChoosen = promptReader.nextLine();

			System.out.println("Entrez un mot ou une phrase :");
			String userInput = promptReader.nextLine();

			if ( translatorChoosen.toLowerCase().equals("j") ) {
				translatedContent = translaterJavaToFrench(userInput);

			} else {
				translatedContent = translateFrenchToJava(userInput);
			}

			if ( translatedContent.equals(userInput) ) {
				System.out.println("Le texte n'est pas valide, veuillez réessayer");

			} else {
				System.out.println(translatedContent + "\n");
				System.out.println("Souhaitez-vous traduire une autre phase ? (y) / (n)");

				String userResponse = promptReader.nextLine();

				if ( userResponse.toLowerCase().equals("n") ) {
					userHasQuit = true;

				}
			}
		}

		System.out.println("Bonne journée ! N'hésitez pas à faire un tour sur https://github.com/carlyne");
		promptReader.close();
	}

	public static String translateFrenchToJava(String userInput) {
		if ( userInput.isEmpty() ) {
			return userInput;
		}

		String [] splitInput = userInput.split("\\s+");

		for (int i = 0; i < splitInput.length; i++) {
			Pattern pattern = Pattern.compile("((?![" + vowels + "])[a-z])([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(splitInput[i]);

			if (matcher.find()) {
				String matcherWord = matcher.replaceAll(matchResult -> matchResult.group(1) + prefix + matchResult.group(2));
				splitInput[i] = matcherWord.toLowerCase();
			}

			Pattern exceptionPattern = Pattern.compile("^([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcherException = exceptionPattern.matcher(splitInput[i]);

			if (matcherException.find()) {
				String matcherExceptionWord = matcherException.replaceFirst(matchResult -> prefix + matchResult.group(1));
				splitInput[i] = matcherExceptionWord.toLowerCase();
			}
		}

		return String.join(" ", splitInput);
	}

	public static String translaterJavaToFrench(String userInput) {
		if ( userInput.isEmpty() ) {
			return userInput;
		}

		String [] splitInput = userInput.split("\\s+");

		for (int i = 0; i < splitInput.length; i++) {
			Pattern pattern = Pattern.compile("((?![" + vowels + "])[a-z])(" + prefix + ")([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(splitInput[i]);

			if (matcher.find()) {
				String matcherWord = matcher.replaceAll(matchResult -> matchResult.group(1) + matchResult.group(3));
				splitInput[i] = matcherWord.toLowerCase();
			}

			Pattern exceptionPattern = Pattern.compile("^" + prefix + "([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcherException = exceptionPattern.matcher(splitInput[i]);

			if (matcherException.find()) {
				String matcherExceptionWord = matcherException.replaceFirst(matchResult -> matchResult.group(1));
				splitInput[i] = matcherExceptionWord.toLowerCase();
			}
		}

		return String.join(" ", splitInput);
	}
}
