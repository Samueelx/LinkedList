package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        boolean flag = true;
        while (flag){
            printPrompt();
            String input = scanner.nextLine();
            switch (input){
                case "I" ->
                    addPlaces(places);
                case "L" ->
                    listPlaces(places);
                case "F" -> moveForward(places);
                default -> {
                    flag = false;
                }
            }
        }

    }

    private static void printPrompt(){
        StringBuilder prompt = new StringBuilder();
        prompt.append("""
                Available Actions (select word or letter):
                (F)orward
                (B)ackward
                (I)nput Places
                (L)ist places
                (M)enu
                (Q)uit
                """).append("\n");
        System.out.println(prompt);
    }

    private static void addPlaces(LinkedList<Place> places){
        Place kiambu = new Place("Kiambu", 0);
        places.addFirst(kiambu);
        System.out.println("How many towns do you want recorded?");
        int numberOfTowns = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfTowns; i++){
            System.out.printf("Town %d%n", i+1);
            String town = scanner.nextLine().trim();
            System.out.printf("Distance from Home: %n");
            int distance = Integer.parseInt(scanner.nextLine().trim());
            places.add(new Place(town, distance));
        }
    }

    private static void listPlaces(LinkedList<Place> places){
        ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
    private static void moveForward(LinkedList<Place> places){
        ListIterator<Place> iterator = places.listIterator();
        Place previousPlace = iterator.next();//0
        while (iterator.hasNext()){
            System.out.println("--> From " + previousPlace.getTown() + " to " + iterator.next());//1
            previousPlace = town;
        }
    }
}
