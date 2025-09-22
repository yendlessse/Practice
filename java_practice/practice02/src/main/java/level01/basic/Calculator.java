package level01.basic;

import static java.lang.Math.abs;

public class Calculator {
    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (i + 1);
        }
        return sum;
    }

    public void checkMaxNumber(int a, int b) {
        int max = a > b ? a: b;
        System.out.println("두 수 중 큰 수는 " + max + "이다.");
    }

    public int sumTwoNumber(int a, int b) {
        return a+b;
    }

    public int minusTwoNumber(int a, int b) {
        return abs(a-b);
    }
}
