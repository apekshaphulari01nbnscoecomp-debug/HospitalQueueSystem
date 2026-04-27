import java.time.LocalTime;

public class Patient implements Comparable<Patient> {

    // ── Fields ──────────────────────────────────────────
    private static int idCounter = 1;   // auto-increments for every new patient

    private int patientId;
    private String name;
    private String gender;
    private int age;
    private String problem;
    private PriorityLevel priority;
    private String assignedDoctor;
    private LocalTime registrationTime;

    // ── Constructor ──────────────────────────────────────
    public Patient(String name, String gender, int age, String problem, PriorityLevel priority) {
        this.patientId        = idCounter++;           // auto ID: 1, 2, 3...
        this.name             = name;
        this.gender           = gender;
        this.age              = age;
        this.problem          = problem;
        this.priority         = priority;
        this.assignedDoctor   = "Not Assigned";
        this.registrationTime = LocalTime.now();       // records exact time of registration
    }

    // ── compareTo (THIS is what PriorityQueue uses) ──────
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority.getLevel(), other.priority.getLevel());
        // EMERGENCY(1) comes before NORMAL(2)
        // Lower number = higher priority = served first
    }

    // ── Getters ──────────────────────────────────────────
    public int getPatientId()            { return patientId; }
    public String getName()              { return name; }
    public String getGender()            { return gender; }
    public int getAge()                  { return age; }
    public String getProblem()           { return problem; }
    public PriorityLevel getPriority()   { return priority; }
    public String getAssignedDoctor()    { return assignedDoctor; }
    public LocalTime getRegistrationTime() { return registrationTime; }

    // ── Setter (only doctor assignment changes after creation) ──
    public void setAssignedDoctor(String doctorName) {
        this.assignedDoctor = doctorName;
    }

    // ── Display ──────────────────────────────────────────
    public void displayInfo() {
        System.out.println("------------------------------------");
        System.out.println("  Patient ID   : " + patientId);
        System.out.println("  Name         : " + name);
        System.out.println("  Age/Gender   : " + age + " / " + gender);
        System.out.println("  Problem      : " + problem);
        System.out.println("  Priority     : " + priority);
        System.out.println("  Doctor       : " + assignedDoctor);
        System.out.println("  Registered At: " + registrationTime);
        System.out.println("------------------------------------");
    }
}