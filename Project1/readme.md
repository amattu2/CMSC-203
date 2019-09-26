# Project 1 - Loan Calculator
First project of the semester. Design a loan calculator using standard input/output methods and basic calculations.

# Assignment Description
Develop a Loan Calculator (as a Java standalone application) to calculate and display
the monthly payment for a loan. The user will be asked to enter the loan amount, the
interest rate, and the number of payments. The formula used for such a calculation
is:<br/>  𝒑𝒂𝒚𝒎𝒆𝒏𝒕 = 𝒍𝒐𝒂𝒏𝑨𝒎𝒐𝒖𝒏𝒕 ∗ ((𝒊𝒏𝒕𝒆𝒓𝒆𝒔𝒕𝑹𝒂𝒕𝒆 / 𝟏𝟐.𝟎) / (𝟏 − (𝟏 + 𝒊𝒏𝒕𝒆𝒓𝒆𝒔𝒕𝑹𝒂𝒕𝒆/𝟏𝟐. 𝟎)^−𝒏𝒖𝒎𝒃𝒆𝒓𝑶𝒇𝑷𝒂𝒚𝒎𝒆𝒏𝒕𝒔))

Payment, loan amount, APR, 12.0, and 1.0 are real numbers; whereas N=number of
payments is an integer. If you wish to use other formulas, please feel free to use them.

Java Hints:
  System.out.print("2 to the power of 3 is: ");
  System.out.println(Math.pow(2.0, 3.0)); // Displays: 2 to the power of 3 is: 8.0

# Assignment Requirements
- Ask the user for the loan amount, interest rate and number of payments.
- Remind the user the numeric values must be greater than 0.
- Display a header for your application.
- Use the Scanner class for input, and use System.out.print or System.out.println for
output.
- Implement the formula given above
