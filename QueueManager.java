import java.util.ArrayList;
import java.util.PriorityQueue;

public class QueueManager {

    // ── Fields ──────────────────────────────────────────
    private PriorityQueue<Patient> waitingQueue;
    private ArrayList<Patient> dischargedPatients;

    // ── Constructor ──────────────────────────────────────
    public QueueManager() {
        waitingQueue       = new PriorityQueue<>();  // uses compareTo() from Patient.java
        dischargedPatients = new ArrayList<>();
    }

    // ── 1. Register a new patient ────────────────────────
    public void registerPatient(Patient patient) {
        // Duplicate check — same name + same problem = possible duplicate
        for (Patient p : waitingQueue) {
            if (p.getName().equalsIgnoreCase(patient.getName())
                    && p.getProblem().equalsIgnoreCase(patient.getProblem())) {
                System.out.println("\n⚠️  WARNING: Patient '"
                    + patient.getName() + "' with same problem is already in queue!");
                System.out.println("   Possible duplicate registration. Please verify.\n");
                return;
            }
        }

        waitingQueue.add(patient);
        System.out.println("\n✅ Patient registered successfully!");
        System.out.println("   Token No : " + patient.getPatientId());
        System.out.println("   Priority  : " + patient.getPriority());
        System.out.println("   Position  : " + waitingQueue.size() + " in queue\n");
    }

    // ── 2. Call next patient (highest priority first) ────
    public Patient callNextPatient() {
        if (waitingQueue.isEmpty()) {
            System.out.println("\n📭 No patients in queue right now.\n");
            return null;
        }

        // find an available doctor
        Doctor availableDoctor = HospitalData.getAvailableDoctor();
        if (availableDoctor == null) {
            System.out.println("\n⏳ All doctors are currently busy. Please wait.\n");
            return null;
        }

        // serve the highest priority patient
        Patient next = waitingQueue.poll();         // removes & returns top of queue
        next.setAssignedDoctor(availableDoctor.getName());

        // mark doctor as busy
        availableDoctor.setAvailable(false);
        availableDoctor.incrementPatientsHandled();

        System.out.println("\n🔔 Calling next patient...");
        next.displayInfo();

        // after consultation, mark doctor available again
        availableDoctor.setAvailable(true);

        // move to discharged list
        dischargedPatients.add(next);

        return next;
    }

    // ── 3. View current waiting queue ───────────────────
    public void viewQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("\n📭 Queue is empty. No patients waiting.\n");
            return;
        }

        System.out.println("\n========== WAITING QUEUE ==========");
        System.out.println("  Total Patients Waiting: " + waitingQueue.size());
        System.out.println("-----------------------------------");

        // copy queue to list so we can display without removing
        ArrayList<Patient> temp = new ArrayList<>(waitingQueue);
        temp.sort(null);    // sort by priority for display

        int position = 1;
        for (Patient p : temp) {
            System.out.println("  [" + position++ + "] "
                + p.getName()
                + " | " + p.getPriority()
                + " | Token: " + p.getPatientId()
                + " | Problem: " + p.getProblem());
        }
        System.out.println("===================================\n");
    }

    // ── 4. View discharged patients ──────────────────────
    public void viewDischargedPatients() {
        if (dischargedPatients.isEmpty()) {
            System.out.println("\n📭 No discharged patients yet.\n");
            return;
        }

        System.out.println("\n========== DISCHARGED PATIENTS ==========");
        for (Patient p : dischargedPatients) {
            System.out.println("  Token: " + p.getPatientId()
                + " | " + p.getName()
                + " | Doctor: " + p.getAssignedDoctor()
                + " | Time: " + p.getRegistrationTime());
        }
        System.out.println("=========================================\n");
    }

    // ── 5. Getters for BillingSystem ─────────────────────
    public ArrayList<Patient> getDischargedPatients() {
        return dischargedPatients;
    }

    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }
}