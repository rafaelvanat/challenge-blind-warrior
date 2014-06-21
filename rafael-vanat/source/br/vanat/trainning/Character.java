package br.vanat.trainning;

public abstract class Character {
	private int health;
	private Weapon weapon;
	
	public Character(){
		this.setWeapon(new Weapon());
		this.setInitialHealth();
	}
	
	protected void fight(Character enemy) throws Exception{
		enemy.lowerHealth(this.getWeapon().getDamage());
	}
	
	protected void setWeapon(Weapon newWeapon){
		this.weapon = newWeapon;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}

	public int getHealth() {
		return health;
	}

	private void setInitialHealth(){
		this.health = 100;
	}
	
	public void lowerHealth(int health) throws Exception {
		this.health = health;
	}
}
