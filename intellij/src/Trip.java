import java.util.List;

public class Trip{
    private String name;
    private String startDate;
    private String endDate;
    private List<String> destinations;
    private float budget;
    private List<String> participants;
    private List<Expense> expenses;

    public Trip(String name, String startDate, String endDate, List<String> destinations, float budget, List<String> participants, List<Expense> expenses) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = destinations;
        this.budget = budget;
        this.participants = participants;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public float getBudget() {
        return budget;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void updateDashboard(){
        //TODO
    }

    public String toString() {
        return name + " Trip"+ "\n" +
                "startDate: " + startDate + "\n" +
                "endDate: " + endDate + "\n" +
                "destinations: " + destinations + "\n" +
                "budget: $" + budget + "\n" +
                "participants: " + participants + "\n";
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public void deleteExpense(){
        expenses.remove(expenses.size()-1);
    }

    public void editExpense(boolean isPersonal, float amount, List<String> participants, String description, Expense expense){
        expenses.remove(expense);
        Expense editedExpense = new Expense(isPersonal, amount, participants, description);
        expenses.add(editedExpense);
    }
}
