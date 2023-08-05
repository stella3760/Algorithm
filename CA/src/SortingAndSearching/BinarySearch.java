package SortingAndSearching;

import java.util.Scanner;

/**
 *
 * @author seunghyekim
 */
public class BinarySearch {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter column (albumID or artist) : ");
        String columnLabel = scanner.nextLine().trim();
        System.out.print("Enter the value to search : ");
        String value = scanner.nextLine().trim();

        // Read albums data
        Album[] albums = readAlbumData.readAlbums(10000);

        // Binary search based on the sorted column label
        if ("albumID".equalsIgnoreCase(columnLabel)) {
            int albumID = Integer.parseInt(value);
            BSAlbumID(albums, albumID, columnLabel);
        } else if ("artist".equalsIgnoreCase(columnLabel)) {
            BSArtist(albums, value, columnLabel);
        } else {
            System.out.println("Invalid column label!");
        }

        scanner.close();
    }

   public static void BSAlbumID(Album[] albums, int albumID, String columnLabel) {
    int lower = 0;
    int upper = albums.length - 1;
    int mid;

    while (upper >= lower) {
        mid = (upper + lower) / 2;

        if (albums[mid].getAlbumID() == albumID) {
            System.out.println("Matching records found for " + columnLabel + ":");
            // Print all matching records from mid to the beginning of the array
            for (int i = mid; i >= 0 && albums[i].getAlbumID() == albumID; i--) {
                System.out.println(albums[i]);
            }
            // Print all matching records from mid + 1 to the end of the array
            for (int i = mid + 1; i < albums.length && albums[i].getAlbumID() == albumID; i++) {
                System.out.println(albums[i]);
            }
            return;
        } else if (albums[mid].getAlbumID() > albumID) {
            upper = mid - 1;
        } else {
            lower = mid + 1;
        }
    }

    System.out.println("Not an existing " + columnLabel + "!");
    }


    public static void BSArtist(Album[] albums, String artist, String columnLabel) {
        boolean found = false;
        System.out.println("Matching records found for " + columnLabel + ":");
        for (Album album : albums) {
            if (album.getArtist().equalsIgnoreCase(artist)) {
                System.out.println(album);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not an existing " + columnLabel + "!");
        }
    }


    
}