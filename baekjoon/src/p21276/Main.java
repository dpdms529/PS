package p21276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] names;
    static HashMap<String, Integer> index = new HashMap<>();
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static int N, M;
    static TreeSet<String> root = new TreeSet<>();
    static TreeMap<String, TreeSet<String>> children = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        names = br.readLine().split(" ");
        indegree = new int[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < names.length; i++) {
            index.put(names[i], i);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] XY = br.readLine().split(" ");
            graph[index.get(XY[1])].add(index.get(XY[0]));
            indegree[index.get(XY[0])]++;
        }

        topologicalSort();

        System.out.println(root.size());

        root.forEach(name -> System.out.print(name + " "));
        System.out.println();

        for (String name : children.keySet()) {
            Set<String> set = children.get(name);
            System.out.print(name + " " + set.size() + " ");
            set.forEach(child -> System.out.print(child + " "));
            System.out.println();
        }
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                root.add(names[i]);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            TreeSet<String> set = new TreeSet<>();

            for (Integer next : graph[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                    set.add(names[next]);
                }
            }

            children.put(names[cur], set);
        }
    }
}

