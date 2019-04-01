/**
 * Simple example demonstrating using the hashCode() method.
 */

public class HashExamples
{
  public static void main(String[] args) {
    String s = new String("Hello");
    
    Integer i = new Integer(15);
    
    // R/B/G parameters
    java.awt.Color c = new java.awt.Color(135, 215, 100);
    
    // get a hash of this object
    HashExamples t = new HashExamples();
    
    // now obtain the hash codes for each of these objects
    
    System.out.println("Hash code of String 'Hello' is: " + s.hashCode());
    System.out.println("Hash code of 15 is: " + i.hashCode());
    System.out.println("Hash code of Color object is: " + c.hashCode());
    System.out.println("Hash code of this object is: " + t.hashCode());
  }
}
    