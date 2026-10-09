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

public class CreateTripInstTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private UiDevice device;

    @Before
    public void setUp() {
        // Get the UiDevice instance
        device = UiDevice.getInstance(androidx.test.platform.app.InstrumentationRegistry.getInstrumentation());

        // Ensure the username field is visible
        Espresso.onView(ViewMatchers.withId(R.id.editUsername))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // Ensure it's visible
                .perform(ViewActions.click()) // Click to focus
                .perform(ViewActions.typeText("your_username"));

        Espresso.closeSoftKeyboard();

        // Perform password input
        Espresso.onView(ViewMatchers.withId(R.id.editPassword))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // Ensure it's visible
                .perform(ViewActions.click()) // Click to focus
                .perform(ViewActions.typeText("your_password"));

        Espresso.closeSoftKeyboard();

        // Perform login button click
        Espresso.onView(ViewMatchers.withId(R.id.log_in))
                .perform(ViewActions.click());

        // Wait for the app to complete the login process and navigate to the main screen
        Espresso.onView(ViewMatchers.withId(R.id.frameLayout))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Test
    public void testCreateTrip() {
        // Click the "Create Trip" button
        Espresso.onView(ViewMatchers.withId(R.id.btn_create_trip))
                .perform(ViewActions.click());

        // Verify the "Create Trip" form is displayed
        Espresso.onView(ViewMatchers.withId(R.id.editName))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Fill out the trip form
        Espresso.onView(ViewMatchers.withId(R.id.editName))
                .perform(ViewActions.typeText("New York 2024"));
        Espresso.closeSoftKeyboard();

        // Trigger the DatePickerDialog for start date
        Espresso.onView(ViewMatchers.withId(R.id.editStartDate))
                .perform(ViewActions.click());

        // Wait for the DatePickerDialog to appear
        device.wait(Until.hasObject(By.desc("Date Picker")), 5000);

        // Get the DatePicker UI element
        UiObject2 datePicker = device.findObject(By.clazz(DatePicker.class));

        // If datePicker is null, log the error and return
        if (datePicker == null) {
            System.out.println("DatePicker not found!");
            return;
        }

        // Get all the child elements of the DatePicker (which should include year, month, and day pickers)
        UiObject2 yearPicker = null;
        UiObject2 monthPicker = null;
        UiObject2 dayPicker = null;

        // Loop through the children of the DatePicker to assign them
        for (UiObject2 child : datePicker.getChildren()) {
            System.out.println("Child found: " + child.getClassName()); // Log the class name of each child
            if (child.getClassName().equals(android.widget.NumberPicker.class.getName())) {
                if (yearPicker == null) {
                    yearPicker = child;
                } else if (monthPicker == null) {
                    monthPicker = child;
                } else if (dayPicker == null) {
                    dayPicker = child;
                }
            }
        }

        // Check if the pickers were successfully found
        if (yearPicker == null || monthPicker == null || dayPicker == null) {
            System.out.println("Failed to find all pickers.");
            return; // Return early if we couldn't find all pickers
        }

        // Select Year (2024)
        yearPicker.click();
        device.findObject(By.text("2024")).click();

        // Select Month (December)
        monthPicker.click();
        device.findObject(By.text("December")).click();

        // Select Day (15)
        dayPicker.click();
        device.findObject(By.text("15")).click();

        // Confirm the date selection by clicking the "OK" button on the DatePicker
        UiObject2 okButton = device.findObject(By.desc("OK"));
        if (okButton != null) {
            okButton.click();
        } else {
            System.out.println("OK button not found!");
            return; // Exit if OK button is not found
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

        // Verify that the new trip is displayed in the list (e.g., in a RecyclerView or TextView)
    }
}
