package Boxing;

import java.util.ArrayList;
import java.util.Arrays;

public class Boxing {
    public static void main(String[] args) {
        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c','d','e'};
        System.out.println(Arrays.toString(characterArray));
        System.out.println(characterArray[0].getClass().getName());

        var intList = getList(2,4,10,6,7,8,9,5,4,6);
        System.out.println(intList);
    }

    private static int returnInt (Integer i){
        return i;
    }

    private static Integer returnInt (int i){
        return i;
    }

    private static ArrayList<Integer> getList(int... list){
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i: list){
            intList.add(i);
        }
        return intList;
    }
}


