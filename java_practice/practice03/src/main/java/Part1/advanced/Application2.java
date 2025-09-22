package Part1.advanced;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("월 급여 입력:");
        int pay = scanner.nextInt();
        System.out.printf("매출액 입력:");
        int macul = scanner.nextInt();

        double bonus;
        if (macul >= 50000000) {
            bonus = 0.05;
        } else if (macul >= 30000000) {
            bonus = 0.03;
        }else if (macul >= 10000000) {
            bonus = 0.01;
        }else {
            bonus = 0;
        }

        int total_pay = totalPay(pay, macul, bonus);

        System.out.println("======================");
        System.out.println("매출액 : " + macul);
        System.out.println("보너스율 : " + (int)(bonus*100) + "%");
        System.out.println("월 급여 : " + pay);
        System.out.println("보너스 금액 : " + (int)(macul * bonus));
        System.out.println("======================");
        System.out.println("총 급여 : " + total_pay);
    }

    public static int totalPay (int pay, int macul, double bonus) {
        int total_pay = (int) (pay + (macul * bonus));
        return total_pay;
    }
}
