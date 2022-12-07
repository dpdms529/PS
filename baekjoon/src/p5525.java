import java.io.*;

public class p5525 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        int result = 0;
        boolean check = false;
        for(int i = 0;i<m-1;i++){
            if(!check && arr[i]=='I'){
                check = true;
            }else if(check){
                if(arr[i]=='O' && arr[i+1]=='I'){
                    cnt++;
                    i++;
                    if(cnt>=n) result++;
                }else{
                    cnt = 0;
                    if(arr[i]!='I') check = false;
                }
            }
        }
        System.out.println(result);
    }
}
