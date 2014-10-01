
public class RPSPlayer {

	private String name = "";
	private int score = 0;
	private String choice = "rock";
	
	public class NoSuchChoiceException extends Exception
	{
	      public NoSuchChoiceException() {}

	      public NoSuchChoiceException(String message)
	      {
	         super(message);
	      }
	 }

	public RPSPlayer(String name){
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getChoice()
	{
		return choice;
	}
	
	public int increaseScore()
	{
		return ++score;
	}
	
	public void setChoice(String choice) throws NoSuchChoiceException
	{
		if(choice.equalsIgnoreCase(RPSGame.ROCK)||choice.equalsIgnoreCase(RPSGame.SCISSORS)||choice.equalsIgnoreCase(RPSGame.PAPER))
		{
			this.choice = choice;
		}
		else
		{
			this.choice = RPSGame.ROCK;
			throw new NoSuchChoiceException("Invalid input. Use the default choice Rock");
		}
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
