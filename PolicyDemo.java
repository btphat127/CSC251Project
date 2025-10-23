import java.util.*; 
import java.io.*;

public class PolicyDemo
{ //open the class container

   public static void main(String[] args)
   { //open the main method

      /* We use try and catch to handle file errors gracefully 
         instead of letting the program crash. */
      try 
      {
         // Create a File object for the policy information file
         File file = new File("PolicyInformation.txt");

         // Create a Scanner to read data from the file
         Scanner inputFile = new Scanner(file);

         // Declare variables
         int policyNumber, age;
         String providerName, firstName, lastName, smokingStatus;
         double height, weight;

         // Create an ArrayList to store Policy objects
         ArrayList<Policy> policies = new ArrayList<>();

         // Read data from the file (8 lines per policy)
         while (inputFile.hasNext())
         {
            policyNumber = Integer.parseInt(inputFile.nextLine().trim());
            providerName = inputFile.nextLine().trim();
            firstName = inputFile.nextLine().trim();
            lastName = inputFile.nextLine().trim();
            age = Integer.parseInt(inputFile.nextLine().trim());
            smokingStatus = inputFile.nextLine().trim();
            height = Double.parseDouble(inputFile.nextLine().trim());
            weight = Double.parseDouble(inputFile.nextLine().trim());

            // Create a Policy object and add it to the list
            Policy p = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
            policies.add(p);

            // Skip the blank line between policies
            if (inputFile.hasNextLine()) 
               inputFile.nextLine();
         }

         // Close the file
         inputFile.close();

         // Counters for smoker and non-smoker
         int smokerCount = 0, nonSmokerCount = 0;

         // Display all policy information
         for (Policy p : policies)
         {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println();
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println();
            System.out.println("Policyholder's First Name: " + p.getFirstName());
            System.out.println();
            System.out.println("Policyholder's Last Name: " + p.getLastName());
            System.out.println();
            System.out.println("Policyholder's Age: " + p.getAge());
            System.out.println();
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println();
            System.out.printf("Policyholder's Height: %.1f inches%n%n", p.getHeightInches());
            System.out.printf("Policyholder's Weight: %.1f pounds%n%n", p.getWeightPounds());
            System.out.printf("Policyholder's BMI: %.2f%n%n", p.getBMI());
            System.out.printf("Policy Price: $%.2f%n%n", p.getPrice());
            System.out.println();

            // Count smoking status
            if (p.getSmokingStatus().equalsIgnoreCase("smoker"))
               smokerCount++;
            else
               nonSmokerCount++;
         }

         // Display the totals
         System.out.println("The number of policies with a smoker is: " + smokerCount);
         System.out.println();
         System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
      }
      catch (IOException e)
      {
         System.out.println("Error reading file: " + e.getMessage());
      }
   } //close the main method
} //close the class container
