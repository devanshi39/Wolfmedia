package operations;
import helpers.*;

import java.sql.Connection;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReportsGeneration {
    Scanner scanner = new Scanner(System.in);

    public void run(final Connection conn){

        while (true) {
            //Taking input for performing the operation
            System.out.println("Choose an operation you want to perform:");
            System.out.println("1. Monthly Play Count per Song");
            System.out.println("2. Monthly Play Count per Album");
            System.out.println("3. Monthly Play Count per Artist");
            System.out.println("4. Total Payments made to Podcast host");
            System.out.println("5. Total Payments made to Artists");
            System.out.println("6. Total Payments made to Record Labels");
            System.out.println("7. Total Revenue Per Month");
            System.out.println("8. Report Songs for an Artist");
            System.out.println("9. Report Songs for an Album");
            System.out.println("10. Report Podcast Episodes for a Podcast");
            System.out.println("11. Exit Reports Generation");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //Navigating to the code for the operation
            switch (choice) {
                case 1:
                    countSong(conn);
                    break;
                
                case 2:
                    countAlbum(conn);
                    break;
                
                case 3:
                    countArtist(conn);
                    break;
                
                case 4:
                    reportHost(conn);
                    break;
                
                case 5:
                    reportArtist(conn);
                    break;
                
                case 6:
                    reportRecordLabel(conn);
                    break;

                case 7:
                    totalRevenue(conn);
                    break;
                
                case 8:
                    reportSongsArtist(conn);
                    break;

                case 9:
                    reportSongsAlbum(conn);
                    break;
                
                case 10:
                    reportPodcasts(conn);
                    break;

                case 11:
                    break;
                
                default:
                    System.out.println("Invalid Input, Please try again.");
            }
            if (choice == 11){
                break;
            }
        }
    }

    public void tablePrint(List<String> columnNames, List<List<Object>> results){
        //For Pretty Printing of the tables
        System.out.print("| ");
        for (String columnName : columnNames) {
            System.out.print(columnName + " | ");
        }
        System.out.println();

        // Print the rows
        for (List<Object> row : results) {
            System.out.print("| ");
            for (Object value : row) {
                System.out.print(value + " | ");
            }
            System.out.println();
        }
    }

    public void countSong(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Song ID.");
        String s_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("S_id");
        columnNames.add("EXTRACT(YEAR_MONTH FROM month_year) AS month_year");
        columnNames.add("play_count AS monthly_play_count");

        String condition = "S_id = " + "'" + s_id + "'";
        List<List<Object>> results = selectHelper.select("song_play", columnNames, condition, "", "",connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("S_id");
        columnNames1.add("month_year");
        columnNames1.add("monthly_play_count");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void countAlbum(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Album ID.");
        String al_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("Album_song.album_id");
        columnNames.add("SUM(song_play.play_count) AS play_count");
        columnNames.add("EXTRACT(YEAR_MONTH FROM month_year) AS month_year");

        String tableName = "Album_song JOIN song_play ON Album_song.s_id = song_play.S_id";
        String condition = "";
        String groupby = "Album_song.album_id, song_play.month_year";
        String having = "album_id = " + "'" + al_id + "'";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("album_id");
        columnNames1.add("monthly_play_count");
        columnNames1.add("monthly_year");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void countArtist(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Artist ID.");
        String ar_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("sungBy.Ar_id");
        columnNames.add("SUM(song_play.play_count) AS play_count");
        columnNames.add("EXTRACT(YEAR_MONTH FROM month_year) AS month_year");

        String tableName = "sungBy JOIN song_play ON sungBy.S_id = song_play.S_id";
        String condition = "";
        String groupby = "sungBy.Ar_id, song_play.month_year";
        String having = "Ar_id = " + "'" + ar_id + "'";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("Ar_id");
        columnNames1.add("monthly_play_count");
        columnNames1.add("monthly_year");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }

    public void reportHost(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Start Date.");
        String start_date = scanner.next();

        System.out.println("Enter the End Date.");
        String end_date = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("host_id");
        columnNames.add("SUM(amount)");

        String tableName = "Pay_PH";
        String condition = "time_stamp >= "+ "'" + start_date + "'" + " and time_stamp <= "+ "'" + end_date + "'";
        String groupby = "host_id";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("host_id");
        columnNames1.add("Amount");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void reportArtist(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Start Date.");
        String start_date = scanner.next();

        System.out.println("Enter the End Date.");
        String end_date = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("Ar_id");
        columnNames.add("SUM(amount)");

        String tableName = "Pay_Ar";
        String condition = "time_stamp >= "+ "'" + start_date + "'" + " and time_stamp <= "+ "'" + end_date + "'";
        String groupby = "Ar_id";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("Ar_id");
        columnNames1.add("Amount");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void reportRecordLabel(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Start Date.");
        String start_date = scanner.next();

        System.out.println("Enter the End Date.");
        String end_date = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("RL_id");
        columnNames.add("SUM(amount)");

        String tableName = "Pay_RL";
        String condition = "time_stamp >= "+ "'" + start_date + "'" + " and time_stamp <= "+ "'" + end_date + "'";
        String groupby = "RL_id";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("RL_id");
        columnNames1.add("Amount");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void totalRevenue(Connection connection){
        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("EXTRACT(YEAR_MONTH FROM month_year) AS month_year");
        columnNames.add("SUM(song.royalty_rate * song_play.play_count) as revenue_generated");

        String tableName = "song_play JOIN song ON song_play.S_id = song.S_id";
        String condition = "";
        String groupby = "song_play.month_year";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("month_year");
        columnNames1.add("revenue_generated");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void reportSongsArtist(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Artist ID.");
        String ar_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("sB.Ar_id");
        columnNames.add("sB.S_id");
        columnNames.add("title");

        String tableName = "song join sungBy sB on song.S_id = sB.S_id";
        String condition = "Ar_id = " + "'" + ar_id + "'";
        String groupby = "";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("Ar_id");
        columnNames1.add("S_id");
        columnNames1.add("title");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void reportSongsAlbum(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Album ID.");
        String al_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("Al.album_id");
        columnNames.add("Al.S_id");
        columnNames.add("title");

        String tableName = "song join Album_song Al on song.S_id = Al.S_id";
        String condition = "album_id = " + "'" + al_id + "'";
        String groupby = "";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("album_id");
        columnNames1.add("S_id");
        columnNames1.add("title");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
    public void reportPodcasts(Connection connection){
        //Taking required input from the user
        System.out.println("Enter the Podcast ID.");
        String pod_id = scanner.next();

        //Fetching the results from the table using select query
        SelectHelper selectHelper = new SelectHelper();

        List<String> columnNames = new ArrayList<>();
        columnNames.add("has.pod_id");
        columnNames.add("podcast_episode.podEp_title");

        String tableName = "podcast_episode  JOIN has ON podcast_episode.podEp_id = has.podEp_id";
        String condition = "has.pod_id = " + "'" + pod_id + "'";
        String groupby = "";
        String having = "";
        List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, connection);

        //Assigning appropriate column names
        List<String> columnNames1 = new ArrayList<>();
        columnNames1.add("pod_id");
        columnNames1.add("podEp_title");

        //Printing the result
        if (!results.isEmpty()) {
            tablePrint(columnNames1, results);
        } else{
            System.out.println("Empty result.");
        }
    }
}
