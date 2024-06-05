
public class UnionFind
{
    private int[] id;

    public UnionFind(int N){
        id = new int[N];
        for(int i =0; i < id.length; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
    int pid  = id[p];
    int qid = id[q];
    for(int i=0; i < id.length; i++)
       if (pid == id[i]) id[i] = qid;


    }

    public int find(int[] id, int q){
    int rootVal = id[q];
    int largeNumber = q;
        for(int i=1; i < id.length; i++) {
            if (id[i] == rootVal){
                largeNumber = i;

            }
        }
    return largeNumber;
    }

}