package observerdesignpattern;
//HOLE SCORE DISPLAY OBSERVER CLASS
import java.lang.Math;
public class HoleScoreDisplay implements Observer{
	//object attributes
	Subject golfer;
	int strokes;
	int par;
	//constructor
	public HoleScoreDisplay(Subject golfer)
	{
		this.golfer = golfer;
		this.golfer.registerObserver(this);
	}
	//overridden observer update method
	public void update(int strokes, int par) 
	{
		this.strokes = strokes;
		this.par = par;
	}
	//display
	public void displayCurrentScore()
	{
		System.out.println("Current Hole Stats:");
		System.out.println("Par: " + this.par);
		System.out.println("Strokes: " + this.strokes);
		int underOver = this.strokes - this.par;
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
