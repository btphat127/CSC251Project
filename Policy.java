/**
 * The Policy class stores information about an insurance policy 
 * and the PolicyHolder who owns the policy.
 */
public class Policy
{ //open the class container

   private int policyNumber;
   private String providerName;
   private PolicyHolder policyHolder; // Aggregation relationship

   /**
    * Default constructor
    */
   public Policy()
   {
      this(0, "", new PolicyHolder());
   }

   /**
    * Constructor that sets all fields
    */
   public Policy(int policyNumber, String providerName, PolicyHolder policyHolder)
   {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.policyHolder = policyHolder;
   }

   // ===== Getters and Setters =====
   public int getPolicyNumber() { return policyNumber; }
   public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

   public String getProviderName() { return providerName; }
   public void setProviderName(String providerName) { this.providerName = providerName; }

   public PolicyHolder getPolicyHolder() { return policyHolder; }
   public void setPolicyHolder(PolicyHolder policyHolder) { this.policyHolder = policyHolder; }

   /**
    * Calculates total policy price based on age, smoking status, and BMI.
    */
   public double getPrice()
   {
      double price = 600.0;

      if (policyHolder.getAge() > 50)
         price += 75.0;

      if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += 100.0;

      double bmi = policyHolder.getBMI();
      if (bmi > 35)
         price += (bmi - 35) * 20.0;

      return price;
   }

   /**
    * Returns a formatted string that represents full policy information.
    * Combines Policy and PolicyHolder details.
    */
   public String toString()
   {
      return String.format(
         "Policy Number: %d%n%n" +
         "Provider Name: %s%n%n" +
         "%s" +
         "Policy Price: $%.2f%n%n",
         policyNumber, providerName, policyHolder.toString(), getPrice());
   }

} //close the class container
