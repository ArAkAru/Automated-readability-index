package com.arakaru.jetbrains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try( Scanner scanner = new Scanner(new File("src/com/arakaru/jetbrains/dataset_91007.txt"))){
			int score;
			String years="";
			while(scanner.hasNextLine()) {
			String param= scanner.nextLine();
			String[] Sentences=param.split("!|\\?|\\. *");
			String[] Words=param.split(" ");
			String Characters=param.replaceAll("[ \\t\\n]", "");
			
			
			double d=(double) Math.round((4.71*((double)Characters.length()/Words.length)+(0.5*(double)Words.length/Sentences.length)-21.43) * 100) / 100;
			score=(int)Math.ceil(d);
			switch(score) {
			
			case(1):
				years="5-6 year olds.";
				break;
			case(2):
				years="6-7 year olds.";
				break;
			case(3):
				years="7-9 year olds.";
				break;
			case(4):
				years="9-10 year olds.";
				break;
			case(5):
				years="10-11 year olds.";
				break;
			case(6):
				years="11-12 year olds.";
				break;
			case(7):
				years="12-13 year olds.";
				break;
			case(8):
				years="13-14 year olds.";
				break;
			case(9):
				years="14-15 year olds.";
				break;
			case(10):
				years="15-16 year olds.";
				break;
			case(11):
				years="16-17 year olds.";
				break;
			case(12):
				years="17-18 year olds.";
				break;
			case(13):
				years="18-24 year olds.";
				break;
			case(14):
				years="24+ year olds.";
				break;
				
			}
            
            System.out.println("Words: "+Words.length);
            System.out.println("Sentences: "+Sentences.length);
            System.out.println("Characters: "+Characters.length());
            System.out.println("The score is: "+d);
			System.out.println("This text should be understood by "+years);
		
	}
		}
			catch(FileNotFoundException e){e.printStackTrace();}
		
}
	}
