package br.vanat.trainning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;

public class PlayerTest extends CharacterTest{
	private static final Logger logger = Logger.getLogger(PlayerTest.class);
	
	private Player player;
	private Enemy enemy;
	
	@Override
    public void setUp(){
        this.player = new Player();
        this.enemy = new Enemy();
    }
	
	@Override
	public void fight() throws Exception{
		int initialHealth = this.player.getHealth();
		this.enemy.fight(this.player);
		assertEquals("Actual life not matching expected life", (initialHealth - this.enemy.getWeapon().getDamage()), this.player.getHealth());
	}
	
	@Override
	public void die() throws Exception{
		super.getThrown().expect( Exception.class );
	    super.getThrown().expectMessage("The hero Zilska has fallen!");
	    
	    while(this.player.isAlive()){
	    	logger.info("PLAYER");
	    	this.enemy.fight(this.player);
	    }
		fail("The hero Zilska was expected to be dead");
	}
}