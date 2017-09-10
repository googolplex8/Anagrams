import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramFinder {
	File f = new File("/Users/league/Desktop/Anagrams/src/Dictionary");

	public static void main(String[] args) throws FileNotFoundException {
		AnagramFinder runner = new AnagramFinder();
		runner.findAnagrams("cinema");
	}

	public ArrayList<String> findAnagrams(String input) throws FileNotFoundException {
		Scanner sc = new Scanner(f);
		char[] chars = input.toCharArray();
		int wordLen = input.length();
		System.out.println("Word length " + wordLen);

		ArrayList<String> anagrams = new ArrayList<String>();
		
		while (sc.hasNextLine()) {
			ArrayList <Character> inputList = new ArrayList <Character>();
			for (int i = 0; i < chars.length; i++) {
				inputList.add(chars[i]);
			}
			
			int counter = 0;
			String compare = sc.nextLine().toLowerCase();
			char[] compareChars = compare.toCharArray();
			ArrayList <Character> compareList = new ArrayList <Character>();
			for (int i = 0; i < compareChars.length; i++) {
				compareList.add(compareChars[i]);
			}
			
			if (compare.length() == wordLen) {
				// System.out.println(compare);
				for (int i = 0; i < wordLen; i++) {
					//ArrayList<Character> tested = new ArrayList<Character>();
					// tested.contains(chars[i])==false && 
				
//					if (compareList.contains(chars[i] + "") ) {
//						//System.out.println(compare);
//						//tested.add(chars[i]);
//						compareList.remove(i);
//						counter++;
//					}
					if(inputList.contains(compareList.get(i))) {
						//System.out.println(compareChars[i]);
						inputList.remove(compareList.get(i));
						counter++;
					}
				}
				if (counter == wordLen && compare.equals(input) == false) {
					anagrams.add(compare);
				}
			}
		}
		sc.close();
		for (String x : anagrams) {
			System.out.println(x);
		}
		return anagrams;
	}
}
// iterate through dictionary and if the dictionary "contains" all of the
// letters of the inputed word, add it to the list