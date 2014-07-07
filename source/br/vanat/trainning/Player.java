package br.vanat.trainning;

import java.util.Random;

import org.apache.log4j.Logger;

public class Player extends Character{
	private static final Logger logger = Logger.getLogger(Player.class);
	
	public Player(){
		super();
		Random rand = new Random();
		Weapon weapon = new Weapon(rand.nextInt(40), 0);
		this.setWeapon(weapon);
	}
	
	@Override
	public void setWeapon(Weapon weapon) {
		logger.info("PLAYER - setWeapon 1 - weapon damage = " + weapon.getDamage());
		Weapon newWeapon = weapon;
		if(weapon.getDamage() > 39){
			newWeapon = new Weapon(39, weapon.getTimesUsed(), weapon.getUsageLimit());
		}
		else if(weapon.getDamage() == 0){
			newWeapon = new Weapon(1, weapon.getTimesUsed(), weapon.getUsageLimit());
		}
		logger.info("PLAYER - setWeapon 2 - weapon damage = " + newWeapon.getDamage());
		super.setWeapon(newWeapon);
	}
	
	@Override
	protected void lowerHealth(int damage) throws Exception{
		super.lowerHealth(damage);
		if(this.getHealth() <= 0){
			throw new Exception("The hero Zilska has fallen!");
		}
	}
}
