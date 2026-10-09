import java.util.List;
import java.util.HashMap;

public class Dashboard {
    private List<Trip> trips;
    private List<HashMap<String, String>> debts; // List of debts. Revise: type of <k,v>

    public Dashboard(List<Trip> trips, List<HashMap<String, String>> debts) {
        this.trips = trips;
        this.debts = debts;
    }

    public List<Trip> getTrips(){
        return trips;
    }

    public List<HashMap<String, String>> getDebts(){
        return debts;
    }

    public String toString() {
        return ("Trips: " + trips + "\nDebts: " + debts);
    }

    public void createTrip(String name, String startDate, String endDate, List<String> destinations, float budget, List<String> participants, List<Expense> expenses) {
        Trip trip = new Trip(name, startDate, endDate, destinations, budget, participants, expenses);
        trips.add(trip);
    }

    public void editTrip(String name, String startDate, String endDate, List<String> destinations, float budget, List<String> participants, List<Expense> expenses, Trip trip){
        trips.remove(trip);
        Trip editedTrip = new Trip(name, startDate, endDate, destinations, budget, participants, expenses);
        trips.add(editedTrip);
    }
}
