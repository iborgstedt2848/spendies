# Create Trip

## 1. Primary actor and goals
Who is the main interested party and what goal(s) this use case is designed to help them achieve:

* __User__: wants to create a new trip object that can later be shared with 
other party members.

## 2. Other stakeholders and their goals

* None

## 3. Preconditions

What must be true prior to the start of the use case.

* User must have signed up or logged in.

## 4. Postconditions

What must be true upon successful completion of the use case.

* Trip object is instantiated.
* The user has been prompted to...
  * name the trip
  * set the dates for a hypothetical trip or mark as current trip
  * select a location
  * add participants
  * set a personal and/or group budget
* Note: The user may opt to skip any of these steps for now and come back later to 
fill them in.

## 4. Workflow

The sequence of steps involved in the execution of the use case, in the form of one or more activity diagrams (please feel free to decompose into multiple diagrams for readability).

The workflow can be specified at different levels of detail:

* __Brief__: main success scenario only;
* __Casual__: most common scenarios and variations;
* __Fully-dressed__: all scenarios and variations.


```plantuml
@startuml

skin rose

title Create Trip (casual level)

'define the lanes
|#application|User|
|#implementation|Controller|

|Controller|
start
:Prompt user to create a trip;

|User|
:Create trip;

|Controller|
:Prompt user to input a name, dates, location, budget;

|User|
:Select trip name, dates, location, budget;

|Controller|
if (Dates) is  ( Future ) then
:Create Trip Draft;

else ( Current ) 
:Create Active Trip;
endif

|Controller|
:Prompt user to set a budget;

|Controller|
if (Budget) is  ( Personal ) then
:Set Personal Budget;

else ( Shared ) 
:Set Shared Budget;
endif

|Controller|
:Prompt user to add participants;

|User|
:Add participants;

|User|
:View trip in trip log;
stop
@enduml
```

# Sequence Diagram
```plantuml
@startuml
skin rose
hide footbox

' participants

actor "User" as user
participant ": TextUI" as ui
participant ": Controller" as controller
participant "curDashboard : Dashboard" as dashboard
participant "trip: Trip" as trip

' messages

user <- ui : Display create trip form

user -> ui : Input name, start date, end date, destinations, budget, participants, expenses

user -> ui : Select "Create trip"
 
ui -> controller : createTrip(name, start date, end date, destinations, budget, participants, expenses)

controller -> dashboard : createTrip(trip)

dashboard -> trip ** : createTrip(name, start date, end date, destinations, budget, participants, expenses)

controller -> ui : displayDashboard(curDashboard)

@enduml
```