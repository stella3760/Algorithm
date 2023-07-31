package SortingAndSearching;

import java.io.File;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) throws Exception {
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//CA//Album.csv"; // file path
        Scanner sc = new Scanner(new File(name));
        Album[] albums = new Album[10000];

        sc.nextLine(); // read header

        int i = 0;
        while (sc.hasNextLine()) {
            String st = sc.nextLine();
            String[] data = st.split(",");
            albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));
        }
        sc.close();

        bubbleSort(albums);

        // You can print the sorted array to check
        System.out.println(albums[0]);
        System.out.println(albums[1]);
    }

    public static void bubbleSort(Album[] albums) {
        int n = albums.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Sorting based on popular column (adjust index as per your requirement)
                if (albums[i - 1].getPopular() > albums[i].getPopular() || 
                    (albums[i - 1].getPopular() == albums[i].getPopular() && albums[i - 1].getAlbumID() > albums[i].getAlbumID())) {
                    Album temp = albums[i - 1];
                    albums[i - 1] = albums[i];
                    albums[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}

class Album {
    // ... Same Album class as before
}
