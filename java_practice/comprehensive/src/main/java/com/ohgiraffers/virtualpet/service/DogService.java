package com.ohgiraffers.virtualpet.service;

import com.ohgiraffers.virtualpet.domain.Action;
import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;

public interface DogService {
    boolean performAction(User user, Dog dog, String action);
    void decreaseStatus(Dog dog);
    Dog getDog(String dogName);
}
