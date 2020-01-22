package org.kizilay.yusuf.caveatemptor;

import java.util.ArrayList;
import java.util.List;

public class MainTests {

    public static void main(String[] args) {

        List<Integer> list= new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);


        list.parallelStream().forEach(element-> {
            System.out.println( element +" starting....");

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println( element +" finishing....");
        });


        System.out.println("Main thread running!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
}
