/**
 * This class overrides the hashCode() method
 * It also overrides equals().
 */ 
public class HashPerson
{
 public static final int PRIME = 1000003;
 private String name;

 public HashPerson(String name) {
  this.name = name;
 }

 public String toString() {
  return name;
 }

 /**
  * simple hashCode()
  */
 public int hashCode() {
  return 0;

  /**
   *  We will uncomment the following later in lab.
   */
   
    /*
  int result = 1;
  result = PRIME * result + name.hashCode();
  return result;
  */
 }


 /**
  * This overrides equals() from java.lang.Object
  * 
  * We will uncomment this method later in this lab.
  */
   
   /*    
 public boolean equals(Object rhs) {
  // first determine if they are the same object reference
  if (this == rhs)
   return true;

  // make sure they are the same class
  if (rhs == null || rhs.getClass() != getClass())
   return false;

  // ok, they are the same class. Cast rhs to HashPerson
  HashPerson other = (HashPerson)rhs;

  // our test for equality simply checks the name field
  if (!name.equals(other.name))
   return false;

  // if we get this far, they are equal
  return true;
 }
*/

}
