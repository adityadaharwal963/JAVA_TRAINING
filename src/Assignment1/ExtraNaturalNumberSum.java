package Assignment2;

public class ExtraNaturalNumberSum {
    int getNaturalNumberSum(int n){
        return n*(n+1)/2;
    }
    int getNaturalNumberSumLoop(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
}
