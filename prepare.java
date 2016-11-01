import java.io.*;
import java.util.*;

public class prepare {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("prepare.in"));
        } else {
            return new Scanner(System.in);
        }
    }
    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("prepare.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            int n = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int i=0;i<n;i++)
            {
                a[i] = in.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                b[i] = in.nextInt();
            }
            int sum = 0;
            boolean flag1 = false, flag2 = false;
            int val = Math.abs(a[0]-b[0]);
            int val_ind = 0;
            for(int i=0;i<n;i++)
            {
                if(val>Math.abs(a[i]-b[i]))
                {
                    val = Math.abs(a[i]-b[i]);
                    val_ind = i;
                }
                if((a[i]>b[i]) && flag1==false)
                    flag1 = true;
                if((b[i]>a[i]) && flag2==false)
                    flag2 = true;
                sum +=Math.max(a[i],b[i]);
            }
            if(flag1 == false)
                sum = sum + a[val_ind] - b[val_ind];
            if(flag2 == false)
                sum = sum - a[val_ind] + b[val_ind];
            out.println(sum);
        }
    }
}