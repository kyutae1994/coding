package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class ParkingFeeCalculation { // 4페이지 & 주차요금계산
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                            "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                            "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
        System.out.println((int) Math.ceil(1/ (double)10));
    }
    public static int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String key : records) {
            String[] temp = key.split(" ");
            int min = getMin(temp[0]);
            if(temp[2].equals("IN")) {
                if(!tm.containsKey(temp[1]))
                    tm.put(temp[1], 0);
                map.put(temp[1], min);
            } else {
                tm.put(temp[1], tm.get(temp[1]) + min - map.get(temp[1]));
                map.remove(temp[1]);
            }
        }

        if(!map.isEmpty()) {
            for(String key : map.keySet()) {
                tm.put(key, tm.get(key) + (23 * 60 + 59) - map.get(key));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer x : tm.values()) {
            if(x <= fees[0]) {
                list.add(fees[1]);
            } else {
                int cost = (int) Math.ceil((x - (double) fees[0]) / fees[2]);
                list.add(fees[1] + cost * fees[3]);
            }
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static int getMin(String time) {
        String[] str = time.split(":");
        int min = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        return min;
    }
}
