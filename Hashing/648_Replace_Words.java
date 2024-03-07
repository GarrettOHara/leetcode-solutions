import java.util.*;

class Solution {
    public static void main(String[] args){
      String[] dictionary = {"cat","bat","rat"};
      String sentence = "the cattle was rattled by the battery";
      System.out.print("BEFORE REPLACE WORDS:\n"+sentence+
        "\n\nAFTER REPLACE WORDS:\n");
      String result = replaceWords(dictionary, sentence);
      System.out.println(result);
    }
    public static  String replaceWords(String[] dict, String sentence) {
        if (dict == null || dict.length == 0) return sentence;

        Set<String> set = new HashSet<>();
        for (String s : dict) set.add(s);

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            sb.append(" " + prefix);
        }

        return sb.deleteCharAt(0).toString();
    }
}
