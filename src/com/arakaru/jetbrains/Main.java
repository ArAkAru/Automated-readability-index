package com.arakaru.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
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

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File("src/com/arakaru/jetbrains/dataset_91007.txt"))) {

			int scoreForAge;

			double score = 0;

			String years = "";
			while (scanner.hasNextLine()) {

				String param = scanner.nextLine();
				String[] Sentences = param.split("!|\\?|\\. *");
				Words = param.split(" ");
				String Characters = param.replaceAll("[ \\t\\n]", "");
				initPoly();

				// score=new FleschKincaid(Sentences,Words,syllables).getScore();
				score = new Automated(Sentences, Words, Characters).getScore();
				// score = new Smog(polysyllables, Sentences).getScore();
				scoreForAge = (int) Math.floor(score);

				switch (scoreForAge) {

				case (1):
					years = "6 year olds.";
					break;
				case (2):
					years = "7 year olds.";
					break;
				case (3):
					years = "9 year olds.";
					break;
				case (4):
					years = "10 year olds.";
					break;
				case (5):
					years = "11 year olds.";
					break;
				case (6):
					years = "12 year olds.";
					break;
				case (7):
					years = "13 year olds.";
					break;
				case (8):
					years = "14 year olds.";
					break;
				case (9):
					years = "15 year olds.";
					break;
				case (10):
					years = "16 year olds.";
					break;
				case (11):
					years = "16-17 year olds.";
					break;
				case (12):
					years = "18 year olds.";
					break;
				case (13):
					years = "24 year olds.";
					break;

				}

				System.out.println("Words: " + Words.length);
				System.out.println("Sentences: " + Sentences.length);
				System.out.println("Characters: " + Characters.length());
				System.out.println("The score is: " + score);
				System.out.println("Syllables: " + syllables);
				System.out.println("Polysyllables: " + polysyllables);
				System.out.println("This text should be understood by " + years);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
