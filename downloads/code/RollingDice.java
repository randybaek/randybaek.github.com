import java.util.ArrayList;
import java.util.Iterator;
 
public class DiceDistribution {
    static Double[][] dist;
    static int DiceNum = 3;
    // dist[Dice Number][Number on dice]
 
    public static void main(String[] args) {
        buildDistRandomly();
 
        ArrayList<String> candidate = permutationWtihDupe();
        for (String can : candidate) {
            printItemProb(can);
        }
    }
 
    public static void printItemProb(String item){
        Double prob = 1.0;
        System.out.print(item + " : ");
        for ( int i = 0 ; i < item.length() ; i++){
            int num = Character.getNumericValue(item.charAt(i));
            prob *= dist[i][num-1];
        }
        System.out.println(prob);
    }
 
    public static void buildDistRandomly(){
        dist = new Double[DiceNum][6];
        for (int i = 0 ; i < DiceNum ; i++){
            dist[i] = buildDiceRandomly();
        }
    }
 
    public static Double[] buildDiceRandomly(){
        Double[] dist = new Double[6];
        Double sum = 0.0;
        for (int i = 0; i < 6 ; i++){
            Double rand = Math.random();
            sum += rand;
            dist[i] = rand;
        }
        for (int i = 0 ; i < 6 ; i++){
            dist[i] = dist[i] / sum;
        }
        return dist;
    }
 
    static ArrayList<String> permutationWtihDupe(){
        ArrayList<String> candidate = new ArrayList<String>();
        // init first candidate
        for (int i = 0; i < 6 ; i++){
            candidate.add(Integer.toString(i+1));
        }
        int curLen = 1;
 
        while (curLen < DiceNum) {
            ArrayList<String> newCandidate = new ArrayList<String>();
            for (Iterator<String> iter = candidate.iterator(); iter.hasNext();){
                String item = iter.next();
                for (int i = 0; i < 6 ; i++){
                    newCandidate.add( item + Integer.toString(i+1));
                }
            }
            candidate = newCandidate;
            curLen++;
        }
        return candidate;
    }
}
