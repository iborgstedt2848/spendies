import java.util.List;

public class Controller {
    private TextUI view;

    public Controller(TextUI view) {
        this.view = view;
    }

    public Trip createTrip() {
        String name = view.getTripName();
        String startDate = view.getStartDate();
        String endDate = view.getEndDate();
        int numDestinations = view.getNumDestinations();
        List<String> destinations = view.getDestinations(numDestinations);
        float budget = view.getBudget();
        List<String> participants = view.getParticipants();
        List<Expense> expenses = view.getExpenses();

        return new Trip(name, startDate, endDate, destinations, budget, participants, expenses);
    }

    public void addExpenseToTrip(Dashboard dashboard) {
        String tripName = view.selectTrip(dashboard.getTrips());
        Trip trip = null;

        // Find the trip by name
        for (Trip t : dashboard.getTrips()) {
            if (t.getName().equalsIgnoreCase(tripName)) {
                trip = t;
                break;
            }
        }

        if (trip != null) {
            Expense expense = view.getExpenseDetails();
            trip.addExpense(expense); // Ensure Trip class has this method
            System.out.println("Expense added successfully to trip: " + trip.getName());
        } else {
            System.out.println("Trip not found: " + tripName);
        }
    }

}