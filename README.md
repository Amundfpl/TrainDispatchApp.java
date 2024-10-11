[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/sT7H9ZJB)
# Portfolio project IDATA1003 - 2023
This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).

STUDENT NAME = "Amund Finne Præsteng Larsen"  

## Project description

[//]: Train dispatch system, where the user can see the train departures, add train departures, serach for train departures by train number or destination and more

## Project structure

<pre>
```
src
├── main
│   └── java
│       ├── edu.ntnu.stud
│       │   ├── inputValidator
│       │   │   └── InputValidator.java
│       │   ├── printer
│       │   │   └── Printer.java
│       │   ├── station
│       │   │   └── Station.java
│       │   ├── stringUtility
│       │   │   └── StringUtility.java
│       │   ├── trainDeparture
│       │   │   └── TrainDeparture.java
│       │   └── visual
│       │       └── Visual.java
│       └── TrainDispatchApp.java
└── test
    └── java
        ├── edu.ntnu.stud
        │   ├── inputValidator
        │   │   └── InputValidator.java
        │   ├── station
        │   │   └── Station.java
        │   └── trainDeparture
        │       └── TrainDeparture.java
```
</pre>
        
## Link to repository

https://github.com/NTNU-BIDATA-IDATG1003-2023/mappe-idatg1003-traindispatchsystem-Amundfpl

## How to run the project

[//]: The main class is the TrainDispatchApp.java, and the main method is the start() method.
When you start the program it will show a list of options, and the user can chose an option by typing a number between 1-8. 
The options are as following: 
1. Show all departures
2. add train
3. assign track
4. add delay
5. search by train number
6. search by destination
7. update the clock
8. exit
## How to run the tests

[//]: The tests can be run by marking all the test classes in the test folder, then right click and press run tests. 

## References

https://www.w3schools.blog/ansi-colors-java
