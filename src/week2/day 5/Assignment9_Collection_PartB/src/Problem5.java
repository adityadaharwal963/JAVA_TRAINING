import java.util.Stack;

public class Problem5 {
    /*
    Browser Navigation System
    Scenario:
    Implement browser back-navigation functionality.
    Requirements:
     Store visited URLs
     Allow back navigation
     Display current page
    Hint:
    Use Stack<String>
     */
    static Stack<String> visitedUrls = new Stack<>();
    static void visit(String website){
        visitedUrls.add(website);
        System.out.println("Visited: "+website);
    }
    static void displayCurrentWebsite(){
        System.out.println("Current Website "+visitedUrls.peek());
    }

    static void navigateBack(){
        visitedUrls.pop();
        displayCurrentWebsite();
    }

    public static void main(String[] args) {


        // visit some urls
        visit("www.google.com");
        visit("www.bing.com");
        visit("www.chat.com");
        visit("www.boat.com");

        //current website
        displayCurrentWebsite();

        // navigate 2 website back;
        navigateBack();
        navigateBack();

    }
}
