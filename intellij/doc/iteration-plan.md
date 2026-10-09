# Next Iteration Plan #1:

Consider criticality, risk, and coverage.
1. Manage Expense (High): This use case is especially important for our project because
it encapsulates adding, delegating, editing, and deleting expenses. We need these
calculations to be accurate because they are the foundation of our app.
   - Prioritizing manual entry of the expenses because it is the more basic way of
     inputting them. Later, we can try implementing the receipt scanning feature.
2. Create Trip (High): This must be done successfully in order to complete any task on the 
app. This prompts the user to input trip details such as location, dates, budget, etc.
3. View Trips (Medium): This includes functionality to edit the trip details and update them 
successfully for trips that have already been created. 
4. Manage Participants (Medium): The ability to add or delete a participant from a trip.
5. Sign Up (Low): One must successfully be added to the account database.
6. Manage Trips (Low): Simply redirects the user to create or view trips.

# Next Iteration Plan #2:

This iteration was focused on laying the foundation for the MVC architecture by creating our regular
classes, our Controller class, and our TextUI class. We were able to implement functionality that
creates a trip and an expense within an existing trip with its given parameters according to user input.

Next, we want to implement expense delegation (high priority), which comes down to calculating shared expenses.
Our system now has a list of names attached to a created expense. It should use that list of names as
well as the length of the list to determine how much money is owed by each participant. This part of the
app is very critical to its functionality, which is why we are going to prioritize it in the next iteration.

We also want to create a more open-ended UI that asks the user "What would you like to do?" and presents
the user with multiple options including create/delete/edit a trip, create/delete/edit an expense,
add/remove a friend, pay off debt, etc. (medium priority). This would simulate the general dashboard of the app where the
user would be able to select between all of these options.

In essence, we want to focus on the Manage Expense use case, which we did not fully implement in this
iteration (specifically dealing with delegation). Less critical use cases for future iterations include
Manage Participants (adding or removing participants from a specific trip) and Sign Up/Log In/Credential 
validation (low priority). These can be implemented after we focus on expense delegation.