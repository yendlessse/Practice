package com.ohgiraffers.virtualpet.service;

import com.ohgiraffers.virtualpet.db.LogDB;
import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;
import com.ohgiraffers.virtualpet.persistence.DogRepository;
import com.ohgiraffers.virtualpet.persistence.FileUserRepository;
import com.ohgiraffers.virtualpet.util.UserUtil;

import static com.ohgiraffers.virtualpet.util.ShowUtil.*;

import java.util.List;

public class DogServiceImpl implements DogService{
    private final DogRepository dogRepository;
    private final FileUserRepository userRepository;
    private final List<User> users;
    private final int ACTION_COST = 20;

    public DogServiceImpl(DogRepository dogRepository, FileUserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
        this.users = userRepository.loadUsers();
    }

    public void performAdopt (String dogName) {
        Dog dog = new Dog(dogName);
        dogRepository.insertDog(dog);

        System.out.println("🎉 기여운 " + dogName + " 을 입양했습니다! 🐾");
        printDogAdopt();

        // 입양한 강아지 리스트 보여주기
        printAdoptedDogs(dogRepository);
    }

    public boolean performGrown (Dog dog) {
        if (dog != null) {
            System.out.println(dog.getName() + "을 키우러 왔습니다!");
            printDogFace();
            return false;
        }else {
            System.out.println("잘못된 이름입니다. 다시 입력해주세요");
            return true;
        }
    }



    @Override
    public boolean performAction(User user, Dog dog, String action) {
        switch (action) {
            case "밥주기":
                UserUtil.checkAndRecharge(user);
                user.usePoints(20); LogDB.log(dog.getName() + " 밥주기 완료");
                dog.feed();
                printeatDog();
                System.out.println("🎉 " + dog.getName() + "의 배부름이 +10 증가했어요! 🍖");
                System.out.println("💰 현재 포인트: " + user.getPoints());
                break;

            case "놀아주기":
                UserUtil.checkAndRecharge(user);
                user.usePoints(20); LogDB.log(dog.getName() + " 놀아주기 완료");
                dog.play();
                printplayDog();
                System.out.println("🎾 " + dog.getName() + "의 기분이 +10 좋아졌어요! 😊");
                System.out.println("💰 현재 포인트: " + user.getPoints());
                break;

            case "재우기":
                UserUtil.checkAndRecharge(user);
                user.usePoints(20); LogDB.log(dog.getName() + " 재우기 완료");
                dog.sleep();
                printsleepDog();
                System.out.println("🛌 " + dog.getName() + "의 체력이 +10 회복되었어요! 💪");
                System.out.println("💰 현재 포인트: " + user.getPoints());
                break;

            case "종료":
                return false;

            default:
                System.out.println("❌ 어이쿠! 입력이 올바르지 않아요 😅 다시 시도해주세요 👉");
        }
        return true;
    }

    @Override
    public void decreaseStatus(Dog dog) {
        if (dog != null) {
            dog.decreaseHunger(20);
            dog.decreaseMood(20);
            dog.decreaseEnergy(20);
            LogDB.log(dog.getName() + " 상태 20씩 감소");
            dogRepository.updateDog(dog);
        }
    }

    @Override
    public Dog getDog(String dogName) {
        return dogRepository.selectDogByName(dogName);
    }
}
