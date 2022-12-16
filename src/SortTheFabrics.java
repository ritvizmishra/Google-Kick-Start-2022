import java.util.*;
import java.lang.*;
import java.io.*;

public class SortTheFabrics{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int test = 1; test <= T; test++){
            int n = in.nextInt();
            //  = new String[n];
            // int[] d = new int[n];
            // int[] u = new int[n];

            List<Kapda> listBhej = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String c = in.next();
                int d = in.nextInt();
                int u = in.nextInt();

                listBhej.add(new Kapda(c, d, u));
            }
            int res = solve(n, listBhej);
            System.out.println("Case #" + test + ": " + res);
        }
    }

    static int solve(int n, List<Kapda> listBhej){
        List<Kapda> pehliList = new ArrayList<>(listBhej);
        List<Kapda> doosriList = new ArrayList<>(listBhej);

        Collections.sort(pehliList, new Rang());
        Collections.sort(doosriList, new Samay());

        int res = 0;
        for(int i = 0; i < n; i++){
            if(pehliList.get(i).IDBata() == doosriList.get(i).IDBata()){
                res++;
            }
        }
        return res;
    }
}

class Rang implements Comparator{
    public int compare(Object o1, Object o2){
        Kapda one = (Kapda) o1;
        Kapda two = (Kapda) o2;

        if(one.uthaKapda().equals(two.uthaKapda())){
            return one.IDBata() - two.IDBata();
        }

        return one.uthaKapda().compareTo(two.uthaKapda());
    }
}

class Samay implements Comparator{
    public int compare(Object o1, Object o2){
        Kapda one = (Kapda) o1;
        Kapda two = (Kapda) o2;

        if(one.samayBata() == two.samayBata()){
            return one.IDBata() - two.IDBata();
        }

        return one.samayBata() - two.samayBata();
    }
}

class Kapda{
    String rang;
    int samay;
    int id;

    public Kapda(String rang, int samay, int id){
        this.rang = rang;
        this.samay = samay;
        this.id = id;
    }

    int IDBata(){
        return id;
    }

    String uthaKapda(){
        return rang;
    }

    int samayBata(){
        return samay;
    }
}