package br.vanat.trainning;

import lombok.Getter;

@Getter
public class Weapon {
	private int damage;
	private int timesUsed;
	private int usageLimit;

	public Weapon(int newDamage, int newTimesUsed) {
		this.setDamage(newDamage);
		this.timesUsed = newTimesUsed;
		this.usageLimit = -1; /* XXX: As stands in game rules (Skullabs)*/
	}
	
	public Weapon(int newDamage, int newTimesUsed, int newUsageLimit) {
		this.setDamage(newDamage);
		this.timesUsed = newTimesUsed;
		this.usageLimit = -1; /* XXX: As stands in game rules (Skullabs)*/
	}
	
	private void setDamage(int newDamage){
		if(newDamage < 0){
			newDamage = 0;
		}
		this.damage = newDamage;
	}
}
