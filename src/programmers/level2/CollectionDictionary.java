package programmers.level2;

public class CollectionDictionary {
    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }
    public static int solution(String word) {
        int answer = word.length();;
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        int index;
        for(int i = 0; i < word.length(); i++) {
            index = str.indexOf(word.charAt(i));
            answer += x[i] * index;
        }
        return answer;
    }
}
