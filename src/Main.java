import java.util.Random;
import java.util.Scanner;
import java.util.stream.*;
import java.math.*;

public class Main {

    //lists the values contained with an array
    public static void listArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]); //draw values

            if (i+1 != size) {          //if not on last value, draw a comma between each value
                System.out.print(", ");
            }
        }
        System.out.print("\n");         //new line
    }

    //checks if the array has been ordered
    public static boolean checkArray(int[] array, int size) {
        int check = 1;
        boolean r = false;
        for (int i = 1; i < size; i++) {
            if (array[i-1] <= array[i]) {
                check++;
            }
            else break;
        }

        if (check == size) {
            r = true;
        }
        else if (check != size) {
            r = false;
        }
        return r;
    }

    //draws a graph of an array's values
    public static void drawArray(int[] array, int size) {
        //draw gui
        for (int i2 = 1; i2 <= size; i2++) {
            for (int i3 = 0; i3 <= array[i2-1]; i3++) {
                System.out.print("▨"); //each box = 1
            }
            System.out.print("\n");
        }

        System.out.print("\n------------------------\n");
    }

    //bubble sort algorithm
    public static void bubblesort(int size, int[] values) {
        int swap1 = 0;
        int swap2 = 0;

        for (int i = 1; i < size; i++) {
            if (values[i-1] > values[i]) {
                swap1 = values[i-1];
                swap2 = values[i];
                values[i-1] = swap2;
                values[i] = swap1;

                drawArray(values, size);
            }
        }
    }

    //bogo sort algorithm
    public static void bogosort(int size, int[] values) {
        int swap1 = 0;
        int swap2 = 0;
        int r = (int)(Math.random() * size); // random number from 0 to array size

        for (int i = 1; i < size; i++) {
            swap1 = values[r];
            swap2 = values[i];
            values[r] = swap2;
            values[i] = swap1;

            drawArray(values, size);
        }
    }


    public static void main(String[] args) {
        try {

          Scanner input = new Scanner(System.in);

            //list of sort types (used later)
            String[] sortTypes = new String[2];
            sortTypes[0] = "Bubble sort";
            sortTypes[1] = "Bogo sort";

            //select array type
            System.out.println("Select array type from lsit:\n[1] Bubble sort \n[2] Bogo sort");
            int type = input.nextInt();

          //set array size
          System.out.println("enter number of values to be sorted");
          int size = input.nextInt();
          int[] values = new int[size];


            //for the data entry loop
            int i = 0;
            //data entry
            while (i < size) {
                System.out.println("enter value " + (i+1) + "/" + size);
                values[i] = input.nextInt();
                i++;
            }

            //show array before sorting
            System.out.println("before:");
            listArray(values, size);

          //sort
          while (checkArray(values, size) != true) {
                switch (type) {
                    case 1:
                        bubblesort(size, values);
                    break;
                    case 2:
                        bogosort(size, values);
                    break;
                    default:
                        bubblesort(size, values);
                    break;
                }
            }

            //show values after being sorted
            System.out.println("after:");
            listArray(values, size);
            System.out.println("using: " + sortTypes[type-1]);

        }
        catch (Exception e) {
            System.out.println("Error: " + e );
        }

    }

}