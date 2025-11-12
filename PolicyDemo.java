import java.util.*;
import java.io.*;

public class PolicyDemo
{ //open the class container

   public static void main(String[] args)
   { //open the main method
      try
      {
         File file = new File("PolicyInformation.txt");
         Scanner inputFile = new Scanner(file);

         int policyNumber, age;
         String providerName, firstName, lastName, smokingStatus;
         double height, weight;

         ArrayList<Policy> policies = new ArrayList<>();

         // Read data for each Policy
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

            // Create PolicyHolder and associate it with a Policy
            PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);

            policies.add(policy);

            if (inputFile.hasNextLine())
               inputFile.nextLine(); // skip blank line
         }

         inputFile.close();

         int smokerCount = 0, nonSmokerCount = 0;

         // Display all policy information (implicit toString call)
         for (Policy p : policies)
         {
            System.out.println(p);  // implicitly calls p.toString()

            if (p.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker"))
               smokerCount++;
            else
               nonSmokerCount++;
         }

         System.out.println("The number of policies with a smoker is: " + smokerCount);
         System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
         System.out.println("The number of Policy objects created: " + Policy.getPolicyCount());
      }
      catch (IOException e)
      {
         System.out.println("Error reading file: " + e.getMessage());
      }
   } //close the main method
} //close the class container
