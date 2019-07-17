
public class char_sort {

	public static void main(String[] args) {
		/*
		 * char selection sorting
		 */
		String phrase = "How are you?";
		String sortedPhrase;
		char[] letter = phrase.toCharArray();
		char minChar;
		char tempChar;
		int minId;
		int i;
		int j;
		int count = 1;

		for (i = 0; i < letter.length; i++) {

			minChar = letter[i];
			minId = i;
			for (j = i; j < letter.length; j++) {
				if (minChar > letter[j]) {
					minChar = letter[j];
					minId = j;
					count++;
				}
			}
			
//			System.out.println(minChar + ","+minId);
			tempChar = letter[minId];
			letter[minId] = letter[i];
			letter[i] = tempChar;
		}
		
//		for (int k=0; k<letter.length; k++) {
//			System.out.print(letter[k]+" ");
//		}
		
		sortedPhrase = new String(letter);
		System.out.println();
		System.out.println(sortedPhrase);
		System.out.println(count);
	}

}
