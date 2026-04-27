# 🏥 Hospital Patient Queue System

> A console-based Hospital OPD Queue Management System built with Core Java — simulating real-world patient registration, priority-based queue management, doctor assignment, billing, and patient history tracking.

---

## 📌 About The Project

This project simulates a real **Hospital Out-Patient Department (OPD)** queue system. Emergency patients are always served before normal patients using Java's **PriorityQueue** — just like a real hospital. The system handles everything from patient registration to billing and file-based history saving.

---

## ✨ Features

- 🚨 **Priority Queue** — Emergency patients served before Normal patients automatically
- 👨‍⚕️ **Doctor Assignment** — Auto-assigns available doctors to patients
- 🔔 **Duplicate Detection** — Alerts if same patient registers twice (fraud guard)
- 🧾 **Invoice Generation** — Consultation fee + Emergency surcharge + 18% GST
- 📊 **Revenue Summary** — Daily revenue breakdown by patient type
- 💾 **File-based History** — Discharged patient records saved to `.txt` file
- 🏥 **Doctor Dashboard** — View all doctors and their patient count

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java (Core) | Entire application |
| PriorityQueue | Patient priority management |
| ArrayList | Doctor and discharged patient list |
| HashMap | Doctor-patient tracking |
| File I/O | Patient history persistence |
| OOP | Patient, Doctor, BillingSystem classes |
| Enum | PriorityLevel (EMERGENCY / NORMAL) |
| Exception Handling | File errors, invalid input |

---

## 📁 Project Structure

```
HospitalQueueSystem/
│
├── PriorityLevel.java       # Enum — EMERGENCY(1), NORMAL(2)
├── Patient.java             # Patient model + Comparable for PriorityQueue
├── Doctor.java              # Doctor model with availability tracking
├── HospitalData.java        # Central data store — doctors list + fee constants
├── QueueManager.java        # Core logic — register, call next, view queue
├── BillingSystem.java       # Invoice generation + GST + revenue summary
├── FileHandler.java         # Save/load/clear patient history from file
└── Main.java                # Entry point — menu-driven interface
```

---

## 🚀 How To Run

### Prerequisites
- Java JDK 8 or above installed
- Any IDE (IntelliJ / Eclipse / VS Code) or terminal

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/HospitalQueueSystem.git

# 2. Navigate to project folder
cd HospitalQueueSystem

# 3. Compile all files
javac *.java

# 4. Run the program
java Main
```

---

## 🎮 How It Works

```
========== MAIN MENU ==========
  1. Register New Patient
  2. View Waiting Queue
  3. Call Next Patient
  4. View Doctor Dashboard
  5. Generate Bill for Last Patient
  6. View Revenue Summary
  7. Save Patient History to File
  8. View Patient History from File
  9. Clear History File
  0. Exit
================================
```

### Sample Flow
1. Register 3 patients — 1 EMERGENCY + 2 NORMAL
2. View Queue — EMERGENCY appears at top
3. Call Next Patient — EMERGENCY served first
4. Generate Bill — surcharge + GST calculated automatically
5. View Revenue Summary — daily totals displayed
6. Save History — written to `patient_history.txt`

---

## 🧾 Sample Invoice Output

```
╔══════════════════════════════════════════╗
║       MediCare General Hospital          ║
╠══════════════════════════════════════════╣
║  PATIENT INVOICE                         ║
╠══════════════════════════════════════════╣
║  Token No     : 1                        ║
║  Patient Name : Rahul Sharma             ║
║  Age / Gender : 35 / Male               ║
║  Problem      : Chest Pain              ║
║  Priority     : EMERGENCY               ║
║  Doctor       : Dr. Mehta               ║
╠══════════════════════════════════════════╣
║  Consultation Fee   : Rs. 500.00        ║
║  Emergency Surcharge: Rs. 200.00        ║
║  GST (18%)          : Rs. 126.00        ║
╠══════════════════════════════════════════╣
║  TOTAL AMOUNT       : Rs. 826.00        ║
╚══════════════════════════════════════════╝
```

---

## 🔑 Key Concepts Demonstrated

- **OOP** — Clean class design with encapsulation
- **PriorityQueue + Comparable** — Core DSA concept applied practically
- **Static blocks** — Pre-loading doctor data on startup
- **File I/O** — BufferedWriter/BufferedReader for persistent storage
- **Exception Handling** — Graceful error management
- **Enum** — Type-safe priority levels

---

## 🚀 Future Scope

- [ ] JDBC + MySQL — Store data in a real database
- [ ] Spring Boot — Convert to REST API
- [ ] JavaFX — Add a graphical user interface
- [ ] JWT Authentication — Doctor login system
- [ ] Appointment scheduling module

---

## 👨‍💻 Author

**Your Name**
- LinkedIn: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)
- GitHub: [github.com/yourusername](https://github.com/yourusername)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ If you found this project helpful, please give it a star!
