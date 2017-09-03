import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramFinder
{
	File f = new File("C:/Users/Eli/Desktop/Anagrams/src/Dictionary");

	public static void main(String[] args) throws FileNotFoundException
	{
		AnagramFinder runner = new AnagramFinder();
		runner.findAnagrams("cinema");
	}

	public ArrayList<String> findAnagrams(String input)
			throws FileNotFoundException
	{
		Scanner sc = new Scanner(f);
		char[] chars = input.toCharArray();
		ArrayList<String> anagrams = new ArrayList<String>();
		int wordLen = input.length();
		System.out.println("Word length " + wordLen);
		while (sc.hasNextLine())
		{
			int counter = 0;

			String compare = sc.nextLine().toLowerCase();
			if (compare.length() == wordLen)
			{
				//System.out.println(compare);
				for (int i = 0; i < wordLen; i++)
				{
					if (compare.contains(chars[i] + ""))
					{
						//System.out.println(compare);
						counter++;
					}
				}
				if (counter == wordLen && compare.equals(input)==false)
				{
					anagrams.add(compare);
				}
			}
		}
		sc.close();
		for (String x : anagrams)
		{
			System.out.println(x);
		}
		return anagrams;
	}
}
// iterate through dictionary and if the dictionary "contains" all of the
// letters of the inputted word, add it to the list