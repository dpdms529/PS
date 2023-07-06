package p12981;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static Set<String> usedWords = new HashSet<>();

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        int i;
        for(i = 0;i<words.length;i++) {
            if(i==0 ? isFail(words[i]) : isFail(words[i-1], words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            usedWords.add(words[i]);
        }

        return answer;
    }

    boolean isFail(String word) {
        return isLengthOne(word) || isUsedWord(word);
    }

    boolean isFail(String prevWord, String curWord) {
        return isLengthOne(curWord) || isNotStartWithLastCharacter(prevWord, curWord) || isUsedWord(curWord);
    }

    boolean isLengthOne(String word) {
        return word.length() == 1;
    }

    boolean isNotStartWithLastCharacter(String prevWord, String curWord) {
        return prevWord.charAt(prevWord.length()-1) != curWord.charAt(0);
    }

    boolean isUsedWord(String word) {
        return usedWords.contains(word);
    }
}
