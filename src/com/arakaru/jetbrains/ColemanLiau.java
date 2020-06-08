package com.arakaru.jetbrains;

public class ColemanLiau {
	private double L;
	private double S;
	private String[] Sentences;
	private String Characters;
	private String[] Words;

	public ColemanLiau(String[] sentences, String characters, String[] words) {

		Sentences = sentences;
		Characters = characters;
		Words = words;
	}

	public double getL() {

		L = ((double) Characters.length() / Words.length) * 100;
		return L;

	}

	public double getS() {

		S = ((double) Sentences.length / Words.length) * 100;

		return S;

	}

	public double getScore() {

		double score = 0;
		score = (double) Math.round((0.0588 * getL() - 0.296 * getS() - 15.8) * 100) / 100;
		return score;

	}

}
