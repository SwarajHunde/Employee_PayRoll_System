import java.util.Scanner;

class Launch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayRollSystem payment = new PayRollSystem();
        boolean exit = false;

        FullTimeEmployee vikas = new FullTimeEmployee("Vikas", 101, 50000);
        FullTimeEmployee sneha = new FullTimeEmployee("Sneha", 102, 60000);
        PartTimeEmployee ramesh = new PartTimeEmployee("Ramesh", 103, 80, 200.00);
        PartTimeEmployee priya = new PartTimeEmployee("Priya", 104, 60, 250.00);

        payment.addEmployee(vikas);
        payment.addEmployee(sneha);
        payment.addEmployee(ramesh);
        payment.addEmployee(priya);

        System.out.println("==================================");
        System.out.println("      Welcome to PayRoll System    ");
        System.out.println("==================================");

        while (!exit) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Display All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = 0;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("⚠ Invalid input! Please enter a number between 1-4.");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n===== Employee List =====");
                    payment.displayEmployee();
                    System.out.println("=========================");
                    break;

                case 2:
                    System.out.print("\nEnter Employee Type (full/part): ");
                    String type = sc.nextLine().trim().toLowerCase();

                    if (type.equals("full")) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();
                        payment.addEmployee(new FullTimeEmployee(name, id, salary));
                        System.out.println("✅ Full-Time Employee added successfully!");
                    } else if (type.equals("part")) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Hours Worked: ");
                        int hours = sc.nextInt();
                        System.out.print("Enter Rate per Hour: ");
                        double rate = sc.nextDouble();
                        sc.nextLine();
                        payment.addEmployee(new PartTimeEmployee(name, id, hours, rate));
                        System.out.println("✅ Part-Time Employee added successfully!");
                    } else {
                        System.out.println("⚠ Invalid employee type! Use 'full' or 'part'.");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter Employee ID to remove: ");
                    if (sc.hasNextInt()) {
                        int removeId = sc.nextInt();
                        sc.nextLine();
                        payment.removeEmployee(removeId);
                    } else {
                        System.out.println("⚠ Invalid ID! Must be a number.");
                        sc.next();
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("\n👋 Thank you for using PayRoll System. Goodbye!");
                    break;

                default:
                    System.out.println("⚠ Invalid choice! Please enter 1, 2, 3, or 4.");
            }
        }

        sc.close();
    }
}
