package com.arakaru.jetbrains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FleschKincaid {
	
	private String[] Sentences;
	private String[] Words;
	private static int syllables = 0;
	private static int polysyllables = 0;
	
	public FleschKincaid(String[] sentences, String[] words) {
		
		Sentences = sentences;
		Words = words;
		
	}
	
	public double getScore() {
		double score=0;
		for(int i=0;i<Words.length;i++) {
			int poly=0;
			String temp=Words[i].replaceAll("!|\\?|\\. *", "");
			Matcher match = Pattern.compile("e$").matcher(temp);
			while(match.find()) {temp=match.replaceAll("");}
			match = Pattern.compile("([aioeuyAEIOUY])").matcher(temp);
			if(!match.find()) {
				syllables+=1;
			}
			match = Pattern.compile("([aioeuyAEIOUY]){2,3}").matcher(temp);
			
			while(match.find()) {
		        syllables+=1;
				poly+=1;
			}
			
			temp = match.replaceAll("");
	
			match = Pattern.compile("[aioeuyAEIOUY]").matcher(temp);
		    
		    while(match.find()) {
		    	poly+=1;
		    	syllables++;
		    	
		    }
		    if(poly>2)
		    	polysyllables+=1;
		}
		
		score = (double) Math.round((0.39*((double)Words.length/Sentences.length)+(11.8*(double)syllables/Words.length)-15.59) * 100) / 100;
		return score;	
	}
	
	
	public static int getPolysyllables() {
		return polysyllables;
	}
	public static int getSyllables() {
		return syllables;
	}
	

}
