# Reflection Assignment 3: OO Redesign of ETL Pipeline

## What changed from Assignment 2 to Assignment 3
In Assignment 2, I implemented the ETL logic in one main class with parsing, transformation rules, file I O, and output formatting combined in one place. In Assignment 3, I decomposed the program into multiple classes with clearer responsibilities.

## How Assignment 3 is more object oriented
I introduced a Product class to represent a row as an object with fields and methods for rounding and formatting. I separated parsing logic into CsvProductParser and orchestration logic into ETLRunner. Each transformation rule is implemented as its own Transformer class.

## OO ideas used
Object and Class
Product objects represent individual rows and classes represent distinct responsibilities.

Encapsulation
Product fields are private and modified through methods, so logic like rounding and formatting is kept inside the Product class.

Inheritance and Polymorphism
I used the Transformer interface and multiple classes that implement it. ETLRunner stores transformers in a list and calls apply on each one, which is polymorphism.

## How I tested Assignment 3 matches Assignment 2
I tested three cases.
1 Robust sample input to verify correct skipping and exact expected transformed output.
2 Empty input file with header only to ensure output file is created with header only.
3 Missing input file to ensure the program prints a clear error message and exits cleanly without a stack trace.

I compared the transformed_products.csv output from Assignment 3 with the expected output and confirmed they match exactly.