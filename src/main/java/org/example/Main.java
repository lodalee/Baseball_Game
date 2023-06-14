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

        for(int value : n) {
            System.out.println(value);
        }

        System.out.println("-------------------------------------------");

        //사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        String number = sc.nextLine();
        if(number.length()==3){
            int first_num = number.charAt(0) -'0';
            int second_num = number.charAt(1) -'0';
            int third_num = number.charAt(2) -'0';
            int[] box = {first_num, second_num, third_num};
            System.out.println(first_num);
            System.out.println(second_num);
            System.out.println(third_num);
            System.out.println(Arrays.toString(box));

            //컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.
            //1. box의 요소들을 하나씩 돌고, n의 요소들을 하나씩 돌아서 두 요소의 숫자와 위치가 같을 때, s++
            //2. box의 요소들과 n의 요소들 중에 같은 숫자가 있으면 그 수 만큼 b++
            int b = 0;
            int s = 0;

            for (int i = 0; i < 3; i++) {
                if (box[i] == n[i]){
                    s++;
                } else if(box[i] == n[0]) {
                    b++;
                } else if(box[i] == n[1]) {
                    b++;
                } else if(box[i] == n[2]) {
                    b++;
                }
            }
            System.out.println(s);
            System.out.println(b);


        }

    }
}




//기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
//숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.
