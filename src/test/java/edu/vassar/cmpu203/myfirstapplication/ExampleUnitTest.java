package edu.vassar.cmpu203.myfirstapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.myfirstapplication.model.Credentials;
import edu.vassar.cmpu203.myfirstapplication.model.Dashboard;
import edu.vassar.cmpu203.myfirstapplication.model.Expense;
import edu.vassar.cmpu203.myfirstapplication.model.LineItem;
import edu.vassar.cmpu203.myfirstapplication.model.Trip;
import edu.vassar.cmpu203.myfirstapplication.model.User;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tripGetExpenses(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);
        List<LineItem> lineItemsList = new ArrayList<>();
        lineItemsList.add(new LineItem("Penne al Vodka", 17, sbParticipants));
        lineItemsList.add(new LineItem("Truffle Fries", 8, sbParticipants));
        Expense expense1 = new Expense("Dinner", lineItemsList);
        trip1.addExpense(expense1);
        //Test
        assertEquals(1, trip1.getExpenses().size());

    }

    @Test
    public void tripEditExpense(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);
        // Exoense Creation
        List<LineItem> lineItemsList = new ArrayList<>();
        lineItemsList.add(new LineItem("Penne al Vodka", 17, sbParticipants));
        lineItemsList.add(new LineItem("Truffle Fries", 8, sbParticipants));
        Expense expense1 = new Expense("Dinner", lineItemsList);
        trip1.addExpense(expense1);
        trip1.editExpense(expense1, "Dinner with Macy", lineItemsList);
        //Test
        assertEquals(1, trip1.getExpenses().size());
        assertEquals("Dinner with Macy", trip1.getExpenses().get(0).getDescription());

    }

    @Test
    public void tripDeleteExpense(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);
        // Expense Creation
        List<LineItem> lineItemsList = new ArrayList<>();
        lineItemsList.add(new LineItem("Penne al Vodka", 17, sbParticipants));
        lineItemsList.add(new LineItem("Truffle Fries", 8, sbParticipants));
        Expense expense1 = new Expense("Dinner", lineItemsList);
        trip1.addExpense(expense1);
        // Remove Expense
        trip1.deleteExpense(expense1);
        //Test
        assertEquals(0, trip1.getExpenses().size());

    }
    @Test
    public void tripValidDate(){
        String validStartDate = "01/21/25";
        String validEndDate = "02/14/25";
        String invalidStartDate = "00/32/25";
        String invalidEndDate = "00/32/26";

        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip validTrip = new Trip("Spring Break '25", validStartDate, validEndDate, sbDestinations, 1000, sbParticipants);
        Trip invalidTrip = new Trip("Spring Break '25", invalidStartDate, invalidEndDate, sbDestinations, 1000, sbParticipants);
        Trip invalidTrip2 = new Trip("Spring Break '25", validEndDate, validStartDate, sbDestinations, 1000, sbParticipants);

//        //Valid Dates
//        assertTrue(validTrip.isValidDate(validTrip.getStartDate()));
//        assertTrue(validTrip.isValidDate(validTrip.getEndDate()));
//        // Invalid Dates - where both dates do not exist
//        assertFalse(validTrip.isValidDate(invalidTrip.getStartDate()));
//        assertFalse(validTrip.isValidDate(invalidTrip.getEndDate()));
        // Invalid Dates - Where the Start Date is AFTER the End Date
        assertFalse(invalidTrip2.startBeforeEnd(invalidTrip2.getStartDate(), invalidTrip2.getEndDate()));


    }

    @Test
    public void dashboardAddTrip(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);

        //Dashboard Creation
        Dashboard dashboard = new Dashboard();

        dashboard.addTrip(trip1);

        //Test
        assertEquals(1, dashboard.getTrips().size());
    }

    @Test

    public void dashboardEditTrip(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);
        //Dashboard Creation
        Dashboard dashboard = new Dashboard();

        dashboard.addTrip(trip1);

        dashboard.editTrip(null, "03/08/25", null, null, null, null, null, trip1);

        //Test
        assertEquals("03/08/25", dashboard.getTrips().get(0).getStartDate());

    }

    @Test
    public void dashboardDeleteTrip(){
        List<String> sbDestinations = new ArrayList<>();
        List<String> sbParticipants = new ArrayList<>();
        // Destinations
        sbDestinations.add("Paris");
        sbDestinations.add("Budapest");
        // Participants
        sbParticipants.add("Isabelle");
        sbParticipants.add("Ashley");
        sbParticipants.add("Macy");
        // Trip Creation
        Trip trip1 = new Trip("Spring Break '25", "03/07/25", "03/17/25", sbDestinations, 1000, sbParticipants);
        //Dashboard Creation
        Dashboard dashboard = new Dashboard();

        dashboard.addTrip(trip1);

        dashboard.deleteTrip(trip1);
        //Test
        assertEquals(0, dashboard.getTrips().size());
    }

    @Test
    public void userAddFriends(){
        Credentials usrnameAndPswrd = new Credentials("abrea", "password123");

        User ash = new User(usrnameAndPswrd);
        String friend1 = "Isabelle";
        String friend2 = "Stacy";

        ash.addFriend(friend1);
        ash.addFriend(friend2);

        assertEquals(2, ash.getFriends().size());

    }

    @Test
    public void userRemoveFriend(){
        Credentials usrnameAndPswrd = new Credentials("abrea", "password123");

        User ash = new User(usrnameAndPswrd);
        String friend1 = "Isabelle";
        String friend2 = "Stacy";

        ash.addFriend(friend1);
        ash.addFriend(friend2);

        ash.removeFriend("Isabelle");

        assertEquals(1, ash.getFriends().size());

    }
}