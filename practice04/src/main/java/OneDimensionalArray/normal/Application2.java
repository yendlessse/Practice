package OneDimensionalArray.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        //주민등록 번호 입력
        Scanner scanner = new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요 : ");
        String id_arr = scanner.nextLine();

        // 문자 배열로 저장
        char[] id_carr = id_arr.toCharArray();

        // 성별자리 이후 가려서 출력
        String hide_id = "";
        for (int i = 0; i < id_carr.length; i++) {
            if ( i <= 6 ){
                hide_id += id_carr[i];
            }else {
                hide_id += "*";
            }
        }

        System.out.println(hide_id);
    }
}
