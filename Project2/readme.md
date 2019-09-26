# Project 2 - Traffic Tickets
Second project of the semester. Develop a Ticket class and provide a driver to interact with the class.

# Project Outline
```
Data Element Class – Ticket 
    • Student Created
    • Include private instance variables to store information needed for a ticket. Select the correct data types for each one. Name and ticket type will be strings, the speed and speed limit will be integers, the ticket number will be of integer and that the school zone and work zone will be Boolean.
    • A constructor that takes the name, speed, speed limit, school zone and work zone. 
    • Another constructor that takes the name, speed and speed limit. The school zone and work zone will be set to false.
    • Getters and setters for the private instance variables.
    • A public method calculateFine which calculates and returns the fine (as a double) based on the table in Assignment Details.
    • A public method printNotice which returns a String with the contents of the Notice. Make sure that your fine is formatted in decimal format. Please see the Assignment Details for exact wording/format. Use your name instead of Professor Kartchner.
    • A private method generateTicketNum which randomly generates a ticket number between 100000 and 999999 inclusively.
    • A private method generateCourtDate which randomly generates a day between 1 and 31 inclusively. All court dates will take place in October 2019.
    • A private method DetermineTicketType which returns a string of either “Payable” or “Must Appear” based on the table in Assignment Details.
    • A toString method that returns a string representation of a Ticket, including the ticket number and ticket type. No specific format required.
    • The method headers must match the Javadoc provided for you for the Ticket class.(Ticket.html)

Driver Class – TicketDriver
    • Student created
    • This is the driver class for Ticket that contains a main method.
    • The driver is responsible to:
        ◦ print a header
        ◦ ask the user for information about a ticket.
        ◦ Print out the notice for that ticket using the methods from the Ticket class. 
        ◦ Allow user to add another ticket.
        ◦ When user is finished entering tickets, prints “Exiting the Ticket Manager” 
        ◦ Refer to the program sample run for more clarification.
    • Data Validation. The following data must be validated:
        ◦ Speed > 0
        ◦ Speed Limit >0 and <= 80
    • Add any necessary methods to modularize your code.
```

# Expected Output
```
Department of Motor Vehicles
Automated Traffic Enforcement


Dear {offender_name},

Please pay the following speeding fine of ${ticket_amount} to the DMV within 10 days of 
receiving this notice to avoid a driver’s license suspension. You are being fined 
for going {speed} MPH in a {limit} MPH school zone.

Ticket Type: {ticket_type}
Ticket Number: {ticket_number}

Returned checks are subject to a returned check fee of $35.00.

Sincerely,
{student_name}
```
