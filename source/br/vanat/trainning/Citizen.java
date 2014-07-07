package br.vanat.trainning;

public class Citizen extends Enemy{

	public Citizen(){
		super();
		Weapon weapon = new Weapon(0, 0);
		this.setWeapon(weapon);
	}
	
	@Override
	public void fight(Character enemy) throws Exception{
		if(!(enemy instanceof Player)){
			super.fight(enemy);
		}
	}
	
	@Override
	public void setWeapon(Weapon weapon) {
		super.setWeapon(new Weapon(0, weapon.getTimesUsed(), weapon.getUsageLimit()));
	}
	
	@Override
	protected void lowerHealth(int damage) throws Exception{
		super.lowerHealth(damage);
		if(this.getHealth() <= 0){
			throw new Exception("Zilska killed an inocent citizen!");
		}
	}
}
