package Part1.hard;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("과일 이름을 입력하세요: ");
        String fruit = scanner.nextLine();

        if (fruit.equals("사과")){
            fruitPrint("사과", 1000);
        } else if (fruit.equals("바나나")){
            fruitPrint("바나나", 3000);
        } else if (fruit.equals("복숭아")){
            fruitPrint("복숭아", 2000);
        } else if (fruit.equals("키위")){
            fruitPrint("키위", 5000);
        } else {
            System.out.println("준비된 상품이 없습니다.");
        }
    }

    public static void fruitPrint(String fruit, int price) {
        System.out.println(fruit + "의 가격은 " + price + "원 입니다.");
    }
}
