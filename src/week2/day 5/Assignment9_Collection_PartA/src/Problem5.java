import java.util.HashMap;

public class Problem5 {
    /*
    Java Map – Phone Directory
    Problem Statement:
    Create a phone directory using HashMap<String, Integer>.
    Then process queries to search for phone numbers.
    Input:
    3
    raj 987654
    amit 998877
    neha 889900
    2
    raj
    sonal
    Output:
    raj=987654
    Not found
     */

    static HashMap<String, Integer> phoneDirectory = new HashMap<>();

    static  void searchPhoneNumber(String name){
        if(phoneDirectory.containsKey(name)){
            System.out.println(name+ "'s phone number:"+phoneDirectory.get(name));
        }else {
            System.out.println(name+"'s Not Found");
        }
    }

    public static void main(String[] args) {
      // number to directory
        phoneDirectory.put("raj", 987654);
        phoneDirectory.put("amit" ,998877);
        phoneDirectory.put("neha", 889900);

        //search number
        searchPhoneNumber("raj");
        searchPhoneNumber("sonal");
    }
}
