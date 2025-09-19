package com.ohgiraffers.virtualpet.persistence;

import com.ohgiraffers.virtualpet.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository {
    private static final String FILE_PATH = "userDB.dat";

    public void saveUsers(List<User> users) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));
            List<User> users = (List<User>) in.readObject();
            in.close();
            return users;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

