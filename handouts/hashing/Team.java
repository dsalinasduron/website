/**
 * A class representing a team with a 
 * (1) name, and
 * (2) wins and losses.
 *
 * @author Greg Gagne 
 */

public class Team
{
 private String name;
 private int wins;
 private int losses;
 
 public Team(String name) {
  this.name = name;
 }

 public Team(String name, int wins, int losses) {
  this.name = name;
  this.wins = wins;
  this.losses = losses;
 }

 /**
  * this overrides equals() in java.lang.Object
  *
  * Two teams are considered equal if they have the same
  * number of wins and losses
  */
 public boolean equals(Object obj) {
  /**
   * return true if they are the same object
   */
  if (this == obj)
   return true;

  /**
   * the following two tests only need to be performed
   * if this class is directly derived from java.lang.Object
   */
  if (obj == null || obj.getClass() != getClass())
   return false;

  // we know obj is of type Team
  Team other = (Team)obj;

  // now test all pertinent fields ...

  if (wins != other.wins || losses!= other.losses)
   return false;
  
  // otherwise they are equal
  return true;
 }
 
 /**
  * This overrides hashCode() in java.lang.Object
  *
  * So to synchronize with equals(), hashCode()
  * is based upon wins, losses, and name.
  */
 public int hashCode() {
  int result = 1;

  result = HashUtilities.PRIME*result + wins;
  result = HashUtilities.PRIME*result + losses;

  return result;
 }
}
