package main;

import java.io.IOException;

import playerClasses.Warrior;
import playerClasses.Wizard;
import weaponsClasses.LongSword;
import weaponsClasses.Knife;

public class testeDrive {

	public static void main(String[] args) throws IOException {

		Warrior guerreiro = new Warrior(6);
		guerreiro.setWeapon(new LongSword(10));
		guerreiro.displayEstatics();
		
		Wizard mago = new Wizard(10);
		mago.setWeapon(new Knife(10));
		mago.displayEstatics();
		mago.setWeapon(new LongSword(10));
		mago.displayEstatics();

	}

}
