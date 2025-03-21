package laborator4;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        Random random=new Random();
        for(int i =0; i<5;i++){
            x.add(random.nextInt(0,10));
        }
        for(int i =0; i<7;i++){
            y.add(random.nextInt(0,10));
        }
        Collections.sort(x);
        Collections.sort(y);

System.out.println("x="+x);
        System.out.println("x="+y);

//a) xPlusY conţine toate elementele şirurilor x şi y;
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println(" xPlusY= "+xPlusY);
    }
}