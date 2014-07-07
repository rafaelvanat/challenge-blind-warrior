package br.vanat.trainning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class GameTest{
	private static final Logger logger = Logger.getLogger(GameTest.class);
	
	private Game game;
	private List<Enemy> enemies;
	
	@Before
    public void setUp(){
		newGame();
		this.enemies = this.game.createEnemyList();
	}
	
	@Test
	public void verifyCreatedEnemyListSize(){
		logger.info("verifyCreatedEnemyListSize - " + this.enemies.size() + " - " + (GameParam.ENEMY_NUMBER + GameParam.CITIZEN_NUMBER));
		assertEquals("Total number of enemies not ok", GameParam.ENEMY_NUMBER + GameParam.CITIZEN_NUMBER, this.enemies.size());
	}
	
	@Test
	public void verifyNumberOfCitizenInEnemyList(){
		int countCitizen = 0;
		for (Enemy enemy : this.enemies) {
			if(enemy instanceof Citizen){
				countCitizen++;
			}
		}
		logger.info("verifyNumberOfCitizenInEnemyList - " + countCitizen + " - " + GameParam.CITIZEN_NUMBER);
		assertEquals("Total number of citizen not ok", GameParam.CITIZEN_NUMBER, countCitizen);
	}
	
	@Test
	public void endGameClauseZilskaKilled(){
		logger.debug("TEST - endGameClauseZilskaKilled");
		boolean zilskaKilled = endGameClause("The hero Zilska has fallen!");
		logger.debug("TEST - endGameClauseZilskaKilled");
		assertEquals("In no game Zislka was killed, seems buggy", true, zilskaKilled);
	}
	
	@Test
	public void endGameClauseInnocentKilled(){
		logger.debug("TEST - endGameClauseInnocentKilled");
		boolean innocentKilled = endGameClause("Zilska killed an inocent citizen!");
		logger.debug("TEST - endGameClauseInnocentKilled");
		assertEquals("In no game Zislka killed an innocent citizen, seems buggy", true, innocentKilled);
	}
	
	@Test
	public void getLog4jProperties(){
		assertEquals("Log4j.properties is not ok", false, Game.getLog4jProperties().isEmpty());
	}
	
	private boolean endGameClause(String endGameClause){
		boolean clauseMatched = false;
		ArrayList<Exception> endGameCauseList = new ArrayList<Exception>();
		for (int i = 0; i < 10; i++) {
			logger.info("endGameClause - NEW GAME - " + i);
			endGameCauseList.add(newGame());
		}
		for (Exception exception : endGameCauseList) {
			logger.info("END GAME CAUSE = " + exception.getMessage() + " - EXPECTED = " + endGameClause);
			if(exception != null && exception.getMessage().equalsIgnoreCase(endGameClause)){
				clauseMatched = true;
				break;
			}
		}
		return clauseMatched;
	}
	
	private Exception newGame(){
		this.game = new Game();
		return this.game.newGame();
	}
}