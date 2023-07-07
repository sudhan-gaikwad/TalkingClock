# TalkingClock

##Talking clock coding challenge   

  Within the team, we don't like clocks that display as numbers. In fact, we like clocks that present the current time in a more "Human Friendly" way. 

###Objective 1 

Write a command-line program that returns the current time using the "Human Friendly Text" demonstrated in the example below. 

  Numeric Time Human Friendly Text  01:00 One o'clock  02:00 Two o'clock  13:00 One o'clock  13:05 Five past one  13:10 Ten past one  13:25 Twenty five past one  13:30 Half past one  13:35 Twenty five to two  13:55 Five to two  For example, if we execute this program at 16:30, it should output "Half past four"    $ talking-clock  Half past four 

###Objective 2 

  Allow the command to take an arbitrary Numeric Time parameter as input and return the "Human Friendly Text" equivalent.   For example:  $ talking-clock 15:00  Three o'clock  $ 

###Objective 3 

  Write a REST service to expose the clock and allow an optional parameter to pass the arbitrary Numeric Time like Objective 2, returning the "Human Friendly Text" as JSON. 

## Run `TalkingClock` class as Java Application for Objective 1 and 2

## Run `TalkingClockApplication` as Java Application for Spring Boot startup and use the REST service endpoint exposed below-
     mvn spring-boot:run 
     http://localhost:8080/talking-clock/{time} 
## To run the test cases `TalkingClockTest` run as JUnit Test 
    mvn test
