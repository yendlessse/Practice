package level2.normal;

public class RandomMaker {
    public static int randomNumber(int min, int max){
        int ans = (int)( Math.random() * (max - min + 1)) + min;
        return ans;
    }

    public static String randomUpperAlphabet(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = (char)((int)(Math.random() * 26) + 'A');
            sb.append(c);
        }
        return sb.toString();
    }

    public static String rockPaperScissors() {
        String[] rps = new String[]{"가위", "바위", "보"};
        int idx = (int)( Math.random() * 3);
        return rps[idx];
    }

    public static String tossCoin() {
        String[] coins = new String[]{"앞면", "뒷면"};
        int idx = (int)( Math.random() * 2);
        return coins[idx];
    }
}
