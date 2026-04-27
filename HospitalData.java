import java.util.ArrayList;

public class HospitalData {

    // ── Constants ────────────────────────────────────────
    public static final String HOSPITAL_NAME    = "MediCare General Hospital";
    public static final double CONSULTATION_FEE = 500.0;   // base fee in rupees
    public static final double EMERGENCY_SURCHARGE = 200.0; // extra for emergency

    // ── Doctor List ──────────────────────────────────────
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    // ── Load default doctors when system starts ──────────
    static {
        doctors.add(new Doctor(1, "Dr. Sharma",   "General Physician"));
        doctors.add(new Doctor(2, "Dr. Mehta",    "Cardiologist"));
        doctors.add(new Doctor(3, "Dr. Kulkarni", "Orthopedic"));
        doctors.add(new Doctor(4, "Dr. Verma",    "Neurologist"));
    }

    // ── Get all doctors ───────────────────────────────────
    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    // ── Find first available doctor ───────────────────────
    public static Doctor getAvailableDoctor() {
        for (Doctor d : doctors) {
            if (d.isAvailable()) {
                return d;
            }
        }
        return null;    // no doctor free right now
    }

    // ── Display all doctors ───────────────────────────────
    public static void displayAllDoctors() {
        System.out.println("\n===== DOCTOR DASHBOARD =====");
        for (Doctor d : doctors) {
            d.displayInfo();
        }
        System.out.println("============================");
    }
}