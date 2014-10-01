import java.util.HashMap;
import java.util.Map;


public class RPSGame {

	protected static final String ROCK = "rock";
	protected static final String SCISSORS = "scissors";
	protected static final String PAPER = "paper";
	public RPSPlayer player1;
	public RPSPlayer player2;
	private static final Map<String,Integer> MAP = new HashMap<String,Integer>();
	
	static {
	     MAP.put( ROCK, 0 );
	     MAP.put( SCISSORS, 1 );
	     MAP.put( PAPER, 2 );
	 }
	
	public RPSGame()
	{
		player1 = new RPSPlayer("player1");
		player2 = new RPSPlayer("Player2");
	}

	
	public void determineWinner()
	{
		switch((3 + MAP.get(player1.getChoice()) - MAP.get(player2.getChoice())) % 3)
		{
		case 1:
			player2.increaseScore();
			break;
		case 2:
			player1.increaseScore();
			break;
		case 0:
			break;
			
			
		}
	}
	
	public String toString()
	{
		return "Current Score:	"+player1.getName()+" - " + player1.getScore() +"	"+"Your Rival - "+player2.getScore();
	}
	
}
