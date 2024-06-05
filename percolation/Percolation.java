import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int vTop; 
    private boolean[][] grid;
    private WeightedQuickUnionUF qUF;
    private WeightedQuickUnionUF vqUF;
    private int vBot;
    private int indShift;
    private int numberOfOpenSite;
    private int rows, cols;
    public Percolation(int n) {
        if (n <= 0)
           throw new IllegalArgumentException("n must be <= 0 ");

        grid = new boolean[n][n];
        rows = grid.length;
        cols = grid[0].length;
        vqUF = new WeightedQuickUnionUF(n * n  + 2);
        qUF = new WeightedQuickUnionUF(n * n + 1);

        
        vTop = n * n;
        vBot = n * n + 1;
        numberOfOpenSite =0;
        indShift = 1;
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               grid[i][j] = false;// close all sites
              }
             }
        }
    


    public void open(int row, int col) {
        if ((row <= 0 || col <= 0)|| (row > rows || col> cols))
           throw new IllegalArgumentException("grid is indexed from (1,1)");

        if (isOpen(row, col))
            return;

        grid[row - indShift][col - indShift] = true;
        numberOfOpenSite++;

        // check top
        if (row - indShift == 0) {
            int p = (row - indShift) * cols + col - indShift;
            vqUF.union(vTop, p);
            qUF.union(vTop, p) ;

        }
        // check bottom
        if (row - indShift + 1 == rows) {
            int p = (row - indShift) * cols + (col - indShift);
            vqUF.union(vBot, p);

        }


        // left check 
        if ((col - indShift) - 1 >=0  && (isOpen(row , col - 1 ))) {
            int p = (row - indShift) * cols + (col - indShift);
            int q = (row - indShift) * cols + (col- indShift - 1);
        vqUF.union(p, q);
        qUF.union(p, q) ;

        }
        /** if (qUF.find(vTop) == qUF.find(q)){
           qUF.union(p, q);
        }
        **/

        //right check
        if (col - indShift + 1 < cols && (isOpen(row , col + 1 ))) {
            int p = (row - indShift) * cols + (col - indShift);
            int q = (row - indShift) * cols + (col - indShift + 1);
        vqUF.union(p, q);
        qUF.union(p,q) ;
        /**if (qUF.find(vTop) == qUF.find(q)) {
           qUF.union(p, q);
        } **/
        }
        // down check
        if (row - indShift +1  < rows && (isOpen(row + 1, col))) {
            int p = (row -indShift) * cols + (col - indShift);
            int q = (row - indShift + 1 )* cols + (col - indShift);
        vqUF.union(p, q);
        qUF.union(p, q) ;
        /** if (qUF.find(vTop) == qUF.find(q)){
           qUF.union(p, q);
        } **/
        }
        // up check
        if (row -indShift -1  >= 0   && (isOpen(row - 1, col ))) {
            int p = (row - indShift) * cols + (col - indShift);
            int q = (row - indShift - 1) * cols + (col - indShift);

        vqUF.union(p, q);
        qUF.union(p, q) ;
        /** if (qUF.find(vTop) == qUF.find(q)){
           qUF.union(p, q);
        }**/
        }
            
    }

    public boolean isOpen(int row, int col) {
        if ((row <= 0 || col <= 0)|| (row > rows || col> cols))
           throw new IllegalArgumentException("grid is indexed from (1,1) with "+cols+" grid, got " +row + ", " + col);

    return grid[row - indShift][col - indShift];
    }

    public boolean isFull(int row, int col) {
        if ((row <= 0 || col <= 0)|| (row > rows || col > cols))
           throw new IllegalArgumentException("grid is indexed from (1,1)");

        int p = (row - indShift)  * cols + (col - indShift);
       
    return qUF.find(vTop) == qUF.find(p);
    }

    public int numberOfOpenSites() {

        return numberOfOpenSite;
    }

    public boolean percolates() {

        return vqUF.find(vTop) == vqUF.find(vBot);
    }
    

/** /    public static void main(String[] args){
        int numObjects = 20;
        int gridSize = numObjects * numObjects;
        Percoration a = new Percoration(numObjects);
        for(int i=0;i < 100 * gridSize;i++){
        int randomRow = StdRandom.uniformInt(1, numObjects + 1);
        int randomCol = StdRandom.uniformInt(1, numObjects + 1);
        StdOut.println("row " + randomRow + "column "  + randomCol);
        a.open(randomRow, randomCol);
        StdOut.println(a.percorates());
        if(a.percorates()){
           StdOut.println("percolates at " + (1.0  * a.numberOfOpenSites()/gridSize));
           System.exit(1);          
        }
           StdOut.println(" number of open Sites" + a.numberOfOpenSites());
     }

    }
    **/
}
