package br.vanat.trainning;

public class Citizen extends Enemy{

	public Citizen(){
		this.getWeapon().setDamage(0);
	}
	
	@Override
	public void lowerHealth(int damage) throws Exception{
		super.lowerHealth(damage);
		if(this.getHealth() <= 0){
			throw new Exception("Zilska killed an inocent citizen!");
		}
	}
}
