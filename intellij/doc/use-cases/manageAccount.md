# Manage Account

## 1. Primary actor and goals
Who is the main interested party and what goal(s) this use case is designed to help them achieve:

* __User__: wants to change their credentials (username, password, email)

## 2. Other stakeholders and their goals

* None

## 3. Preconditions

What must be true prior to the start of the use case.

* User must have downloaded the app.
* User must have made an account.

## 4. Postconditions

What must be true upon successful completion of the use case.

* User's Spendies account is updated to match their changes.


## 4. Workflow

The sequence of steps involved in the execution of the use case, in the form of one or more activity diagrams (please feel free to decompose into multiple diagrams for readability).

The workflow can be specified at different levels of detail:

* __Brief__: main success scenario only;
* __Casual__: most common scenarios and variations;
* __Fully-dressed__: all scenarios and variations.


```plantuml
@startuml

skin rose

title Manage (casual level)

'define the lanes
|#application|User|
|#implementation|Controller|

start
|User|
:Selects Username, Password, Email form;

|Controller|
:Execute __Update Credentials__;

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
spendiesUI -> user : Displays general dashboard
user -> spendiesUI : Press "edit account"
spendiesUI -> user : Displays username, password, email form
user -> spendiesUI : Press "change [username, password, email]"

spendiesUI -> system : updateCredentials()
spendiesUI -> user : Confirms change and displays updated [username, password, email]
@enduml
```
