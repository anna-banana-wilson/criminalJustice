# Criminal Justice

Created by Anna Wilson in September 2021

This repository comes from an assignment I did in my Data Structures class. To start of, we read this article from Pro Publica:
https://www.propublica.org/article/machine-bias-risk-assessments-in-criminal-sentencing

It's about a study that uncovered how biased machine learning is when used in the criminal justice system. My assignment is recreated the same data analysis that Pro Publica did. It analyzes the results of trials, and looks at factors such as race and whether the personal reoffended after 5 years. 

My code is made to take in a large file of data with lots of information, like what the person was charged with, how "high-risk" the AI decided they were, and more. My program is designed to take only the necesary information from this large file and produce the following results:

Labelled as Low-Risk but Reoffended, White:       38.099174%
Labelled as Low-Risk but Reoffended, Black:       43.55372%
Labelled as High-Risk but Didn't Reoffend, White: 20.151134%
Labelled as High-Risk but Didn't Reoffend, Black: 70.78085%

This is an unfinished project. The numbers you see above are somewhat different from the results my professor said were correct. What I learned through this process is that data is very messy-- my theory about why my results were not quite right is that I did not account enough for the data anomalies. For example, some rows in the data file have missing collumns. For example, if the person did not reoffend, there is a blank in the column listing what the second offense was. It was trickier than expected for me to account for things like this when reading a file of text using Java. 

*Caveat:*
This was done in a Java course. If I come back to this project to fix it, I will absolutley NOT use Java again. My professor expressed as he was introducing the project that this could be done in less than an hour using R. I have yet to learn R, but this project is on my bucket list when I do. In Java, the analysis was designed using object-oriented programming. I created an object to represent a single person (a defendant in a trial) called Defendant. This project was my first ever introduction to object-oriented programming. 

*Explanation of each file:*

Main.java: Devoted to runnning the code, printing the results to the output, and storing all of the test cases I created. 

Defendant.java: Contains a class for the object Defendant that will be used to store and easily access the information for each defendant in the data.

OrganizedScores.java: For an arrayList that store the data. It organizes all of them into one big ArrayList so I can easily access them. This class also holds some useful medthods I made that can be used to populate the ArrayList and further organize the data.

*How to run:*
This project requires the 3 java files and the compas-scores.csv file to run. It simply prints the output to the console upon being run.
