
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;;
public class ThreeSumN2LogN {
    //private int[] N;
    private int[] N = {30, -40, -20, -10, 40, 0, 10, 5};
    public ThreeSumN2LogN(int capacity){
        /**N = new int[capacity];
        for(int i = -(capacity) / 2 ; i <= capacity / 2; i++){
           StdOut.println(i);
           N[i + (capacity / 2)] = i;
        }
           **/  
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
                /**StdOut.print("i: " + i);**/
                if(bisearch(-(N[i]+N[j]))!= -1){
                if (N[bisearch(-(N[i]+N[j]))] == N[i] ){
                     count++;
                } 
            }
    } 
}

    return count; }

    public int bisearch(int item){
    int highIndex = N.length - 1 ;
    int lowIndex = 0;

    while(lowIndex<= highIndex){
    int searchIndex = lowIndex + (highIndex - lowIndex) /2;
        if (item < N[searchIndex]){
            highIndex = searchIndex - 1; 
        }
        else if(item > N[searchIndex]){
            lowIndex = searchIndex + 1;
        }
        else  return  searchIndex;

        StdOut.print("current item in the array\n");
        StdOut.println(N[searchIndex]);
        StdOut.print("low index\n");
        StdOut.println(lowIndex);

        StdOut.print("high index\n");
        StdOut.println(highIndex);

    }
    StdOut.println("no match found for "+ (item));
    return -1;
}

 public static void main(String[] args){
    ThreeSumN2LogN  obj = new ThreeSumN2LogN(25);
    StdOut.println("count " + obj.threesum());
 }
}