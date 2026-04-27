import java.time.LocalTime;
import java.util.ArrayList;

public class BillingSystem {

    // ── Generate bill for one patient ────────────────────
    public void generateBill(Patient patient) {

        // base consultation fee
        double totalFee = HospitalData.CONSULTATION_FEE;

        // add emergency surcharge if applicable
        double surcharge = 0.0;
        if (patient.getPriority() == PriorityLevel.EMERGENCY) {
            surcharge = HospitalData.EMERGENCY_SURCHARGE;
            totalFee += surcharge;
        }

        // calculate GST (18%)
        double gst     = totalFee * 0.18;
        double grandTotal = totalFee + gst;

        // print invoice
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       " + HospitalData.HOSPITAL_NAME + "        ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  PATIENT INVOICE                         ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Token No     : %-25d ║%n", patient.getPatientId());
        System.out.printf ("║  Patient Name : %-25s ║%n", patient.getName());
        System.out.printf ("║  Age / Gender : %-2d / %-20s ║%n", patient.getAge(), patient.getGender());
        System.out.printf ("║  Problem      : %-25s ║%n", patient.getProblem());
        System.out.printf ("║  Priority     : %-25s ║%n", patient.getPriority());
        System.out.printf ("║  Doctor       : %-25s ║%n", patient.getAssignedDoctor());
        System.out.printf ("║  Visit Time   : %-25s ║%n", patient.getRegistrationTime());
        System.out.printf ("║  Bill Time    : %-25s ║%n", LocalTime.now());
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Consultation Fee  : Rs. %-16.2f ║%n", HospitalData.CONSULTATION_FEE);

        if (surcharge > 0) {
        System.out.printf ("║  Emergency Surcharge: Rs. %-15.2f ║%n", surcharge);
        }

        System.out.printf ("║  GST (18%%)         : Rs. %-16.2f ║%n", gst);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  TOTAL AMOUNT      : Rs. %-16.2f ║%n", grandTotal);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  Thank you for visiting MediCare!        ║");
        System.out.println("║  Get well soon! 💊                       ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();
    }

    // ── Generate bills for ALL discharged patients ───────
    public void generateAllBills(ArrayList<Patient> dischargedPatients) {
        if (dischargedPatients.isEmpty()) {
            System.out.println("\n📭 No discharged patients to bill yet.\n");
            return;
        }

        System.out.println("\n📋 Generating bills for all discharged patients...");
        for (Patient p : dischargedPatients) {
            generateBill(p);
        }
    }

    // ── Daily revenue summary ─────────────────────────────
    public void showRevenueSummary(ArrayList<Patient> dischargedPatients) {
        if (dischargedPatients.isEmpty()) {
            System.out.println("\n📭 No data available for summary.\n");
            return;
        }

        int totalPatients   = dischargedPatients.size();
        int emergencyCount  = 0;
        int normalCount     = 0;
        double totalRevenue = 0.0;

        for (Patient p : dischargedPatients) {
            double fee = HospitalData.CONSULTATION_FEE;
            if (p.getPriority() == PriorityLevel.EMERGENCY) {
                fee += HospitalData.EMERGENCY_SURCHARGE;
                emergencyCount++;
            } else {
                normalCount++;
            }
            double gst = fee * 0.18;
            totalRevenue += fee + gst;
        }

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║         DAILY REVENUE SUMMARY            ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Total Patients    : %-20d ║%n", totalPatients);
        System.out.printf ("║  Emergency Cases   : %-20d ║%n", emergencyCount);
        System.out.printf ("║  Normal Cases      : %-20d ║%n", normalCount);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Total Revenue     : Rs. %-16.2f ║%n", totalRevenue);
        System.out.println("╚══════════════════════════════════════════╝\n");
    }
}