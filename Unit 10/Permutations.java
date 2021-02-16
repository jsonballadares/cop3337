import java.util.ArrayList;

/**
 * Permutations
 */
public class Permutations {
    public static ArrayList<String> permutations(String word) {
        ArrayList<String> result = new ArrayList<String>();

        if (word.length() == 0) {
            result.add(word);
            return result;
        } else {
            for (int i = 0; i < word.length(); i++) {
                String shorter = word.substring(0, i) + word.substring(i + 1);
                System.out.println("Shorter for i: " + i + " shorter: " + shorter);
                ArrayList<String> shorterPermutations = permutations(shorter);
                System.out.println("Shorter Permutations: " + shorterPermutations);
                for (String s : shorterPermutations) {
                    result.add(word.charAt(i) + s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permutations("eatjasonmacbookdonaldtrumpdump"));
    }
}