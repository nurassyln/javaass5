package com.company;

import com.company.controller.UserController;
import com.company.repository.UserRepository;
import com.company.repository.interfaces.IUserRepository;

import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(IUserRepository repository){
        this.controller = new UserController(repository);
        this.scanner = new Scanner(System.in);
    }


    public void start(){
            while(true){
                System.out.println();
                System.out.println("Выберите опцию:");
                System.out.println("1. Добавить камень");
                System.out.println("2. Удалить камень");
                System.out.println("3. Создать ожерелье");
                System.out.println("4. Удалить ожерелье");
                System.out.println("5. Увидеть ожерелье ");
                System.out.println("6. Увидеть камень");
                System.out.println();
                try {
                    System.out.println("Введите опцию (1-6): ");
                    int option = scanner.nextInt();
                    if (option == 1){
                        addStone();
                    }else if(option == 2){
                        deleteStone();
                    }else if(option == 3){
                        createNecklace();
                    }else if(option == 4){
                        deleteNecklace();
                    }else if(option == 5){
                        seeNecklace();
                    }else if(option == 6){
                        seeStone();
                    }else{
                        break;
                    }
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                    scanner.next();
                }
                System.out.println("*********************");
            }
    }

    private void addStone(){
        System.out.println("Введите название камня: ");
        String name = scanner.next();
        System.out.println("Укажите цену в нац. валюте: ");
        int price = scanner.nextInt();
        System.out.println("Укажите удельный вес в каратах: ");
        int weight = scanner.nextInt();

        String response =controller.addStone(name, price, weight);
        System.out.println(response);
    }

    private void deleteStone(){
        System.out.println("Введите id камня, которого нужно удалить.:");
        int id = scanner.nextInt();
        System.out.println(controller.deleteStone(id));
    }

    private void createNecklace(){
        System.out.println("Введите название ожерелья: ");
        String name = scanner.next();
        System.out.println("Укажите удельный вес в каратах: ");
        int weight = scanner.nextInt();
        System.out.println("Укажите цену в нац. валюте: ");
        int price = scanner.nextInt();
        System.out.println("Сколько камней должно быть в ожерелье?: ");
        int amountOfStones= scanner.nextInt();
        String response = controller.createNecklace(name,weight,price,amountOfStones);
        System.out.println(response);
    }

    private void deleteNecklace(){
        System.out.println("Введите id ожерелья, которое нужно удалить.");
        int id = scanner.nextInt();
        System.out.println(controller.deleteNecklace(id));
    }

    private void seeStone(){
        System.out.println("Введите id камня: ");

        int id = scanner.nextInt();
        String response = controller.getStoneById(id);
        System.out.println(response);
    }

    private void seeNecklace(){
        System.out.println("Введите id ожерелья:");
        int id = scanner.nextInt();
        System.out.println(controller.getNecklaceById(id));
    }
}


