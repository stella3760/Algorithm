package SortingAndSearching;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        Album[] albums = readAlbumData.readAlbums(); // 앨범 데이터 읽기
        bubbleSort(albums); // 버블 정렬 수행

        // 정렬된 앨범 데이터 출력
        System.out.println(albums[0]);
        System.out.println(albums[1]);
    }

    public static void bubbleSort(Album[] albums) {
        int n = albums.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (albums[i - 1].getAlbumID() > albums[i].getAlbumID() || 
                    (albums[i - 1].getAlbumID() == albums[i].getAlbumID() && albums[i - 1].getArtist().compareTo(albums[i].getArtist()) > 0)) {
                    Album temp = albums[i - 1];
                    albums[i - 1] = albums[i];
                    albums[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
