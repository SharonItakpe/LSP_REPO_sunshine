# AI Prompts and Excerpts for Assignment 3

## Prompt 1
How can I redesign my Java ETL pipeline into an object oriented design with multiple classes while keeping behavior identical?

## Excerpt of AI response
Suggested splitting into Product model, parser, transformer steps, and a runner to orchestrate extract transform load.

## What I used
I created a Product class to encapsulate row data, a CsvProductParser for skipping rules, and a Transformer interface with multiple transformer classes applied in order.

## Prompt 2
How can I demonstrate inheritance and polymorphism in an OO redesign of an ETL pipeline?

## Excerpt of AI response
Use an interface or abstract class for transformation steps and implement multiple concrete transformers applied as a list.

## What I used
I used the Transformer interface and a list of Transformer implementations, which is polymorphism since the runner calls apply on each transformer without knowing the specific class.