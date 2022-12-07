import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    private int i;
    private int w;
    private int h;
    private int r;
    public Node(int i, int w, int h){
        this.i = i;
        this.w = w;
        this.h = h;
    }

    public int getI(){
        return i;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public int compareTo(Node o) {
        if(this.w > o.getW() && this.h > o.getH()) return 1;
        else if(this.w<o.getW() && this.h<o.getH()) return -1;
        else return 0;
    }
}
public class p7568 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Node(i,w,h));
        }
        for(int i = 0;i<n;i++){
            int cnt = 1;
            for(int j = 0;j<n;j++){
                if(list.get(i).compareTo(list.get(j))<0) cnt++;
            }
            list.get(i).setR(cnt);
        }
        for(int i = 0;i<n;i++){
            System.out.print(list.get(i).getR() + " ");
        }
    }
}
