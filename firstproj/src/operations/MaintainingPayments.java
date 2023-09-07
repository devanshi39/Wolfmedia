package operations;

import helpers.*;

import java.sql.Connection;
import java.util.Scanner;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class MaintainingPayments {
    Scanner scanner = new Scanner(System.in);

    public void run(final Connection conn){

        while (true) {
            //Taking input for performing the operation
            System.out.println("Choose an operation you want to perform:");
            System.out.println("1. Make Payment to Record Label");
            System.out.println("2. Make Payment to Artist");
            System.out.println("3. Make Payment to Podcast Host");
            System.out.println("4. Receive Payment from User");
            System.out.println("9. Exit Maintaining Payments");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();
            //Navigating to the code for the operation
            switch (choice) {
                case 1:
                    makePaymentToRL(conn);
                    break;
                
                case 2:
                    makePaymentToArtist(conn);
                    break;
                
                case 3:
                    makePaymentToPodcastHost(conn);
                    break;

                case 4:
                    receivePaymentUser(conn);
                    break;

                case 9:
                    break;
                
                default:
                    System.out.println("Invalid Input, Please try again.");
            }
            if (choice == 9){
                break;
            }
        }
    }

    public void makePaymentToRL(Connection connection){
        //Taking the required input
        System.out.println("Enter the details for payment -");
        System.out.println("Enter the Song_id:");
        String song_id = scanner.next();
        System.out.println("Enter the Year:");
        int year = scanner.nextInt();
        System.out.println("Enter the Month:");
        int month = scanner.nextInt();
        
        //Performing the operation
        PaymentRL paymentRL = new PaymentRL();
        paymentRL.payRL(song_id, month, year, connection);
    }

    public void makePaymentToArtist(Connection connection){
        //Taking the required input
        System.out.println("Enter the details for payment -");
        System.out.println("Enter the Song_id:");
        String song_id = scanner.next();
        System.out.println("Enter the Year:");
        int year = scanner.nextInt();
        System.out.println("Enter the Month:");
        int month = scanner.nextInt();

        //Performing the operation
        PaymentArtist paymentArtist = new PaymentArtist();
        paymentArtist.payArtist(song_id, month, year, connection);
    }

    public void makePaymentToPodcastHost(Connection connection){
        //Taking the required input
        System.out.println("Enter the details for payment -");
        System.out.println("Enter the Year:");
        int year = scanner.nextInt();
        System.out.println("Enter the Month:");
        int month = scanner.nextInt();

        //Performing the operation
        PaymentPHost paymentPHost = new PaymentPHost();
        paymentPHost.payPHost(month, year, connection);
    }

    public void receivePaymentUser(Connection connection){
        Map<String, Object> columnValues = new HashMap<>();

        //Taking the required input and assigning the values
        System.out.println("Enter the details for receiving payment -");
        System.out.println("Enter the User ID:");
        String user_id = scanner.next();
        columnValues.put("u_id", user_id);
        System.out.println("Enter the Date:");
        String date = scanner.next();
        columnValues.put("time_stamp", date);
        String paymentId = UUID.randomUUID().toString();
        columnValues.put("payment_id", paymentId);
        columnValues.put("amount", 10);

        String table_name = "Pay_User";

        //Performing the insert query
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, table_name, connection);
        System.out.println("The payment ID generated is " + paymentId);
    }
}
