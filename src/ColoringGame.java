import java.util.Scanner;

public class ColoringGame {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int t = 1; t <= T; t++){
            int n = in.nextInt();
            int res = f(n);
            System.out.println("Case #"+ t + ": " + res);
        }
    }

    public static int f(int n){
        if(n <= 5) return 1;
        int bot = 1;
        int john = 0;
        int x = 1;
        int count = 0;

        while(x <= n){
            if(count % 2 == 0){
                x += 3;
                if(x <= n) john++;
            }
            else{
                x += 2;
                if(x <= n) bot++;
            }
            count++;
        }
        return bot;
    }
}
