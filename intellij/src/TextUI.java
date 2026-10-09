import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    private Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    // Create a Trip Methods
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Spendies! Would you like to create a trip? (yes/no)");
    }

    public String getUserResponse() {
        return scanner.nextLine();
    }

    public String getTripName() {
        System.out.println("Enter the trip name: ");
        return scanner.nextLine();
    }

    public String getStartDate() {
        System.out.println("Enter the start date: ");
        return scanner.nextLine();
    }

    public String getEndDate() {
        System.out.println("Enter the end date: ");
        return scanner.nextLine();
    }

    public int getNumDestinations() {
        System.out.println("How many destinations will this trip have? ");
        return scanner.nextInt();
    }

    public List<String> getDestinations(int numDestinations) {
        List<String> destinations = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < numDestinations; i++) {
            System.out.println("Enter the destination name: ");
            destinations.add(scanner.nextLine());
        }
        return destinations;
    }

    public float getBudget() {
        System.out.println("What is your budget? ");
        return scanner.nextFloat();
    }

    public List<String> getParticipants() {
        scanner.nextLine(); // Consume newline
        System.out.println("Who will be joining you? Please provide a comma-separated list of names: ");
        String participants = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(participants.split(",")));
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>();
    }

    public void displayTripDetails(Trip trip) {
        System.out.println("Trip Created: " + trip.getName());
    }

    public String selectTrip(List<Trip> trips) {
        System.out.println("Available trips:");
        for (Trip trip : trips) {
            System.out.println("- " + trip.getName());
        }
        System.out.println("Enter the name of the trip you want to add an expense to: ");
        return scanner.nextLine();
    }

public Expense getExpenseDetails() {
    System.out.println("Is this expense personal? (yes/no)");
    boolean isPersonal = scanner.nextLine().equalsIgnoreCase("yes");

    System.out.println("Enter the amount spent: ");
    float amount = scanner.nextFloat();
    scanner.nextLine(); // Consume newline

    System.out.println("Enter a description for the expense: ");
    String description = scanner.nextLine();

    System.out.println("Who participated in this expense? Please provide a comma-separated list of names including yourself: ");
    String participantsInput = scanner.nextLine();
    List<String> participants = new ArrayList<>(Arrays.asList(participantsInput.split(",")));

    return new Expense(isPersonal, amount, participants, description);
}

public void displayExpenses(List<Expense> expenses) {
    System.out.println("Expenses:");
    for (Expense expense : expenses) {
        System.out.println(expense);
    }
}
}