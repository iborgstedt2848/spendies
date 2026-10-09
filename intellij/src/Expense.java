import java.util.List;

public class Expense {
    private boolean isPersonal; // True if personal, false if shared
    private float amount;
    private List<String> participants;
    private String description;

    public Expense(boolean isPersonal, float amount, List<String> participants, String description){
        this.isPersonal = isPersonal;
        this.amount = amount;
        this.participants = participants;
        this.description = description;
    }

    public boolean getPersonal(){
        return isPersonal;
    }

    public float getAmount(){
        return amount;
    }

    public List<String> getParticipants(){
        return participants;
    }

    public String getDescription(){
        return description;
    }

    public String toString() {
        return ("$" + amount + " was spent on " + description + " by " + participants + ".");
    }
}
