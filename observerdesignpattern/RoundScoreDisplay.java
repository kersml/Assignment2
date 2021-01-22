//ROUND SCORE DISPLAY OBSERVER CLASS
package observerdesignpattern;
import java.lang.Math;
public class RoundScoreDisplay implements Observer {
	//object attributes
	Subject golfer;
	static int strokesTotal;
	static int parTotal;
	//constructor
	public RoundScoreDisplay(Subject golfer)
	{
		this.golfer = golfer;
		this.golfer.registerObserver(this);
	}
	//overridden observer update method
	public void update(int strokes, int par)
	{
		strokesTotal = strokesTotal + strokes;
		parTotal = parTotal + par;
	}
	//display
	public static void displayRoundScore()
	{
		System.out.println("Round Stats:");
		System.out.println("Par: " + parTotal);
		System.out.println("Strokes: " + strokesTotal);
		int underOver = strokesTotal - parTotal;
		if (underOver == 0)
		{
			System.out.println("Made par");
		}
		else if(underOver < 0)
		{
			System.out.println(Math.abs(underOver) + " under par");
		}
		else
		{
			System.out.println(underOver + " over par");
		}
		System.out.println();
	}
}
