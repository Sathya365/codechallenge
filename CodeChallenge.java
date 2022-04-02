package com.features;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class CodeChallenge {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		String line = "";
		String splitBy = ",";
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\satya\\OneDrive\\Desktop\\french_dictionary.csv"));
		// CSVReader reader = null;
		Map<String, String> keyAndValuePair = new LinkedHashMap<String, String>();
		while ((line = br.readLine()) != null) {
			String[] row = line.split(splitBy);
			keyAndValuePair.put(row[0], row[1]);
		}

		String sentence = readFileAsString("C:\\Users\\satya\\OneDrive\\Desktop\\shakesphere.txt");

		String replacedString = sentence;

		for (String key : keyAndValuePair.keySet()) {
			replacedString = replacedString.replace(key, keyAndValuePair.get(key));
			String stringWithFirstCapitalLetter = capitaliseFirstLetter(key);
			replacedString = replacedString.replace(stringWithFirstCapitalLetter, keyAndValuePair.get(key));
		}
		saveFile(replacedString);
	}

	private static void saveFile(String replacedString) throws IOException {
		String year = "2022";
		String month = "04";
		String date = "01";
		String surname = "satya";
		String givenname = "narayana";
		String college = "srm";
		String outputFilename = year + month + date + surname + givenname + college + ".txt";
		Files.writeString(Paths.get("C:\\Users\\satya\\OneDrive\\Desktop\\" + outputFilename), replacedString);	
		System.out.println("File saved successfully !!!");
	}

	private static String capitaliseFirstLetter(String key) {
		String firstLetter = key.substring(0, 1);
		String remainingLetters = key.substring(1, key.length());
		firstLetter = firstLetter.toUpperCase();
		// join the two substrings
		String stringWithFirstCapitalLetter = firstLetter + remainingLetters;
		return stringWithFirstCapitalLetter;
	}

	private static String readFileAsString(String path) throws IOException {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(path)));
		return data;
	}

}
