package operations;

import helpers.*;

import java.sql.Connection;
import java.util.Scanner;

//import java.util.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignments {
    Scanner scanner = new Scanner(System.in);

    public void run(final Connection conn){

        while (true) {
	// Update operations for maintaining the metadata for the required tables.
	// Here we enter and update a particular song's play count, update monthly listener's for artists and subscribers and ratings for a podcast.
	// We also have the functionality to update the listener's count for a particular podcast.
	// Finally we have the functionlity to find a song given an artist or an album and also find podcast episodes for a given podcast ID.
            System.out.println("Choose an operation you want to perform:");
            System.out.println("1. Enter Song's play count");
            System.out.println("2. Update Song's play count");
            System.out.println("3. Update monthly listener for artists");
            System.out.println("4. Update subscribers and ratings for a podcast");
            System.out.println("5. Update listener's count for a podcast");
            System.out.println("6. Find songs and podcasts");
            System.out.println("9. Exit Metadata and record updation");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                	enterSongPC(conn);
                    break;
                
                case 2:
                	updateSongPC(conn);
                    break;
                
                case 3:
                    updateMonthlyListener(conn);
                    break;
                    
                case 4:
                    updateSubsAndRating(conn);
                    break;
                    
                case 5:
                    updateListenCnt(conn);
                    break;
                    
                case 6:
                    findSongsAndPodcasts(conn);
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

	public void findSongsAndPodcasts(Connection conn) {
	// This function implements the functionality of finding songs for a given artist or an album. It also implements finding podcast episodes when
	// given a particular podcast ID.
//		Map<String, Object> columnNames = new HashMap<>();
		
		while(true) {
			System.out.println("Choose the operation you want to perform:");
            System.out.println("1. Find songs");
            System.out.println("2. Find podcasts episodes");
            System.out.println("8. Exit this section");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
            case 1:
            	while(true) {
            		System.out.println("Choose the operation you want to perform:");
                    System.out.println("1. Find songs by artist");
                    System.out.println("2. Find songs by album");
                    System.out.println("8. Exit this section");
                    System.out.println("Enter your choice: \t");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    switch(choice1) {
		    // Case for finding songs
                    case 1:
                    	System.out.println("Enter Artist ID whose song you want to find:");
                        String aID = scanner.nextLine();
                        List<String> columnNames1 = new ArrayList<>();
                        columnNames1.add("title");
                        SelectHelper selectHelper1 = new SelectHelper();
                        
                        String tableName1 = "song JOIN sungBy sB ON song.S_id = sB.S_id";
                        String condition1 = "Ar_id=" + ("\"") + aID + ("\"");
                        String groupby1 = "";
                        String having1 = "";
                        List<List<Object>> results = selectHelper1.select(tableName1, columnNames1, condition1, groupby1, having1, conn);
                        System.out.println(results);
                        break;
                    
                    case 2:
                    	System.out.println("Enter Album ID whose corresponding song you want to find:");
                        String albumID = scanner.nextLine();
                        List<String> columnNames2 = new ArrayList<>();
                        columnNames2.add("title");
                        SelectHelper selectHelper2 = new SelectHelper();
                        
                        String tableName2 = "song JOIN Album_song Al ON song.S_id = Al.S_id";
                        String condition2 = "album_id=" + ("\"") + albumID + ("\"");
                        String groupby2 = "";
                        String having2 = "";
                        List<List<Object>> results2 = selectHelper2.select(tableName2, columnNames2, condition2, groupby2, having2, conn);
                        System.out.println(results2);
                    	break;
                    	
                    case 8:
                    	break;
                    	
                    default:
                    	System.out.println("Invalid Input, Please try again.");
                    }
                    if (choice1 == 8){
                        break;
                        }
            	}
            	break;
            case 2:
	    // case for finding podcast episodes
            	System.out.println("Enter podcast ID whose episodes you need to see:");
                String podID = scanner.nextLine();
                List<String> columnNames = new ArrayList<>();
                columnNames.add("podEp_title");
                SelectHelper selectHelper = new SelectHelper();
                
                String tableName = "podcast_episode pe JOIN has ON has.PodEp_id = pe.podEp_id";
                String condition = "pod_id=" + ("\"") + podID + ("\"");
                String groupby = "";
                String having = "";
                List<List<Object>> results = selectHelper.select(tableName, columnNames, condition, groupby, having, conn);
                System.out.println(results);
                break;
               
            case 8:
            	break;
            	
            default:
            	System.out.println("Invalid Input, Please try again.");
            	
                }
            if (choice == 8){
                break;
            }
	
	}}
	public void updateListenCnt(Connection conn) {
	// This function updates the listening count for a particular podcast ID
		Map<String, Object> columnValues = new HashMap<>();
		
		System.out.println("Enter podcast episode ID for which you want to update the listener's count:");
        String podEp_id = scanner.nextLine();
        System.out.println("Enter the new value for the listener count:");
        int lCount = scanner.nextInt();
        columnValues.put("listenCount", lCount);
        scanner.nextLine();

        String condition = "podEp_id=" + ("\"") + podEp_id + ("\"");
//        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("podcast_episode", condition, columnValues, conn);
	}

	public void updateSubsAndRating(Connection conn) {
	// This function updates the subscriber count and Rating for a particular podcast
		Map<String, Object> columnValues = new HashMap<>();
		
		while(true) {
			System.out.println("Choose the operation you want to perform:");
            System.out.println("1. Update subscriber count");
            System.out.println("2. Update ratings for the podcast");
            System.out.println("8. Exit this section");
            System.out.println("Enter your choice: \t");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            case 1:
	    // Case for updating subscriber count
            	System.out.println("Enter podcast ID for which you want to update the subscriber count:");
                String pID = scanner.nextLine();
                System.out.println("Enter the new value for the total subscribers:");
                int tSubs = scanner.nextInt();
                columnValues.put("total_subs", tSubs);
                scanner.nextLine();

                String condition = "pod_id=" + ("\"") + pID + ("\"");
//                System.out.println(condition);

                UpdateHelper updateHelper = new UpdateHelper();
                updateHelper.update("podcast", condition, columnValues, conn);
                break;
            
            case 2:
	    // Case for updating rating for a podcast
            	System.out.println("Enter podcast ID for which you want to update the rating:");
                String podID = scanner.nextLine();
                System.out.println("Enter the new value for the rating of the corresponding podcast:");
                float rating = scanner.nextFloat();
                columnValues.put("rating", rating);
                scanner.nextLine();

                String condition1 = "pod_id=" + ("\"") + podID + ("\"");
//                System.out.println(condition1);

                UpdateHelper updateHelper1 = new UpdateHelper();
                updateHelper1.update("podcast", condition1, columnValues, conn);
                break;
                
            case 8:
                break;
            
            default:
                System.out.println("Invalid Input, Please try again.");
            }
            if (choice == 8){
                break;
                }
		}
	}

	public void enterSongPC(Connection conn) {
        // Function implements the insertion of a song's playcount
    	Map<String, Object> columnValues = new HashMap<>();
    	
    	System.out.println("Enter song ID for which you want to enter the play count for:");
        String sID = scanner.nextLine();
        columnValues.put("S_id", sID);
        System.out.println("Enter the play count:");
        String playCount = scanner.nextLine();
        columnValues.put("play_count", playCount);
        System.out.println("Enter the date/time:");
        String pDate = scanner.nextLine();
        String result = pDate.substring(5, 7);
        String playDate;
        if(result.equals("01")) {
        	playDate = "Jan";
        }
        else if(result.equals("02")) {
        	playDate = "Feb";
        }
        else if(result.equals("03")) {
        	playDate = "Mar";
        }
        else playDate = "April";
        columnValues.put("month_year", playDate);
        InsertHelper insertHelper = new InsertHelper();
        insertHelper.insertQuery(columnValues, "song_play", conn);
	}

	public void updateSongPC(Connection conn) {
        // Function updates a particular song's playcount when given a songID
		Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Enter song ID for which you want to update the play count for:");
        String sID = scanner.nextLine();
        System.out.println("Enter the new value for the play count:");
        int pCount = scanner.nextInt();
        columnValues.put("play_count", pCount);
        scanner.nextLine();
        System.out.println("Enter the month for which it needs to be updated for:");
        String month = scanner.nextLine();
        columnValues.put("play_count", pCount);

        String condition = "S_id=" + ("\"") + sID + ("\" AND month_year=") + ("\"") + month + ("\"");
        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("song_play", condition, columnValues, conn);
		
	}
	
    public void updateMonthlyListener(Connection conn) {
    // This function updates monthly listener's for a particular song for a particular month
		Map<String, Object> columnValues = new HashMap<>();

        System.out.println("Enter artist ID for which you want to update the play count:");
        String arID = scanner.nextLine();
        System.out.println("Enter the new value for the monthly listeners count:");
        int mCount = scanner.nextInt();
        columnValues.put("monthly_listeners", mCount);
        scanner.nextLine();

        String condition = "Ar_id=" + ("\"") + arID + ("\"");
//        System.out.println(condition);

        UpdateHelper updateHelper = new UpdateHelper();
        updateHelper.update("artists", condition, columnValues, conn);
		
	}

}

