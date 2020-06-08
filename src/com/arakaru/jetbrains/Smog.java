package com.arakaru.jetbrains;

public class Smog {
	private int polysyllables = 0;
	private String[] sentences;

	public Smog(int polysyllables, String[] sentences) {

		this.polysyllables = polysyllables;
		this.sentences = sentences;
	}

	public double getScore() {
		double score = 0;
		score = (double) Math.round((1.043 * Math.sqrt(polysyllables * 30.0 / sentences.length) + 3.1291) * 100) / 100;
		return score;
	}
}
