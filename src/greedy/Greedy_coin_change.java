package greedy;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Greedy_coin_change {


    public static int coinChangeNaive(Integer coins[],int amount){
        if(amount == 0) return 0;
        int minCoins = -1;

        for(int i=0;i<coins.length; i++){
            int current_coin = coins[i];
            if(current_coin> amount){
                continue;
            }else{
                int remaining_amount = amount-current_coin;
                int friend = coinChangeNaive(coins,remaining_amount);
                int total_answer = friend + 1;

                if(minCoins == -1){
                    minCoins = total_answer;
                }else{
                    if(total_answer<minCoins){
                        minCoins = total_answer;
                    }
                }
            }

        }
        return minCoins;
    }

    public static void calculateCoin(Integer coins[], int remaining_amount, int total_no_of_coins){
        for(int i=0; i<coins.length; i++){
            int current_coin = coins[i];
            int no_of_coin_needed = (int)Math.floor(remaining_amount/current_coin);
            remaining_amount = remaining_amount % current_coin;

            System.out.println(current_coin+ " needed: " + no_of_coin_needed);
            total_no_of_coins = total_no_of_coins + no_of_coin_needed;
        }
        System.out.println("Minimum coin needed: " + total_no_of_coins);
    }


     public static void main(String[] args) {
         Integer coins[] = {25,10,1};
         Arrays.sort(coins, Collections.reverseOrder());
         int total_no_of_coins = 0;
         int remaining_amount = 30;
         calculateCoin(coins,remaining_amount,total_no_of_coins);
         int result = coinChangeNaive(coins,remaining_amount);
         System.out.println(result);
     }
}


class Activity{
    String taskId;
    int startTime;
    int finishTime;


    public static int activitySelection(Activity activities[]){
        Arrays.sort(activities, (left,right) -> Integer.compare(left.finishTime, right.finishTime));
        int picked = 1;
        int availableTime = activities[0].finishTime;
        System.out.println(activities[0].taskId);
        for(int i=1;i<activities.length;i++){
            Activity currentTask = activities[i];
            if(currentTask.startTime>=availableTime){
                picked = picked+1;
                System.out.println(activities[i].taskId);
                availableTime = currentTask.finishTime;
            }
        }
        return picked;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Activity[] activities = new Activity[n];
        for(int i=0;i<n;i++){
            activities[i] = new Activity();
            activities[i].taskId = sc.next();
            activities[i].startTime = sc.nextInt();
            activities[i].finishTime = sc.nextInt();
        }
        int result = activitySelection(activities);
        System.out.println(result);
    }
}


class Knapsack{

    static class Products{
        String productID;
        int weight;
        int value;
    }


    public static int knapsack(Products[] products, int capacity){

        Arrays.sort(products, (left,right)-> Integer.compare(right.value*left.weight,left.value * right.weight));
        int maximumValue = 0;

        for (Products product:products) {
            if(product.weight <=capacity){
                maximumValue = maximumValue + product.value;
                System.out.println(product.productID);
                capacity = capacity - product.weight;
            }
        }
        return maximumValue;

    }


    public static int knapsack_naive(int it, Products[] products, int capacity){
        if(capacity ==0 || it == products.length) return 0;
        Products currentProduct = products[it];
        if(currentProduct.weight > capacity){
            int friend = knapsack_naive(it+1, products,capacity);
            return friend;
        }
        else{
            int friend2 = currentProduct.value + knapsack_naive(it+1,products,capacity-currentProduct.weight );

            int friend3 = knapsack_naive(it+1, products,capacity);
            if(friend2>friend3){
                return friend2;
            }else{
                return friend3;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        Products products[] = new Products[n];
        for(int i=0;i<n;i++){
            products[i] = new Products();
            products[i].productID = sc.next();
            products[i].weight = sc.nextInt();
            products[i].value = sc.nextInt();
        }
        int result = knapsack_naive(0,products,capacity);
        System.out.println("MAX: "+result);
    }
}
