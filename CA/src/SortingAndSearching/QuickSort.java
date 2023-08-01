package SortingAndSearching;

/**
 *
 * @author seunghyekim
 */
public class QuickSort {
    public static void quickSort(Album[] albums, int low, int high) {
        if (low < high) {
            int pi = partition(albums, low, high);
            quickSort(albums, low, pi - 1);
            quickSort(albums, pi + 1, high);
        }
    }

    public static int partition(Album[] albums, int low, int high) {
        Album pivot = albums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            int compareArtist = albums[j].getArtist().compareTo(pivot.getArtist());
            if (compareArtist < 0 || (compareArtist == 0 && albums[j].getAlbumID() < pivot.getAlbumID())) {
                i++;

                // Swap albums[i] and albums[j]
                Album temp = albums[i];
                albums[i] = albums[j];
                albums[j] = temp;
            }
        }

        // Swap albums[i+1] and albums[high]
        Album temp = albums[i + 1];
        albums[i + 1] = albums[high];
        albums[high] = temp;
        return i + 1;
    }

}
