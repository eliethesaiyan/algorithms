public class QuickFindUF
{
    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for(int i =0; i < id.length; i++)
            id[i] = 0;
    }

    public void union(int p, int q){
        int pid  = id[p];
        int qid = id[q];
        
        for(int i=0; i < id.length; i++){
        if (pid == id[i]) {
            id[i] = qid;
            System.out.println("changed");
        }
        System.out.println(i);

        }
    }

    public static void main(String[] args){
        QuickFindUF p = new QuickFindUF(2);
        System.out.println(java.util.Arrays.toString(p.id));
        p.union(0,1);
    }
}