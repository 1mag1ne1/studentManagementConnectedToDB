package com.hohai.main;

import com.hohai.module.Student;
import com.hohai.service.StudentManagerService;
import com.sun.org.glassfish.gmbal.GmbalException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }


    public static void run(){
        System.out.println("----------welcome to Walt's StudentManagementSystem----------");
        System.out.println("press any key to continue!!!");
        scanner.next();
        System.out.println("now chose your option by entering the number below:");
        while(true){
            System.out.println("1.show all students' information\n2.delete student's information by id\n3.add\n4.update by id\n5.exit\n");
            int s = scanner.nextInt();
            Service(s);
        }
    }
    public static void Service(int s){
        int id;
        String name;
        int age;
        switch (s){
            case 1:
                System.out.println(StudentManagerService.selectAllStudent());
                break;
            case 2:
                System.out.println("enter the id");
                id = scanner.nextInt();
                StudentManagerService.deleteById(id);
                break;
            case 3:
                System.out.println("enter id:");
                id = scanner.nextInt();
                System.out.println("enter name:");
                name = scanner.next();
                System.out.println("enter age:");
                age = scanner.nextInt();
                StudentManagerService.updateAdd(id,name,age);
                break;
            case 4:
                System.out.println("enter id:");
                id = scanner.nextInt();
                System.out.println("enter name:");
                name = scanner.next();
                System.out.println("enter age:");
                age = scanner.nextInt();
                StudentManagerService.modefyById(id,name,age);
                break;
            case 5:
                System.exit(0);
            default:

        }
    }
}