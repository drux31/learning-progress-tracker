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

#### Stage 3 - Detailed record
In this stage, we will add users to the data store and update their records as the new learning data becomes available.

The objectives are the followings:

1. Check if the provided email has been already used when adding information about students. If so, respond with the following message: This email is already taken.
1. Recognize the new list command to print the Students: a header followed by the student IDs. The students must be listed in the order they were added. Remember, each ID must be unique. If there are no students to list, print No students found.
1. Recognize the new add points and print the following message in response: Enter an id and points or 'back' to return. After that, the program must read learning progress data in the following format: studentId number number number number. The numbers correspond to the courses (Java, DSA, Databases, Spring). Number is a non-negative integer number. If there is no student with the specified ID, the program should print No student is found for id=%s. where %s is the invalid ID. Also, if any of the numbers are missing, or there is an extra number or any of the numbers do not meet the requirements mentioned above, the program should print Incorrect points format. If the learning progress data is entered in the correct format, and the specified user exists, the program should update the student's record and print Points updated. Once back is entered, the program must stop reading learning progress data.
1. Recognize the find command and print the following message: Enter an id or 'back' to return. After that, if an ID is entered, the program should either print details of the student with the specified ID in this format: id points: Java=%d; DSA=%d; Databases=%d; Spring=%dwhere %d is the respective number of points earned by the student. If the ID cannot be found, print the error message: No student is found for id=%s. where %s is the invalid ID.

#### Stage 4 - Retrieving statistics
For this stage, we need to add new features to our program: it must provide the statistics about each course and track the performance of each student in each course.

The following must be calculated:

    * Find out which courses are the most and least popular ones. The most popular has the biggest number of enrolled students;
    * Find out which course has the highest and lowest student activity. Higher student activity means a bigger number of completed tasks;
    * Establish the easiest and hardest course. The easiest course has the highest average grade per assignment;
    * Establish top learners for each course.

The objectives of the stage are:

1. Add a new command to your program's toolkit: statistics. If users enter this command, your program should output the header: Type the name of a course to see details or 'back' to quit and six lines with the following information: Most popular, Least popular, Highest activity, Lowest activity, Easiest course, Hardest course with the names of the corresponding courses. After that, if users enter a course name, the program should display the details of this course, but if users enter a name that doesn't correspond to any of the courses, the program should print Unknown course. When the back command is entered, the program goes back to other available commands.
1. When users enter the statistics command, your program must display the details about any course. When users type in the name of a course, the program should display the name of the course in the first line, then the column headers, and a list of student IDs, their total points in the respective course, and the percent of completion (one decimal place precision). If a course has no students, output only the name of the course and the column headers.
1.   Course details are available only after users enter statistics, they should not be available with the back. If users type in any course name before entering the statistics command, the program must respond with the Unknown command! message.
1. Sort student lists by the total number of points in descending order and then by the ID in ascending order.

