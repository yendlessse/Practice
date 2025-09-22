package Part2.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        while (n <= 2) {
            System.out.printf("2보다 큰 정수를 하나 입력하세요 : ");
            n = scanner.nextInt();

            if (n <= 2) {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
            }
        }

        for (int i = 2; i < n ; i++) {
            if (n % i == 0) {
                System.out.println("소수가 아니다");
                return;
            } else if (n % i != 0) {
                if (i == n-1) {
                    // 나누어 떨어지지 않고 나눠봐야 하는 마지막 수라면
                    System.out.println("소수다");
                    return;
                } else {
                    // 나누어 떨어지지 않고 나눠봐야 하는 수가 더 남아있다면
                    continue;
                }
            }
        }

    }
}
