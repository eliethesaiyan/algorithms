public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N;

    public ResizingArrayStackOfStrings(){
        s = new String[1];
        N = 0;
    }

    public void push(String item){
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i=0; i < N; i++) copy[i] = s[i];
        s = copy;
    
    }
    
}
