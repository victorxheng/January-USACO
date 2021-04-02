import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class jan2021prob2 {
    private static int[] forwards;
    private static int[] backwards;
    private static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        s = st.nextToken();

        int[] a=new int[Q];
        int[] b=new int[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            a[i] = Integer.parseInt(st.nextToken())-1;
            b[i] = Integer.parseInt(st.nextToken())-1;
        }

        forwards = new int[N];
        backwards = new int[N];
        operation(true);
        operation(false);

        int[] o =new int[Q];
        for(int i =0; i<Q;i++)
        {
            if(a[i]>0)o[i]+=forwards[a[i]-1];
            if(b[i]<(N-1))o[i]+=backwards[b[i]+1];
        }

        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        for(int i = 0; i < Q; i++) out.println(o[i]);
        out.close();
    }
    private static void operation(boolean f){
        boolean[] pointers = new boolean[26];
        char pointer = 0;
        int sum = 0,start,end;
        if(f){start=0;end=s.length();}
        else{start=s.length()-1;end=0;}
        int i=start;
        while (true){
            if (!(pointers[(int) s.charAt(i) - 65])) sum++;
            if (s.charAt(i) < pointer) {
                pointers = Arrays.copyOfRange(pointers, 0, s.charAt(i) - 65);
                pointers = Arrays.copyOfRange(pointers, 0, 26);
            }
            pointers[(int) s.charAt(i) - 65] = true;
            pointer = s.charAt(i);
            if(f){forwards[i] = sum;i++;if(i>=end)break;}
            else {backwards[i]= sum;i--;if(i<end)break;}
        }
    }
}
