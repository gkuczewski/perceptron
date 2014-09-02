package perceptron;
import java.util.*;

public class Perceptron {

    public static final int INFINITY = 100_000;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int nInputs = input.nextInt();
        int nSets = input.nextInt();
        
        for(int sets = 0; sets < nSets ; sets++){
            int nPatterns = input.nextInt();
            String[] patterns = new String[nPatterns];
            int[] output = new int[nPatterns];
            for (int i = 0; i < nPatterns; i++){
                patterns[i] = input.next();
                output[i] = input.nextInt();
            }
            int[] inputs = new int[nInputs];
            int[] weights = new int[nInputs];
            int sum, outpt , error;
            for(int j = 0; j < nInputs; j++){
                weights[j]= 0;
            }
            boolean again = false;
            for(int pass = 0; again && pass < INFINITY; pass++){
                for(int pat = 0; pat < nPatterns; pat++){
                     for(int i = 0; i < nInputs; i++){
                        inputs[i] = patterns[pat].charAt(i) == '1'? 1: -1;
                    }
                    sum = 0;
                    for(int i = 0; i < nInputs ; i++){
                        sum += inputs[i] * weights[i];
                    }
                    outpt = sum >= 0 ? 1 : 0;
                    error = output[pat] - outpt;
                    if(error != 0) {
                        again = true;
                    }
                    for(int i = 0; i < nInputs ; i++){
                            weights[i] += error * inputs[i];
                     }
                   
                }
               
            }
             if(again){
              System.out.println("cannot learn");
              }
                    else{
                        System.out.println("can learn");
                    }
        }
        
    }
}
