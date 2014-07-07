package br.vanat.trainning;

import org.apache.log4j.Logger;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public abstract class Character {
	private static final Logger logger = Logger.getLogger(Character.class);
	
	@Setter(AccessLevel.NONE) private int health;
	private String name;
	private Weapon weapon;
	private boolean alive;
	
	public Character(){
		this.setInitialHealth();
		this.setName(this.getClass().getSimpleName() + this.hashCode());
		this.setAlive(true);
	}
	
	public void fight(Character enemy) throws Exception{
		enemy.lowerHealth(this.getWeapon().getDamage());
		enemy.setAlive((enemy.getHealth() > 0));
		logger.info(this.getName() +  " damages " + enemy.getName() + ". Damage taken = " + this.getWeapon().getDamage() + ". Remaing health = " + enemy.getHealth());
	}
	
	private void setInitialHealth(){
		this.health = 100;
	}
	
	protected void lowerHealth(int damage) throws Exception {
		this.health = this.health - damage;
	}
}
