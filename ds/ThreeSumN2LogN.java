import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;;
public class ThreeSumN2LogN {
    private int[] N;
    public ThreeSumN2LogN(int capacity){
        N = StdRandom.permutation(capacity, capacity);
        Arrays.sort(N);
        int i = 0;
        while(i < N.length){
        StdOut.println(N[i]);
        i++;
        }
    }
    
    public void sort() {

    }
    public int threesum(){
        int count = 0;
        for(int i=0; i < N.length; i++){
            for(int j=i+1; j< N.length; j++){
                if (-(N[i]+N[j]) == N[bisearch(i)])
                     count++;
                } 
    } 
    return count; }

    public int bisearch(int item){
    int lowIndex =  0;
    int highIndex = N.length;
    int searchIndex =  N.length /2;

    while(lowIndex< highIndex){
        if (N[searchIndex] == item)
            return  searchIndex;

        if (N[searchIndex] < item)
            highIndex = searchIndex; 
        if (N[searchIndex] > item)
            lowIndex = searchIndex;

        StdOut.println(lowIndex);
        StdOut.println(N[searchIndex]);

        StdOut.println(highIndex);

    }
    return -1;


    }

 public static void main(String[] args){
    ThreeSumN2LogN  obj = new ThreeSumN2LogN(20);
    StdOut.println("row " + obj.threesum());
 }
}