package src.com.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cube01 {

    public static String push(String target, int cnt, int dir) {
        String answer;
        int leng = target.length();
        cnt %= leng;
        if (dir == 1) {
            answer = target.substring(leng-cnt) + target.substring(0,leng-cnt);
        } else {
            answer = target.substring(cnt) + target.substring(0, cnt);
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        String[] arr = st.split(" ");
        String target = arr[0];
        int cnt = Integer.parseInt(arr[1]);
        String direction = arr[2].toUpperCase();
        int dir = (direction.equals("R")) ? 1 : -1;
        if (cnt < 0) {
            dir *= -1;
            cnt = Math.abs(cnt);
        }
        System.out.println(push(target, cnt, dir));

        br.close();
    }
}
