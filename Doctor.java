public class Doctor {

    // ── Fields ──────────────────────────────────────────
    private int doctorId;
    private String name;
    private String specialization;
    private boolean isAvailable;
    private int patientsHandled;

    // ── Constructor ──────────────────────────────────────
    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId        = doctorId;
        this.name            = name;
        this.specialization  = specialization;
        this.isAvailable     = true;    // doctor is free when system starts
        this.patientsHandled = 0;       // no patients handled yet
    }

    // ── Getters ──────────────────────────────────────────
    public int getDoctorId()           { return doctorId; }
    public String getName()            { return name; }
    public String getSpecialization()  { return specialization; }
    public boolean isAvailable()       { return isAvailable; }
    public int getPatientsHandled()    { return patientsHandled; }

    // ── Setters ──────────────────────────────────────────
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // called every time doctor finishes with a patient
    public void incrementPatientsHandled() {
        this.patientsHandled++;
    }

    // ── Display ──────────────────────────────────────────
    public void displayInfo() {
        System.out.println("  Dr. " + name
            + " | " + specialization
            + " | Available: " + (isAvailable ? "Yes" : "No")
            + " | Patients Handled: " + patientsHandled);
    }
}
