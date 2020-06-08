package com.arakaru.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	static String[] Words;
	private static int syllables = 0;
	private static int polysyllables = 0;

	static void initPoly() {

		for (int i = 0; i < Words.length; i++) {
			int poly = 0;
			String temp = Words[i].replaceAll("!|\\?|\\. *", "");
			Matcher match = Pattern.compile("e$").matcher(temp);
			while (match.find()) {
				temp = match.replaceAll("");
			}
			match = Pattern.compile("([aioeuyAEIOUY])").matcher(temp);
			if (!match.find()) {
				syllables += 1;
			}
			match = Pattern.compile("([aioeuyAEIOUY]){2,3}").matcher(temp);

			while (match.find()) {
				syllables += 1;
				poly += 1;
			}

			temp = match.replaceAll("");

			match = Pattern.compile("[aioeuyAEIOUY]").matcher(temp);

			while (match.find()) {
				poly += 1;
				syllables++;

			}
			if (poly > 2)
				polysyllables += 1;
		}

	}

	static String getAge(int argAge) {
		String years = "";
		switch (argAge) {

		case (1):
			years = "about 6 year olds";
			break;
		case (2):
			years = "about 7 year olds)";
			break;
		case (3):
			years = "about 9 year olds";
			break;
		case (4):
			years = "about 10 year olds";
			break;
		case (5):
			years = "about 11 year olds";
			break;
		case (6):
			years = "about 12 year olds";
			break;
		case (7):
			years = "about 13 year olds";
			break;
		case (8):
			years = "about 14 year olds";
			break;
		case (9):
			years = "about 15 year olds";
			break;
		case (10):
			years = "about 16 year olds";
			break;
		case (11):
			years = "about 17 year olds";
			break;
		case (12):
			years = "about 18 year olds";
			break;
		case (13):
			years = "about 24 year olds";
			break;

		}
		return years;
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File("src/com/arakaru/jetbrains/dataset_91007.txt"))) {

			int scoreForAge[] = new int[4];
			double score[] = new double[4];

			while (scanner.hasNextLine()) {

				String param = scanner.nextLine();
				String[] Sentences = param.split("!|\\?|\\. *");
				Words = param.split(" ");
				String Characters = param.replaceAll("[ \\t\\n]", "");
				initPoly();

				System.out.println("Words: " + Words.length);
				System.out.println("Sentences: " + Sentences.length);
				System.out.println("Characters: " + Characters.length());
				System.out.println("Syllables: " + syllables);
				System.out.println("Polysyllables: " + polysyllables);

				System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
				Scanner chooseScore = new Scanner(System.in);

				switch (chooseScore.nextLine()) {
				case ("ARI"):
					score[0] = new Automated(Sentences, Words, Characters).getScore();
					scoreForAge[0] = (int) Math.round(score[0]);
					System.out
							.println("Automated Readability Index: " + score[0] + " (" + getAge(scoreForAge[0]) + ").");
					break;
				case ("FK"):
					score[0] = new FleschKincaid(Sentences, Words, syllables).getScore();
					scoreForAge[0] = (int) Math.round(score[0]);
					System.out.println(
							"Flesch–Kincaid readability tests: " + score[0] + " (" + getAge(scoreForAge[0]) + ").");
					break;
				case ("SMOG"):
					score[0] = new Smog(polysyllables, Sentences).getScore();
					scoreForAge[0] = (int) Math.round(score[0]);
					System.out.println(
							"Simple Measure of Gobbledygook: " + score[0] + " (" + getAge(scoreForAge[0]) + ").");
					break;
				case ("CL"):
					score[0] = new ColemanLiau(Sentences, Characters, Words).getScore();
					scoreForAge[0] = (int) Math.round(score[0]);
					System.out.println("Coleman–Liau index:: " + score[0] + " (" + getAge(scoreForAge[0]) + ").");
					break;
				case ("all"): {
					score[0] = new Automated(Sentences, Words, Characters).getScore();
					scoreForAge[0] = (int) Math.round(score[0]);
					score[1] = new FleschKincaid(Sentences, Words, syllables).getScore();
					scoreForAge[1] = (int) Math.round(score[1]);
					score[2] = new Smog(polysyllables, Sentences).getScore();
					scoreForAge[2] = (int) Math.round(score[2]);
					score[3] = new ColemanLiau(Sentences, Characters, Words).getScore();
					scoreForAge[3] = (int) Math.round(score[3]);
					//System.out.println(;)
					
					System.out
							.println("\nAutomated Readability Index: " + score[0] + " (" + getAge(scoreForAge[0]) + ").");
					System.out.println(
							"Flesch–Kincaid readability tests: " + score[1] + " (" + getAge(scoreForAge[1]) + ").");
					System.out.println(
							"Simple Measure of Gobbledygook: " + score[2] + " (" + getAge(scoreForAge[2]) + ").");
					System.out.println("Coleman–Liau index:: " + score[3] + " (" + getAge(scoreForAge[3]) + ").");

				}

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
