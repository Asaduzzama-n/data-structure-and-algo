package dp;

import java.util.Arrays;

 class Fibonacci {


    public static int fib(int n, int[] cache){
        if(cache[n]!= -1){
            return cache[n];
        }
        if(n==0)return 0;
        else if(n==1) return 1;
        else{
            int friend1=fib(n-1,cache);
            int friend2=fib(n-2,cache);
            int result = friend1+friend2;
            cache[n] = result;
            return result;
        }
    }

    public static void printCache(int[] cache){
       for(int i=0;i<1007;i++){
           System.out.print(cache[i]+ " ");
       }
    }

    public static void main(String[] args) {
        int[] cache = new int[1007];
        Arrays.fill(cache,-1);
        int result = fib(40, cache);
        printCache(cache);
        System.out.println(result);
    }
}
