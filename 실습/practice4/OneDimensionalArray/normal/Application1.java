package OneDimensionalArray.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        // 문자열 입력
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 하나 입력하세요 : ");
        String str = scanner.nextLine();
        char[] carr = str.toCharArray();

        // 검색할 문자 입력
        System.out.printf("검색할 문자를 입력하세요 : ");
        String find = scanner.nextLine();
        char find_c = find.charAt(0);

        // 검색한 문자 세기
        int count = 0;
        for (int i = 0 ; i < carr.length; i++) {
            if(carr[i] == find_c) {
                count++;
            }else {
                continue;
            }
        }

        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 "
                + find_c +"은 " + count +"개 입니다.");
    }
}
