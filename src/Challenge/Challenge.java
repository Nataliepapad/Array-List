package Challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();

        boolean flag = true;
        while(flag){
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
                case 0 -> flag = false;
            }

            groceryList.sort(Comparator.naturalOrder());
            if(!groceryList.isEmpty()) {
                System.out.println(groceryList);
            } else {
                System.out.println("No items in the list");
            }
        }

    }

    private static Scanner scanner = new Scanner(System.in);

    private static void addItems(ArrayList<String> groceryList){
        String[] items = scanner.nextLine().split(",");

        for(String i : items){
            String trimmed = i.trim();
            if(!groceryList.contains(trimmed)){
                groceryList.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceryList){
        String[] items = scanner.nextLine().split(",");
        for(String i : items){
            String trimmed = i.trim();
                groceryList.remove(trimmed);
        }
    }
    private static void printActions(){
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list
                2 - to remove items
                Enter a number for which action you wish to do:""";

        System.out.println(textBlock + " ");
    }
}
