import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem10 {
    /*
    10. Online Voting System
    Concept: Set + HashMap
    Scenario
    In an online election:
     A voter can vote only once.
     You must count votes for each candidate.
    Task
    1. Use Set to store voted user IDs.
    2. Use HashMap to store candidate → votes.
    3. Display final results.
     */

    static Set<String> voted = new HashSet<>();
    static HashMap<String,Integer> votingData= new HashMap<>();

    static void simulateVote(Voter voter,String candidate){
        if(!voted.contains(voter.getId())){
            // add voter to voted list
            voted.add(voter.getId());

            // update voting data
            if(votingData.containsKey(candidate))
                votingData.put(candidate,votingData.get(candidate)+1);
            else
                votingData.put(candidate,1);
        }else {
            System.out.println("Already Voted");
        }
    }

    static void displayResult(){
        int maxVotes = 0;
        String winner = "";
        for(Map.Entry<String,Integer> log: votingData.entrySet()){
            System.out.println(log.getKey()+" "+log.getValue());
            if(maxVotes < log.getValue()){
                maxVotes = log.getValue();
                winner = log.getKey();
            }
        }
        System.out.println("Winner: "+winner);
    }

    public static void main(String[] args) {
        //voters
        Voter v1 = new Voter("ewej2","Kohu");
        Voter v2 = new Voter("ewej4","Khhu");
        Voter v3 = new Voter("ewej5","Kobahaku");
        Voter v4 = new Voter("ewej8","Kobahak3");

        // simulate Voting
        simulateVote(v1,"BJP");
        simulateVote(v2,"Congress");
        simulateVote(v3,"BJP");
        simulateVote(v4,"AAP");
        simulateVote(v3,"Congress"); // <-- user already voted

        // declare winner
        displayResult();
    }
}

class Voter{
    private String id;
    private String name;


    public Voter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}