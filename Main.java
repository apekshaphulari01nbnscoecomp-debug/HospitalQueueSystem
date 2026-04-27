import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc           = new Scanner(System.in);
        QueueManager queue   = new QueueManager();
        BillingSystem billing = new BillingSystem();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   🏥 MEDICARE HOSPITAL QUEUE SYSTEM 🏥   ║");
        System.out.println("╚══════════════════════════════════════════╝");

        boolean running = true;

        while (running) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("  1. Register New Patient");
            System.out.println("  2. View Waiting Queue");
            System.out.println("  3. Call Next Patient");
            System.out.println("  4. View Doctor Dashboard");
            System.out.println("  5. Generate Bill for Last Patient");
            System.out.println("  6. View Revenue Summary");
            System.out.println("  7. Save Patient History to File");
            System.out.println("  8. View Patient History from File");
            System.out.println("  9. Clear History File");
            System.out.println("  0. Exit");
            System.out.println("================================");
            System.out.print("  Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // consume leftover newline

            switch (choice) {

                case 1:
                    // Register new patient
                    System.out.println("\n--- REGISTER PATIENT ---");
                    System.out.print("Name    : ");
                    String name = sc.nextLine();

                    System.out.print("Age     : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Gender  : ");
                    String gender = sc.nextLine();

                    System.out.print("Problem : ");
                    String problem = sc.nextLine();

                    System.out.println("Priority: 1. EMERGENCY  2. NORMAL");
                    System.out.print("Choice  : ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    PriorityLevel priority = (p == 1)
                        ? PriorityLevel.EMERGENCY
                        : PriorityLevel.NORMAL;

                    Patient patient = new Patient(name, gender, age, problem, priority);
                    queue.registerPatient(patient);
                    break;

                case 2:
                    // View queue
                    queue.viewQueue();
                    break;

                case 3:
                    // Call next patient
                    Patient served = queue.callNextPatient();
                    if (served != null) {
                        System.out.print("\n  Generate bill now? (y/n): ");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("y")) {
                            billing.generateBill(served);
                        }
                    }
                    break;

                case 4:
                    // Doctor dashboard
                    HospitalData.displayAllDoctors();
                    break;

                case 5:
                    // Bill all discharged patients
                    billing.generateAllBills(queue.getDischargedPatients());
                    break;

                case 6:
                    // Revenue summary
                    billing.showRevenueSummary(queue.getDischargedPatients());
                    break;

                case 7:
                    // Save to file
                    FileHandler.savePatientHistory(queue.getDischargedPatients());
                    break;

                case 8:
                    // Load from file
                    FileHandler.loadPatientHistory();
                    break;

                case 9:
                    // Clear file
                    FileHandler.clearHistory();
                    break;

                case 0:
                    // Exit
                    System.out.print("\n  Save history before exit? (y/n): ");
                    String save = sc.nextLine();
                    if (save.equalsIgnoreCase("y")) {
                        FileHandler.savePatientHistory(queue.getDischargedPatients());
                    }
                    System.out.println("\n👋 Thank you for using MediCare System. Goodbye!\n");
                    running = false;
                    break;

                default:
                    System.out.println("\n⚠️  Invalid choice. Please try again.\n");
            }
        }

        sc.close();
    }
}