package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    private static boolean exists(int n[], int index) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] == index)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
        int n[] = new int[3];
        int index = 0;
        for (int i = 0; i < n.length; i++) {
            do {
                index = (int) (random() * 10);
            } while (exists(n, index));
            n[i] = index;
        }

//        for (int value : n) {
//            System.out.println(value);
//        }

        System.out.println("-------------------------------------------");

        //사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        //기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
        //무제한 = 반복문 for while break continue
        int count = 0;
        int b = 0;
        int s = 0;
        while (s != 3) {
            System.out.print( ++count +"번째 시도 : ");
            String number = sc.nextLine();
            if (number.length() == 3) {
                b = 0;
                s = 0;

                int first_num = number.charAt(0) - '0';
                int second_num = number.charAt(1) - '0';
                int third_num = number.charAt(2) - '0';
                int[] box = {first_num, second_num, third_num};

                for (int i = 0; i < 3; i++) {
                    if (box[i] == n[i]) {
                        s++;
                    } else if (box[i] == n[0]) {
                        b++;
                    } else if (box[i] == n[1]) {
                        b++;
                    } else if (box[i] == n[2]) {
                        b++;
                    }
                }
                System.out.println(b+"B"+s+"S");
            } else {
                System.out.println("숫자의 개수가 맞지 않습니다");
            }
        }
        System.out.println( count + "번만에 맞히셨습니다.");
        System.out.println( "게임을 종료합니다.");
    }
}
