package p92341;

import java.util.*;

class Car implements Comparable<Car>{
    String id;
    int inTime;
    boolean parking;
    int totalTime;

    public Car(String id){
        this.id = id;
    }

    public void calcTotalTime(int outTime){
        totalTime += outTime - inTime;
    }

    public int calcFee(int[] fees){
        int overTime = totalTime - fees[0];
        int fee = fees[1];
        if(overTime > 0){
            int timeUnit = overTime % fees[2] == 0 ? overTime / fees[2] : overTime / fees[2] + 1;
            fee = fees[1] + timeUnit * fees[3];
        }
        return fee;
    }

    @Override
    public int compareTo(Car o){
        return this.id.compareTo(o.id);
    }
}

public class Solution {
    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Car> carMap = new HashMap<>();

        for(String record : records){
            String[] data = record.split(" ");
            String[] time = data[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int minTime = hour * 60 + minute;
            String id = data[1];
            Car car = carMap.getOrDefault(id, new Car(id));
            if(data[2].equals("IN")){
                car.inTime = minTime;
                car.parking = true;
                carMap.put(id, car);
            }else if(data[2].equals("OUT")){
                car.calcTotalTime(minTime);
                car.parking = false;
            }
        }

        ArrayList<String> carIds = new ArrayList<>(carMap.keySet());
        Collections.sort(carIds);
        int[] answer = new int[carIds.size()];
        int idx = 0;
        for(String id : carIds){
            Car car = carMap.get(id);
            if(car.parking){
                car.calcTotalTime(1439);
                car.parking = false;
            }
            answer[idx++] = car.calcFee(fees);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int result[] = solution(fees, records);
        for(int i : result){
            System.out.println(i);
        }
    }
}
