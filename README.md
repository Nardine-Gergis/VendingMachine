# VendingMachine
create a program that simulates a vending machine

# Features

- The program should display all of the items and their respective prices when the program starts, along with an option to exit the program.
- The user must put in some amount of money before an item can be selected.
Only one item can be vended at a time.
- If the user selects an item that costs more than the amount the user put into the vending machine, the program should display a message indicating insufficient funds and then redisplay the amount the user had put into the machine.
- If the user selects an item that costs equal to or less than the amount of money that the user put in the vending machine, the program should display the change returned to the user. Change must be displayed as the number of quarters, dimes, nickels, and pennies returned to the user.
- Vending machine items must be stored in a file. Inventory for the vending machine must be read from this file when the program starts and must be written out to this file just before the program exits. The program must track the following properties for each item:
   - Item name
   - Item cost
   - Number of items in inventory
- When an item is vended, the program must update the inventory level appropriately. If the machine runs out of an item, it should no longer be available as an option to the user. However, the items that have an inventory level of zero must still be read from and written to the inventory file and stored in memory.

# Guidelines

You should take considerable time to design this application before you even think about writing code. Follow the Service Layer and DAO interface design approaches shown in the write-ups and videos.
Discuss your design with your mentor and get basic approval before you begin coding.

- This application must follow the MVC pattern used for all previous labs (App class, Controller, View, Service Layer, DAO) – this includes the use of constructor based dependency injection.
- You must have a full set of unit tests for your DAO and Service Layer components.
- You must use BigDecimal for all monetary calculations where applicable.
- You must use application specific exceptions and your application must fail gracefully under all conditions (i.e. no displaying a stack trace when an exception is thrown). At a minimum you should have the following application specific exceptions thrown by your Service Layer:
   - One that is thrown when the user tries to purchase an item but doesn't deposit enough money (i.e. InsufficientFundsException)
   - One that is thrown when the user tries to purchase an item that has zero inventory (i.e. NoItemInventoryException)
- Use enums to represent the values of different coins.
- Include an Audit DAO to log events and the time they occurred.