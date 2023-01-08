package Array;

import java.util.Arrays;
import java.util.Random;

public class ArrayMain {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);
        System.out.println(Arrays.toString(thirdArray));

        Arrays.sort(thirdArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(firstArray));

        System.out.println("-".repeat(30));

        String[] sArray = {"Alex", "James", "Will", "Nathalie", "George"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray, "Alex") >= 0){
            System.out.println("Alex was found in the list");
        }

        int[] sortAsc = getRandomArray(5);
        System.out.println(Arrays.toString(sortAsc));
        Arrays.sort(sortAsc);
        System.out.println(Arrays.toString(sortAsc));
        int[] sortDesc = Arrays.copyOf(sortAsc, sortAsc.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for(int i = 0; i < sortDesc.length - 1; i++){
                if(sortDesc[i] < sortDesc[i + 1]){
                    temp = sortDesc[i];
                    sortDesc[i] = sortDesc[i + 1];
                    sortDesc[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(sortDesc));

    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
