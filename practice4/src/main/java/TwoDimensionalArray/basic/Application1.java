package TwoDimensionalArray.basic;

public class Application1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];

        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count;
                count ++;
            }
        }
        arrPrint(arr);
    }

    private static void arrPrint (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
