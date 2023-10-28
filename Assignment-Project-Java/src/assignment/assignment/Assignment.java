package assignment;
import java.io.Console;
import java.util.ArrayList;
import static java.lang.System.out;

public class Assignment {
    
    public static final Console cnsl = System.console();
    public static final String GAP = "------------------------------------------------------------------------";

    public static ArrayList<Song> initList(){
        ArrayList<Song> songList = new ArrayList<>();
        songList.add( new Song("Fred Again", "ten", 4335459));
        songList.add( new Song("Flowdan", "Pepper", 7651));
        songList.add( new Song("BMTH", "DarkSide", 1152275));
        songList.add( new Song("Bad Bunny", "MONACO", 1842887));
        songList.add( new Song("CMAT", "California", 168));
        songList.add( new Song("Jazmin Bean", "Terrified", 2893672));
        songList.add( new Song("Paris Paloma", "drywall", 1359126));
        songList.add( new Song("Gwams", "PAMELA", 5));
        songList.add( new Song("mustbejohn", "Waiting", 5554485));
        songList.add( new Song("Ren", "Uninvited", 2784167));
        songList.add( new Song("Reaper", "IMY", 6973053));
        songList.add( new Song("LAXX", "Math", 125463));
        songList.add( new Song("The Outlines", "Koven", 810334));
        songList.add( new Song("Bruises", "Fox Stevenson", 32785612));
        songList.add( new Song("Standstill", "Slippy", 5390));
        return songList;              
        }
    
    private static String printOptions() {
        out.println(); /* I am aware of the \n operator but prefered this method as it looked better on my console (in my opinion) */
        out.println("What do you want to do:");
        out.println();
        out.println("Add an Song [A]");
        out.println("Remove a Song [R]");
        out.println("View all songs [S]");
        out.println("Print Songs over a Certain number of plays [P]");
        out.println("Exit Program [X]");
        out.println();
        String choice = cnsl.readLine();
        choice = choice.toUpperCase();
        return choice;
    } 

    private static Song addSong() {
        
        out.println();
        out.println("Input Artist : ");
        final String ARTIST_INPUT = cnsl.readLine();

        out.println();
        out.println("Input Song : ");
        final String SONG_INPUT = cnsl.readLine();

        out.println();
        out.println("Input how many times the song has currently been played (whole number) : ");
        String played = cnsl.readLine();

        if (!played.matches("\\d+")){
            do {
                    out.println("\nThat Wasnt an Integer! \n\nPlease Enter an Integer : ");
                    played = cnsl.readLine();         
            } while (!played.matches("\\d+"));
        }

        final int PLAYED_INPUT = Integer.parseInt(played);
        return new Song(ARTIST_INPUT, SONG_INPUT, PLAYED_INPUT);
    }

    private static ArrayList<Song> songRemove(ArrayList<Song> songs){
            int x = 0;
            for (Song s:songs){
                out.println();
                out.println(s.title + " By " + s.artist+ "[" + x + "]"); // Could add a try catch to catch people putting in the wrong number
                out.println();
                ++x;                
            } 
        out.println("Pick a Song to remove by entering the number in the square brackets : \n");
        final int SONG_REMOVE = Integer.parseInt(cnsl.readLine());
        songs.remove(SONG_REMOVE);
        return songs;
    }

    private static void playedSongs(ArrayList<Song> songs) {
        out.println();
        out.println("Minimum Plays = ");
        out.println();
        final int PLAYS = Integer.parseInt(cnsl.readLine());
        out.println(GAP);
        for (Song s:songs){
            if(s.played > PLAYS){
                out.println();
                out.println(s.title + " By " + s.artist+ " has been played " + s.played + " times.");
                out.println();
            }                
        }
        out.println(GAP); 
    }

    private static void allSongs(ArrayList<Song> songs) {
        out.println(GAP);
        for (Song s:songs){
            out.println();
            out.println(s.title + " By " + s.artist+ " has been played " + s.played + " times.");
            out.println();                
        }
        out.println(GAP); 
    }

    public static void main(String []args) {
        ArrayList<Song> songList = initList();
        String choice;
        do{
            choice = printOptions();
            switch (choice) {

                case "A":
                    songList.add(addSong());
                    break;

                case "R":
                    songRemove(songList);
                    break;                
            
                case "P":
                    playedSongs(songList);
                    break;

                case "S":
                    allSongs(songList);
                    break;
                
                default:
                    break;
                
            }                    
        } while (!choice.equals("X"));
    }
}
