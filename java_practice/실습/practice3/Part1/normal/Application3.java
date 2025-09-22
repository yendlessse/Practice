package Part2.normal;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("정수를 입력하세요 : ");
        int n = scanner.nextInt();

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                System.out.print("박");
            } else {
                System.out.print("수");
            }
        }
    }
}
