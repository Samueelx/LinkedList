package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String town, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", town, distance);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        addPlace(places, new Place("Nairobi", 90));
        addPlace(places, new Place("Muranga", 270));
        addPlace(places, new Place("Thika", 70));
        addPlace(places, new Place("Nakuru", 360));
        addPlace(places, new Place("Naivasha", 320));
        addPlace(places, new Place("Kiambu", 0));
        ListIterator<Place> iterator = places.listIterator();
        boolean flag = true;
        boolean forward = true;
        printPrompt();
        while (flag){
            if (!iterator.hasPrevious()){
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()){
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }
            System.out.print("Enter a value: ");
            String input = scanner.nextLine().toUpperCase().substring(0, 1);
            switch (input){
                case "L" -> {
                    System.out.println(places);
                }
                case "M" -> printPrompt();
                case "F" -> {
                    System.out.println("User wants to move forward");
                    if (!forward){
                        forward = true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext())
                        System.out.println(iterator.next());
                }
                case "B" -> {
                    System.out.println("User wants to move backwards");
                    if (forward){
                        forward = false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious())
                        System.out.println(iterator.previous());
                }
                default -> flag = false;
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
                (Q)uit """).append("\n");
        System.out.println(prompt);
    }
    private static void addPlace(LinkedList<Place> places, Place place){
        if (places.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }
        for (Place p: places){
            if (p.town().equalsIgnoreCase(place.town())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }
        int matchedIndex = 0;
        for (Place p : places){
            if (place.distance() < p.distance()){
                places.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        places.add(place);
    }


}
