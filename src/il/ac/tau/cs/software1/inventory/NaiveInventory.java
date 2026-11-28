package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	// TODO: add the fields:
	//       - an array of Collectibles (it may be larger than the number of items actually stored)
	//       - an int that counts how many items are actually stored
	private Collectible[] collectibles; 
	private int count;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.count = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (collectibles.length == count)
		{
			int newLength = collectibles.length * 2;
			Collectible[] newcCollectibles = new Collectible[newLength];
			for(int i = 0; i < collectibles.length; i++)
			{
				newcCollectibles[i] = collectibles[i];
			}
			collectibles = newcCollectibles;			
		}
		collectibles[count] = collectible;
		count++;
	}

	@Override
	public float getTotalWeight() {
		float total = 0;
		for(int i = 0; i < count; i++)
		{
			total += collectibles[i].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
