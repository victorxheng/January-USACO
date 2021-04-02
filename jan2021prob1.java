import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class jan2021prob1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) cows[i] = i;

        int[] aArr = new int[K];
        int[] bArr = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            aArr[i] = Integer.parseInt(st.nextToken());
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<?>[] num = new HashSet<?>[N];
        for (int i = 0; i < N; i++) {
            num[i] = new HashSet<Integer>();
            ((HashSet<Integer>)num[i]).add(i);
        }

        for (int m = 0; m < K; m++) {
            int a = aArr[m]-1;
            int b = bArr[m]-1;
            int temp = cows[a];
            cows[a] = cows[b];
            cows[b] = temp;
            ((HashSet<Integer>)num[cows[a]]).add(a);
            ((HashSet<Integer>)num[cows[b]]).add(b);
        }

        int[] o = new int[N];
        for (int i = 0; i < N; i++) {
            if (o[i] == 0) {
                ArrayList<Integer> ordering = new ArrayList<>();
                ordering.add(i);
                int currentIndex = cows[i];
                while (currentIndex != i) {
                    ordering.add(currentIndex);
                    ((HashSet<Integer>) num[i]).addAll(((HashSet<Integer>) num[currentIndex]));
                }
                int sum = num[i].size();
                for (int j = 0; j < ordering.size(); j++) o[ordering.get(j)] = sum;
            }
        }

        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        for (int i = 0; i < N; i++) out.println(o[i]);
        out.close();
    }
}
