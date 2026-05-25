package org.example;

import java.util.*;

public class RandomNumbersSum {
    Random random = new Random();
    int a = random.nextInt(6) + 1;
    int b = random.nextInt(6) + 1;
    public void SumAndPrint() {
        System.out.println("a = " + a + " b = " + b);
        int c = a + b;
        System.out.println("c = " + c);
        if (c > 7) {
            System.out.println("Число " + c + " больше " + 7);
        } else if (c<7) {
            System.out.println("Число " + c + " меньше " + 7);
        }else{
            System.out.println("Число "+c+" равно "+ 7);
        }
    }
}
