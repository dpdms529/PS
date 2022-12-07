import java.io.*;

public class p1992 {
    public static int[][] graph;
    public static String quadTree(int startY, int endY, int startX, int endX){
        if(startY==endY && startX==endX){
            return String.valueOf(graph[startY][startX]);
        }else{
            int midY = (startY + endY) / 2;
            int midX = (startX + endX) / 2;
            String item1 = quadTree(startY, midY, startX, midX);
            String item2 = quadTree(startY, midY, midX + 1, endX);
            String item3 = quadTree(midY + 1, endY, startX, midX);
            String item4 =  quadTree(midY + 1, endY, midX + 1, endX);
            if((item1.equals("1") || item1.equals("0")) && (item1.equals(item2) && item2.equals(item3) && item3.equals(item4))) return item1;
            else{
                return "(" + item1 + item2 + item3 + item4 + ")";
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0;i<n;i++){
            String col = br.readLine();
            for(int j = 0;j<n;j++){
                graph[i][j] = col.charAt(j)-'0';
            }
        }
        System.out.println(quadTree(0,n-1,0,n-1));
    }
}
