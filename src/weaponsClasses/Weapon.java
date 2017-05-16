package weaponsClasses;

import java.util.Random;

public class Weapon {
	
	protected String name;
	protected String dice;
	protected int damageMin = 0;
	protected int damageMax = 0;
	protected int durability;
	
	public Weapon() {
		//nada aqui
	}
	
	public int damage() {
		return this.getRandFactory();
	}
	public String getDice() {
		return this.dice;
	}
	public void setDamageMin(int dm) {
		this.damageMin = dm;
	}
	public void setDamageMax(int dm) {
		this.damageMax = dm;
	}
	public String getName() {
		return this.name;
	}
	public int getRandFactory() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(this.damageMax) + this.damageMin;
	}
	public void reduceDurability(int dano) {
		this.durability -= dano;
	}
	public void recalculateParams() {
		String[] damage = this.dice.split("d");
		this.setDamageMin( Integer.parseInt(damage[0]) );
		this.setDamageMax( Integer.parseInt(damage[0]) * Integer.parseInt(damage[1]) );
	}
	
}
