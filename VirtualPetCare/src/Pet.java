import java.util.Random;

public class Pet {

	private String name;
	private int happiness = 100;
	private int hunger = 0;
	private Random rand = new Random();

	public Pet(String name) {
		this.name = name;
	}

	public void play() {
		if (happiness < 100) {
			increaseHappiness();
			switch (rand.nextInt(3)) {
			case 0:
				System.out
						.println("You played flirt pole with your pet. Your pet looks happy!");
				break;
			case 1:
				System.out
						.println("You played water hose with your pet. Your pet looks happy!");
				break;
			case 2:
				System.out
						.println("You played tug of war with your pet. Your pet looks happy!");
				break;
			case 3:
				System.out
						.println("You played ball games with your pet. Your pet looks happy!");
				break;
			}
		} else {
			System.out
					.println("You Pet doesn't want to play game with you now.");
		}

	}

	public void feed(boolean treat) {
		if(hunger > 0)
		{
		if(treat)
		{
			increaseHappiness();
		}
		decreaseHunger();
		}else
		{
			System.out.println("Your pet is not hungery.");
		}
	}

	public void live() {
		if(rand.nextInt(9) <=5)
		{
			increaseHunger();
		}
		if(rand.nextInt(9)<=3)
		{
			decreaseHappiness();
		}
	}

	public String toString() {
		return "Name: " + name + "\n" + "Happiness: " + happiness + "\n"
				+ "hunger: " + hunger;

	}

	public String getName() {
		return name;
	}
	
	private void increaseHappiness()
	{
		happiness = (100 < happiness + 10) ? 100 : happiness + 10;
	}
	private void decreaseHappiness()
	{
		happiness = (0 > happiness - 10) ? 0 : happiness - 10;
	}
	
	private void increaseHunger()
	{
		hunger = (100 < hunger + 10) ? 100 : hunger + 10;
	}
	
	private void decreaseHunger()
	{
		hunger = (0 > hunger - 10) ? 0 : hunger - 10;
	}
}
