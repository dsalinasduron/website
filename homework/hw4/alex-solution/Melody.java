/**
 * A Melody object stores the notes of a song and provides functionality given these notes.
 *
 * Created by Alex Brown
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
    private Queue<Note> song;
    private double songDuration = -1;

    // Constructs a melody with the provided song
    public Melody(Queue<Note> song) {
        this.song = song;
    }

    // Returns the total length of the song in seconds
    public double getTotalDuration() {
        // If we have not found the song duration yet, calculate it and store it
        if(songDuration < 0) {
            double tempSongDuration = 0;
            double repeatSectionDuration = 0;
            boolean countRepeat = false;
            int songLength = song.size();
            int notesChecked = 0;
            // Make sure we check all of our notes
            while(notesChecked != songLength) {
                // Remove the note from the queue to use it
                Note note = song.remove();
                // Check to see if the note is the start of a repeated section
                if(note.isRepeat() && !countRepeat) { // If a note is a repeat and we are at the start of a repeat section
                    countRepeat = true;
                    repeatSectionDuration += note.getDuration();
                } else if(note.isRepeat() && countRepeat) { // If a note is a repeat and we are at the end of a repeat section
                    countRepeat = false;
                    repeatSectionDuration += note.getDuration();
                    tempSongDuration += repeatSectionDuration * 2;
                    repeatSectionDuration = 0;
                } else if(countRepeat) { // If we are in the middle of a repeat
                    repeatSectionDuration += note.getDuration();
                } else { // If this is not a repeated section
                    tempSongDuration += note.getDuration();
                }
                // Add the note back at the end of the queue and increment our notes checked
                song.add(note);
                ++notesChecked;
            }
            songDuration = tempSongDuration;
        }
        return songDuration;
    }

    // Changes the duration of each note by the tempo given
    public void changeTempo(double tempo) {
        // Update the song duration if it has been calculated already
        if(songDuration != -1) {
            songDuration *= tempo;
        }
        int songLength = song.size();
        int notesUpdated = 0;
        // Make sure we update all of the notes
        while(notesUpdated != songLength) {
            // Remove the note from the queue to use it
            Note note = song.remove();
            // Get the duration and then set the duration to the old duration * tempo
            double duration = note.getDuration();
            note.setDuration(duration * tempo);
            // Add the note back at the end of the queue and increment our notes updated
            song.add(note);
            ++notesUpdated;
        }
    }

    // Reverses the order of the notes in the song
    public void reverse() {
        Stack<Note> reverseStoreNotes = new Stack<>();
        int songLength = song.size();
        int notesStored = 0;
        // Store all the notes on the stack
        while(notesStored != songLength) {
            // Remove the note from the queue to use it
            Note note = song.remove();
            // Push the note onto the stack
            reverseStoreNotes.push(note);
            // Increment our notes stored
            ++notesStored;
        }
        // Pop all of the notes from the stack and add them back to the queue
        while(!reverseStoreNotes.isEmpty()) {
            song.add(reverseStoreNotes.pop());
        }
    }

    // All of the notes from the given other song to the end of this song leaving
    // the other song unchanged
    public void append(Melody other) {
        int songLength = other.song.size();
        int notesAdded = 0;
        // Add all of the notes from the other song to this one
        while(notesAdded != songLength) {
            // Remove the note from the other song queue to use it
            Note note = other.song.remove();
            // Add the note this this song queue
            song.add(note);
            // Add the note back at the end of the other song queue and increment our notes added
            other.song.add(note);
            ++notesAdded;
        }
        // Add the duration of the other song to our song
        songDuration += other.songDuration;
    }

    // Plays the song by calling each note's play method
    public void play() {
        boolean repeat = false;
        Queue<Note> repeatSection = new LinkedList<Note>();
        int songLength = song.size();
        int notesPlayed = 0;
        // Play all of the notes of the song
        while(notesPlayed != songLength) {
            // Remove the note from the queue to use it
            Note note = song.remove();
            // Check to see if the note is the start of a repeated section
            note.play();
            if(note.isRepeat() && !repeat) { // if the note is a repeat and we have not started a repeat section yet
                repeat = true;
                repeatSection.add(note);
            } else if(note.isRepeat() && repeat) { // if the note is a repeat and we have already started a repeat section
                repeat = false;
                repeatSection.add(note);
                // Play the repeated section
                while(!repeatSection.isEmpty()) {
                    repeatSection.remove().play();
                }
            } else if(repeat) { // if we are in the middle of a repeat
                repeatSection.add(note);
            }
            // Play the note, add it back to the song queue, increment the notes played
            //note.play();
            song.add(note);
            ++notesPlayed;
        }
    }

    // Returns each note outputted on a separate line
    public String toString() {
        int songLength = song.size();
        int notesOutputted = 0;
        String output = "";
        // Make sure we check all of out notes;
        while(notesOutputted != songLength) {
            // Remove the note from the queue to use it
            Note note = song.remove();
            // Add each notes toString() call to a string.
            output += note.toString() + "\n";
            // Add the note back on the queue and increment the notes outputted
            song.add(note);
            ++notesOutputted;
        }
        return output;
    }
}
