
public class ScrambleRunner {
	public static void main(String[] args) {
		System.out.println(scrambleIt("TAN"));
		System.out.println(scrambleIt("ABRACADABRA"));
		System.out.println(scrambleIt("WHOA"));
		System.out.println(scrambleIt("AARDVARK"));
		System.out.println(scrambleIt("EGGS"));
		System.out.println(scrambleIt("A"));
		System.out.println(scrambleIt(""));
	}
	
	public static String scrambleIt(String word) {
		int i = 0;
		String scramble = "";
		while(i < word.length()) {
			if(i + 1 < word.length()) {
				if(word.charAt(i) == 'A' && word.charAt(i + 1) != 'A') {
					scramble += word.charAt(i + 1);
					scramble += word.charAt(i);
					i += 2;
				} else {
					scramble += word.charAt(i);
					i++;
				}
			} else {
				scramble += word.charAt(i);
				i++;
			}
		}
		return scramble;
	}
}
