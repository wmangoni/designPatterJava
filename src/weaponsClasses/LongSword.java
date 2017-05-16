package weaponsClasses;

public class LongSword extends Weapon{
	
	public LongSword(int durability) {
		this.name = "Long Sword";
		this.dice = "1d8";
		this.durability = durability;
		this.recalculateParams();
	}

}
