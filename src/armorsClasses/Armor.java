package armorsClasses;

public class Armor {
	
	protected String name;
	protected int bonusCa;
	protected int durability;
	
	public Armor() {
		//nada aqui
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBonusCa() {
		return bonusCa;
	}

	public void setBonusCa(int bonusCa) {
		this.bonusCa = bonusCa;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

}
