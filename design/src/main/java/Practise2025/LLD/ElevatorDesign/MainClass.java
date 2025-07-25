package Practise2025.LLD.ElevatorDesign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Questions-
how are you going to do the prioritization?
*/


public class MainClass {
	
}

enum Direction{
	Up,
	Down,
	Stop
}


/*
Elevator class to manage elevator and it's related parameters
*/
class Elevator{
	int elevatorNumber;
	int maxCapacity;
	Direction direction;
	int currFloor;
	int currCapacity;

	public Elevator(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getCurrFloor() {
		return currFloor;
	}
	public void setCurrFloor(int currFloor) {
		this.currFloor = currFloor;
	}
	public void increaseCurrCapacity(int increaseBy) {
		this.currCapacity += increaseBy;
	}
	public int getCurrCapacity() {
		return this.currCapacity;
	}
}

interface ElevatorStrategy{
	Elevator getElevator(HashSet<Elevator> listOfElevator);
}

class SameDirectionAndNearestStrategy implements ElevatorStrategy{
	@Override
	public Elevator getElevator(HashSet<Elevator> listOfElevator) {
		
		return null;
	}
}


class ElevatorManager{
	ElevatorStrategy elevatorStrategy;
	HashSet<Elevator> elevatorSet;
	
	public ElevatorManager(ElevatorStrategy elevatorStrategy) {
		this.elevatorStrategy = elevatorStrategy;
		this.elevatorSet = new HashSet<>();
	}
	
	public void addNewElevator(Elevator elevator) {
		elevatorSet.add(elevator);
	}
	
	public void removeElevator(Elevator elevator) {
		elevatorSet.remove(elevator);
	}
}




/*
The elevator system should consist of multiple elevators serving multiple floors.
Each elevator should have a capacity limit and should not exceed it.
Users should be able to request an elevator from any floor and select a destination floor.
The elevator system should efficiently handle user requests and optimize the movement of elevators to minimize waiting time.
The system should prioritize requests based on the direction of travel and the proximity of the elevators to the requested floor.
The elevators should be able to handle multiple requests concurrently and process them in an optimal order.
The system should ensure thread safety and prevent race conditions when multiple threads interact with the elevators.

Elevator -> capacity
Multiple E -> Multiple Floors

User -> sourse Floor -> destination Floor



ElevatorMain
ElevatorStrategy es = new nES();
ElevatorManager em  = new ElevatorManager(es);
em.getElevator();

----------------------
ElevatorManager

Variables
ElevatorStrategy elvatorStrategy
List<Elevator> elevatorList

Method
ElevatorManager(ElevatorStrategy es)
synchronized getElevator(){
	elvatorStrategy.getElevator(List<Elevator> listOfElevator)
}

addNewElevator()
removeElevator()

-----------------
ElevatorStrategy (Interface)
getElevator()

nearestElevatorStrategy

sameDirElevatorStrategy

mixNearAndSameDirStrategy


-----------------
Elevator

Variables:
MaxCapacity
CurrentDirection
CurrentFloor
CurrCapacity

Methods:
getterSetter for currentFloor, MaxCapacity and CurrentDirection
increaseCurrCapacity(int increaseBy)
getCurrCapacity()
---------------


*/
