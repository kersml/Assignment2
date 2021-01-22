/*Coded by Miller Kershaw
 * 1/22/21 1:54 PM
 * This program simulates a round of golf and shows the score for each hole and the total round
 * input: none
 * output: hole scores, total scores
 */
//GOLFER SUBJECT CLASS
package observerdesignpattern;
import java.util.ArrayList;
public class Golfer implements Subject {
	//object attributes
	ArrayList<Observer> observers;
	String name;
	//constructor
	public Golfer(String firstName)
	{
		observers = new ArrayList<Observer>();
		this.name = firstName;
	}
	//add an observer
	public void registerObserver(Observer observer) 
	{
		observers.add(observer);
	}
	//remove an observer
	public void removeObserver(Observer observer) 
	{
		observers.remove(0);
	}
	//update the scores for each observer, call display methods
	public void notifyObservers(int strokes, int par) 
	{
		HoleScoreDisplay test = new HoleScoreDisplay(this);
		for (Observer obs : observers)
		{
			obs.update(strokes, par);
		}
		test.displayCurrentScore();
		RoundScoreDisplay.displayRoundScore();
	}
	//take score input and send to observers
	public void enterScore(int strokes, int par)
	{
		this.notifyObservers(strokes, par);
	}
	//name access
	public String getName()
	{
		return this.name;
	}
}
