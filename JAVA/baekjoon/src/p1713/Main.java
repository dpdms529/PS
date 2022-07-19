package p1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    int index;
    int id;
    int cnt;

    public Student(int index, int id, int cnt){
        this.index = index;
        this.id = id;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Student o) {
        if(cnt == o.cnt){
            return o.index - index ;
        }else{
            return o.cnt - cnt;
        }
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<total;i++){
            int id = Integer.parseInt(st.nextToken());
            boolean find = false;
            for(Student s : list){
                if(s.id == id){
                    s.cnt++;
                    find = true;
                }
            }
            if(!find){
                if(list.size()==n){
                    Collections.sort(list);
                    list.remove(list.size()-1);
                }
                list.add(new Student(i, id, 1));
            }
        }
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.id - o2.id;
            }
        };
        Collections.sort(list, comp);
        for(Student s:list){
            System.out.print(s.id + " ");
        }

    }

}
