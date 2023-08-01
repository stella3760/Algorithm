package SortingAndSearching;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        Album[] albums = readAlbumData.readAlbums(); // Read albums data
    }

    public static void bubbleSort(Album[] albums) {
        int n = albums.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (albums[j] != null && albums[j + 1] != null) {
                    int compareArtist = albums[j].getArtist().compareTo(albums[j + 1].getArtist());
                    if (compareArtist > 0 || (compareArtist == 0 && albums[j].getAlbumID() > albums[j + 1].getAlbumID())) {
                        // Swap albums[j] and albums[j+1]
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                        swapped = true;
                    }
                }
            }

            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
