package Part1.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("첫 번째 정수: ");
        int a = scanner.nextInt();
        System.out.printf("두 번째 정수: ");
        int b = scanner.nextInt();
        System.out.printf("연산 기호를 입력하세요: ");
        String cal = scanner.next();

        if (cal.equals("+")) {
            System.out.println(a + b);
        }else if (cal.equals("-")) {
            System.out.println(a - b);
        }else if (cal.equals("*")) {
            System.out.println(a * b);
        }else if (cal.equals("/")) {
            System.out.println(a / b);
        }else if (cal.equals("%")) {
            System.out.println(a % b);
        }else {
            System.out.println("입력하신 연산은 없습니다");
        }

    }
}
