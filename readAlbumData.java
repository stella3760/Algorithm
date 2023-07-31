
/** * @author eugen */
import java.io.File;
import java.util.*;

public class readAlbumData {

	public static void main(String[] args) throws Exception{
		//parsing and reading the CSV file data into the music (object) array
		// provide the path here...
        File directory = new File("./");
  		String name = directory.getAbsolutePath() + "//album.csv";
  		System.out.println("directory = " + name);
		Scanner sc = new Scanner(new File(name));
		Album[] albums = new Album[10000];

		// this will just print the header in CSV file
		sc.nextLine();

		int i = 0; String st = "";

		while (sc.hasNextLine())  //returns a boolean value
		{
			st = sc.nextLine();
			String[] data = st.split(",");


			System.out.println("value of  i " + i  + " st = " +st);
			albums[i++] = new Album(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]));

		}
		sc.close();  //closes the scanner

		// We can print album details due to overridden toString method in album class
		System.out.println(albums[0]);
		System.out.println(albums[1]);

		// we can compare albums based on their ID due to overridden CompareTo method in album  class
		System.out.println(albums[0]==albums[0]);
		System.out.println(albums[0]==albums[1]);

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
