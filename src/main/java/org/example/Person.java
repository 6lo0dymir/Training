package org.example;

public class Person {
    String name;
    int age;

    Person(){

        name = "Tom";
        age = 21;
    }
    Person(String username){
        name = username;
        age = 21;
    }
    Person(String username, int userage){
        name = username;
        age = userage;
    }
    void print(){
        System.out.println("Имя: " + name);
        System.out.println("Возраст: "+age);
    }
}
