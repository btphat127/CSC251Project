import java.util.Scanner;
public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public Policy() {
        this.policyNumber = "0000";
        this.providerName = "Unknown";
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = 30;
        this.smokingStatus = "non-smoker";
        this.height = 65;
        this.weight = 150;
    }

    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    public double calculatePolicyPrice() {
        double price = 600.0;
        if (age > 50) {
            price += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}


class PolicyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        String policyNumber = sc.nextLine();

        System.out.print("\nPlease enter the Provider Name: ");
        String providerName = sc.nextLine();

        System.out.print("\nPlease enter the Policyholder’s First Name: ");
        String firstName = sc.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("\nPlease enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = sc.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Height (in inches): ");
        double height = sc.nextDouble();

        System.out.print("\nPlease enter the Policyholder’s Weight (in pounds): ");
        double weight = sc.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

        System.out.println("\n--- Policy Details ---");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder: " + policy.getFirstName() + " " + policy.getLastName());
        System.out.println("Age: " + policy.getAge());
        System.out.println("Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Height: " + policy.getHeight() + " inches");
        System.out.println("Weight: " + policy.getWeight() + " pounds");
        System.out.printf("BMI: %.2f%n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());

        sc.close();
    }
}
