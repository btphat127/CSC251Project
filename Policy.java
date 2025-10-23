/**
 * The Policy class stores information about an insurance policy.
 * It includes policyholder data and methods to calculate BMI and price.
 */
public class Policy
{ //open the class container

   // Fields
   private int policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double heightInches;
   private double weightPounds;

   /**
    * Default constructor initializes empty or zero values.
    */
   public Policy()
   { //open default constructor
      this(0, "", "", "", 0, "non-smoker", 0.0, 0.0);
   } //close default constructor

   /**
    * Constructor that sets all field values.
    * @param policyNumber policy ID number
    * @param providerName insurance provider name
    * @param firstName policyholder first name
    * @param lastName policyholder last name
    * @param age policyholder age
    * @param smokingStatus smoker or non-smoker
    * @param heightInches height in inches
    * @param weightPounds weight in pounds
    */
   public Policy(int policyNumber, String providerName, String firstName, String lastName,
                 int age, String smokingStatus, double heightInches, double weightPounds)
   { //open constructor
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.heightInches = heightInches;
      this.weightPounds = weightPounds;
   } //close constructor

   // ===== Getters =====

   /** @return the policy number */
   public int getPolicyNumber() { return policyNumber; }

   /** @return the provider name */
   public String getProviderName() { return providerName; }

   /** @return the first name of policyholder */
   public String getFirstName() { return firstName; }

   /** @return the last name of policyholder */
   public String getLastName() { return lastName; }

   /** @return the age of policyholder */
   public int getAge() { return age; }

   /** @return the smoking status ("smoker" or "non-smoker") */
   public String getSmokingStatus() { return smokingStatus; }

   /** @return height in inches */
   public double getHeightInches() { return heightInches; }

   /** @return weight in pounds */
   public double getWeightPounds() { return weightPounds; }

   // ===== Setters =====

   /** @param policyNumber sets the policy number */
   public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

   /** @param providerName sets the provider name */
   public void setProviderName(String providerName) { this.providerName = providerName; }

   /** @param firstName sets the first name */
   public void setFirstName(String firstName) { this.firstName = firstName; }

   /** @param lastName sets the last name */
   public void setLastName(String lastName) { this.lastName = lastName; }

   /** @param age sets the policyholder age */
   public void setAge(int age) { this.age = age; }

   /** @param smokingStatus sets smoker or non-smoker */
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

   /** @param heightInches sets the height in inches */
   public void setHeightInches(double heightInches) { this.heightInches = heightInches; }

   /** @param weightPounds sets the weight in pounds */
   public void setWeightPounds(double weightPounds) { this.weightPounds = weightPounds; }

   // ===== Methods =====

   /**
    * Calculates BMI using formula: (weight * 703) / (height²)
    * @return BMI as a double
    */
   public double getBMI()
   {
      if (heightInches <= 0) return 0.0;
      return (weightPounds * 703) / (heightInches * heightInches);
   }

   /**
    * Calculates policy price based on age, smoker status, and BMI.
    * @return total policy price
    */
   public double getPrice()
   {
      double price = 600.0; // base price

      if (age > 50)
         price += 75.0;

      if (smokingStatus.equalsIgnoreCase("smoker"))
         price += 100.0;

      double bmi = getBMI();
      if (bmi > 35)
         price += (bmi - 35) * 20.0;

      return price;
   }

} //close the class container
