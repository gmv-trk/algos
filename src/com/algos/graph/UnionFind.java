package com.algos.graph;

/*
 * Find if 2 vertices are connected in a graph. if( find(p) == find(q)) then connected
 * Find common ancestor of 2 vertices. if(find(p) == find(q)) then {present. while(proot[n] == qroot[m]) {n--;m--;} proot[n+1] is the common ancestor} else {no} 
 */

public class UnionFind {
    private static int noOfComponents = 0;
    private static int[] arr = new int[10];
    private static int[] size = new int[10];
    private static String[] edges = {"0,1","4,5","3,2", "6,7", "7,8", "4,3","4,8"};
    public static void main(String[] args) {
        quickFind(); // downside, every union needs parse of whole array to update the roots of current vertices of edge
        System.out.println(noOfComponents);
        quickUnion(); // better than above as we process the array only for p and q to find their roots (not complete array) 
        System.out.println(noOfComponents);
        weightedQuickUnion(); // better because height of the tree will be less compared to above 2
        System.out.println(noOfComponents);
        for(int i=0; i<size.length; i++){
            System.out.print(size[i]+" ");
        }
    }
    
    private static void weightedQuickUnion(){
      //Initialize array
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
            size[i] = 1;
        }
        noOfComponents=arr.length;
        for(int i=0; i <edges.length;i++ ){
            String[] strarr = edges[i].split(",");
            int p = Integer.parseInt(strarr[0]);
            int q = Integer.parseInt(strarr[1]);
            if(arr[p] == arr[q]){
                System.out.println(p + " and "+q +" are connected");
                continue;
            }
            weightedQuickUnionUnion(p,q);
        }
    }
    
    private static void weightedQuickUnionUnion(int p, int q){
        int proot = weightedQuickUnionfind(p);
        int qroot = weightedQuickUnionfind(q);
        if(qroot == proot){
            return;
        }
        //point smaller root to larger one
        if(size[proot]>size[qroot]){
            arr[qroot] = proot;
            size[proot]+=size[qroot];
        }else{
            arr[proot] = qroot;
            size[qroot]+=size[proot];
        }
        noOfComponents--;
    }
    
    private static int weightedQuickUnionfind(int n){
        while(arr[n] != n){
            n=arr[n];
        }
        return n;
    }
    
    private static void quickUnion(){
      //Initialize array
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        noOfComponents=arr.length;
        for(int i=0; i <edges.length;i++ ){
            String[] strarr = edges[i].split(",");
            int p = Integer.parseInt(strarr[0]);
            int q = Integer.parseInt(strarr[1]);
            if(arr[p] == arr[q]){
                System.out.println(p + " and "+q +" are connected");
                continue;
            }
            quickunionunion(p,q);
        }
    }
    
    private static void quickunionunion(int p, int q){
        int proot = quickunionfind(p);
        int qroot = quickunionfind(q);
        if(proot == qroot){
            return;
        }
        arr[q] = proot;
        noOfComponents--;
    }
    
    private static int quickunionfind(int p){
        while(arr[p] != p){
            p = arr[p];
        }
        return p;
    }
    

    private static void quickFind() {
        //Initialize array
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        noOfComponents=arr.length;
        
        for(int i=0; i<edges.length;i++ ){
            String[] strarr = edges[i].split(",");
            int p = Integer.parseInt(strarr[0]);
            int q = Integer.parseInt(strarr[1]);
            if(arr[p] == arr[q]){
                System.out.println(p + " and "+q +" are connected");
                continue;
            }
            quickfindunion(p, q);
            
        }        
    }
    
    private static void quickfindunion(int p,int q){
        int proot = quickfindfind(p);
        int qroot = quickfindfind(q);
        if(proot == qroot){
            return;
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i] == qroot){
                arr[i] = proot;
            }
        }
        /*arr[q] = p;*/
        noOfComponents--;
    }
    
    private static int quickfindfind(int n){
        return arr[n];
        /*while( arr[n] != n){
            n = arr[n];
        }
        return n;*/
    }
}
