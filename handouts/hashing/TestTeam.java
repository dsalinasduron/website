public class TestTeam
{
 public static void main(String[] args) {
  Team a = new Team("Eagles",6,2);
  Team b = new Team("Ducks",6,2);

  System.out.println(a.hashCode());
  System.out.println(b.hashCode());

  if (a.equals(b))
   System.out.println("Yes - They are equal");
  else
   System.out.println("No - They are not equal");
 }
}
