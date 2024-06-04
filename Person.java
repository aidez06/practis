import java.util.Comparator;

public class Person {
    private String lname;
    private String fname;
    private int age;
    private double weight;
    private double height;
    private String personType;


    public Person(String lname, String fname, int age, double weight, double height, String personType) {
        this.lname = lname;
        this.fname = fname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.personType = personType;
    }

    // Implementation of Getters and Setters 
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    /**
     * Calculates the (BMI) of the person.
     * 
     * @return BMI value of the person.
     */
    public double getBMI() {
        return getWeight() / Math.pow(getHeight(), 2);
    }


    /**
     * Retrieve the full name of the person
     * 
     * @return The full name of the person
     */
    public String getFullName(){
        return getFname() + " " + getLname();
    }


    /**
     * Returns a string representation of the Person object
     * 
     * @return String containing full name, person type, age, and BMI
     */
    public String toString(){
        return getFullName() + " is a " + getPersonType() + " age of " + getAge() + " with a BMI of " + getBMI();
    }


    // Comparators

     /**
     * Comparator for Person objects based on BMI
     */
    public class BMIComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            double bmi1 = o1.getBMI();
            double bmi2 = o2.getBMI();

            return Double.compare(bmi1, bmi2);
        }
    }

    
    /**
     * Comparator for Person objects based on person type
     */
    public class PersonTypeComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getPersonType().compareTo(o2.getPersonType());
        }
    }


    /**
     * Comparator for Person objects based on age
     */
    public class AgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }


    /**
     * Comparator for Person objects based on full name.
     */
    public class FullNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }

    
    /**
     * Comparator to compare Person objects based on last name.
     */
    public class LastNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getLname().compareTo(o2.getLname());
        }
    }
}