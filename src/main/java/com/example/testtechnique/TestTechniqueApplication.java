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
		Boolean userHasQuit = false;

		/*	On fait une boucle, tant que l'utilisateur veut traduire des phrases :

				Si translatedContent est le meme contenu que celui passé en paramètre :
					le texte est invalide : texte vide ou ne contient qu'une série de chiffre
					On demande au user de rentrer un nouvel input
					on récupère l'input et on retraduis

				Si translateContent est différent du contenu passé en paramètre
					On affiche le contenu traduit
					On demande à l"utilisateur s'il veut rentrer une nouvelle phrase

					Si l'utilisateur dit oui :
						on récupère l'input et on retraduis

					Si non :
						userHasQuit = true

			On ferme le prompter
		 */
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

		return input;
	}
}
