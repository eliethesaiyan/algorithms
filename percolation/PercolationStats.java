

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
private    int gridSize;
private    int numTrials;
private double CONFIDENCE_95;
private    double[] percolationValues;
    public PercolationStats(int n, int trials){
    gridSize = n * n;
    numTrials = trials;
    CONFIDENCE_95 =  1.96;
    percolationValues = new double[numTrials];
    Percolation a = new Percolation(n);
    for (int trial=0; trial < numTrials ; trial++){
          while(!a.percolates()){
               int col = StdRandom.uniformInt(1, n + 1);
               int row = StdRandom.uniformInt(1, n + 1);
               a.open(row, col);
          }
           // StdOut.println("percorated at trial " + trial);
            percolationValues[trial] =  (1.0 * a.numberOfOpenSites())/ gridSize;
          }
    }

     

    public  double mean(){
    return StdStats.mean(percolationValues);

    }

    public double stddev(){
    return StdStats.stddev(percolationValues);
    }
    
    public double confidenceLo(){
    return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(numTrials));
    }

    public double confidenceHi(){
    return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(numTrials));
    }

    public static void main(String[] args){
        int gridSide = 5;
        int numTrials =10;

        if (args.length >= 2){
            StdOut.print("args " + args);
            gridSide = Integer.parseInt(args[0]);
            numTrials = Integer.parseInt(args[1]);
        }
        PercolationStats ps = new PercolationStats(gridSide, numTrials);
        StdOut.println("mean            =" + ps.mean());
        StdOut.println("stdev            =" + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");


    }
}
