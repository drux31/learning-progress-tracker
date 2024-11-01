## Learning Progress Tracker (Java)
This project is a Java project from the learning path **Spring security for Java backend Developpers**. Its objectives are to help us practice several Java subjects, such as:
* loops and flow controls;
* functional decomposition;
* SOLID principles;
* use of collections (Maps and Lists) to sort and filter data;
* JUnit testing.

### About the project
Online learning is gaining popularity. A good education platform can manage registrations, track learning progress, send notifications and newsletters to many users worldwide. It is a huge volume of work indeed. In this project, we build an application that keeps track of the registered users, their learning progress, and metrics. It will also provide detailed information about each user or any category of users and the overall statistics for the entire learning platform.

The project is divided in five stages, detailled in the following lines.

#### Stage 1 - No empty lines
In this stage, we setup the core of the program: read input, detect predefined set of commands and respond accordingly. In order to do so, a command-line interface (CLI) was implemented, so that the user can enter different commands and receive the corresponding responses. The CLI had to be case-insensitive and keep responses informative for the user.

**Main objectives**:
1. Demonstrate that it is running by printing its title: Learning Progress Tracker.
1. Wait for the commands. In this stage, the only command the program should recognize is exit. Once a user enters it, the program should print Bye! and quit.
1. Detect if a user has entered a blank line and print No input in response.
1. Print Unknown command! if a user enters an unknown command.

#### Stage 2 - Verify new users
In this stage, we verify new users by checking their registration. The program read information about users from the CLI and verify that it matches a predifined pattern.
Every user provide the following credentials:
* first name;
* last name;
* email address.

**Objectives**
In addition to the features of the first stage, your program should:
1. Recognize a new command: add students and respond with the following message: Enter student credentials or 'back' to return.
1. Recognize a new back command and react as follows: if users want to finish adding new students, the program should print a message with the total number of students added during the session, for example: Total 5 students have been added. Otherwise, print a hint: Enter 'exit' to exit the program.
1. The program should read user credentials from the console and check whether they match the established patterns. If the credentials match all patterns, print The student has been added. Otherwise, it should print which part of the credentials is not acceptable: Incorrect first name, Incorrect last name and Incorrect email.
1. If the input cannot be interpreted as valid credentials, the program should print Incorrect credentials.

Unit tests should be used to be sure that all the format requirements have been implemented. 
