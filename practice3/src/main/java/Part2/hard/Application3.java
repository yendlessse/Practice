package Part2.hard;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String str = scanner.nextLine();

        // 문자열이 영문자인지 확인
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                System.out.println("영문자가 아닌 문자열이 포함되어 있습니다.");
                return;
            }
        }

        System.out.print("찾을 문자 입력 : ");
        String findChar = scanner.nextLine();


        char target = findChar.charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        System.out.println("포함된 갯수: " + count + "개");
    }
}
