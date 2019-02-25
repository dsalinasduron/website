import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody
{
   
    private Queue<Note> Song;
    private double tempo; 

    public Melody(Queue<Note> song)
    {
        this.Song = song;
        this.tempo = 1.0;
    }

    public double getTotalDuration()
    {
        double duration = 0.0;

        
        Queue<Note> calcQueue = new LinkedList<>();
        calcQueue.addAll(this.Song);

       
        while (calcQueue.peek() != null)
            duration += calcQueue.poll().getDuration();

        return duration;
    }

    public void changeTempo(double tempo)
    {
        
        this.tempo = tempo / 100;
    }

    public void reverse()
    {
        Stack<Note> reverseStack = new Stack<>();
        reverseStack.addAll(this.Song);
        this.Song.clear();

       
        while (!reverseStack.empty())
        {
            this.Song.add(reverseStack.pop());
        }
    }

    public void append(Melody other)
    {
        
        // Exercise proper data access, get it with the other object's consent!
        Song.addAll(other.getSong());
    }

    public void play()
    {
        
        Queue<Note> playQueue = new LinkedList<>();
        Queue<Note> repeatQueue = new LinkedList<>();
        Note currentNote;
        boolean isRepeating = false;

        // Set main queue
        playQueue.addAll(this.Song);

        
        while (playQueue.peek() != null)
        {
            currentNote = playQueue.poll();

            // Check for repeats, set proper mode
            if (currentNote.isRepeat() &! isRepeating)
            {
                isRepeating = true;
                repeatQueue.add(currentNote);
                continue;
            }

            // Fill in secondary queue
            if (isRepeating)
                repeatQueue.add(currentNote);

            // Check again for mode, playback if necessary
            if (isRepeating && currentNote.isRepeat())
            {
                isRepeating = false;

                while (repeatQueue.peek() != null)
                {
                    // Should be safe to reuse
                    currentNote = repeatQueue.poll();

                    StdAudio.play(
                            currentNote.getDuration() / this.tempo,
                            currentNote.getPitch(),
                            currentNote.getOctave(),
                            currentNote.getAccidental()
                    );
                }

                // Don't play current note again, it was the last element
                // of the secondary queue
                continue;
            }

            StdAudio.play(
                    currentNote.getDuration() / this.tempo,
                    currentNote.getPitch(),
                    currentNote.getOctave(),
                    currentNote.getAccidental()
            );
        }
    }

    public Queue<Note> getSong()
    {
        return this.Song;
    }

    public String toString()
    {
        
        return Song.toString() + System.getProperty("line.separator");
    }
}
