package Practise2025.LLD.CarRentalSystem;

public class Main {
	
}

/*
The car rental system should allow customers to browse and reserve available cars for specific dates.
Each car should have details such as make, model, year, license plate number, and rental price per day.
Customers should be able to search for cars based on various criteria, such as car type, price range, and availability.
The system should handle reservations, including creating, modifying, and canceling reservations.
The system should keep track of the availability of cars and update their status accordingly.
The system should handle customer information, including name, contact details, and driver's license information.
The system should handle payment processing for reservations.
The system should be able to handle concurrent reservations and ensure data consistency.

Actor:
User

--------
enum CarType
------------
interface Car -> economy, sedan, premium -> use factory to select one of them
getRentalPrice()
setRentalPrice()

--------------
EconomyCar extends Car:
carType
make
model
year
license plate number
rental price per day

getterSetter for all
----------------
CarManager
Car car
HashSet<Date, UserId> bookedDated

Mathod:
CarManger(car)
checkAvailability(startDate, endDate)
bookCar(startDate, endDate)


---------

CarFactory
getCarManger(CarType carType)
CarManger carManger;




-----------
 

------------
User:
List<Car> getCars(startDate, endDate, carType)
bookCar(Car, startDate, endDate)

*/
