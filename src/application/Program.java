package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Number: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("Checkin date (dd/mm/yyyy): ");
        LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
        System.out.print("Checkout date (dd/mm/yyyy): ");
        LocalDate checkout = LocalDate.parse(sc.next(), fmt1);
        if (!checkin.isAfter(checkout)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation r = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + r);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Checkin date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Checkout date (dd/mm/yyyy): ");
            checkout = LocalDate.parse(sc.next(), fmt1);

            LocalDate now = LocalDate.now();
            if (checkin.isBefore(now) || checkout.isBefore(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkout.isAfter(checkin)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else{
                r.updatedDates(checkin, checkout);
                System.out.println("Reservation: " + r);
            }
        }
        sc.close();
    }

}
