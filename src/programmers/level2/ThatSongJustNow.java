package programmers.level2;

public class ThatSongJustNow { // 3페이지 & 방금그곡
    public static void main(String[] args) {
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution("ABCDEFG", musicinfos));
    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int max =  -1;
        m = reMake(m);

        for(String info : musicinfos) {
            String[] in = info.split(",");
            String music = in[2];
            String musicInfo = reMake(in[3]);

            String[] start = in[0].split(":");
            String[] end = in[1].split(":");
            int st = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int min = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            int musicTime = min - st;

            if(musicTime > musicInfo.length()) {
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < musicTime / musicInfo.length(); i++) {
                    sb.append(musicInfo);
                }

                sb.append(musicInfo.substring(0, musicTime % musicInfo.length()));
                musicInfo = sb.toString();
            } else {
                musicInfo = musicInfo.substring(0, musicTime);
            }

            if(musicInfo.contains(m) && musicTime > max) {
                max = musicTime;
                answer = music;
            }
        }
        return max != -1 ? answer : "(None)";
    }

    public static String reMake(String m) {
        m = m.replace("C#", "I");
        m = m.replace("D#", "J");
        m = m.replace("F#", "K");
        m = m.replace("G#", "L");
        String reInfo = m.replace("A#", "H");

        return m;
    }
}
