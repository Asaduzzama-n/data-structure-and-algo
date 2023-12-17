package recursion;

import java.util.Arrays;
import java.util.Scanner;


//Prints the numbers from 1 to n.
public class Prints_from_1_to_n {

    public static void printNumber(int i,int n){
        if(i>n) return;

        System.out.println(i);
        printNumber(i+1,n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNumber(1,n);
    }
}

//Calculate the sum of numbers from 1 to n.
//1,2,3

class Print_sum_of_1_to_n{

    public static int printSum(int i, int n){
        if(i>n) return 0;

        int sum = printSum(i+1, n);
        return i+sum;


    }

    //Alternate way
    public static int sum(int n){
        if(n==0) return 0;
        int res = n+sum(n-1);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int result = printSum(1,3);
        int result2 = sum(3);
        System.out.println(result);
        System.out.println(result2);
    }
}
//Calculate the factorial of n.
class Factorial_of_n{

    public static int factorial(int n){
        if(n==0) return 1;
        int fact = n*factorial(n-1);
        System.out.println(n + "  "+ fact);
        return fact;
    }

    public static void main(String[] args) {
        int result= factorial(3);
        System.out.println(result);
    }
}


//Calculate the sum of digits of a given number n.
class Sum_of_the_digits{

    public static int sumOfTheDigits(int n){
        if(n==0) return 0;

        int lastDigit = n%10;
        int remaining = n/10;
        int result = lastDigit + sumOfTheDigits(remaining);
        return result;
    }

    public static void main(String[] args) {
        int result = sumOfTheDigits(555);
        System.out.println(result);
    }
}

//Calculate the nth term of a Fibonacci series.

class Nth_terms_of_fibonacci{

    public static int fib(int n){
        if(n==1) return 0;
        if(n==2) return 1;

        int friend1 = fib(n-1);
        int friend2 = fib(n-2);

        return friend1+friend2;

    }

    public static void main(String[] args) {
        int result = fib(5);
        System.out.println(result);
    }
}


//Calculate a to the power b

class A_to_the_power_b{

    public static int power(int a, int b){
        if(b==0) return 1;

        int friend = power(a, b-1);
        int result = friend * a;
        return result;
    }

    public static void main(String[] args) {
        int result = power(2, 4);
        System.out.println(result);
    }
}


//Print the array elements.

class Print_the_array_elements{

    public static void print(int arr[], int i){
        if(i==arr.length) return;
        System.out.println(arr[i]);
        print(arr,i+1);
    }

    public static void main(String[] args) {
        int arr[] = {6, 9, 8, 4, 5, 1, 2, 3, 4, 5};
        print(arr,0);
    }
}


class Find_max_in_array{

    public static int findMax(int arr[], int currIndex){
    if(currIndex == 0) return arr[currIndex];

    int currentValue = arr[currIndex];
    int friend = findMax(arr, currIndex-1);
    if(currentValue> friend){
        return currentValue;
    }else{
        return friend;
    }
    }

    public static void main(String[] args) {
        int arr[] = {6, 9, 8, 4, 5, 1, 2, 3, 4, 5};
        int result = findMax(arr, arr.length-1);
        System.out.println(result);
    }
}

//Find the smallest element of a given array.

class Find_smallest_element{

    public static int findMin(int arr[], int currIndex){
        if(currIndex == 0) return arr[currIndex];

        int currentValue = arr[currIndex];
        int friend = findMin(arr, currIndex-1);
        if(currentValue < friend){
            return currentValue;
        }else{
            return friend;
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 9, 8, 4, 5, 1, 2, 3, 4, 5};
        int result = findMin(arr, arr.length-1);
        System.out.println(result);
    }
}

//Find the largest and smallest element of a given array.

class MinMax {

    static int max;
    static int min;



    public static MinMax findMinMax(int arr[], int currentIndex){
        if(currentIndex == 0){
            MinMax result = new MinMax();
            result.max = arr[currentIndex];
            result.min = arr[currentIndex];
            return result;
        }
        MinMax result =  new MinMax();

        int currentValue = arr[currentIndex];
        MinMax friend = findMinMax(arr,currentIndex-1);

        if(currentValue>friend.max){
            result.max = currentValue;
        }else if(currentValue<friend.min){
            result.min = currentValue;
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = {6, 9, 8, 4, 5, -1, 2, 3, 4, 5};
        MinMax result = findMinMax(arr, arr.length-1);
        System.out.println(result.max+"  "+result.min);
    }
}

class Is_palindrome{

    public static boolean isPalindrome(String str,int left, int right ){
        if(left>=right){
            return true;
        }
        String s = str.toLowerCase();
        if(s.charAt(left) == s.charAt(right)){
            boolean friend = isPalindrome(s, left+1, right-1);
            return friend;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        String str = "Madam";
        boolean result = isPalindrome(str,0,str.length()-1);
        if(!result) System.out.println("Not palindrome");
        else System.out.println("Palindrome");

    }
}