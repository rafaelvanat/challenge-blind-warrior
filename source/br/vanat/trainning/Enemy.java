package br.vanat.trainning;

import java.util.Random;

public class Enemy extends Character{

	public Enemy(){
		super();
		Random rand = new Random();
		Weapon weapon = new Weapon(rand.nextInt(60), 0);
		this.setWeapon(weapon);
	}
	
	@Override
	public void setWeapon(Weapon weapon) {
		Weapon newWeapon = weapon;
		if(weapon.getDamage() > 59){
			newWeapon = new Weapon(59, weapon.getTimesUsed(), weapon.getUsageLimit());
		}
		else if(weapon.getDamage() == 0 && this instanceof Enemy){
			newWeapon = new Weapon(1, weapon.getTimesUsed(), weapon.getUsageLimit());
		}
		super.setWeapon(newWeapon);
	}
}
