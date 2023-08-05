package SortingAndSearching;


/** * @author eugen */
import java.io.File;
import java.util.*;

public class readAlbumData {

	public static Album[] readAlbums(int size) throws Exception{
	//parsing and reading the CSV file data into the music (object) array
	// provide the path here...
            String name = "./src/album.csv";
            Scanner sc = new Scanner(new File(name));
            Album[] albums = new Album[size];

            sc.nextLine(); // Skip header

            int i = 0;
            while (sc.hasNextLine() && i < size) {
                String st = sc.nextLine();
                String[] data = st.split(",");
                albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));
            }
            
            sc.close();  //closes the scanner

            return albums;
        }
       
}




class Album implements Comparable<Object>{

	private int albumID;
	private String artist;
	private int popular;
	private float loudness;
	private float speech;
	private float duration;


	// constructor
	public Album(int albumID, String artist, int popular, float loudness , float speech, float duration) {
		super();
		this.albumID = albumID;
		this.artist = artist;
		this.popular = popular;
		this.loudness = loudness;
		this.speech = speech;
		this.duration = duration;
	}

	// setters and getters
	public int getAlbumID() {
		return albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}


	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getPopular() {
		return popular;
	}

	public void setPopular(int popular) {
		this.popular = popular;
	}

	public float getLoudness() {
		return loudness;
	}

	public void setLoudness(float loudness) {
		this.loudness = loudness;
	}

	public float  getSpeech() {
		return speech;
	}

	public void setSpeech(float speech) {
		this.speech = speech;
	}

	public float  getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	// so the film objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the title of the film
	@Override
	public int compareTo(Object obj) {

		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/


		Album alm = (Album)obj;
		return albumID - (alm.getAlbumID());
	}

	@Override
	public String toString() {
		return "Album [albumID= " + albumID + ", artist= " + artist + ", speech = "
				+ speech  +  ", popular = " + popular  + ", loudness = "
				+ loudness  + ", duration = " + duration + "]";
	}


        
}

