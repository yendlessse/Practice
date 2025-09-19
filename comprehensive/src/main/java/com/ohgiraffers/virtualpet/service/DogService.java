package com.ohgiraffers.virtualpet.service;

import com.ohgiraffers.virtualpet.db.LogDB;
import com.ohgiraffers.virtualpet.domain.Action;
import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;
import com.ohgiraffers.virtualpet.persistence.DogRepository;
import com.ohgiraffers.virtualpet.persistence.FileUserRepository;

import java.util.List;

public class DogService implements IDDogService {

    private final DogRepository dogRepository;
    private final FileUserRepository userRepository;
    private final List<User> users;
    private final int ACTION_COST = 20;

    public DogService(DogRepository dogRepository, FileUserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
        this.users = userRepository.loadUsers();
    }

    @Override
    public void performAction(String dogName, Action action) {
        Dog dog = dogRepository.selectDogByName(dogName);
        if (dog == null) {
            System.out.println("강아지가 없습니다!");
            return;
        }

        User user = users.get(0);
        if (user.getPoints() < ACTION_COST) {
            System.out.println("포인트가 부족합니다!");
            return;
        }

        user.usePoints(ACTION_COST);
        userRepository.saveUsers(users);

        switch (action) {
            case FEED -> { dog.feed(); LogDB.log(dogName + " 밥주기 완료"); }
            case PLAY -> { dog.play(); LogDB.log(dogName + " 놀아주기 완료"); }
            case SLEEP -> { dog.sleep(); LogDB.log(dogName + " 잠재우기 완료"); }
        }

        dogRepository.updateDog(dog);
    }

    @Override
    public void decreaseStatus(String dogName) {
        Dog dog = dogRepository.selectDogByName(dogName);
        if (dog != null) {
            dog.decreaseHunger(20);
            dog.decreaseMood(20);
            dog.decreaseEnergy(20);
            LogDB.log(dogName + " 상태 20씩 감소");
            dogRepository.updateDog(dog);
        }
    }

    @Override
    public Dog getDog(String dogName) {
        return dogRepository.selectDogByName(dogName);
    }
}
