package Part2.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("문자열을 입력하세요: ");
        String str = scanner.nextLine();

        System.out.printf("숫자를 입력하세요: ");
        int n = scanner.nextInt();

        n %= 26;

        for (int i = 0 ; i < str.length(); i++){
            if (str.charAt(i) == ' ') {
                continue;
            }else {
               // 대문자 일때
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    int base = 'A';
                    char code = (char) (base + (str.charAt(i) -base + n) % 26);
                    System.out.print(code + " ");
                }

                //소문자 일때
                else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    int base = 'a';
                    char code = (char) (base + (str.charAt(i) -base + n) % 26);
                    System.out.print(code + " ");
                }

            }
        }
    }
}
