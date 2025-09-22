package Part2.hard;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        // 난수 생성
        int ans = (int)(Math.random() * 100) + 1;
        System.out.println(ans);

        // 사용자 입력
        int guess;

        //count로 횟수 세기
        int count = 0;
        do {
            // 정수 입력
            Scanner scanner = new Scanner(System.in);
            System.out.printf("정수를 입력하세요 : ");
            guess = scanner.nextInt();

            // 횟수 세기
            count ++;

            if (guess == ans) {
                // 정답을 맞춘 경우
                System.out.println("정답입니다. " + count + "회만에 정답을 맞추셨습니다.");
            } else if (guess > ans) {
                // 입력받은 정수보다 난수가 작은 경우
                System.out.println("입력하신 정수보다 작습니다.");
            } else {
                // 입력받은 정수보다 난수가 큰 경우
                System.out.println("입력하신 정수보다 큽니다.");
            }
        } while (guess != ans);
    }
}
