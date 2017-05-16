package weaponsClasses;

public class Knife extends Weapon{

	public Knife(int durability) {
		this.name = "Kinfe";
		this.dice = "1d4";
		this.durability = durability;
		this.recalculateParams();
	}
	
}
