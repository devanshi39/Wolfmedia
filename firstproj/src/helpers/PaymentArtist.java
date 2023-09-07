package helpers;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class PaymentArtist {
    public void payArtist(String songId, int month, int year, Connection connection){
        try{
            // Prepare the SQL query
            String sql = "INSERT INTO Pay_Ar(Ar_id, Rl_id, Time_stamp, Amount) " +
            "SELECT     sungBy.Ar_id , (select Rl_id from owns where S_id = ?) as Rl_id , ? as Time_stamp, " +
            "SUM(song_play.play_count * song.royalty_rate * 0.7) / (SELECT COUNT(*) FROM sungBy WHERE sungBy.S_id = ?) AS Amount " +
            "FROM     sungBy         JOIN song ON sungBy.S_id = song.S_id         JOIN song_play ON song.S_id = song_play.S_id " +
            "WHERE         song.S_id = ? and EXTRACT(MONTH FROM song_play.month_year) = ? and EXTRACT(YEAR FROM song_play.month_year) = ? " +
            "GROUP BY     sungBy.Ar_id, month_year";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, songId);
            statement.setDate(2, new java.sql.Date(getFirstDayOfMonth(month, year).getTime()));
            statement.setString(3, songId);
            statement.setString(4, songId);
            statement.setInt(5, month);
            statement.setInt(6, year);

            // Execute the SQL query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(rowsInserted + " row(s) have been inserted into Pay_Ar.");
            } else {
                System.out.println("No rows have been inserted into Pay_Ar.");
            }

            // Close the resources
            statement.close();
            //connection.close();
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
