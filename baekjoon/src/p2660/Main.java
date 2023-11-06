package p2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        String line;
        while (!(line = br.readLine()).equals("-1 -1")) {
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        Candidate[] candidates = new Candidate[N];
        for (int i = 1; i <= N; i++) {
            candidates[i - 1] = new Candidate(i, bfs(i));
        }

        Arrays.sort(candidates);

        int minScore = candidates[0].score;
        ArrayList<Integer> candidateIds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (candidates[i].score == minScore) {
                candidateIds.add(candidates[i].id);
            }
        }

        System.out.println(minScore + " " + candidateIds.size());
        for (int id : candidateIds) {
            System.out.print(id + " ");
        }


    }

    static int bfs(int start) {
        Queue<Candidate> queue = new LinkedList<>();
        boolean visited[] = new boolean[N + 1];
        Candidate candidate = new Candidate(start, 0);
        queue.offer(candidate);
        visited[start] = true;

        while (!queue.isEmpty()) {
            candidate = queue.poll();

            for (int next : graph[candidate.id]) {
                if (!visited[next]) {
                    queue.offer(new Candidate(next, candidate.score + 1));
                    visited[next] = true;
                }
            }

        }

        return candidate.score;
    }
}

class Candidate implements Comparable<Candidate> {
    int id;
    int score;

    public Candidate(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Candidate o) {
        if (score == o.score) {
            return Integer.compare(id, o.id);
        }
        return Integer.compare(score, o.score);
    }
}
