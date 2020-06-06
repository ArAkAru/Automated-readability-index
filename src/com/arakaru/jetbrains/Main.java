package com.arakaru.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File("src/com/arakaru/jetbrains/dataset_91007.txt"))) {
			int count = 0;
			int scoreForAge;
			int polycounnt = 0;
			double score = 0;
			String years = "";
			while (scanner.hasNextLine()) {
				String param = scanner.nextLine();
				String[] Sentences = param.split("!|\\?|\\. *");
				String[] Words = param.split(" ");
				String Characters = param.replaceAll("[ \\t\\n]", "");

				// score=new FleschKincaid(Sentences,Words).getScore();
				score = new Automated(Sentences, Words, Characters).getScore();

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
				System.out.println("Syllables: " + FleschKincaid.getSyllables());
				System.out.println("Polysyllables: " + FleschKincaid.getPolysyllables());
				System.out.println("This text should be understood by " + years);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
