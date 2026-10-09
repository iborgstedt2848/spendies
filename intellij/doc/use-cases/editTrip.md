# Edit Trip

## 1. Primary actor and goals
Who is the main interested party and what goal(s) this use case is designed to help them achieve:

* __User__: wants to view a trip that has already been created or a trip that is in
trip drafts.

## 2. Other stakeholders and their goals

* None

## 3. Preconditions

What must be true prior to the start of the use case.

* User must have signed up or logged in.
* User must have created or drafted at least one trip.

## 4. Postconditions

What must be true upon successful completion of the use case.

* Trip is updated if information has been changed.
  * e.g. If the user chooses to change the location, dates. etc.
* Trip is added to the "active" trip log if a drafted trip has been completely planned.

## 4. Workflow

The sequence of steps involved in the execution of the use case, in the form of one or more activity diagrams (please feel free to decompose into multiple diagrams for readability).

The workflow can be specified at different levels of detail:

* __Brief__: main success scenario only;
* __Casual__: most common scenarios and variations;
* __Fully-dressed__: all scenarios and variations.


```plantuml
@startuml

skin rose

title Edit Trip (casual level)

'define the lanes
|#application|User|
|#implementation|Controller|

start
|Controller|
:Display form;

|User|
if (Select) is  ( Name. Dates. Location Form ) then

|Controller|
:Validate and save information;

endif

|User|
if (Select) is  ( Budget  Form ) then

|Controller|
:Execute __Update Budget__;

endif

|User|
if (Select) is  ( Manage Participants ) then

|Controller|
:Execute __Manage Participants__;

endif

|User|
if (Select) is  ( Delete Trip ) then

|Controller|
:Remove from trip list;

endif


stop
@enduml
```

# Sequence Diagram
```plantuml
@startuml
hide footbox
actor User as user
participant ": SpendiesUI" as spendiesUI
participant ": Controller" as system
[o-> spendiesUI :
spendiesUI -> user : Display trip form
user -> spendiesUI : Input name, dates, location, and budget
user -> spendiesUI : Click done
spendiesUI -> system : editTrip()
system ->> spendiesUI : updateDashboard()
spendiesUI -> user : Show edited trip on dashboard
@enduml
```