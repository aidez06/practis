import java.util.ArrayList;
import java.util.Comparator;

public class Vehicle {
    private String name;
    private String plateNum;
    private int maxPassengers;
    private ArrayList<Person> passengers;
    private int numPassengers;
    
    public Vehicle(String name, String plateNum, int maxPassengers, int numPassengers, ArrayList<Person> passengers) {
        this.name = name;
        this.plateNum = plateNum;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.passengers = passengers;
    }

    // Getters and Setters for all Attributes
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNum() {
        return this.plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public int getMaxPassengers() {
        return this.maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getNumPassengers() {
        return this.numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public ArrayList<Person> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(ArrayList<Person> passengers) {
        this.passengers = passengers;
    }

     /**
     * Increases the recent number of passengers by 1 
     */
    public void increasePassengers() {
        this.numPassengers++;
    }

    /**
     * Decreases the recent number of passengers by 1
     */
    public void decreasePassengers() {
        this.numPassengers--;
    }

    /**
     * Adds new passenger to the list of passengers in the vehicle and increments the passenger count.
     * 
     * @param p The person added as a passenger
     */
    public void addNewPassenger(Person p) {
        this.passengers.add(p);
        this.increasePassengers();
    }

    /**
     * Checks if a given person exists in the list of passengers
     * 
     * @param p The person to check if it is in the list of passengers
     * @return if the person exists as a passenger so it return true, otherwise false.
     */
    public boolean passengerExists(Person p) {
        boolean result = false;
        for (Person passenger : passengers) {
            if (passenger.getFullName() == p.getFullName()) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * Sorts the list of passengers using the provided comparator
     * 
     * @param comparator The comparator to be used to sort the passenger
     */
    public void sortPassengers(Comparator<Person> comparator) {
        passengers.sort(comparator);
    }

    /**
     * Swaps the positions of passengers at the specified index in the list of passengers
     * 
     * @param index1 The first passenger
     * @param index2 The second passenger
     */
    public void swapPassengers(int index1, int index2) {
        if (index1 >= 0 && index1 < passengers.size() && index2 >= 0 && index2 < passengers.size()) {
            Person temp = passengers.get(index1);
            passengers.set(index1, passengers.get(index2));
            passengers.set(index2, temp);
        } else {
            System.out.println("Invalid index");
        }
    }

    /**
     * Returns a string representation of the Vehicle object
     * 
     * @return String representation containing vehicle information and passenger details
     */
    @Override
    public String toString() {
        String sb = "Vehicle Info: \n" + "Vehicle: " + this.name + "\n" + "Plate Number: " + this.plateNum + "\n"
            + "Max Passengers: " + this.maxPassengers + "\n" + "Number of Passengers: " + this.numPassengers + "\n" + "Passengers:\n";
        
        for (Person person : passengers) {
            sb += person.toString() + "\n";
        }
        
        return sb;
    }
}