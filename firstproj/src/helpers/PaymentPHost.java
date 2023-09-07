package helpers;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class PaymentPHost {
    public void payPHost(int month, int year, Connection connection) {
        try{
            // Generate a random payment ID
            String paymentId = UUID.randomUUID().toString();

            // Prepare the SQL query
            String sql = "INSERT INTO Pay_PH (payment_id, host_id, time_stamp, Amount) " +
                    "SELECT ? as  payment_id,  ph.host_id AS host_id,  ? as time_stamp,    " +
                    "SUM((p.flat_fee + (pe.ads_count * pe.Ad_rate))) AS Amount  " +
                    "FROM     pod_host ph         JOIN has h ON ph.pod_id = h.pod_id         JOIN podcast_episode pe ON h.podEp_id = pe.podEp_id         JOIN podcast p ON ph.pod_id = p.pod_id " +
                    "WHERE EXTRACT(MONTH FROM pe.release_date) = ? AND EXTRACT(YEAR FROM pe.release_date) = ? " +
                    "GROUP BY ph.host_id";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paymentId);
            statement.setDate(2, new java.sql.Date(getFirstDayOfMonth(month, year).getTime()));
            statement.setInt(3, month);
            statement.setInt(4, year);

            // Execute the SQL query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(rowsInserted + " row(s) have been inserted into Pay_PH with payment ID " + paymentId + ".");
            } else {
                System.out.println("No rows have been inserted into Pay_PH.");
            }

            // Close the resources
            statement.close();
            //connection.close();
            System.out.println("The payment ID generated is " + paymentId);
        }catch (SQLException e) {
            System.out.println("Exception at payment to Podcast Host");
            e.printStackTrace();
        }
    }

    private static Date getFirstDayOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 2);
        return calendar.getTime();
    }
    
}
