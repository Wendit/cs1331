import java.util.Random;
import java.util.Scanner;

public class RPSTournament {

	public RPSTournament() {
	}

	public static void main(String args[]) {
		String name = "Player1";
		Scanner scan = new Scanner(System.in);
		RPSGame game = new RPSGame();
		int count = 0;
		System.out.println("Welcome to the rock,scissors,paper game!");
		System.out.println("Please enter your name:");
		name = scan.nextLine();
		game.player1.setName(name);
		
		while (count == 0) {
			System.out
					.println("Please enter the number of games you wish to play:");
			try{
			count = Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e)
			{
				System.err.println("Number format exception, please enter a valid number.");
				count = 0;
			}
		}
		game.player2.setName("Computer");
		
		for(int i = count; i >0; i--)
		{
			
			System.out.println(game.player1.getName() + " ,enter your choice:");
			try {
				game.player1.setChoice(scan.nextLine().toLowerCase());
				game.player2.setChoice(generateChoice());
			} catch (RPSPlayer.NoSuchChoiceException e) {
				System.err.println(e.getMessage());
			}	
			System.out.println("Your Rival choose: "+game.player2.getChoice());
			game.determineWinner();
			System.out.println(game.toString() + "\n");
		}
		
		if(game.player1.getScore() == game.player2.getScore())
		{
			System.out.println("Draw!");
		}
		else 
		{
			System.out.print((game.player1.getScore() >game.player2.getScore())?
					game.player1.getName():game.player2.getName());
			System.out.print(" won, with "+((game.player1.getScore() >game.player2.getScore())?
					game.player1.getScore():game.player2.getScore())+"/"+count + " total games");
		}
	}
	
	private static String generateChoice()
	{
		Random rand = new Random();
		switch(rand.nextInt(3))
		{
			case 0: return RPSGame.ROCK;
			case 1: return RPSGame.SCISSORS;
			case 2: return RPSGame.PAPER;
				
		}
		return RPSGame.ROCK;
	}
}
