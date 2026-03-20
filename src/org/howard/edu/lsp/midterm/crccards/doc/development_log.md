# Development Log

Resource Used: ChatGPT
Transcript: 

Me: I need a break down of each step I should take for question 1 in the document attached

Chat: Absolutely. Here is the exact step by step breakdown for Question 1 only from your midterm. The goal is to help you move in order and not miss any points. This question asks you to implement the CRC cards for a Task Management System, use the required package, include Javadocs, and add two markdown documentation files.
Question 1 goal
You need to create:
Task.java
TaskManager.java
development_log.md
crccards.md
All Java files go in:
org.howard.edu.lsp.midterm.crccards
All markdown files go in:
org.howard.edu.lsp.midterm.crccards.doc
Step 1: Create the main Java package
In Eclipse:
Right click src
Click New
Click Package
Type exactly:
org.howard.edu.lsp.midterm.crccards
Click Finish
This is required because the exam says every Java class must use that exact package.
Step 2: Create Task.java
In Eclipse:
Right click the package org.howard.edu.lsp.midterm.crccards
Click New
Click Class
Class name: Task
Leave the checkboxes unchecked
Click Finish
Step 3: Code Task.java
This class stores task information and updates task status, exactly as described in the CRC card.
What it must contain:
Fields
taskId
description
status
Constructor
public Task(String taskId, String description)
Rule
Default status must be "OPEN".
Required methods
getTaskId()
getDescription()
getStatus()
setStatus(String status)
toString()
Important rules
Valid statuses are only:
OPEN
IN_PROGRESS
COMPLETE
If setStatus() gets anything else, status becomes:
UNKNOWN
Exact toString() format
It must output like:
T1 Write report [OPEN]
What to do in this step
Write the full class with:
private fields
constructor
getters
setStatus
toString
Javadocs on the class and all public methods
Step 4: Create TaskManager.java
In Eclipse:
Right click the package org.howard.edu.lsp.midterm.crccards
Click New
Click Class
Class name: TaskManager
Leave checkboxes unchecked
Click Finish
Step 5: Choose the internal data structure for TaskManager
The exam says you must choose an appropriate Java data structure to:
store tasks
find by task ID
prevent duplicates
get tasks by status
Best choice:
Map<String, Task>
Why this is a strong choice:
key = task ID
fast lookup
easy duplicate checking
still lets you loop through values to filter by status
So inside TaskManager, create a private field like:
private Map<String, Task> tasks;
Then initialize it in a constructor.
Step 6: Code TaskManager.java
This class collaborates with Task and manages a collection of Task objects.
Required methods
public void addTask(Task task)
public Task findTask(String taskId)
public List<Task> getTasksByStatus(String status)
Rules to implement
addTask(Task task)
Add the task to your collection
If the ID already exists, throw:
IllegalArgumentException
This is required.
findTask(String taskId)
Return the matching task if found
Return null if not found
getTasksByStatus(String status)
Return a List<Task>
Include every task whose status exactly matches the given value
Status comparison is case-sensitive because the exam says status values are case-sensitive
What to do in this step
Write the full class with:
private internal data structure
constructor
three required methods
Javadocs for class and all public methods
Step 7: Make sure your code works with the provided Driver
The exam gives a Driver class and says do not modify it. Your code must work with it exactly as written.
So after writing Task and TaskManager:
Create the provided Driver.java in the same package if it is not already there
Paste it exactly as given in the exam
Run Driver
You should get the expected output shown in the exam:
open tasks print correctly
duplicate task ID is detected
invalid status becomes UNKNOWN
findTask("T2") works
missing task returns null and prints “Task not found.”
Step 8: Add Javadocs everywhere
Question 1 requires:
all classes must include Javadocs
all public methods must include Javadocs
each class should include a brief description and author name
each public method should include description, @param where needed, and @return where needed
What to do in this step
Go back through:
Task.java
TaskManager.java
And make sure:
class comment is at the top
every public method has a proper Javadoc block
Step 9: Create the documentation package
Now make the doc package for the markdown files.
In Eclipse:
Right click src
Click New
Click Package
Type exactly:
org.howard.edu.lsp.midterm.crccards.doc
Click Finish
This is required by the exam.
Step 10: Create development_log.md
In Eclipse:
Right click org.howard.edu.lsp.midterm.crccards.doc
Click New
Click File
File name:
development_log.md
Click Finish
The exam says this file must document any external resources you used. If you used AI, it says you must include the complete conversation transcript, not a summary.
What to put in it
Since you are using ChatGPT, include:
that you used ChatGPT
the complete prompts and responses used for Question 1
If you had used no outside help, you would write exactly:
No external assistance was used.
But that would not apply here.
Step 11: Create crccards.md
In Eclipse:
Right click org.howard.edu.lsp.midterm.crccards.doc
Click New
Click File
File name:
crccards.md
Click Finish
This file needs a short explanation, in 2 to 3 sentences, answering:
Why does TaskManager collaborate with Task, but Task does not collaborate with TaskManager?
What to cover
Your explanation should say something like:
TaskManager needs Task because its responsibilities are to store, add, find, and filter task objects
Task only stores and updates its own information, so it does not need to know about TaskManager
Write it in your own words.
Step 12: Test everything before pushing
Before you submit, verify all of these:
Java structure
Task.java is in org.howard.edu.lsp.midterm.crccards
TaskManager.java is in org.howard.edu.lsp.midterm.crccards
Driver.java is in org.howard.edu.lsp.midterm.crccards
Doc structure
development_log.md is in org.howard.edu.lsp.midterm.crccards.doc
crccards.md is in org.howard.edu.lsp.midterm.crccards.doc
Behavior
default status is OPEN
invalid status becomes UNKNOWN
duplicate ID throws IllegalArgumentException
findTask returns null when not found
getTasksByStatus returns a List<Task>
Style
class Javadocs included
public method Javadocs included
Step 13: Push to GitHub early and often
The exam specifically says to push your work to GitHub multiple times during the exam and that only code in the repo at the end will be graded.
So do this:
Save all files
Push after Task.java
Push after TaskManager.java
Push after the markdown files
Push again after final testing
Best order to complete Question 1
This is the order I recommend:
Create package
Create Task.java
Fully code Task.java
Create TaskManager.java
Fully code TaskManager.java
Add or run the provided Driver.java
Fix any errors until output matches
Add Javadocs
Create doc package
Create development_log.md
Create crccards.md
Push to GitHub

Me: When I run, i am getting T3 Submit homework [OPEN] first and then T1 Write report [OPEN]

Chat: If the order of open tasks comes out reversed, that can happen with HashMap. To make the output stable and match the sample exactly, use LinkedHashMap instead of HashMap.
So if needed, change this line in TaskManager.java:
import java.util.HashMap;
to:
import java.util.LinkedHashMap;
and change:
tasks = new HashMap<>();
to:
tasks = new LinkedHashMap<>();
