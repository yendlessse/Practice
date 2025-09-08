package Part1.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        double height = scanner.nextDouble();

        double BMI = weight / (height * height);

        if (BMI < 20) {
            System.out.println("당신은 저체중 입니다");
        }else if (BMI < 25) {
            System.out.println("당신은 정상체중 입니다");
        }else if (BMI < 30) {
            System.out.println("당신은 과체중 입니다");
        }else {
            System.out.println("당신은 비만 입니다.");
        }
    }
}
