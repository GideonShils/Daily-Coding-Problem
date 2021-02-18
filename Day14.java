/*
*  DAY 14:
* 
*  The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
*
*  Hint: The basic equation of a circle is x2 + y2 = r2.
*
*/

/*
Imagine a circle with radius 1 centered at origin.
Also imagine a square with side length 2 centered at origin. This will perfectly fit the circle inside it.

If radius is 1, area or circle = pi
If side length of square is 2, then area = 4.

So ratio of circle area to square area = pi/4.

If we generate random points in this square, we can calculate the
ratio of num points in the circle to num points in the square, and calculate pi.

Since the equation of a circle is x2 + y2 = r2, and the radius is 1, then for
a point to fall inside the circle, x2+ y2 must be less than 1.

numPointsInCircle / numPointsInSquare = pi / 4
pi = (numPointsInCircle / numPointsInSquare) * 4
*/

public class Day14 {
  public static void main(String[] args) {
    int numTrials = 1000000;
    double pointsInSquare = 0;
    double pointsInCircle = 0;

    for (int i = 0; i < numTrials; i++) {
      pointsInSquare++;

      double x = Math.random();
      double y = Math.random();

      if ((x * x) + (y * y) < 1) {
        pointsInCircle++;
      }
    }

    double pi = (pointsInCircle / pointsInSquare) * 4;

    System.out.println(pi);
  }
}