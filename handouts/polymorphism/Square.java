public class Square implements Shape
{
  private double length;
  private double width;
  
  public Square(double length, double width) {
    this.length = length;
    this.width = width;
  }
  
  public double getArea() {
    return length * width;
    //return 0;
  }
  
  public double getPerimeter() {
    //return 0;
    return length * 2 + width * 2;
  }
  
}
  
  
  
  