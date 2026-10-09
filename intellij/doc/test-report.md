# Test Report:

* All tests are run under the assumption that the user is a new user
and thus has no existing trips and/or expenses
## Test 1: User does not want to create a trip or edit dashboard
### User Input: 
Signifies user remaining in Dashboard, but not interacting with trip features
### Output:
```
Welcome to Spendies! Would you like to create a trip? (yes/no)
no
Thank you! Goodbye.
```
### Does this meet expectations?
Yes, this meets expectations because this  correctly handles the case where a user chooses 
not to interact with the dashboard's trip features. It reinforces the system precondition that a 
trip must exist before any expenses can be added or edited.


## Test 2: User creates a trip and does NOT want to add an expense
### User Input:
User fills out trip form, with trip details only
### Output:
```
Welcome to Spendies! Would you like to create a trip? (yes/no)
yes

Enter the trip name:
Germany

Enter the start date:
3/29

Enter the end date:
4/7

How many destinations will this trip have?
1

Enter the destination name:
Hamburg

what is your budget?
1349313

Who will be joining you? Please provide a comma-separated list of names:
Oscar, Donald, Bob

Trip Created: Germany
Current Trips:
Germany Trip 
startDate: 3/29
endDate: 4/7
destinations: [Hamburgl
budget: $1349313.0
participants: [Oscar, Donald, Bob]

Would you like to add an expense to a trip? (yes/no)
no

Thank you! Goodbye.
```
### Does this meet expectations?
Yes, this meets expectations because it shows that users can successfully 
create a trip, while also enforcing the logical constraint that expenses can
only be added when there is an existing trip to associate them with. This 
validation ensures data integrity by preventing orphaned expenses.

## Test 3: User creates a trip and adds an expense to the trip
### User Input:
User fills out trip form, with trip details and then fills out expense form with expense details
### Output:
```
Welcome to Spendies! Would you like to create a trip? (yes/no)
yes

Enter the trip name:
Japan

Enter the start date:
10/20

Enter the end date:
10/30

How many destinations will this trip have?
2

Enter the destination name:
Japan

Enter the destination name:
Korea

What is your budget?
10000.25

Who will be joining you? Please provide a comma-separated list of names:
Isabelle, Ashley

Trip Created: Japan
Current Trips:
Japan Trip startDate: 10/20
endDate: 10/30
destinations: [Japan, Koreal budget: $10000.25
participants: [Isabelle, Ashley]

Would you like to add an expense to a trip? (yes/no)
yes

Available trips:
- Japan

Enter the name of the trip you want to add an expense to:
Japan

Is this expense personal? (yes/no)
по

Enter the amount spent:
60

Enter a description for the expense: dinner
Isabelle, Ashley

Expense added successfully to trip: Japan

Current Trips:
Japan Trip startDate: 10/20
endDate: 10/30
destinations: [Japan, Koreal budget: $10000.25
participants: [Isabelle, Ashley]
Who participated in this expense? Please provide a comma-separated list of names including yourself:

Expenses:
$60.0 was spent on dinner by [Isabelle, Ashley].
```
### Does this meet expectations?
Yes this  meets expectations as it successfully handles key functions. First, it
creates a new trip and adds it to the list of existing trips. Later, when users create an expense,
they can access this trip's information to properly allocate costs and delegate participation. The 
system also correctly updates the trip's list of expenses, confirming that the relationship between 
trips and expenses is working as intended.

