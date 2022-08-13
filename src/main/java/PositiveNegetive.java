import java.net.PortUnreachableException;
import java.util.Scanner;

public class PositiveNegetive {
    public static void main(String[] args) {
// Call from function
//     useFun();
//     greatFunc();
//     leapYearFun();
//        smallCapital();
//        gpaFind();
//        decimalNumber();
//        factorial();
//        primeNumber();
//        maxMin();
        keyBoarrdPress();
//      Using normal method

//        System.out.println("Enter value ");
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        if (number>0){
//            System.out.println("Positive");
//
//        }else {
//            System.out.println("Negative");
//        }


    }

    // Write a program to get a number from the user and print whether it is positive or negative.
    // Using function
    public static void useFun() {
        System.out.println("Enter value ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("Positive");

        } else {
            System.out.println("Negative");
        }

    }

    // Take three numbers from the user and print the greatest number
    public static void greatFunc() {
        System.out.println("Enter gretest number : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter number 2 :");
        int num2 = sc.nextInt();
        System.out.println("Enter number 3");
        int num3 = sc.nextInt();
        if (num1 > num2 && num1 > num3) {
            System.out.println("Perform first statement");
        } else if (num2 > num3 && num2 > num1) {
            System.out.println("Perform second statement ");

        } else if (num3 > num1 && num3 > num2) {
            System.out.println("perform third statement ");

        } else {
            System.out.println("Small");
        }


    }

    //    Leap year code programming practice
//Write a program that takes a year from user and print whether that year is a leap year or not
    public static void leapYearFun() {
        System.out.println("Enter leap year value :");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is Leyap year");
        } else {
            System.out.println(year + " is Not leap year");
        }

    }
//    Write a program to check if inputted letter is small or capital
//    Identify small or capital number

    public static void smallCapital() {
        System.out.println("Enter small number or capital number : ");
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(ch + " is an uppercase");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch + " is a lowercase");

        } else {
            System.out.println("Not an upper and lowercase ");
        }

    }

    //    Write a program to calculate GPA and find grade
    public static void gpaFind() {

        Scanner sc = new Scanner(System.in);
        int marks[] = new int[6];
        int i;
        float total = 0, avg = 0;
        for (i = 0; i < 6; i++) {
            System.out.println(" Enter marks of subject : " + (i + 1) + ":");
            marks[i] = sc.nextInt();
            total = total + marks[i];
        }
        avg = total / 6;
        System.out.println("The student grade is :");
        if (avg >= 80) {
            System.out.println("A+");
        } else if (avg <= 70 && avg < 80) {
            System.out.println("A");
        } else if (avg <= 60 && avg < 70) {
            System.out.println("B");

        } else if (avg >= 50 && avg < 60) {
            System.out.println("C");

        } else if (avg >= 40 && avg < 50) {
            System.out.println("D");

        } else {
            System.out.println("F");
        }

    }

    //Input 2 decimal numbers and check if they are both same or different up to two decimal places
    public static void decimalNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first decimal number ");
        double num1 = sc.nextDouble();
        System.out.println("Input second decimal number : ");
        double num2 = sc.nextDouble();
        sc.close();

        if (Math.abs(num1 - num2) <= 0.01) {
            System.out.println("These number are same ");
        } else {
            System.out.println("These number are different");
        }

    }

    //    Write  a program to find the factorial of a given number
    public static void factorial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input factorial number :");
        int number = sc.nextInt();

        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;

        }
        System.out.println(fact);
    }
//    Write a program to check a number if it is prime or not

    public static void primeNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input prime number: ");
        int n = sc.nextInt();
        boolean flag = true;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                flag = false;
                break;

            }
        }
        if (flag == true) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not prime number ");
        }

    }
    public static void maxMin(){
        Scanner sc =new Scanner(System.in);
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        char choice;
        do {
            System.out.println("Enter the number : ");
            int number = sc.nextInt();
            if (number>max){
                max=number;
            }if (number>min){
                min =number;
            }
            System.out.println("Do you want to continue y/n?");
            choice =sc.next().charAt(0);
        }while ( choice =='y' || choice =='y');
        System.out.println(max);
        System.out.println(min);
    }
    public static void keyBoarrdPress(){
        Scanner sc =new Scanner(System.in);
        int sum =0;
        char ch;
        System.out.println("Input number :");
        do {
            sum +=sc.nextInt();
            System.out.println(sum);
            System.out.println("Do you want to continue ");
            ch=sc.next().charAt(0);
        }while (ch !='q');

    }
}





