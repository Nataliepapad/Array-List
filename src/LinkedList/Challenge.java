package LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", name , distance);
    }
}

public class Challenge {

    public static void main(String[] args) {

        LinkedList<Place> placesAustralia = new LinkedList<>();

        //Adding places
        addPlace(placesAustralia, new Place("Adelaide", 1374));
        addPlace(placesAustralia, new Place("Alice Springs", 2771));
        addPlace(placesAustralia, new Place("Brisbane", 917));
        addPlace(placesAustralia, new Place("Darwin", 3972));
        addPlace(placesAustralia, new Place("Melbourne", 877));
        addPlace(placesAustralia, new Place("Perth", 3923));
        addPlace(placesAustralia, new Place("Perth", 3923));

        placesAustralia.addFirst(new Place("Sydney", 0));

        System.out.println(placesAustralia);

        //Menu
        boolean forward = true;
        boolean quit = false;
        var iterator = placesAustralia.listIterator();
        Scanner scanner = new Scanner(System.in);

        printMenu();

        while(!quit) {
            if(!iterator.hasPrevious()){
                System.out.println("User is starting from: " + iterator.next());
                forward = true;
            } else if (!iterator.hasNext()) {
                System.out.println("User reached final place: " + iterator.previous());
                forward = false;
            }
            System.out.println("Choose Action:");
            String action = scanner.nextLine().toUpperCase().substring(0,1);
            switch (action) {
                case "F" -> {
                    if (!forward) {
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println("User is moving to " + iterator.next());
                    }
                }
                case "B" -> {
                    if (forward) {
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("User is going back to " + iterator.previous());
                    }
                }
                case "L" -> printPlaces(placesAustralia);
                case "M" -> printMenu();
                default -> quit = true;
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place){

        //Checking for duplicates
        if(list.contains(place)){
            System.out.println(place + " already found on the list");
            return;
        }

        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println(place + " already found on the list");
                return;
            }
        }

        //Sorting places according to distance from Sydney
        int matchedIndex = 0;
        for( var listPlace: list){
            if (place.distance() < listPlace.distance()) {
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        list.add(place);
    }

    private static void printPlaces(LinkedList<Place> list){
        for (Place place : list) {
            System.out.println(place);
        }
    }
    private static void printMenu(){
        String textBlock = """
                Available actions:
                (F)orward
                (B)ackward
                (L)ist of Places
                (M)enu
                (Q)uit""";

        System.out.println(textBlock + " ");
    }
}
