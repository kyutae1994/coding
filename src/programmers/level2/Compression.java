//package programmers.level2;
//import java.util.*;
//
//public class Compression {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("KAKAO")));
//    }
//    public static int[] solution(String msg) {
//        int[] answer = {};
//        Map<Integer, String> map = new HashMap<>();
//        int i = 0;
//        for(i = 1; i <= 26; i++) {
//            map.put(i, String.valueOf((char)(64 + i)));
//        }
//
//        boolean flag = false;
//        for(int j = 0; j < msg.length() - 1; j++) {
//            String word = msg.charAt(j) + "";
//
//            while (map.containsValue(word)) {
//                j++;
//                if (j == msg.length()) {
//                    flag = true;
//                    break;
//                }
//                word += msg.charAt(j);
//            }
//            if (flag) {
//
//            }
//        }
//        System.out.println(map);
//        return answer;
//import java.util.*;
//public class Compression {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
//    }
//    public static int[] solution(String msg) {
//        int cnt = 1;
//        List<Integer> list = new ArrayList<>();
//        Map<String, Integer> map = new HashMap<>();
//        for(int i = 0; i < 26; i++)
//            map.put((char)(65 + i) + "", cnt++);
//
//        for(int i = 0; i < msg.length(); i++) {
//            int a = 1;
//            while(i + a <= msg.length() && map.containsKey(msg.substring(i, i + a))) {
//                a++;
//            }
//            if(i + a > msg.length()) {
//                list.add(map.get(msg.substring(i, i + a - 1)));
//                break;
//            }
//            list.add(map.get(msg.substring(i, i + a - 1)));
//            map.put(msg.substring(i, i + a), cnt++);
//            if(a > 1) i += a - 2;
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
//>>>>>>> origin/master
//    }
//}
