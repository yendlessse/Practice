package com.ohgiraffers.virtualpet.persistence;

import com.ohgiraffers.virtualpet.domain.Dog;

import java.util.List;

public interface DogStorage {
    void saveDogs(List<Dog> dogs);
    List<Dog> loadDogs();
}
