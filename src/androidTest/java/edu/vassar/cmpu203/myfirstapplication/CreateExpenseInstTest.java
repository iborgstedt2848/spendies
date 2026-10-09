package edu.vassar.cmpu203.myfirstapplication;

import android.widget.DatePicker;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.vassar.cmpu203.myfirstapplication.R;
import edu.vassar.cmpu203.myfirstapplication.controller.MainActivity;

public class CreateExpenseInstTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private UiDevice device;

    @Before
    public void setUp() {
        // Get the UiDevice instance
        device = UiDevice.getInstance(androidx.test.platform.app.InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testCreateTripAndExpense() {
        // Step 1: Log in (if needed)
        login("your_username", "your_password");

        // Step 2: Create Trip
        createTrip("New York 2024", "John, Jane", "2024-12-01 to 2024-12-10", "$1000");

        // Step 3: Click on the specific trip widget
        selectTripWidget("New York 2024");

        // Step 4: Verify Trip Details (Ensure correct trip screen)
        verifyTripDetails("New York 2024", "Participants: John, Jane",
                "Dates: 2024-12-01 to 2024-12-10", "Budget: $1000");

        // Step 5: Create Expense
        createExpense();
    }

    private void login(String username, String password) {
        // Enter the username
        Espresso.onView(ViewMatchers.withId(R.id.editUsername))
                .perform(ViewActions.typeText(username));
        Espresso.closeSoftKeyboard();

        // Enter the password
        Espresso.onView(ViewMatchers.withId(R.id.editPassword))
                .perform(ViewActions.typeText(password));
        Espresso.closeSoftKeyboard();

        // Click the "Log in" button
        Espresso.onView(ViewMatchers.withId(R.id.log_in))
                .perform(ViewActions.click());

        // Wait for the main screen or dashboard to appear
        Espresso.onView(ViewMatchers.withId(R.id.frameLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    private void createTrip(String tripName, String participants, String dates, String budget) {
        // Click the "Create Trip" button
        Espresso.onView(ViewMatchers.withId(R.id.btn_create_trip))
                .perform(ViewActions.click());

        // Verify the "Create Trip" form is displayed
        Espresso.onView(ViewMatchers.withId(R.id.editName))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Fill out the trip form
        Espresso.onView(ViewMatchers.withId(R.id.editName))
                .perform(ViewActions.typeText(tripName));
        Espresso.closeSoftKeyboard();

        // Trigger the DatePickerDialog for start date
        Espresso.onView(ViewMatchers.withId(R.id.editStartDate))
                .perform(ViewActions.click());

        // Wait for the DatePickerDialog to appear
        device.wait(Until.hasObject(By.desc("Date Picker")), 5000);

        // Get the DatePicker UI element
        UiObject2 datePicker = device.findObject(By.clazz(DatePicker.class));

        if (datePicker != null) {
            UiObject2 okButton = device.findObject(By.desc("OK"));
            if (okButton != null) {
                okButton.click();
            } else {
                System.out.println("OK button not found!");
            }
        } else {
            System.out.println("DatePicker not found!");
        }

        // Fill out the rest of the form
        Espresso.onView(ViewMatchers.withId(R.id.editEndDate))
                .perform(ViewActions.typeText("12/17/2024"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.editDestinations))
                .perform(ViewActions.typeText("New York"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.editBudget))
                .perform(ViewActions.typeText("500"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.editParticipants))
                .perform(ViewActions.typeText("Isabelle, Ashley"));

        // Submit the trip form
        Espresso.onView(ViewMatchers.withId(R.id.btn_create_trip))
                .perform(ViewActions.click());

        // Wait for the dashboard to update
        Espresso.onIdle();
    }

    private void selectTripWidget(String tripName) {
        // Find the trip widget with the specified name and click it
        Espresso.onView(ViewMatchers.withText(tripName))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))  // Ensure the trip is displayed
                .perform(ViewActions.click());  // Click the trip widget
    }

    private void verifyTripDetails(String tripName, String participants, String dates, String budget) {
        // Ensure you are on the correct trip screen (act_feed) for the trip you just created
        Espresso.onView(ViewMatchers.withId(R.id.af_trip_name))
                .check(ViewAssertions.matches(ViewMatchers.withText(tripName)));

        Espresso.onView(ViewMatchers.withId(R.id.af_trip_participants))
                .check(ViewAssertions.matches(ViewMatchers.withText(participants)));

        Espresso.onView(ViewMatchers.withId(R.id.af_trip_dates))
                .check(ViewAssertions.matches(ViewMatchers.withText(dates)));

        Espresso.onView(ViewMatchers.withId(R.id.af_trip_budget))
                .check(ViewAssertions.matches(ViewMatchers.withText(budget)));
    }

    private void createExpense() {
        // Step 1: Go to the expenses screen
        Espresso.onView(ViewMatchers.withId(R.id.af_create_expense))
                .perform(ViewActions.click());

        // Step 2: Check if the "Create Expense" form is displayed
        Espresso.onView(ViewMatchers.withId(R.id.create_expense_id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())); // Ensure the view is visible before interacting

        // Step 3: Add a new expense
        Espresso.onView(ViewMatchers.withId(R.id.et_expense_description))
                .perform(ViewActions.typeText("Trip Expense"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.btn_add_line_item))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.et_line_item_name))
                .perform(ViewActions.typeText("Dinner"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.et_line_item_price))
                .perform(ViewActions.typeText("100"));
        Espresso.closeSoftKeyboard();

        Espresso.onView(ViewMatchers.withId(R.id.et_line_item_participants))
                .perform(ViewActions.typeText("Isabelle, Ashley"));
        Espresso.closeSoftKeyboard();

        // Step 4: Save the expense
        Espresso.onView(ViewMatchers.withId(R.id.btn_save_expense))
                .perform(ViewActions.click());

        // Step 5: Verify the expense is created
        Espresso.onView(ViewMatchers.withId(R.id.af_container_expenses))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("Trip Expense"))));
    }
}
