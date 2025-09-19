package com.ohgiraffers.virtualpet.service;

import com.ohgiraffers.virtualpet.domain.Action;
import com.ohgiraffers.virtualpet.domain.Dog;

public interface IDDogService {
    void performAction(String dogName, Action action);
    void decreaseStatus(String dogName);
    Dog getDog(String dogName);
}
