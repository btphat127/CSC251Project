/**
 * The PolicyHolder class stores personal information 
 * about the person who owns an insurance policy.
 */
public class PolicyHolder
{ //open the class container

   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double heightInches;
   private double weightPounds;

   /**
    * Default constructor
    */
   public PolicyHolder()
   {
      this("", "", 0, "non-smoker", 0.0, 0.0);
   }

   /**
    * Constructor that sets all personal information
    */
   public PolicyHolder(String firstName, String lastName, int age, String smokingStatus,
                       double heightInches, double weightPounds)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.heightInches = heightInches;
      this.weightPounds = weightPounds;
   }

   // ===== Getters and Setters =====
   public String getFirstName() { return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   public String getLastName() { return lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }

   public int getAge() { return age; }
   public void setAge(int age) { this.age = age; }

   public String getSmokingStatus() { return smokingStatus; }
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

   public double getHeightInches() { return heightInches; }
   public void setHeightInches(double heightInches) { this.heightInches = heightInches; }

   public double getWeightPounds() { return weightPounds; }
   public void setWeightPounds(double weightPounds) { this.weightPounds = weightPounds; }

   /**
    * Calculates and returns BMI using the formula (weight * 703) / (height^2)
    */
   public double getBMI()
   {
      if (heightInches <= 0) return 0.0;
      return (weightPounds * 703) / (heightInches * heightInches);
   }

   /**
    * Returns a formatted string containing all PolicyHolder information.
    */
   public String toString()
   {
      return String.format(
         "Policyholder's First Name: %s%n" +
         "Policyholder's Last Name: %s%n" +
         "Policyholder's Age: %d%n" +
         "Policyholder's Smoking Status (smoker/non-smoker): %s%n" +
         "Policyholder's Height: %.1f inches%n" +
         "Policyholder's Weight: %.1f pounds%n" +
         "Policyholder's BMI: %.2f%n%n",
         firstName, lastName, age, smokingStatus, heightInches, weightPounds, getBMI());
   }

} //close the class container
