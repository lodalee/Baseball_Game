package org.example;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    private static boolean exists(int randomNumbers[], int randomNumber) {
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] == randomNumber)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
        int[] randomNumbers = new int[3];
//        List<Integer> randomNumbers = new ArrayList<>();
        int randomNumber;

        for (int i = 0; i < 3; i++) {
            do {
                // random()      => 0부터 1사이의 랜덤한 실수값을 내어주더라 (0초과 1미만)
                // random() * 10 => 0부터 10사이의 랜덤한 실수값을 내어주더. (0초과 10미만) -> (0.xxxx ~ 9.xxxxx)
                // random() * 100 => 0부터 100사이의 랜덤한 실수값을 내어주더라 (0초과 100미만)
                randomNumber = (int) (random() * 10);

//            } while (randomNumbers.contains(randomNumber));
            } while (exists(randomNumbers, randomNumber));

//            randomNumbers.add(randomNumber);
            randomNumbers[i] = randomNumber;
        }

        //사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        //기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
        //무제한 = 반복문 for while break continue
        int count = 0;
        int ball = 0;
        int strike = 0;
        while (strike != 3) {
            System.out.print( ++count +"번째 시도 : ");
            String number = sc.nextLine();
            if (number.length() == 3) {
                ball = 0;
                strike = 0;
//                int[] box = {number / 100 , (number % 100) / 10, number % 10};

                // String으로 받았을 때 stream 메서드를 통해 분리해준다.
//                List<Integer> box = Arrays
//                        .stream(number.split(""))
//                        .map((element) -> {
//                            return Integer.parseInt(element);
//                        }).toList();

                int first_num = number.charAt(0) - '0';
                int second_num = number.charAt(1) - '0';
                int third_num = number.charAt(2) - '0';
                int[] box = {first_num, second_num, third_num};

                for (int i = 0; i < 3; i++) {
                    if (box[i] == randomNumbers[i]) {
                        strike++;
                    } else if (box[i] == randomNumbers[0]) {
                        ball++;
                    } else if (box[i] == randomNumbers[1]) {
                        ball++;
                    } else if (box[i] == randomNumbers[2]) {
                        ball++;
                    }
//                    int targetNumber = box.get(i);
//                    int currentRandomNumber = randomNumbers.get(i);
//
//                    if(targetNumber == currentRandomNumber) {
//                        strike++;
//                    } else if (randomNumbers.contains(targetNumber)){
//                        ball++;
//                    }
                }
                System.out.println(ball+"B"+strike+"S");
            } else {
                System.out.println("숫자의 개수가 맞지 않습니다");
            }
        }
        System.out.println( count + "번만에 맞히셨습니다.");
        System.out.println( "게임을 종료합니다.");
    }
}
