import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class OnlineExaminationSystem {
    private static User currentUser;
    private static Timer timer;
    private static int timeRemaining = 300; // 5 minutes (in seconds)

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Examination System:");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfileAndPassword(scanner);
                    break;
                case 3:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        startExam(scanner);
                    }
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // You can replace this with actual user authentication logic
        if ("admin".equals(username) && "password".equals(password)) {
            currentUser = new User(username, password);
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please login first.");
        } else {
            System.out.println("Profile and Password update functionality.");
        }
    }

    private static void startExam(Scanner scanner) {
        System.out.println("Starting the exam...");

        // Start a timer for the exam
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Exam auto-submitted.");
                timer.cancel();
            }
        }, timeRemaining * 1000);

        // Implement MCQs and answer selection logic here
        // For simplicity, we'll simulate MCQs
        int questions = 10;
        int correctAnswers = 0;
        String answer;

        for (int i = 1; i <=1; i++) {
            System.out.println("\nQuestion " + "1" + ":Number of primitive data types in Java are?");
            System.out.print("a) 6  b) 7  c) 8  d) 9\nYour answer: ");
             answer = scanner.nextLine();

            if ("c".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "2" + ": What is the size of float and double in java?");
            System.out.print("a) 32 and 64  b) 32 and 32  c) 64 and 64  d) 66 and 32\nYour answer: ");
            answer = scanner.nextLine();

            if ("a".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "3" + ": Where does the system stores parameters and local variables whenever a method is invoked?");
            System.out.print("a) Heap  b) Stack c) Array d) tree\nYour answer: ");
             answer = scanner.nextLine();

            if ("b".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "4" + ": Which of the following is a mutable class in Java??");
            System.out.print("a) String b) Integer c) Double d) all of the above\nYour answer: ");
             answer = scanner.nextLine();

            if ("d".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "5" + ": When is the object created with new keyword??");
            System.out.print("a) run time  b) compile time  c) depends on code  d) None\nYour answer: ");
             answer = scanner.nextLine();

            if ("a".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "6" + ":In which of the following is toString() method defined?");
            System.out.print("a) java.lang.Object.  b) java.lang.String.  c) java.lang.util.  d) None\nYour answer: ");
            answer = scanner.nextLine();

            if ("a".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "7" + ":compareTo() returns");
            System.out.print("a) True  b) False  c) int value  d) None\nYour answer: ");
             answer = scanner.nextLine();

            if ("c".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "8" + ":Output of Math.floor(3.6)?");
            System.out.print("a) 3  b) 4  c) 3.0  d) 4.0\nYour answer: ");
          answer = scanner.nextLine();

            if ("c".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "9" + ":  Identify the modifier which cannot be used for constructor.");
            System.out.print("a) public   b) protected  c) static d)private \nYour answer: ");
           answer = scanner.nextLine();

            if ("d".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }
            System.out.println("\nQuestion " + "10" + ": What is Runnable?");
            System.out.print("a) Abstarct Class  b) Interface  c) class d) method\nYour answer: ");
         answer = scanner.nextLine();

            if ("b".equalsIgnoreCase(answer)) {
                correctAnswers++;
            }

        }

        System.out.println("\nExam completed.");
        System.out.println("Correct answers: " + correctAnswers + " out of " + questions);

        // End the exam session
        closeSession();
    }

    private static void closeSession() {
        if (timer != null) {
            timer.cancel();
        }
        currentUser = null;
        System.out.println("\nSession closed.");
    }

    private static void logout() {
        closeSession();
        System.out.println("Logout successful.");
    }
}