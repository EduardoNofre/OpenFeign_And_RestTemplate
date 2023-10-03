package br.com.client.app.util;

public class Util {

	public static String feingDetailMessage(String sentence, String word) {
		int startingPosition = sentence.indexOf(word) + word.length();
		int endingPosition = sentence.length();

		return sentence.substring(startingPosition, endingPosition).replaceAll("\"", "").replaceAll(":", "")
				.replaceAll("}", "").replaceAll("]", "");
	}

}
