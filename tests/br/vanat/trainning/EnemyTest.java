package br.vanat.trainning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;

public class EnemyTest extends CharacterTest {
	private static final Logger logger = Logger.getLogger(EnemyTest.class);
	private Player player;
	private Enemy enemy;
	
	@Override
	public void setUp() {
		this.player = new Player();
		this.enemy = new Enemy();
	}

	@Override
	public void fight() throws Exception {
		int initialHealth = this.enemy.getHealth();
		this.player.fight(this.enemy);
		assertEquals("Actual life not matching expected life", (initialHealth - this.player.getWeapon().getDamage()), this.enemy.getHealth());
	}

	@Override
	public void die() throws Exception {
		while(this.enemy.isAlive()){
			logger.info("ENEMY");
			this.player.fight(this.enemy);
		}
	    assertFalse("Enemy died as expected", this.enemy.isAlive());
	}

}
