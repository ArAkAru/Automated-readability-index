package com.arakaru.jetbrains;



public class FleschKincaid {

	private String[] Sentences;
	private String[] Words;
	private int syllables = 0;

	public FleschKincaid(String[] sentences, String[] words, int syllables) {

		Sentences = sentences;
		Words = words;
		this.syllables = syllables;
	}

	public double getScore() {
		double score = 0;
		score = (double) Math.round(
				(0.39 * ((double) Words.length / Sentences.length) + (11.8 * (double) syllables / Words.length) - 15.59)
						* 100)
				/ 100;
		return score;
	}

}
