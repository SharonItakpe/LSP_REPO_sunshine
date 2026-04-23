# Question 5

Heuristic 1:
Name:
A class should capture only one key abstraction

Explanation:
This improves readability and maintainability by ensuring that each class has a clear and focused purpose. When a class only represents one concept, it is easier to understand and modify without affecting unrelated functionality. In lecture, this was explained by comparing well-designed classes with "God classes" that try to do too much and become difficult to manage.

Heuristic 2:
Name:
All data should be hidden within its class

Explanation:
This improves maintainability by enforcing encapsulation. By keeping variables private and controlling access through methods, the internal state of the class is protected from unintended changes. In lecture, this was discussed as a way to prevent errors and make it safer to modify code without breaking other parts of the program.

Heuristic 3:
Name:
Minimize coupling between classes

Explanation:
This improves readability and flexibility by reducing dependencies between classes. When classes are loosely coupled, changes in one class do not heavily impact others. In lecture, this was illustrated by showing how tightly coupled systems are harder to extend, while loosely coupled systems are easier to maintain and scale.