package kakao;

import java.util.*;

public class p92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, Integer> cnt = new HashMap<>();
        for(String id : id_list){
            cnt.put(id,0);
        }
        HashMap<String, ArrayList<String>> reportUser = new HashMap<>();
        for(String id : id_list){
            reportUser.put(id, new ArrayList<>());
        }
        for(int i = 0;i<report.length;i++){
            String str[] = report[i].split(" ");
            reportUser.get(str[0]).add(str[1]);
        }
        ArrayList<String> ban = new ArrayList<>();
        for(String id :id_list){
            int userCnt = cnt.get(id);
            if(userCnt >= k){
                ban.add(id);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
