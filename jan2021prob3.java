import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class jan2021prob3 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] firstRow = new int[N];
        int[] secondRow = new int[N];
        int[] vfirstRow = new int[N];
        int[] vsecondRow = new int[N];

        for (int i = 0; i < N;i++) {//N^2
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(i%2==0)firstRow[j]+=num;
                else secondRow[j]+=num;

                if(j%2==0)vfirstRow[i]+=num;
                else vsecondRow[i]+=num;
            }
        }

        int sum =0;
        for(int i = 0; i<N; i++){
            int top = firstRow[i];
            int bottom = secondRow[i];
            if(top>bottom) sum+=top;
            else sum+=bottom;
        }
        int vsum = 0;
        for(int i = 0; i<N; i++){
            int top = vfirstRow[i];
            int bottom = vsecondRow[i];
            if(top>bottom) vsum+=top;
            else vsum+=bottom;
        }

        if(vsum>sum) sum=vsum;
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        out.println(sum);
        out.close();
    }

}