import java.util.Random;
import java.util.Scanner;
public class Prototype
{
    //Variables
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    int monsterHP = 15;
    int playerHP = 100;
    int playerChoice;
    String user;

	public static void main(String[] args) 
	{
		Prototype game = new Prototype();
		game.playerSetup();
		game.gameStart();
	}

	public void playerSetup()
	{
	    System.out.println("--------------------------------------"); 
	    System.out.println("Welcome to Shadow's Embrace.");
	    System.out.print("Your adventure begins here. Please enter a name: ");
	    user = s.nextLine();
	}
	
	public void gameStart()
	{
		 //START OF GAME
	    System.out.println("---------------------------------------"); 
	    System.out.println(user +" You are a man fighting for your love of your life! You must rescue her in order for you to successfully finish this mission!");
	}
	

}	


