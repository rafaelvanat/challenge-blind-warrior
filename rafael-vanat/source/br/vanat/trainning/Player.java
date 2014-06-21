package br.vanat.trainning;

public class Player extends Character{

	public Player(){
		this.getWeapon().setDamage(40);
	}
	
	@Override
	public void lowerHealth(int damage) throws Exception{
		super.lowerHealth(damage);
		if(this.getHealth() <= 0){
			throw new Exception("The hero Zilska has fallen");
		}
	}
}
