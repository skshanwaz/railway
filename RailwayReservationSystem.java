import java.util.Scanner;

public class RailwayReservationSystem {

    public static void main(String[] args) {
        int totalSeats = 72;
        int availableSeats = totalSeats;
        boolean[] seatOccupied = new boolean[totalSeats];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of members:");
        int numberOfMembers = scanner.nextInt();

        for (int i = 0; i < numberOfMembers; i++) {
            System.out.println("Enter Name:");
            String name = scanner.next();

            System.out.println("Enter Gender (m or f):");
            String gender = scanner.next();

            System.out.println("Enter Age:");
            int age = scanner.nextInt();

            if (age >= 65 && gender.equalsIgnoreCase("f")) {
                System.out.println(name + " choose the type of the seat:");
                System.out.println("1. Left seat\n2. Upper seat\n3. Middle seat\n4. Side Left\n5. Side Upper");
                System.out.println("Enter your option:");
                int seatOption = scanner.nextInt();

                int seatNumber = allocateSeat(seatOccupied, seatOption);
                if (seatNumber != -1) {
                    System.out.println("One seat is reserved for " + name + " at seat number " + seatNumber);
                    availableSeats--;
                } else {
                    System.out.println("Sorry, no available seats for " + name + ".");
                }
            } else {
                System.out.println("Reservation available only for female passengers aged 65 or above.");
            }

            System.out.println(availableSeats + " Seats left");
        }

        scanner.close();
    }

    private static int allocateSeat(boolean[] seatOccupied, int seatOption) {
        for (int i = 0; i < seatOccupied.length; i++) {
            if (!seatOccupied[i]) {
                seatOccupied[i] = true;
                return i + 1; // Seat numbers start from 1
            }
        }
        return -1; // No available seats
    }
}