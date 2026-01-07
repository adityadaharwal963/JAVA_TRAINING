package Assignment2;

public class Problem8Insurance {
    /*
    Problem 8: Insurance Policy Eligibility
    Problem Dascription
    Policy eligibility based on age, medical history, and soking status.
    Rules
    • Аде 18-60
    No critical illness
    Smoken → premium increases by 20%
    Input Format
    isSomker
    hasCriticalIllness true/false
    BasePremium
    Output Format
•   Print Not Eligible or final premium amount
     */

    public static void  checkInsurance(int age,double basePremium, boolean isSmoker, boolean hasCriticalIllness){
        if(age<=60 && age>=18 && !hasCriticalIllness){
            if(isSmoker){
                basePremium += basePremium*0.2;
            }
            System.out.println("Your Premium is:"+basePremium);
        }
        System.out.println("Not Eligible");

    }
}
