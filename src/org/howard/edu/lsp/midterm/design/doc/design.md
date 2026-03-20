# Improved Design Using CRC Cards

Class: Order
Responsibilities:
- store order information
- provide customer and item details
- provide order price
Collaborators:
- DiscountCalculator
- TaxCalculator

Class: DiscountCalculator
Responsibilities:
- calculate discount based on order price
- return discounted total
Collaborators:
- Order

Class: TaxCalculator
Responsibilities:
- calculate tax for an order
- return total with tax
Collaborators:
- Order

Class: ReceiptPrinter
Responsibilities:
- generate receipt output
- print order summary for the customer
Collaborators:
- Order

Class: OrderRepository
Responsibilities:
- save order information
- manage order persistence
Collaborators:
- Order

Class: EmailService
Responsibilities:
- send confirmation messages
- notify customer of completed order
Collaborators:
- Order

Class: ActivityLogger
Responsibilities:
- record order processing activity
- log processing time
Collaborators:
- Order

Class: OrderProcessor
Responsibilities:
- coordinate order processing steps
- delegate work to helper classes
Collaborators:
- Order
- DiscountCalculator
- TaxCalculator
- ReceiptPrinter
- OrderRepository
- EmailService
- ActivityLogger