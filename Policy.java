/**
 * The Policy class stores information about an insurance policy
 * and the policyholder associated with it.
 */
public class Policy
{ //open the class container

   private int policyNumber;
   private String providerName;
   private PolicyHolder policyHolder; // Composition (Aggregation)

   /**
    * Default constructor
    */
   public Policy()
   {
      this(0, "", new PolicyHolder());
   }

   /**
    * Constructor with parameters
    * @param policyNumber policy ID
    * @param providerName provider name
    * @param policyHolder PolicyHolder object
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

   // ===== Price calculation =====

   /**
    * Calculates the policy price based on holder data.
    * @return total price
    */
   public double getPrice()
   {
      double price = 600.0; // base

      if (policyHolder.getAge() > 50)
         price += 75.0;

      if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += 100.0;

      double bmi = policyHolder.getBMI();
      if (bmi > 35)
         price += (bmi - 35) * 20.0;

      return price;
   }

} //close the class container
