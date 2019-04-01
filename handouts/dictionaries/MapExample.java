/**
 * Example program showing how to use the Java Map
 */

import java.util.*;

public class MapExample
{
  public static void main(String[] args) {
    Map<String, String> bookMap = new HashMap<String, String>();
    
    // map key:value pairs of several Shakespeare titles
    // key = isbn
    // value = title
    bookMap.put("0174435894", "All's Well that Ends Well.");
    bookMap.put("0174436092", "Comedy of Errors");
    bookMap.put("0174436025", "Hamlet");
    bookMap.put("0174435584", "Macbeth");
    bookMap.put("0174436033", "Much Ado about Nothing");
    
    // now illustrate some map operations
    
    System.out.println("isbn 0174436025 is mapped to " + bookMap.get("0174436025"));
    System.out.println("isbn 0174436033 is mapped to " + bookMap.get("0174436033"));
    
    System.out.println("isbn 0174436032 is mapped to " + bookMap.get("0174436032"));
  }
}
