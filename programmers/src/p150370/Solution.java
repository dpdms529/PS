package p150370;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        Map<String, Integer> expirationPeriodByTerm = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            expirationPeriodByTerm.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        for (String privacy : privacies) {
            StringTokenizer st = new StringTokenizer(privacy);
            LocalDate collectionDate = LocalDate.parse(st.nextToken(), formatter);
            String term = st.nextToken();

            int diff = 0;
            diff += (todayDate.getYear() - collectionDate.getYear()) * 12 * 28
                    + (todayDate.getMonthValue() - collectionDate.getMonthValue()) * 28
                    + (todayDate.getDayOfMonth() - collectionDate.getDayOfMonth());

            if (diff / 28.0 >= expirationPeriodByTerm.get(term)) {
                answer.add(idx);
            }

            idx++;
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
        String[] today = {"2022.05.19", "2020.01.01"};
        String[][] terms = {{"A 6", "B 12", "C 3"}, {"Z 3", "D 5"}};
        String[][] privacies = {{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}, {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}};

        solution(today[0], terms[0], privacies[0]);

        for (int i = 0; i < today.length; i++) {
            int[] result = solution(today[i], terms[i], privacies[i]);
            System.out.println(Arrays.toString(result));
        }
    }
}
