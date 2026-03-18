package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Number: ");
            Integer roomNumber = sc.nextInt();
            System.out.print("Checkin date (dd/mm/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Checkout date (dd/mm/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.next(), fmt1);

            Reservation r = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + r);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Checkin date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Checkout date (dd/mm/yyyy): ");
            checkout = LocalDate.parse(sc.next(), fmt1);

            r.updatedDates(checkin, checkout);

            System.out.println("Reservation: " + r);
        }
        catch(DomainException e ){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error!");
        }

        sc.close();
    }

}
