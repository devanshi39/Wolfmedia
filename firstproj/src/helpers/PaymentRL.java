package helpers;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class PaymentRL {
    public void payRL(String songId, int month, int year, Connection connection) {
        try{
            // Generate a random payment ID
            String paymentId = UUID.randomUUID().toString();

            // Prepare the SQL query
            String sql = "INSERT INTO Pay_RL (payment_id, Rl_id, time_stamp, Amount) " +
                    "SELECT ? as payment_id, owns.RL_id as Rl_id, ? as time_stamp, " +
                    "SUM(song_play.play_count * song.royalty_rate * 0.3) as Amount " +
                    "FROM song " +
                    "INNER JOIN owns ON song.S_id = owns.S_id " +
                    "INNER JOIN song_play ON song.S_id = song_play.S_id " +
                    "WHERE song.S_id = ? AND EXTRACT(MONTH FROM song_play.month_year) = ? AND EXTRACT(YEAR FROM song_play.month_year) = ? " +
                    "GROUP BY owns.RL_id, EXTRACT(MONTH FROM song_play.month_year), EXTRACT(YEAR FROM song_play.month_year)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paymentId);
            statement.setDate(2, new java.sql.Date(getFirstDayOfMonth(month, year).getTime()));
            statement.setString(3, songId);
            statement.setInt(4, month);
            statement.setInt(5, year);

            // Execute the SQL query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(rowsInserted + " row(s) have been inserted into Pay_RL with payment ID " + paymentId + ".");
            } else {
                System.out.println("No rows have been inserted into Pay_RL.");
            }

            // Close the resources
            statement.close();
            //connection.close();
            System.out.println("The payment ID generated is " + paymentId);
        }catch (SQLException e) {
            System.out.println("Exception at payment to Artist");
            e.printStackTrace();
        }
    }

    private static Date getFirstDayOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 2);
        return calendar.getTime();
    }
    
}
