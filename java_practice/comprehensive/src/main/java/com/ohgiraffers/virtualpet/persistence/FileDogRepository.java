package com.ohgiraffers.virtualpet.persistence;

import com.ohgiraffers.virtualpet.domain.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDogRepository implements DogStorage {
    private static final String FILE_PATH = "dogsDB.dat";

    @Override
    public void saveDogs(List<Dog> dogs) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            out.writeObject(dogs);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dog> loadDogs() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));
            List<Dog> dogs = (List<Dog>) in.readObject();
            in.close();
            return dogs;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
