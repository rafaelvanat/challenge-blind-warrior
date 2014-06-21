package br.vanat.trainning;

import lombok.Data;

@Data
public class Weapon {
	private int damage;
	private int timesUsed;
	private int usageLimit;

	public Weapon() {
		setUsageLimit(-1);
	}
}
