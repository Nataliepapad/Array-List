import java.util.ArrayList;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type.toUpperCase());
    }
}

public class Groceries {

    public static void main(String[] args) {
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "fruit", 4);
        groceryArray[2] = new GroceryItem("oranges", "fruit", 7);

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("butter"));
        groceryList.add(new GroceryItem("milk"));
        groceryList.add(new GroceryItem("apples", "fruit", 4));
        groceryList.add(0, new GroceryItem("oranges", "fruit", 7));
        System.out.println(groceryList);

        groceryList.remove(1);
        System.out.println(groceryList);
    }
}