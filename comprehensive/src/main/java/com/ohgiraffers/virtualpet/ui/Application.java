package com.ohgiraffers.virtualpet.ui;

import com.ohgiraffers.virtualpet.domain.Action;
import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;
import com.ohgiraffers.virtualpet.persistence.DogRepository;
import com.ohgiraffers.virtualpet.persistence.DogStorage;
import com.ohgiraffers.virtualpet.persistence.FileDogRepository;
import com.ohgiraffers.virtualpet.persistence.FileUserRepository;
import com.ohgiraffers.virtualpet.service.DogService;
import com.ohgiraffers.virtualpet.util.TimerUtil;
import com.ohgiraffers.virtualpet.util.UserUtil;

import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.virtualpet.util.ShowUtil.*;
import static com.ohgiraffers.virtualpet.util.UserUtil.checkAndRecharge;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Repository & Service 초기화
        DogStorage dogStorage = new FileDogRepository();
        DogRepository dogRepo = new DogRepository(dogStorage);
        FileUserRepository userRepo = new FileUserRepository();
        DogService dogService = new DogService(dogRepo, userRepo);

        //사용자 로드 (첫 가입자의 경우)
        List<User> users = userRepo.loadUsers();
        User user;
        if (users.isEmpty()) {
            user = new User("player2", 50); // 기본 포인트 1000
            users.add(user);
            userRepo.saveUsers(users);
        } else {
            user = users.get(0);
        }

        //강아지 입양/키우기 선택
        System.out.println("🐶✨ 안녕하세요! 귀여운 강아지 키우기 게임에 오신걸 환영합니다! ✨🐶");
        Dog dog = null;
        while (true) {
            System.out.print("강아지를 입양하시겠어요? 키우러 가시겠어요? (입양/키우기/종료) 👉 ");
            String choice = sc.nextLine().trim();

            if (choice.equals("입양")) {
                System.out.print("강아지 이름을 입력하세요👉 ");
                String dogName = sc.nextLine().trim();
                dog = new Dog(dogName);
                dogRepo.insertDog(dog);

                System.out.println("🎉 기여운 " + dogName + " 을 입양했습니다! 🐾");
                printDogAdopt();

                // 입양한 강아지 리스트 보여주기
                printAdoptedDogs(dogRepo);
                continue;

            }else if (choice.equals("키우기")){
                List<Dog> dogs = dogRepo.selectAllDogs();

                while (true) {
                    // 입양한 강아지 리스트 보여주기
                    printAdoptedDogs(dogRepo);
                    System.out.print("💌 키우러 갈 강아지를 이름을 입력해주세요 🐾 ");
                    String selectedDogName = sc.nextLine().trim();

                    Dog selectedDog = dogs.stream()
                            .filter(d -> d.getName().equalsIgnoreCase(selectedDogName))
                            .findFirst()
                            .orElse(null);

                    if (selectedDog != null) {
                        dog = selectedDog;
                        System.out.println(dog.getName() + "을 키우러 왔습니다!");
                        printDogFace();
                        break;
                    }else {
                        System.out.println("잘못된 이름입니다. 다시 입력해주세요");
                    }
                }

                break;
            }else if (choice.equals("종료")){
                System.out.println("\n🎉 게임 종료 🎉");
                System.out.println("🐶 다음에 또 놀러와요! 안녕! 👋");
                return;
            }else {
                System.out.println("잘못된 입력입니다. '입양', '키우기', '종료' 중 하나를 입력해주세요.");
            }
        }

        //강아지 선택 완료 후 새로운 루프 시작
        TimerUtil timer = new TimerUtil(dogService, dog.getName());
        timer.start();

        boolean run = true;

        while(run) {
            dog = dogService.getDog(dog.getName());

            //상태 출력
            printDogStatus(dog);

            //사용자 행동 선택
            System.out.println("💡 무엇을 하시겠어요? 🐾");
            System.out.println("1️⃣ 밥주기 🍖 / 2️⃣ 놀아주기 🎾 / 3️⃣ 재우기 🛌 / 4️⃣ 종료 ❌");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "밥주기":
                    if (!checkAndRecharge(user, sc)) break;
                    user.usePoints(20);
                    dogService.performAction(dog.getName(), Action.FEED);
                    printeatDog();
                    System.out.println("🎉 " + dog.getName() + "의 배부름이 +10 증가했어요! 🍖");
                    System.out.println("💰 현재 포인트: " + user.getPoints());
                    break;

                case "놀아주기":
                    if (!checkAndRecharge(user, sc)) break;
                    user.usePoints(20);
                    dogService.performAction(dog.getName(), Action.PLAY);
                    printplayDog();
                    System.out.println("🎾 " + dog.getName() + "의 기분이 +10 좋아졌어요! 😊");
                    System.out.println("💰 현재 포인트: " + user.getPoints());
                    break;

                case "재우기":
                    if (!checkAndRecharge(user, sc)) break;
                    user.usePoints(20);
                    dogService.performAction(dog.getName(), Action.SLEEP);
                    printsleepDog();
                    System.out.println("🛌 " + dog.getName() + "의 체력이 +10 회복되었어요! 💪");
                    System.out.println("💰 현재 포인트: " + user.getPoints());
                    break;

                case "종료":
                    run = false;
                    timer.interrupt(); // 타이머 종료
                    dogRepo.updateDog(dog); // 강아지 상태 저장
                    userRepo.saveUsers(List.of(user)); // 사용자 상태 저장

                    printDogStatus(dog);
                    System.out.println("💰 현재 포인트: " + user.getPoints());
                    System.out.println("\n🎉 게임 종료 🎉");
                    System.out.println("🐶 다음에 또 놀러와요! 안녕! 👋");
                    break;

                default:
                    System.out.println("❌ 어이쿠! 입력이 올바르지 않아요 😅 다시 시도해주세요 👉");
            }

        }
    }
}
