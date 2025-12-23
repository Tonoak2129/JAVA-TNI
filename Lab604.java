import java.util.Scanner;

public class Lab604 {
    public static Scanner scn = new Scanner(System.in);

    public static void display_array(int[] numbers){
        System.out.print("List of numbers in array: ");
        for(int nums : numbers) {
            System.out.print(nums + " ");
        }
        System.out.println("");
    }
    public static int input_index(int[] numbers){
        System.out.print("Enter index: ");
        int index = scn.nextInt();
        while (index < 0 || index > numbers.length) {
            System.out.print("Invalid index!! Enter index, again: ");
            index = scn.nextInt();
        }
        return index;
    }
    public static boolean check_index(int[] numbers,int index){
        if (index < 0 || index >= numbers.length){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] numbers = {47,13,82,17,61,29,94,36};
        display_array(numbers);

        int index = input_index(numbers);

        System.out.println("");
        System.out.println("The number at index " + index + " is " + numbers[index]);

        if (check_index(numbers,index-1)) {
            System.out.println("The number before index " + index + " is " + numbers[index-1]);
        }
        else {
            System.out.println("The number before index " + index + " is Out of range!!");
        }

        if (check_index(numbers,index+1)){
            System.out.println("The number after index " + index + " is " + numbers[index+1]);
        }
        else {
            System.out.println("The number before index " + index + " is Out of range!!");
        }
    }
}
