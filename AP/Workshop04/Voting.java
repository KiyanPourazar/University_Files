package voting;
import java.util.*;

public class Voting {

    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type,String question, boolean isAnonymous){
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        
    }
    
    public ArrayList<String> getChoices(){
        return null;
    }
    public void createChoice (String choice){
        // voters.add(choice);
    }
    public void vote (Person voter, ArrayList<String> Voter){

    }
    public void vote(Person person){

    }
    public void printResults(){

    }
    public void printVoters(){

    }


}
