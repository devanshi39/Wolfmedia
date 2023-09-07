package operations;

import helpers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.lang.Exception;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class InformationProcessing {

    Scanner scanner = new Scanner(System.in);

    public void run(final Connection conn) throws Exception {

        while (true) {
            //Basic information insert update delete on songs, artists, podcast host and podcast episode
            //Also assign songs and artist to albums
            //Likewise assign podcast host and episodes to podcast
            System.out.println("Choose an operation you want to perform:");
            System.out.println("1. Insert Song");
            System.out.println("2. Update Song");
            System.out.println("3. Delete Song");
            System.out.println("4. Insert Artist");
            System.out.println("5. Update Artist");
            System.out.println("6. Delete Artist");
            System.out.println("7. Insert Podcast Host");
            System.out.println("8. Update Podcast Host");
            System.out.println("9. Delete Podcast Host");
            System.out.println("10. Insert Podcast Episode");
            System.out.println("11. Update Podcast Episode");
            System.out.println("12. Delete Podcast Episode");
            System.out.println("13. Assign song to album");
            System.out.println("14. Assign artist to album");
            System.out.println("15. Assign artist to Record label");
            System.out.println("16. Assign podcast episode to podcast");
            System.out.println("17. Assign podcast host to podcast");
            System.out.println("18. Exit Information Processing");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    insertSong(conn);
                    break;
                
                case 2:
                    updateSong(conn);
                    break;
                
                case 3:
                    deleteSong(conn);
                    break;

                case 4:
                    insertArtist(conn);
                    break;
                
                case 5:
                    updateArtist(conn);
                    break;
                
                case 6:
                    deleteArtist(conn);
                    break;

                case 7:
                    insertPodcastHost(conn);
                    break;

                case 8:
                    updatePodcastHost(conn);
                    break;

                case 9:
                    deletePodcastHost(conn);
                    break;

                case 10:
                    insertPodcastEpi(conn);
                    break;

                case 11:
                    updatePodcastEpi(conn);
                    break;

                case 12:
                    deletePodcastEpi(conn);
                    break;

                case 13:
                    assignSongToAlbum(conn);
                    break;

                case 14:
                    assignArtistToAlbum(conn);
                    break;

                case 15:
                    assignArtistToRecordLabel(conn);
                    break;

                case 16:
                    assignPodcastEpiToPodcast(conn);
                    break;

                case 17:
                    assignPodcastHostToPodcast(conn);
                    break;

                case 18:
                    break;
                
                default:
                    System.out.println("Invalid Input, Please try again.");
            }
            if (choice == 18){
                break;
            }
        }
    }

    public void assignPodcastHostToPodcast(Connection conn){
        // Assign a podcast host to podcast
        Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Enter the Podcast Host ID:");
        String host_id = scanner.nextLine();
        columnValues.put("host_id", host_id);
        System.out.println("Enter the podcast ID:");
        String pod_id = scanner.nextLine();
        columnValues.put("pod_id", pod_id);

        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "pod_host", conn);

    }
    public void assignPodcastEpiToPodcast(Connection conn) {
        // Assign a podcast episode to podcast
        Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Enter the Podcast Episode ID:");
        String podEp_id = scanner.nextLine();
        columnValues.put("podEp_id", podEp_id);
        System.out.println("Enter the podcast ID:");
        String pod_id = scanner.nextLine();
        columnValues.put("pod_id", pod_id);

        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "has", conn);
    }
    public void assignArtistToRecordLabel(Connection conn) {
        // Assign an artist to record label
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Enter the artist ID:");
        String S_id = scanner.nextLine();
        columnValues.put("Ar_id", S_id);
        System.out.println("Enter the record label ID:");
        String Rl_id = scanner.nextLine();
        columnValues.put("Rl_id", Rl_id);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "Rl_Artist", conn);

    }
    public void assignArtistToAlbum(Connection conn) throws SQLException{
        // assign an artist to album
//      start a transaction
        try {
            conn.setAutoCommit(false);
            Map<String, Object> columnValues = new HashMap<>();
            System.out.println("Enter the artist ID:");
            String Ar_id = scanner.nextLine();
            columnValues.put("Ar_id", Ar_id);
            System.out.println("Enter the album ID:");
            String album_id = scanner.nextLine();
            columnValues.put("album_id", album_id);
            InsertHelper insertHelper = new InsertHelper();
            insertHelper.insertQuery(columnValues, "Artist_album", conn);
            conn.commit();
        }
        catch(SQLException e){
            System.err.println("Exception at Insert");
            conn.rollback();
        }
//        end of transaction
    }
    public void assignSongToAlbum(Connection conn) throws SQLException {
        // assign a song to album
        //transaction
        try {
            conn.setAutoCommit(false);
            Map<String, Object> columnValues = new HashMap<>();

            System.out.println("Enter the song ID:");
            String S_id = scanner.nextLine();
            columnValues.put("S_id", S_id);
            System.out.println("Enter the album ID:");
            String album_id = scanner.nextLine();
            columnValues.put("album_id", album_id);

            InsertHelper insertHelper = new InsertHelper();
            insertHelper.insertQuery(columnValues, "Album_song", conn);
            conn.commit();
        }
        catch(SQLException e){
            System.err.println(e);
            conn.rollback();
        }
    }
    public void insertPodcastEpi(Connection conn) throws SQLException {
        //insert operation on basic info for podcast episode
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Enter podcast episode ID:");
        String podEp_id = scanner.nextLine();
        columnValues.put("podEp_id", podEp_id);
        System.out.println("Enter podcast episode title ID:");
        String podEp_title = scanner.nextLine();
        columnValues.put("podEp_title", podEp_title);
        System.out.println("Enter podcast episode duration(hh:mm:ss):");
        String duration = scanner.nextLine();
        columnValues.put("duration", duration);
        System.out.println("Enter podcast episode listening count:");
        int listenCount = scanner.nextInt();
        scanner.nextLine();
        columnValues.put("listenCount", listenCount);
        System.out.println("Enter podcast episode advertisement count:");
        int ads_count = scanner.nextInt();
        scanner.nextLine();
        columnValues.put("ads_count", ads_count);
        System.out.println("Enter podcast episode release date (yyyy-mm-dd):");
        String release_date = scanner.nextLine();
        columnValues.put("release_date", release_date);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "podcast_episode", conn);
    }

    public void updatePodcastEpi(Connection conn) {
        //update operation on basic info for podcast episode
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Choose the column to update:");
        System.out.println("1. Episode title");
        System.out.println("2. Duration");
        System.out.println("3. Listening Count");
        System.out.println("4. Advertisement Count");
        System.out.println("5. Release date");
        System.out.println("Enter your choice: \t");
        int column = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new value:");

        if (column == 1) {
            String value = scanner.nextLine();
            columnValues.put("podEp_title", value);
        } else if (column == 2) {
            String value = scanner.nextLine();
            columnValues.put("duration", value);
        }else if (column == 3){
            int value = scanner.nextInt();
            scanner.nextLine();
            columnValues.put("listenCount", value);
        } else if (column == 4){
            int value = scanner.nextInt();
            scanner.nextLine();
            columnValues.put("ads_count", value);
        } else if (column == 5){
            String value = scanner.nextLine();
            columnValues.put("release_date", value);
        }

        System.out.println("Enter the episode ID for the update operation:");
        String podEp_id = scanner.nextLine();

        String condition = "podEp_id=" + ("\"") + podEp_id + ("\"");
        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("podcast_episode", condition, columnValues, conn);
    }

    public void deletePodcastEpi(Connection conn) {
        //delete operation on basic info for podcast episode
        System.out.println("Provide the Episode ID which you want to delete:");
        String value = scanner.nextLine();
        String condition = "null";
        condition = "podEp_id=" + ("\"") + value + ("\"");
        DeleteHelper deleteHelper = new DeleteHelper();
        deleteHelper.delete("podcast_episode", condition, conn);
    }
    public void updatePodcastHost(Connection conn) {
        //update operation on basic info for podcast host
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Choose the column to update:");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Email ID");
        System.out.println("4. Contact Number");
        System.out.println("5. City");
        System.out.println("Enter your choice: \t");
        int column = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new value:");

        if (column == 1){
            String value =  scanner.nextLine();
            columnValues.put("f_name",value);
        } else if (column == 2) {
            String value = scanner.nextLine();
            columnValues.put("l_name", value);
        } else if (column == 3){
            String value = scanner.nextLine();
            columnValues.put("email", value);
        } else if (column == 4){
            String value = scanner.nextLine();
            columnValues.put("phone", value);
        } else if (column == 5){
            String value = scanner.nextLine();
            columnValues.put("city", value);
        }

        System.out.println("Enter the host ID for the update operation:");
        String host_id = scanner.nextLine();

        String condition = "host_id=" + ("\"") + host_id + ("\"");
        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("podcast_host", condition, columnValues, conn);
    }

    public void deletePodcastHost(Connection conn) {
        //delete operation on basic info for podcast host

        System.out.println("Provide the Host ID which you want to delete:");
        String value = scanner.nextLine();
        String condition = "null";
        condition = "host_id=" + ("\"") + value + ("\"");
        DeleteHelper deleteHelper = new DeleteHelper();
        deleteHelper.delete("podcast_host", condition, conn);
    }

    public void insertPodcastHost(Connection conn) throws SQLException {
        //insert operation on basic info for podcast host
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Enter podcast host ID:");
        String host_id = scanner.nextLine();
        columnValues.put("host_id", host_id);
        System.out.println("Enter Host's first name:");
        String f_name = scanner.nextLine();
        columnValues.put("f_name", f_name);
        System.out.println("Enter Host's last name:");
        String l_name = scanner.nextLine();
        columnValues.put("l_name", l_name);
        System.out.println("Enter email id of host:");
        String email = scanner.nextLine();
        columnValues.put("email", email);
        System.out.println("Enter contact number of host:");
        String phone = scanner.nextLine();
        columnValues.put("phone", phone);
        System.out.println("Enter the city of host:");
        String city = scanner.nextLine();
        columnValues.put("city", city);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "podcast_host", conn);
    }
    private void deleteArtist(Connection conn) {
        //delete operation on basic info for artist
    	System.out.println("Provide the ArtistID which you want to delete:");
    	String value = scanner.nextLine();
        String condition = "null";
        condition = "Ar_id=" + ("\"") + value + ("\""); 
        DeleteHelper deleteHelper = new DeleteHelper();
        deleteHelper.delete("artists", condition, conn);
		
	}

	private void updateArtist(Connection conn) {
        //update operation on basic info for artist
		Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Choose the column to update:");
        System.out.println("1. Name");
        System.out.println("2. Primary Genre");
        System.out.println("3. Active status of the artist:");
        System.out.println("4. Monthly listeners");
        System.out.println("5. Country");
        System.out.println("6. Type");
        System.out.println("Enter your choice: \t");
        int column = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new value:");
        
        if (column == 1) {
            String value = scanner.nextLine();
            columnValues.put("name", value);
        } else if (column == 2){
            String value = scanner.nextLine();
            columnValues.put("primary_genre", value);
        } else if (column == 3){
            String value = scanner.nextLine();
            columnValues.put("status", value);
        } else if (column == 4){
            int value = scanner.nextInt();
            scanner.nextLine();
            columnValues.put("monthly_listeners", value);
        } else if (column == 5){
            String value = scanner.nextLine();
            columnValues.put("country", value);
        } else if (column == 6){
            String value = scanner.nextLine();
            columnValues.put("type", value);
        }

        System.out.println("Enter the artist ID for the update operation:");
        String Ar_id = scanner.nextLine();

        String condition = "Ar_id=" + ("\"") + Ar_id + ("\"");
        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("artists", condition, columnValues, conn);
		
	}

	private void insertArtist(Connection conn) throws SQLException {
        //insert operation on basic info for artist
		Map<String, Object> columnValues = new HashMap<>();
		
		System.out.println("Enter artist ID:");
        String Ar_id = scanner.nextLine();
        columnValues.put("Ar_id", Ar_id);
        System.out.println("Enter artist name:");
        String Ar_name = scanner.nextLine();
        columnValues.put("name", Ar_name);
        System.out.println("Enter the primary genre:");
        String pGenre = scanner.nextLine();
        columnValues.put("primary_genre", pGenre);
        System.out.println("Enter active status of the artist:");
        String status = scanner.nextLine();
        columnValues.put("status", status);
        System.out.println("Enter country of origin of the artist:");
        String country = scanner.nextLine();
        columnValues.put("country", country);
        System.out.println("Enter the number of monthly listeners:");
        int mListeners = scanner.nextInt();
        scanner.nextLine();
        columnValues.put("monthly_listeners", mListeners);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "artists", conn);
	}

	public void insertSong(Connection conn) throws SQLException {
        //insert operation on basic info for song
        Map<String, Object> columnValues = new HashMap<>();
        System.out.println("Enter song ID:");
        String sId = scanner.nextLine();
        columnValues.put("S_id", sId);
        System.out.println("Enter royalty rate:");
        float rRate = scanner.nextFloat();
        scanner.nextLine();
        columnValues.put("royalty_rate", rRate);
        System.out.println("Enter Release Country:");
        String rCountry = scanner.nextLine();
        columnValues.put("release_country", rCountry);
        System.out.println("Enter Release Date (yyyy-mm-dd):");
        String rDate = scanner.nextLine();
        columnValues.put("release_date", rDate);
        System.out.println("Enter Title:");
        String title = scanner.nextLine();
        columnValues.put("title", title);
        System.out.println("Enter Duration:");
        Float duration = scanner.nextFloat();
        scanner.nextLine();
        columnValues.put("duration", duration);
        System.out.println("Enter whether is royalty is paid (Yes/No):");
        String rPaid = scanner.nextLine();
        columnValues.put("Royalty_paid", rPaid);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "song", conn);
    }

    public void updateSong(Connection conn) {
        //update operation on basic info for song
        Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Choose the column to update:");
        System.out.println("1. Title");
        System.out.println("2. Royalty rate");
        System.out.println("3. Release date(yyyy-mm-dd)");
        System.out.println("4. Release Country");
        System.out.println("5. Duration");
        System.out.println("6. Royalty Paid(Yes/No)");
        System.out.println("Enter your choice: \t");
        int column = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the song ID for the update operation:");
        String sId = scanner.nextLine();
        System.out.println("Enter the new value:");

        if (column == 1) {
            String value1 = scanner.nextLine();
            columnValues.put("title", value1);
        } else if (column == 2) {
            float value1 = scanner.nextFloat();
            scanner.nextLine();
            columnValues.put("royalty_rate", value1);
        } else if (column == 3) {
            String value1 = scanner.nextLine();
            columnValues.put("release_date", value1);
        } else if (column == 4) {
            String value1 = scanner.nextLine();
            columnValues.put("release_country", value1);
        } else if (column == 5) {
            float value1 = scanner.nextFloat();
            scanner.nextLine();
            columnValues.put("duration", value1);
        } else if (column == 6) {
            String value1 = scanner.nextLine();
            columnValues.put("Royalty_paid", value1);
        }

        String condition = "S_id=" + ("\"") + sId + ("\"");
        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("song", condition, columnValues, conn);
    }

    public void deleteSong(Connection conn){
        //delete operation on basic info for song
        System.out.println("Provide the SongID which you want to delete:");
    	String value = scanner.nextLine();
        String condition = "null";
        condition = "S_id=" + ("\"") + value + ("\""); 
        DeleteHelper deleteHelper = new DeleteHelper();
        deleteHelper.delete("song", condition, conn);
    }
}

