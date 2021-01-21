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

			// Selection du type de traducteur
			System.out.println("Souhaitez-vous traduire : \n - français <-> javanais (f) \n - javanais <-> français (j)\n");
			String translatorChoosen = promptReader.nextLine();

			// Traduction du contenu rentré par l'utilisateur et prise en compte des mots invalides
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

				// Permet à l'utilisateur de traduire un nouveau texte
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

	/**
	 * Ajoute un préfixe "av" devant les voyelles précédées d'une consonne ou si le mot commence par une voyelle
	 * @param userInput
	 * @return
	 */
	public static String translateFrenchToJava(String userInput) {
		if ( userInput.isEmpty() ) {

			// On retourne la phrase qui sera traitée par le prompter comme une entrée invalide
			return userInput;
		}

		String [] splitInput = userInput.split("\\s+");

		for (int i = 0; i < splitInput.length; i++) {

			// On récupère les mots pour leur ajouter ou non un prefix entre une consonne et une voyelle
			// Le pattern suivant cible tous les mots qui possedent une consonne suivie d'une voyelle
			Pattern pattern = Pattern.compile("((?![" + vowels + "])[a-z])([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(splitInput[i]);

			if (matcher.find()) {
				String matcherWord = matcher.replaceAll(matchResult -> matchResult.group(1) + prefix + matchResult.group(2));

				// on change le mot de la phrase seulement s'il doit etre traduis
				splitInput[i] = matcherWord.toLowerCase();
			}

			// Dans le cas où la première lettre est une voyelle, on modifie le mot également
			// Le pattern suivant cible tous les mots qui commencent par une voyelle
			Pattern firstLetterCase = Pattern.compile("^([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcherFirstLetterCase = firstLetterCase.matcher(splitInput[i]);

			if (matcherFirstLetterCase.find()) {
				String matcherExceptionWord = matcherFirstLetterCase.replaceFirst(matchResult -> prefix + matchResult.group(1));
				splitInput[i] = matcherExceptionWord.toLowerCase();
			}
		}

		// On retourne la phrase qui sera traitée par le prompteur
		return String.join(" ", splitInput);
	}

	/**
	 * Supprime préfixe "av" devant les voyelles précédées d'une consonne ou si le mot commence par une voyelle
	 * @param userInput
	 * @return
	 */
	public static String translaterJavaToFrench(String userInput) {
		if ( userInput.isEmpty() ) {
			return userInput;
		}

		String [] splitInput = userInput.split("\\s+");

		for (int i = 0; i < splitInput.length; i++) {

			// On récupère les mots avec un prefix av entre une consonne et une voyelle et on supprime le prefixe
			Pattern pattern = Pattern.compile("((?![" + vowels + "])[a-z])(" + prefix + ")([" + vowels + "])", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(splitInput[i]);

			if (matcher.find()) {
				String matcherWord = matcher.replaceAll(matchResult -> matchResult.group(1) + matchResult.group(3));
				splitInput[i] = matcherWord.toLowerCase();
			}

			// On traite le cas de la première lettre si c'est une voyelle
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
