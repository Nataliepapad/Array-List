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
        addPlace(placesAustralia, new Place("Sydney", 0));

        //Menu
        boolean flag = true;
        while(flag) {
            printActions();
            switch (scanner.nextLine()) {
                case "Forward" :
                case "F" : forwardPlace(placesAustralia);
                case "Backward":
                case "B" : backwardPlace(placesAustralia);
                case "List of Places":
                case "L" :printPlaces(placesAustralia);
                case "Menu":
                case "M" :printActions();
                case "Quit":
                default : flag = false;
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static void addPlace(LinkedList<Place> list, Place place){

        //Checking for duplicates
        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println(p + " already found on the list");
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

    private static void forwardPlace(LinkedList<Place> list){
        String place = scanner.nextLine();

        var iterator = list.listIterator();
        while (iterator.equals(place) && iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void backwardPlace(LinkedList<Place> list){
        String place = scanner.nextLine();

        var iterator = list.listIterator();
        while (iterator.equals(place) && iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }

    private static void printPlaces(LinkedList<Place> list){
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    private static void printActions(){
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
