package OneDimensionalArray.basic;

public class Application1 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0 ; i < 10; i++) {
            arr[i] = i+1;
        }

        showArr(arr);
    }

    public static void showArr(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
