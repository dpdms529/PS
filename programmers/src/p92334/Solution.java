package p92334;

import java.util.*;

class User {
    ArrayList<String> reportIds = new ArrayList<>();
    int reportNum = 0;
}

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> userMap = new HashMap<>();
        HashMap<String, User> reportResult = new HashMap<>();
        int idx = 0;
        for(String id : id_list){
            userMap.put(id, idx++);
            reportResult.put(id, new User());
        }

        for(String r : report){
            String[] reportData = r.split(" ");
            User user = reportResult.get(reportData[1]);
            if(user.reportIds.contains(reportData[0])) continue;
            user.reportIds.add(reportData[0]);
            user.reportNum++;
            reportResult.put(reportData[1], user);
        }

        for(String id : id_list){
            User user = reportResult.get(id);
            if(user.reportNum >= k){
                for(String reportId : user.reportIds){
                    answer[userMap.get(reportId)]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = solution(id_list, report, 2);
        for(int i : result){
            System.out.println(i);
        }
    }
}
