package com.algos.recursion;

public class StringPermutation {
    
    private static void perm(String str,int start ,int end){
        if(start == end){
            System.out.println(str);
        }else{
            for(int i=start; i<=end ; i++){
                str = swap(str,start,i);
                perm(str, start+1, end);
                str = swap(str,start,i);
            }
        }
    }
    
    private static void perm2(char[] str, int length, char[] store){
        if(length ==0){
            System.out.println(String.valueOf(store)+" ");
        }else{
            for(int i=0; i<str.length; i++){
                store[length-1] = str[i];
                perm2(str, length-1, store);
            }
        }
    }
    
    private static String swap(String str, int pos1, int pos2){
        char[] chararr = str.toCharArray();
        char tmp = chararr[pos1];
        chararr[pos1] = chararr[pos2];
        chararr[pos2] = tmp;
        return String.valueOf(chararr);
    }
    
    /*
     * Gen­er­ate Well Ordered Pass­words of a Given Length K. Well ordered means that dig­its should be in increas­ing order in every gen­er­ated password.
     */
    public static void printWellOrdered(int number, int x, int k) {

        if (k == 0) {
            System.out.println(number);
            return;
        }

        for (int i = (x + 1); i < 10; i++) {
            printWellOrdered(number * 10 + i, i, k - 1);
        }

    }
    
    public static void main(String[] args) {
        String str = "Algo";
        perm(str, 0, str.length()-1);
        int length = 2;
        perm2(str.toCharArray(), length, new char[length]);
        printWellOrdered(0,0,7);
        
    }

}
