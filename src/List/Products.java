package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Products {
    public static void main(String[] args) {
        String[] items = {"Apples" , "Bananas", "EGGS", "milk"};

        List<String> list = List.of(items);
        System.out.println(list);

        System.out.println(list.getClass().getName());

        System.out.println("-".repeat(30));

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("Yogurt");
        groceries.replaceAll(String::toLowerCase);
        System.out.println(groceries);

        System.out.println("-".repeat(30));

        ArrayList<String> nextList = new ArrayList<>(
                List.of("water", "chocolate", "tomatoes"));
        nextList.replaceAll(String::toLowerCase);
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("-".repeat(30));

        System.out.println("Third items is: "+ groceries.get (2));

        if(groceries.contains("mustard")){
            System.out.println("List contains mustard");
        } else if (groceries.contains("water")){
            System.out.println("List contains water");
        }

        groceries.add("yogurt");
        System.out.println("We find \"Yogurt\" at position: " + groceries.indexOf("yogurt")
                            + " and at position: " + groceries.lastIndexOf("yogurt"));

        groceries.add("yogurt");
        groceries.add("yogurt");
        System.out.println(groceries);

        groceries.remove("yogurt");
        System.out.println(groceries);

        groceries.removeAll(List.of("yogurt"));
        System.out.println(groceries);

        groceries.retainAll(List.of("water", "chocolate", "tomatoes"));
        System.out.println(groceries);

        groceries.clear();
        if(groceries.isEmpty()){
            System.out.println("The groceries list is empty");
        }

        System.out.println("-".repeat(30));

        groceries.addAll(List.of("mustard", "ketchup", "bbq", "coffee"));
        groceries.addAll(Arrays.asList("milk", "oranges", "lemon"));
        System.out.println(groceries);

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
    }
}
