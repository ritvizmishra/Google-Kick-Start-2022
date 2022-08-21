import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class StudentsAndMentors {
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int t = 1; t <= T; t++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n;){
                a[i] = in.nextInt();
            }

            int[] res = f(n, a);

            System.out.print("Case #" + t + ": ");
            for(int i = 0; i < n; i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[] f(int n, int[] a){
        int[] res = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            set.add(a[i]);
            if(map.containsKey(a[i])) map.put(a[i], map.get(a[i]) + 1);
            else map.put(a[i], 1);
        }

        for(int i = 0; i < n; i++){
            int x = a[i] * 2;
            int y = set.floor(x) == null ? -1 : set.floor(x);

            if(y == a[i] && map.get(a[i]) == 1){
                y = set.floor(a[i] - 1) == null ? -1 : set.floor(a[i] - 1);
            }

            if(y == -1) res[i] = -1;
            else res[i] = y;

        }
        return res;
    }
}
