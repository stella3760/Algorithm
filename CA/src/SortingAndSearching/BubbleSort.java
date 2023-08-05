package SortingAndSearching;

/**
 *
 * @author seunghyekim
 */

public class BubbleSort {

    public static void main(String[] args) throws Exception {
        int[] sizes = {10, 100, 1000, 5000, 10000};

        // Sorting and printing the sorted albums
        Album[] albumsSample = readAlbumData.readAlbums(10000);
        bubbleSort(albumsSample);
            for (int i = 0; i < 10000; i++) {
                System.out.println(albumsSample[i]);
            }

        // Using Quick Sort
        QuickSort.quickSort(albumsSample, 0, albumsSample.length - 1);
        for (int i = 0; i < 10000; i++) {
            System.out.println(albumsSample[i]);
        }
            
        // Experimentally analyzing time complexity
        System.out.println("\nTime complexity analysis:");
            for (int size : sizes) {
                long totalTime = 0;
                int iterations = 10; // Number of iterations for averaging

                for (int i = 0; i < iterations; i++) {
                    Album[] albums = readAlbumData.readAlbums(size);
                    long startTime = System.nanoTime();
                    bubbleSort(albums);
                    long endTime = System.nanoTime();
                    totalTime += (endTime - startTime);
                }

                System.out.println("Average time for " + size + " records: " + totalTime / iterations / 1000000.0 + " ms");
            }
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
