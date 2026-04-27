import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_PATH = "patient_history.txt";

    // ── Save all discharged patients to file ─────────────
    public static void savePatientHistory(ArrayList<Patient> dischargedPatients) {
        if (dischargedPatients.isEmpty()) {
            System.out.println("\n📭 No discharged patients to save.\n");
            return;
        }

        try {
            FileWriter fw     = new FileWriter(FILE_PATH, true);  // true = append mode
            BufferedWriter bw = new BufferedWriter(fw);

            for (Patient p : dischargedPatients) {
                bw.write("------------------------------------");
                bw.newLine();
                bw.write("Token No      : " + p.getPatientId());
                bw.newLine();
                bw.write("Name          : " + p.getName());
                bw.newLine();
                bw.write("Age / Gender  : " + p.getAge() + " / " + p.getGender());
                bw.newLine();
                bw.write("Problem       : " + p.getProblem());
                bw.newLine();
                bw.write("Priority      : " + p.getPriority());
                bw.newLine();
                bw.write("Doctor        : " + p.getAssignedDoctor());
                bw.newLine();
                bw.write("Registered At : " + p.getRegistrationTime());
                bw.newLine();
                bw.write("------------------------------------");
                bw.newLine();
            }

            bw.close();
            System.out.println("\n💾 Patient history saved to '" + FILE_PATH + "' successfully!\n");

        } catch (IOException e) {
            System.out.println("\n❌ Error saving patient history: " + e.getMessage() + "\n");
        }
    }

    // ── Load and display history from file ───────────────
    public static void loadPatientHistory() {
        File file = new File(FILE_PATH);

        // check if file exists first
        if (!file.exists()) {
            System.out.println("\n📭 No patient history file found yet.\n");
            return;
        }

        try {
            FileReader fr     = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("\n========== PATIENT HISTORY ==========");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("=====================================\n");

            br.close();

        } catch (IOException e) {
            System.out.println("\n❌ Error reading patient history: " + e.getMessage() + "\n");
        }
    }

    // ── Clear history file ───────────────────────────────
    public static void clearHistory() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
            System.out.println("\n🗑️  Patient history cleared successfully!\n");
        } else {
            System.out.println("\n📭 No history file found to clear.\n");
        }
    }
}