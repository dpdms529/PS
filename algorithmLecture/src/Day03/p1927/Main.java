package Day03.p1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MinHeap{
    List<Integer> list;

    public MinHeap(){
        list = new ArrayList<>();
        list.add(0);
    }

    public void swap(int a, int b){
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }

    public void insert(int val){
        list.add(val);
        int cur = list.size()-1;
        int parent = cur/2;
        while(true){
            if(parent == 0 || list.get(parent) <= list.get(cur)) break;
            swap(parent, cur);
            cur = parent;
            parent = cur/2;
        }
    }

    public int delete(){
        int size = list.size();
        if(size==1) return 0;

        int top = list.get(1);
        list.set(1, list.get(size-1));
        list.remove(size-1);
        size--;

        int cur = 1;
        while(true){
            int left = cur * 2;
            int right = cur * 2 + 1;
            if(left >= size) break;

            int minValue = list.get(left);
            int minPos = left;

            if(right < size && minValue > list.get(right)){
                minValue = list.get(right);
                minPos = right;
            }
            if(list.get(cur) > minValue){
                swap(cur, minPos);
                cur = minPos;
            }else{
                break;
            }
        }
        return top;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MinHeap heap = new MinHeap();
        for(int i = 0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                System.out.println(heap.delete());
            }else{
                heap.insert(x);
            }
        }
    }
}
