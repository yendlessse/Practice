package level2.normal;

public class Application {
    public static void main(String[] args) {
        //첫 번째 인자의 최소값 부터 두 번째 인자까지 범위의 난수를 출력 (randomNumber 호출)
        int num = RandomMaker.randomNumber(1, 10);
        System.out.println(num);
        //인자로 전달한 정수 길이의 랜덤한 문자열을 출력함 (randomUpperAlphabet 호출)
        String str = RandomMaker.randomUpperAlphabet(4);
        System.out.println(str);
        //가위, 바위, 보 중 한 가지를 출력함 (rockPaperScissors 호출)
        String rpc = RandomMaker.rockPaperScissors();
        System.out.println(rpc);
        //앞면, 뒷면 중 한 가지를 출력함 (tossCoin 호출)
        String coin = RandomMaker.tossCoin();
        System.out.println(coin);
    }
}
