package org.example;

public class SimpleCalculator{

    void sum (int a, int b){
        System.out.println("Результат = "+(a+b));
    }
    void sub (int a, int b){
        System.out.println("Результат = "+(a-b));
    }
    void mult (int a, int b){
        System.out.println("Результат = "+(a*b));
    }
    void div (int a, int b) throws ArithmeticException{
        try{
            if (b==0){
                throw  new ArithmeticException("На ноль делить нельзя!");
            }
            System.out.println("Результат = "+(a/b));
        }catch (ArithmeticException e){
            System.out.println("Ошибка! " +e.getMessage());
        }
    }

}