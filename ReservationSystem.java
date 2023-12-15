
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add some sample user credentials and reservations
        userCredentials.put("john123", "password");
        userCredentials.put("alice456", "pass123");
        reservations.put("john123", "Reservation 1");
        reservations.put("alice456", "Reservation 2");

        System.out.println("Welcome to the Online Reservation System!");
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (isValidLogin(loginId, password)) {
            System.out.println("Login successful!");

            System.out.println("Please select an option:");
            System.out.println("1. Make a reservation");
            System.out.println("2. View reservations");
            System.out.println("3. Cancel a reservation");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    makeReservation(loginId);
                    break;
                case 2:
                    viewReservations(loginId);
                    break;
                case 3:
                    cancelReservation(loginId);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } else {
            System.out.println("Invalid login credentials!");
        }

        scanner.close();
    }

    public static boolean isValidLogin(String loginId, String password) {
        // Check if the loginId exists in the userCredentials map
        if (userCredentials.containsKey(loginId)) {
            String storedPassword = userCredentials.get(loginId);
            // Check if the entered password matches the stored password
            if (password.equals(storedPassword)) {
                return true;
            }
        }
        return false;
    }

    public static void makeReservation(String loginId) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter reservation details: ");
        String reservationDetails = scanner.nextLine();

        reservations.put(loginId, reservationDetails);
        System.out.println("Reservation made successfully!");

        scanner.close();
    }

    public static void viewReservations(String loginId) {
        if (reservations.containsKey(loginId)) {
            String reservationDetails = reservations.get(loginId);
            System.out.println("Your reservation: " + reservationDetails);
        } else {
            System.out.println("No reservations found for this user.");
        }
    }

    public static void cancelReservation(String loginId) {
        if (reservations.containsKey(loginId)) {
            reservations.remove(loginId);
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("No reservations found for this user.");
        }
    }
}

