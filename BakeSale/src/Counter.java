/**
 * A counter class which contains item name, counts and total counts.
 * 
 * @author Wendi Tang
 */
public class Counter {

	private String itemName;
	private int count;
	private static int totalCount;
	
	/**
	 * Overloaded constructor
	 * @param itemName The item name
	 * @param count The number of the item
	 */
	public Counter(String itemName, int count)
	{
		this.itemName = itemName;
		changeCount(true,count);
	}
	
	/**
	 * Reset counts and total counts
	 */
	public void reset()
	{
		totalCount -= count;
		count = 0;	
	}
	
	/**
	 * Change the count by 1
	 * @param increment either increment or decrement
	 * @return the count after change.
	 */
	public int changeCount(boolean increment)
	{
		changeCount(increment,1);
		return count;
	}
	
	/**
	 * Change the count by the given amount
	 * @param increment either increment or decrement
	 * @param amount	the total amount to change
	 * @return	the count after change applied
	 */
	public int changeCount(boolean increment,int amount)
	{
		if(increment)
		{
			count += amount;
			totalCount += amount;
		}
		else
		{
			count -= amount;
			totalCount -= amount;
		}
		
		return count;
	}
	
	/**
	 * Get the count
	 * @return the count
	 */
	public int   getCount()
	{
		return count;
	}
	/**
	 * Get total counts
	 * @return total counts
	 */
	public static int getTotalCount()
	{
		return totalCount;
	}
	
	/**
	 * To string
	 */
	public String toString()
	{
		return itemName+","+count+" left.";
	}
	
	/**
	 * Get item name
	 * @return the item name
	 */
	public String getItemName()
	{
		return itemName;
	}
}
