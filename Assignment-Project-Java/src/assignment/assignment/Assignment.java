package assignment;
import java.io.Console;
import java.util.ArrayList;
import static java.lang.System.out;

public class Assignment {
  
    private static final Console cnsl = System.console(); //Makes console comands easier
    
    private static void gap(){ // Makes a gap/page break kind of thing, just made it a function as was used a few times
        out.println("------------------------------------------------------------------------");
    }

    private static int intCheck(){ //doesnt work for songRemove because it wont pick up IOOBE if not given array
        boolean done = false;
        int output = 0;
        while(!done){
            try {
                output = Integer.parseInt(cnsl.readLine());
                done = true;
            }catch (NumberFormatException e){
                out.println("\nThat Wasnt an Integer! \n\nPlease Enter an Integer : ");
            }  
        }
        return output;
    }

    private static String emptyCheck(String input){ // Makes a gap/page break kind of thing, just made it a function as was used a few times
        while (input.matches("")){
            out.println("Please enter a value!\n");
            input = cnsl.readLine();
            }
            return input;
    }

    private static ArrayList<Song> initList(){ //Initialises the ArrayList of Songs and adds the songs
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
    
    private static String printOptions() { //Prints all the menu Options
        out.println("\nWhat do you want to do:");
        out.println("\nAdd an Song [A]");
        out.println("Remove a Song [R]");
        out.println("View all songs [S]");
        out.println("Print Songs over a Certain number of plays [P]");
        out.println("Exit Program [X]\n");
        String choice = cnsl.readLine();
        choice = choice.toUpperCase();
        return choice;
    } 

    private static Song addSong() { //Adds the song to the Array List
        out.println("\nInput Artist : ");
        final String ARTIST_INPUT = emptyCheck(cnsl.readLine());
        out.println("\nInput Song : ");
        final String SONG_INPUT = emptyCheck(cnsl.readLine());
        out.println("\nInput how many times the song has currently been played (whole number) : ");
        final int PLAYED_INPUT = intCheck();
        return new Song(ARTIST_INPUT, SONG_INPUT, PLAYED_INPUT);
    }

    private static ArrayList<Song> songRemove(ArrayList<Song> songs){ //Removes a song from array by using indexing
        int x = 0;
        boolean done = false;
        gap();
        out.println("\n");
        for (Song s:songs){
            out.println(s.title + " By " + s.artist+ "[" + x + "]\n"); 
            ++x;                
        }
        gap(); 
        out.println("Pick a Song to remove by entering the number in the square brackets : \n");
        while(!done){
            try {
                songs.remove(intCheck());
                done = true;
            }catch (IndexOutOfBoundsException e){
                out.println("\nYour song number isn't correct, please check again! \nPlease Enter an Integer : ");
            }
        }
        return songs;
    }

    private static void printSongs(ArrayList<Song> songs, boolean version) { //Prints the songs, either all of them or songs over a certain play count, using the arg 'version' to decide. Prints text if no song has enough plays 
        int plays = 0;
        boolean noSongs = true;
        if (version){
            out.println("\nMinimum Plays = \n");
            plays = intCheck();
        }
        gap();
        out.println("\n");
        for (Song s:songs){
            if(s.played > plays){
                noSongs = false;
                out.println(s.title + " By " + s.artist+ " has been played " + s.played + " times." + "\n");
            }
        }
        if(noSongs){
            out.println("There are no songs that have more than " + plays + " plays!\n");
            }                
        gap(); 
    }
    public static void main(String []args) { //The Main Method
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
                    printSongs(songList, true);
                    break;

                case "S":
                    printSongs(songList, false);
                    break;
                
                default:
                    break;
            }                    
        } while (!choice.equals("X"));
    }
}
