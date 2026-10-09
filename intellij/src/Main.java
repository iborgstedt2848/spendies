import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TextUI view = new TextUI();
        Dashboard dashboard = new Dashboard(new ArrayList<>(), new ArrayList<>());
        Controller controller = new Controller(view);

        view.displayWelcomeMessage();
        String response = view.getUserResponse();

        if (response.equalsIgnoreCase("yes")) {
            Trip trip = controller.createTrip();
            dashboard.createTrip(trip.getName(), trip.getStartDate(), trip.getEndDate(),
                    trip.getDestinations(), trip.getBudget(), trip.getParticipants(), trip.getExpenses());
            view.displayTripDetails(trip);
        } else {
            System.out.println("Thank you! Goodbye.");
            return;
        }

        // Print the trips list
        System.out.println("Current Trips:");
        for (Trip t : dashboard.getTrips()) {
            System.out.println(t.toString());
        }

        System.out.println("Would you like to add an expense to a trip? (yes/no)");
        String addExpenseResponse = view.getUserResponse();

        if (addExpenseResponse.equalsIgnoreCase("yes")) {
            controller.addExpenseToTrip(dashboard);
        }else{
            System.out.println("Thank you! Goodbye.");
            return;
        }

        // Print current trips and expenses for verification
        System.out.println("Current Trips:");
        for (Trip t : dashboard.getTrips()) {
            System.out.println(t);
            view.displayExpenses(t.getExpenses());
        }
    }
}