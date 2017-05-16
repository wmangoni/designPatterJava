package playerClasses;

import java.util.Random;

public class Wizard extends Player{
	
	public Wizard(int level) {
		
		Random randomGenerator = new Random();

		this.level = level;
		this._str = randomGenerator.nextInt(4) + 8 + this.factorLevel(level);
		this._dex = randomGenerator.nextInt(4) + 10;
		this._con = randomGenerator.nextInt(6) + 10;
		this._int = randomGenerator.nextInt(4) + 13;
		this._wis = randomGenerator.nextInt(4) + 14;
		this._cha = randomGenerator.nextInt(4) + 12;

		this.recalculateParams(this.factorLevel(level));
		this.calculateBba();
		this.nome = "Wizard";
	}
	
	public void calculateBba() {
		this.bba = (int) Math.ceil(this.level - 1 / 2);
	}

}
