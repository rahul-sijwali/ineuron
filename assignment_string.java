import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class assignment_string {
	static String removeDublicates(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		for (char c : map.keySet()) {
			if (map.get(c) > 1) {
				str = str.replace("" + c, "");
			}
		}
		return str;

	}

	static void printDublicates(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		for (char c : map.keySet()) {
			if (map.get(c) > 1) {
				System.out.print(c + " ");
			}
		}
		System.out.println();

	}

	static boolean checkPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;

			i++;
			j--;
		}
		return true;

	}

	static void countCharacters(String str) {
		Map<String, Integer> map = new HashMap<>();
		map.put("consonants", 0);
		map.put("vowels", 0);
		map.put("special_characters", 0);

		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {

				if (vowels.contains(Character.toLowerCase(str.charAt(i)))) {
					map.put("vowels", map.get("vowels") + 1);
				} else {
					map.put("consonants", map.get("consonants") + 1);
				}

			} else if (!Character.isDigit(str.charAt(i))) {
				map.put("special_characters", map.get("special_characters") + 1);
			}
		}

		for (String s : map.keySet()) {
			System.out.print("number of " + s + " are--> ");
			System.out.println(map.get(s));
		}
	}

	static boolean checkAnagram(String str1, String str2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {
			map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
		}

		if (map1.keySet().size() != map2.keySet().size())
			return false;

		for (Character c : map1.keySet()) {

			if (!map2.containsKey(c))
				return false;
			if (map1.get(c) != map2.get(c))
				return false;
		}

		for (Character c : map2.keySet()) {

			if (!map1.containsKey(c))
				return false;
			if (map1.get(c) != map2.get(c))
				return false;
		}

		return true;
	}

	public static boolean checkPanagram(String str) {
		Character[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		Set<Character> strSet = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				strSet.add(Character.toLowerCase(str.charAt(i)));
			}
		}

		for (Character c : alphabets) {
			if (!strSet.contains(c))
				return false;
		}

		return true;

	}

	public static boolean checkUnique(String str) {
		Set<Character> strSet = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			strSet.add(str.charAt(i));
		}

		if (str.length() != strSet.size())
			return false;

		return true;
	}

	public static void maxOccuring(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int max = -1;
		Character ch = null;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
				if (map.get(str.charAt(i)) > max) {
					max = map.get(str.charAt(i));
					ch = str.charAt(i);
				}

			}

		}

		System.out.print("max occuring character is " + ch);
		System.out.println(" with count--> " + max);

	}

	public static void main(String[] args) {
		String dublicate = "abcabcxyz";
		String countThis = "1a2b#@tyu";
		String panagram = "The quick brown fox jumps over a lazy dog";

		String removed = removeDublicates(dublicate);
		System.out.println(removed);

		printDublicates(dublicate);

		System.out.print(checkPalindrome("2552"));
		System.out.println();

		countCharacters(countThis);

		System.out.println(checkAnagram("rabbit", "bartib"));

		System.out.println(checkPanagram(panagram));

		System.out.println(checkUnique(dublicate));

		maxOccuring(panagram);

	}

}
