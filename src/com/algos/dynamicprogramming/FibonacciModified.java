package com.algos.dynamicprogramming;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation
Tn+2 = (Tn+1)^2 + Tn 
So, if the first two terms of the series are 0 and 1:
the third term = 1^2 + 0 = 1
fourth term = 1^2 + 1 = 2
fifth term = 2^2 + 1 = 5
... And so on.

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series. 

You are given three space separated integers A, B and N on one line. 
0 <= A,B <= 2
3 <= N <= 20 
Output : One integer.
This integer is the Nth term of the given series when the first two terms are A and B respectively. 

Some output may even exceed the range of 64 bit integer.
arr can be BigInteger[] instead of String[]  

 * @author madhavi
 *
 */
public class FibonacciModified {
    private static int a = -1;
    private static int b = -1;
    private static int n = -1;
    private static String[] arr = null;
    
    public static void findNthFibonacciNumber(){
        Scanner scan = null;
        try{
            scan = new Scanner(System.in);
            a = scan.nextInt();
            b = scan.nextInt();
            n = scan.nextInt();
            arr = new String[n];
        }finally{
            scan.close();
        }
      
      //initialize
      for(int i=2; i<n;i++){
          arr[i] = "-1";
      }
      System.out.println(findFibonacciNumber(n));
    }
    
    public static BigInteger findFibonacciNumber(int n){
        BigInteger returnVal;

        if(n == 1){
            arr[n-1] = String.valueOf(a);
            returnVal =  new BigInteger(arr[n-1]);
        }else if(n == 2){
            arr[n-1] = String.valueOf(b);
            returnVal = new BigInteger(arr[n-1]);
        }else if(!arr[n-1].equals("-1")){
            returnVal = new BigInteger(arr[n-1]);
        }else {
            BigInteger out2 = findFibonacciNumber(n-1).pow(2).add(findFibonacciNumber(n-2));
            arr[n-1] = out2.toString();
            returnVal = out2;
        }
//        System.out.println("fib("+n+") = "+returnVal.toString());
        return returnVal;
    }
    
    private static BigInteger findFibonacciNumberIteratively(int n) {
        for (int index =1; index<=n; index ++){
            if(index == 1){
                arr[index] = String.valueOf(a);
            }else if(index ==2){
                arr[index] = String.valueOf(b);
            }else{
                BigInteger fib = (new BigInteger(arr[index-1])).pow(2).add(new BigInteger(arr[index-2]));
                arr[index] = fib.toString();
            }
        }
        return new BigInteger(arr[n]);
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input FirstElement : ");
        a = scan.nextInt();
        System.out.println("Input SecondElement : ");
        b = scan.nextInt();
        System.out.println("Input index N to calculate fibonacci number ");
        n = scan.nextInt();
        arr = new String[n+1];
        //initialize
        for(int i=2; i<=n;i++){
            arr[i] = "-1";
        }
        // recursive
        Long startTime = System.nanoTime();
        BigInteger number = findFibonacciNumber(n);
        Long diff = System.nanoTime() - startTime;
        System.out.println("Recursive "+ number);
        System.out.println("Timetaken in nanosecs "+ diff);
        //re-initialize, since we are using same arr
        for(int i=2; i<=n;i++){
            arr[i] = "-1";
        }
        startTime = System.nanoTime();
        number = findFibonacciNumberIteratively(n);
        diff = System.nanoTime() - startTime;
        System.out.println("Iterative "+ number);
        System.out.println("Timetaken in nanosecs "+ diff);
        System.out.println("Recursion is faster as n increases");
    }

    
}
