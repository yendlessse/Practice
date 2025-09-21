package com.ohgiraffers.virtualpet.ui;

import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;
import com.ohgiraffers.virtualpet.persistence.DogRepository;
import com.ohgiraffers.virtualpet.persistence.DogStorage;
import com.ohgiraffers.virtualpet.persistence.FileDogRepository;
import com.ohgiraffers.virtualpet.persistence.FileUserRepository;
import com.ohgiraffers.virtualpet.service.DogService;
import com.ohgiraffers.virtualpet.service.DogServiceImpl;
import com.ohgiraffers.virtualpet.util.TimerUtil;

import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.virtualpet.util.ShowUtil.printAdoptedDogs;
import static com.ohgiraffers.virtualpet.util.ShowUtil.printDogStatus;

public class Application_final {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DogStorage dogStorage = new FileDogRepository();
        DogRepository dogRepo = new DogRepository(dogStorage);
        FileUserRepository userRepo = new FileUserRepository();
        DogServiceImpl dogService = new DogServiceImpl(dogRepo, userRepo);

        //사용자 로드 (첫 가입자의 경우)
        List<User> users = userRepo.loadUsers();
        User user;
        if (users.isEmpty()) {
            user = new User("player1", 100); // 기본 포인트 100
            users.add(user);
            userRepo.saveUsers(users);
        } else {
            user = users.get(0);
        }

        //강아지 입양/키우기 선택
        System.out.println("🐶✨ 안녕하세요! 귀여운 강아지 키우기 게임에 오신걸 환영합니다! ✨🐶");

        Dog selectedDog = null;
        while (true) {
            System.out.print("강아지를 입양하시겠어요? 키우러 가시겠어요? (입양/키우기/종료) 👉 ");
            String choice = sc.nextLine().trim();

            if (choice.equals("입양")) {
                System.out.print("강아지 이름을 입력하세요👉 ");
                String dogName = sc.nextLine().trim();
                selectedDog = new Dog(dogName);
                dogService.performAdopt(dogName);
                continue;
            }else if (choice.equals("키우기")){
                List<Dog> dogs = dogRepo.selectAllDogs();

                boolean action = true;
                while (action) {
                    // 입양한 강아지 리스트 보여주기
                    printAdoptedDogs(dogRepo);
                    System.out.print("💌 키우러 갈 강아지를 이름을 입력해주세요 🐾 ");
                    String selectedDogName = sc.nextLine().trim();
                    selectedDog = dogs.stream()
                            .filter(d -> d.getName().equalsIgnoreCase(selectedDogName))
                            .findFirst()
                            .orElse(null);

                    action = dogService.performGrown(selectedDog);
                }

                break;
            }else if (choice.equals("종료")) {
                System.out.println("\n🎉 게임 종료 🎉");
                System.out.println("🐶 다음에 또 놀러와요! 안녕! 👋");
                return;
            }else {
                System.out.println("잘못된 입력입니다. '입양', '키우기', '종료' 중 하나를 입력해주세요.");
            }
        }

        //강아지 선택 완료 후 새로운 루프 시작
        TimerUtil timer = new TimerUtil(dogService, selectedDog);
        timer.start();

        boolean run = true;
        while (run) {

            selectedDog = dogService.getDog(selectedDog.getName());

            //상태 출력
            printDogStatus(selectedDog);

            //사용자 행동 선택
            System.out.println("💡 무엇을 하시겠어요? 🐾");
            System.out.println("1️⃣ 밥주기 🍖 / 2️⃣ 놀아주기 🎾 / 3️⃣ 재우기 🛌 / 4️⃣ 종료 ❌");

            String action_choice = sc.nextLine().trim();
            run = dogService.performAction(user, selectedDog, action_choice);

            if (!run) {
                timer.stopTimer();
                userRepo.saveUsers(users);
                System.out.println("\n🎉 게임 종료 🎉");
                System.out.println("🐶 다음에 또 놀러와요! 안녕! 👋");
            }
        }
    }
}
