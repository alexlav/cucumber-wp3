package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameGenerator {
	private List<String> vocals = new ArrayList<String>();
	private List<String> startConsonants = new ArrayList<String>();
	private List<String> endConsonants = new ArrayList<String>();
	private List<String> nameInstructions = new ArrayList<String>();

	public NameGenerator() {
		String demoVocals[] = { "a", "e", "i", "o", "u", "ei", "ai", "ou", "j", "ji", "y", "oi", "au", "oo" };
		String demoStartConsonants[] = { "b", "c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
				"w", "x", "z", "ch", "bl", "br", "fl", "gl", "gr", "kl", "pr", "st", "sh", "th"};
		String demoEndConsonants[] = { "b", "d", "f", "g", "h", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "z",
				"ch", "gh", "nn", "st", "sh", "th", "tt", "ss", "pf", "nt" };
		String nameInstructions[] = {"vcdcvdvdv", "cvdvdcvdv", "cdvcvdcd", "vdvdvdcd"};
		this.vocals.addAll(Arrays.asList(demoVocals));
		this.startConsonants.addAll(Arrays.asList(demoStartConsonants));
		this.endConsonants.addAll(Arrays.asList(demoEndConsonants));
		this.nameInstructions.addAll(Arrays.asList(nameInstructions));
	}

	public NameGenerator(String[] vocals, String[] startConsonants, String[] endConsonants) {
		this.vocals.addAll(Arrays.asList(vocals));
		this.startConsonants.addAll(Arrays.asList(startConsonants));
		this.endConsonants.addAll(Arrays.asList(endConsonants));
	}

	public NameGenerator(String[] vocals, String[] startConsonants, String[] endConsonants, String[] nameInstrucions) {
		this(vocals, startConsonants, endConsonants);
		this.nameInstructions.addAll(Arrays.asList(nameInstrucions));
	}

	public String getName() {
		return firstCharUppercase(getNameByInstructions(getRandomElementFrom
				(nameInstructions)));
	}

	private int randomInt(int min, int max) {
		return (int) (min + (Math.random() * (max + 1 - min)));
	}

	private String getNameByInstructions(String nameInstructions) {
		String name = "";
		int l = nameInstructions.length();

		for (int i = 0; i < l; i++) {
			char x = nameInstructions.charAt(0);
			switch (x) {
			case 'v':
				name += getRandomElementFrom(vocals);
				break;
			case 'c':
				name += getRandomElementFrom(startConsonants);
				break;
			case 'd': 
				name += getRandomElementFrom(endConsonants); 
				break;
			}
			nameInstructions = nameInstructions.substring(1);
		}
		return name;
	}

	private String firstCharUppercase(String name) {
		return Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
	}

	private String getRandomElementFrom(List<String> v) {
		return v.get(randomInt(0, v.size()-1));
	}

	public String getEmail(String firstname, String lastname, String websiteName) {
		String website1 = websiteName.split("\\.")[1];		
		String email = firstname+"."+ lastname + "@" + website1 + ".com";
		return email;
	}

	public String getWebsite() {
		String name = getUsername();
		String website = "http://www." + name + ".com";
		return website;
	}
	
	public String getUsername(){
		String username = getName();
		username = Character.toString(username.charAt(0)).toLowerCase() + username.substring(1);
		return username;
	}
}
