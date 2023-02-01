package p1068;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int leafNum = 0;
    static int removeIndex;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int root = -1;
        tree = new ArrayList[N];

        for(int i = 0;i<N;i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1){
                root = i;
                continue;
            }

            tree[parent].add(i);
        }

        removeIndex = Integer.parseInt(br.readLine());

        if(removeIndex != root){
            findLeaf(root);
        }

        System.out.println(leafNum);

    }

    public static void findLeaf(int index){
        if(tree[index].contains(removeIndex)){
            tree[index].remove(tree[index].indexOf(removeIndex));
        }

        if(tree[index].size() == 0) leafNum++;
        else{
            for(int child : tree[index]){
                findLeaf(child);
            }
        }
    }
}
