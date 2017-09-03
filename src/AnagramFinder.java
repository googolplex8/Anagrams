import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramFinder {
	File f = new File("/Users/league/Documents/workspace/Ash/Anagrams/src/Dictionary");
	
	
public static void main(String[] args) throws FileNotFoundException {
	AnagramFinder runner = new AnagramFinder();
	runner.findAnagrams("cinema");
}
public ArrayList<String> findAnagrams(String input) throws FileNotFoundException{
	Scanner sc = new Scanner(f);
	char[] chars = input.toCharArray();
	ArrayList<String> anagrams = new ArrayList<String>();
	int numLets = anagrams.size();
	while(sc.hasNextLine()){
		if(sc.nextLine().contains(anagrams.get(0))){
			anagrams.add(sc.nextLine());
		}
	}
	for(String x : anagrams){
		System.out.println(x);
	}
	return anagrams;
	
}
}
//iterate through dictionary and if the dictionary "contains" all of the letters of the inputted word, add it to the list