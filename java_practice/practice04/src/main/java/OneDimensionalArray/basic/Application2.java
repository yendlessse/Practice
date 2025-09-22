package OneDimensionalArray.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        String[] fruits = new String[]{"딸기", "바나나", "복숭아", "키위", "사과"};

        // 정수 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.printf("0부터 4까지의 정수를 입력하세요: ");
        int num = scanner.nextInt();
        if ( num > 4 || num < 0) {
            System.out.println("준비된 과일이 없습니다.");
        }else {
            System.out.println(fruits[num]);
        }
    }
}
