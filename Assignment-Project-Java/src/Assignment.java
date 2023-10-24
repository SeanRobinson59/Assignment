import java.io.Console;
import java.util.ArrayList;
import static java.lang.System.out;

public class Assignment {
    
    public static Console cnsl = System.console();
    
    public static ArrayList<Song> InitList(){
        ArrayList<Song> song_list = new ArrayList<Song>();
        song_list.add( new Song("Fred Again", "ten", 4335459));
        song_list.add( new Song("Flowdan", "Pepper", 7651));
        song_list.add( new Song("BMTH", "DarkSide", 1152275));
        song_list.add( new Song("Bad Bunny", "MONACO", 1842887));
        song_list.add( new Song("CMAT", "California", 168));
        song_list.add( new Song("Jazmin Bean", "Terrified", 2893672));
        song_list.add( new Song("Paris Paloma", "drywall", 1359126));
        song_list.add( new Song("Gwams", "PAMELA", 5));
        song_list.add( new Song("mustbejohn", "Waiting", 5554485));
        song_list.add( new Song("Ren", "Uninvited", 2784167));
        song_list.add( new Song("Reaper", "IMY", 6973053));
        song_list.add( new Song("LAXX", "Math", 125463));
        song_list.add( new Song("The Outlines", "Koven", 810334));
        song_list.add( new Song("Bruises", "Fox Stevenson", 32785612));
        song_list.add( new Song("Standstill", "Slippy", 5390));
        return song_list;              
        }
    
    private static String PrintOptions() {
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

    private static Song AddSong() {
        
        out.println();
        out.println("Input Artist : ");
        String artist_input = cnsl.readLine();

        out.println();
        out.println("Input Song : ");
        String song_input = cnsl.readLine(); /* need to alter to make sure if a number is entered, it will be read as a string */

        out.println();
        String played ="A";
        out.println("Input how many times the song has currently been played (whole number) : ");
        played = cnsl.readLine();

        if (!played.matches("\\d+")){
            do {
                    out.println("\nThat Wasnt an Integer! \n\nPlease Enter an Integer : ");
                    played = cnsl.readLine();         
            } while (!played.matches("\\d+"));
        }

        int played_input = Integer.parseInt(played);
        return new Song(artist_input, song_input, played_input);
    }

    private static ArrayList<Song> Remove(ArrayList<Song> songs){
            int x = 0;
            for (Song s:songs){
                out.println();
                out.println(s.title + " By " + s.artist + "[" + x + "]");
                out.println();
                ++x;                
            } 
        out.println("Pick a Song to remove by entering the number in the square brackets : \n");
        int song_remove = Integer.parseInt(cnsl.readLine());
        songs.remove(song_remove);
        return songs;
    }

    private static void Played(ArrayList<Song> songs) {
        out.println();
        out.println("Minimum Plays = ");
        out.println();
        int plays = Integer.parseInt(cnsl.readLine());
        for (Song s:songs){
            if(s.played > plays){
                out.println();
                out.println(s.title + " By " + s.artist + " has been played " + s.played + " times.");
                out.println();
            }                
        } 
    }

    private static void AllSongs(ArrayList<Song> songs) {
        for (Song s:songs){
            out.println();
            out.println(s.title + " By " + s.artist + " has been played " + s.played + " times.");
            out.println();                
        } 
    }

    public static void main(String []args) {
        ArrayList<Song> song_list = InitList();
        String choice = "A";
        do{
            choice = PrintOptions();
            switch (choice) {

                case "A":
                    song_list.add(AddSong());
                    break;

                case "R":
                    Remove(song_list);
                    break;                
            
                case "P":
                    Played(song_list);
                    break;

                case "S":
                    AllSongs(song_list);
                    break;
                
            }                    
        } while (!choice.equals("X"));
    }
}
