package Part1.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("국어 점수를 입력하세요 : ");
        int korean = scanner.nextInt();
        System.out.printf("영어 점수를 입력하세요 : ");
        int english = scanner.nextInt();
        System.out.printf("수학 점수를 입력하세요 : ");
        int math = scanner.nextInt();

        if (avgCal(korean, english, math) && korean >= 40 && english >= 40 && math >= 40) {
            System.out.println("합격입니다!");
        }
        if (avgCal(korean, english, math) == false) {
            System.out.println("평균점수 미달로 불합격 입니다");
        }
        if (korean < 40) {
            System.out.println("국어 점수 미달로 불합격 입니다");
        }
        if (english < 40) {
            System.out.println("영어 점수 미달로 불합격 입니다");
        }
        if (math < 40) {
            System.out.println("수학 점수 미달로 불합격 입니다");
        }
    }

    public static boolean avgCal (int k, int e, int m) {
        double avg = (k + e + m) / 3;
        if (avg >= 60) {
            return true;
        } else {
            return false;
        }
    }
}
