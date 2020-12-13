package src.com.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cube02 {
    /*
    R R W
    G C W
    G B B
     */
    static char[][] map = {{'R', 'R', 'W'}, {'G', 'C', 'W'}, {'G', 'B', 'B'}};

    public static void push(String com) {
        String str;
        StringBuilder target = new StringBuilder();
        int length = 3;
        int cnt = 1;
        if (com.contains("U")) {
            target = new StringBuilder(String.valueOf(map[0]));
            if (com.contains("'")) {
                str = target.substring(length - cnt) + target.substring(0, length - cnt);
            } else {
                str = target.substring(cnt) + target.substring(0, cnt);
            }
            map[0] = str.toCharArray();
        } else if (com.contains("B")) {
            target = new StringBuilder(String.valueOf(map[2]));
            if (com.contains("'")) {
                str = target.substring(cnt) + target.substring(0, cnt);
            } else {
                str = target.substring(length - cnt) + target.substring(0, length - cnt);
            }
            map[2] = str.toCharArray();
        } else if (com.contains("R")) {
            for (char[] chars : map) {
                target.append(chars[2]);
            }
            if (com.contains("'")) {
                str = target.substring(length - cnt) + target.substring(0, length - cnt);
            } else {
                str = target.substring(cnt) + target.substring(0, cnt);
            }
            for (int i = 0; i < map.length; i++) {
                map[i][2] = str.toCharArray()[i];
            }
        } else {
            for (char[] chars : map) {
                target.append(chars[0]);
            }
            if (com.contains("'")) {
                str = target.substring(cnt) + target.substring(0, cnt);
            } else {
                str = target.substring(length - cnt) + target.substring(0, length - cnt);
            }
            for (int i = 0; i < map.length; i++) {
                map[i][0] = str.toCharArray()[i];
            }
        }
        System.out.println(com);
        printArr();
    }

    public static void printArr() {
        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printArr();
        while (true) {
            System.out.print("CUBE> ");
            char[] comArr = br.readLine().toCharArray();
            for (int i = 0; i < comArr.length; i++) {
                if (comArr[i] == 'Q') {
                    System.out.println("Bye~");
                    br.close();
                    return;
                } else if (i + 1 < comArr.length && comArr[i + 1] == '\'') {
                    push("" + comArr[i] + comArr[i + 1]);
                    i++;
                } else {
                    push(comArr[i] + "");
                }

            }
        }
    }

}
