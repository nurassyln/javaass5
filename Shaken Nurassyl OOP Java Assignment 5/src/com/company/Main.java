package com.company;

import com.company.database.PostgreSQL;
import com.company.database.interfaces.IDB;
import com.company.repository.UserRepository;
import com.company.repository.interfaces.IUserRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgreSQL();

        IUserRepository repository = new UserRepository(db);

        MyApplication my_app = new MyApplication(repository);

        my_app.start();

    }
}
