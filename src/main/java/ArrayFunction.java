import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunction {
    public static void main(String[] args) {
//        maxMin();
//        arraySort();
//        exitNumber();
//        duplicateNumber();
        employeeSalary();
//       int[] numbers=new int[3];
//       Scanner sc =new Scanner(System.in);
//        System.out.println("Input number : ");
//        int sum =0;
//
//        for (int i=0;i<numbers.length;i++){
//            numbers[i]=sc.nextInt();
//            sum+=numbers[i];
//
//        }
//        System.out.println(sum);
//

    }


    public static void maxMin() {
        int[] number = {20, 56, 100, 32, 40};
        int max = number[0];
        int min = number[0];
        for (int i = 0; i < number.length; i++) {
            if (number[i] > max) {
                max = number[i];
            }
            if (number[i] < min) {
                min = number[i];
            }
        }
        System.out.println(max);
        System.out.println(min);


    }

    //    Sort numbers in ascending and descending from an array
    public static void arraySort() {
        int[] numbers = {12, 20, 30, 40, 5, 7, 9, 10};
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }

    public static void exitNumber() {
        int[] numbers = {20, 4, 5, 7, 8, 10, 11};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input found number : ");
        boolean found = false;
        int toFind = sc.nextInt();
        for (int n : numbers) {
            if (n == toFind) {
                found = true;
                break;
            }

        }
        if (found) {
            System.out.println("Found");

        } else {
            System.out.println("Not Found");
        }

    }

    //    Find the duplicate element in array
    public static void duplicateNumber() {
        int[] arr = {10, 20, 5, 2, 4, 3, 4, 5};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);

                }
            }
        }

    }
    public static void employeeSalary(){
        int[] salary ={4500,8740,9875,7893,4561};
       Arrays.sort(salary);
        int n = salary.length;
        System.out.println(salary[n-2]);

    }
}
