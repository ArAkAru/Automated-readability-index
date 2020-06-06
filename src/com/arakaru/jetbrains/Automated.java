package com.arakaru.jetbrains;

public class Automated {
	
	private double score;
	private String[] Sentences;
	private String[] Words;
	private String Characters;
	
	
	
	public Automated(String[] sentences, String[] words, String characters) {
		Sentences = sentences;
		Words = words;
		Characters = characters;
	}


	public double getScore() {
		score=(double) Math.round((4.71*((double)Characters.length()/Words.length)+(0.5*(double)Words.length/Sentences.length)-21.43) * 100) / 100;
		return score;
	}
}
