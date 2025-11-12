/**
 * The PolicyHolder class stores personal information 
 * for a person who owns an insurance policy.
 */
public class PolicyHolder
{ //open the class container

   // Fields related to the person (moved from Policy)
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
    * Constructor with all personal fields
    * @param firstName policyholder's first name
    * @param lastName policyholder's last name
    * @param age policyholder's age
    * @param smokingStatus "smoker" or "non-smoker"
    * @param heightInches height in inches
    * @param weightPounds weight in pounds
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

   // ===== Calculations =====

   /**
    * Calculates and returns the BMI.
    * @return BMI as double
    */
   public double getBMI()
   {
      if (heightInches <= 0) return 0.0;
      return (weightPounds * 703) / (heightInches * heightInches);
   }

} //close the class container
