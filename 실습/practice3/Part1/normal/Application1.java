package Part1.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n<1 || n>10) {
            System.out.println("반드시 1~10 사이의 정수를 입력해야한다.");
        } else if (n%2 == 0){
            System.out.println("짝수다");
        } else {
            System.out.println("홀수다");
        }
    }
}
