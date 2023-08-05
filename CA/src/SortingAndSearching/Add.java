package SortingAndSearching;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author seunghyekim
 */
public class Add {
    public static void main(String[] args) throws Exception {
        // Read albums from csv file
        Album[] albums = readAlbumData.readAlbums(10000); 

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to add data? (yes/no)");
        String response = input.nextLine();
        
        if (response.equalsIgnoreCase("yes")) {
            String artist = "";
            int popular = 0;
            float loudness = 0f;
            float speechiness = 0f;
            float duration = 0f;
            
            while (true) {
                try {
                    System.out.println("Enter artist: ");
                    artist = input.nextLine();
                    if (artist.isEmpty() || artist.matches("\\d+")) {
                        throw new InvalidInputException("Artist cannot be empty. Please correct this. Enter an String for artist");
                    }
                    break;
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    System.out.println("Enter popular(int): ");
                    popular = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer for popular.");
                }
            }

            while (true) {
                try {
                    System.out.println("Enter loudness(float): ");
                    loudness = Float.parseFloat(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a float for loudness.");
                }
            }

            while (true) {
                try {
                    System.out.println("Enter speechiness(float): ");
                    speechiness = Float.parseFloat(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a float for speechiness.");
                }
            }

            while (true) {
                try {
                    System.out.println("Enter duration(float): ");
                    duration = Float.parseFloat(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a float for duration.");
                }
            }

            int newAlbumID = albums[albums.length - 1].getAlbumID() + 1;
            Album newAlbum = new Album(newAlbumID, artist, popular, loudness, speechiness, duration);
            albums = addAlbumRecord(albums, newAlbum);

            writeAlbumsToCSV(albums, "./src/album.csv");
        }

        input.close();
    }

    public static Album[] addAlbumRecord(Album[] albums, Album newRecord) {
        Album[] newAlbums = Arrays.copyOf(albums, albums.length + 1);
        newAlbums[newAlbums.length - 1] = newRecord;
        return newAlbums;
    }

    public static void writeAlbumsToCSV(Album[] albums, String filename) throws Exception {
        PrintWriter pw = new PrintWriter(new File(filename));
        StringBuilder sb = new StringBuilder();

        sb.append("albumID,artist,popular,loudness,speech,duration\n");

        for (Album album : albums) {
            sb.append(album.getAlbumID()).append(",");
            sb.append(album.getArtist()).append(",");
            sb.append(album.getPopular()).append(",");
            sb.append(album.getLoudness()).append(",");
            sb.append(album.getSpeech()).append(",");
            sb.append(album.getDuration()).append("\n");
        }

        pw.write(sb.toString());
        pw.close();
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
