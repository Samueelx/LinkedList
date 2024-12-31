package dev.lpa;

import java.util.LinkedList;
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
        boolean flag = true;
        while (flag){
            printPrompt();
            String input = scanner.nextLine();
            switch (input){
                case "L" -> {
                    Place nairobi = new Place("Nairobi", 90);
                    addPlace(places, nairobi);
                    addPlace(places, new Place("Muranga", 270));
                    addPlace(places, new Place("Thika", 70));
                    addPlace(places, new Place("Nakuru", 360));
                    addPlace(places, new Place("Naivasha", 320));
                    addPlace(places, new Place("Kiambu", 0));
                    System.out.println(places);
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
