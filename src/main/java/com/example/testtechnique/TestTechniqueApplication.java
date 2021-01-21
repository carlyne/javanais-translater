package com.example.testtechnique;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class TestTechniqueApplication {

	public static void main(String[] args) {
		Scanner promptReader = new Scanner(System.in);
		System.out.println("Bienvenue dans le traducteur français / javanais ! Entrez une phrase");

		Boolean userHasQuit = false;

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

	public static String translater(String input) {

		/*
			Si input est vide :
				On renvoi l'input vide
		 */

		/*	Cas pour un mot français dans une phrase :

			On fait une substring pour isoler chaque mot
			On va insérer "av" dans le mot en utilisant un pattern regex
			A tester sur regex 101 kkchose comme : /((?![aeiou])[a-z]{2})([aeiou])/ig
			Pour faire deux groupes : un avec la consonne et un avec la voyelle qui suit (case insensitive)
			Comme ça avec un string.replace on peut remplacer cette portion avec la consonne (ciblée dans le premier groupe) + av + rajouter la voyelle (deuxième groupe)


			Cas mot javanais

			On fait une substring pour isoler chaque mot
			On fait une regex pur capturer un "av" entre une consnne et une voyelle, kkchose comme : /(?:(?![aeiou])[a-z])(av)(?:[aeéèioôöuü])/ig
			Ensuite on la remplace par du rien pur la supprimer
		 */

		/*
			On retransforme la substring en string avant de la retourner
		 */

		return "bavonjavour";
	}
}
