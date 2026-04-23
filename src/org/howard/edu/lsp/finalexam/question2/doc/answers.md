# Question 2 Answers

## Template Method Design Explanation

The Template Method pattern is implemented in the abstract class `Report`, where the method `generateReport()` defines the fixed workflow: `loadData() → formatHeader() → formatBody() → formatFooter()`. This makes sure that all reports follow the same structure.

The methods `loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()` are declared as abstract which then allow the subclasses to provide their own specific implementations. Using these methods enables variation in behavior while maintaining a consistent overall process.

Polymorphism is demonstrated in the `Driver` class by using a `List<Report>`, where different report types are stored and processed using the same `generateReport()` method.