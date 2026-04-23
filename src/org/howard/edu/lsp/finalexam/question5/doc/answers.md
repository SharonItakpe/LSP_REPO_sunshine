# Question 5

Heuristic 1:
Name:
H2.1: All data should be hidden within its class

Explanation:
This heuristic improves maintainability by enforcing encapsulation. By keeping data private and only accessible through methods, it prevents other classes from directly modifying internal state. In lecture, this was explained as a way to protect data and reduce the impact of changes, since other classes only depend on the public interface and not the internal implementation.

Heuristic 2:
Name:
H2.8: A class should capture one and only one key abstraction

Explanation:
This heuristic improves readability and maintainability by ensuring that each class has a single, well-defined responsibility. When a class focuses on one abstraction, it is easier to understand, test, and modify. In lecture, this was illustrated by discussing how classes that try to handle multiple responsibilities become harder to maintain and lead to poor design.

Heuristic 3:
Name:
H3.2: Do not create god classes/objects in your system

Explanation:
This heuristic improves maintainability by preventing one class from controlling too much of the system’s logic. A god class centralizes too many responsibilities, making the system harder to modify and extend. In lecture, this was explained using the example of a controller class that gathers data from other classes and makes all decisions, instead of allowing objects to manage their own behavior, which leads to poor distribution of responsibilities. 