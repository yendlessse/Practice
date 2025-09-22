package com.ohgiraffers.virtualpet.persistence;

import com.ohgiraffers.virtualpet.domain.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogRepository {
    private final DogStorage dogStorage;
    private final List<Dog> dogList;

    public DogRepository(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
        this.dogList = dogStorage.loadDogs();
    }

    //모든 강아지 반환
    public List<Dog> selectAllDogs() {
        return new ArrayList<>(dogList);
    }

    // 이름으로 특정 강아지 찾기
    public Dog selectDogByName(String name) {
        return dogList.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    //새로운 강아지 추가
    public void insertDog(Dog dog) {
        dogList.add(dog);
        dogStorage.saveDogs(dogList);
    }

    //강아지 삭제
    public void deleteDog(String name) {
        dogList.removeIf(dog -> dog.equals(name));
        dogStorage.saveDogs(dogList);
    }

    //강아지 정보 업데이트
    public void updateDog(Dog updatedDog) {
        for (int i = 0; i < dogList.size(); i++) {
            if (dogList.get(i).getName().equals(updatedDog.getName())) {
                dogList.set(i, updatedDog);
                dogStorage.saveDogs(dogList);
                break;
            }
        }
    }
}
