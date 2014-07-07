package br.vanat.trainning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CitizenTest extends CharacterTest{
	private static final Logger logger = Logger.getLogger(CitizenTest.class);
	
	private Player player;
	private Citizen citizen;
	
	@Override
    public void setUp(){
		this.citizen = new Citizen();
		this.player = new Player();
    }
	
	@Override
	public void fight() throws Exception{
		int initialHealth = this.citizen.getHealth();
		this.player.fight(this.citizen);
		assertEquals("Actual life not matching expected life", (initialHealth - this.player.getWeapon().getDamage()), this.citizen.getHealth());
	}
	
	@Override
	public void die() throws Exception{
		super.getThrown().expect( Exception.class );
	    super.getThrown().expectMessage("Zilska killed an inocent citizen!");
	    
	    int counter = 0;
	    while(this.citizen.isAlive()){
	    	logger.info("CITIZEN");
	    	this.player.fight(this.citizen);
	    	counter++;
	    	if(counter > 100){
	    		fail("Zilska should've killed an inocent citizen");
	    	}
	    }
		fail("Zilska should've killed an inocent citizen");
	}
	
	@Test
	public void citizenCannotHurt() throws Exception{
		int initialHealth = this.player.getHealth();
		this.citizen.fight(this.player);
		assertEquals("Actual life not matching expected life", initialHealth, this.player.getHealth());
	}
}
