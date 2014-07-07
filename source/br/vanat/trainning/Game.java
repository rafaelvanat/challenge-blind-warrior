package br.vanat.trainning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import lombok.Getter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Game {
	private static final Logger logger = Logger.getLogger(Game.class);
	private static final int TOTAL_ENEMIES = (GameParam.CITIZEN_NUMBER + GameParam.ENEMY_NUMBER);
	
	@Getter private List<Enemy> deadEnemies = new ArrayList<Enemy>();
	
	public Player createPlayer(){
		return new Player();
	}
	
	public List<Enemy> createEnemyList(){
		List<Enemy> enemies = new ArrayList<Enemy>();
		for(int totalEnemies = TOTAL_ENEMIES; totalEnemies > 0; totalEnemies--){
			if(totalEnemies % GameParam.CITIZEN_NUMBER == 0){
				enemies.add(new Citizen());
			}
			else{
				enemies.add(new Enemy());
			}
		}
		return enemies;
	}
	
	public Exception newGame(){
		Player zilska = createPlayer();
		List<Enemy> enemies = createEnemyList();
		Exception endClause = null;
		try{
			battle(zilska, enemies);
		}
		catch (Exception e) {
			endClause = e;
			logger.info(e.getMessage());
		}
		finally{
			battleResult(endClause);
		}
		return endClause;
	}
	
	private void battleResult(Exception e) {
		logger.info("BATTLE HAS COME TO AN END. SEE THE RESULTS");
		logger.info("END REASON = " + ((e != null) ? e.getMessage() : ""));
		logger.info("DEAD ENEMIES = " + this.getDeadEnemies().size());
	}

	private void battle(Player zilska, List<Enemy> enemies) throws Exception{
		int totalEnemiesFought = 0;
		Random rand = new Random();
		while(totalEnemiesFought < TOTAL_ENEMIES){
			int index = rand.nextInt(TOTAL_ENEMIES);
			if(enemies.get(index).isAlive()){
				this.fight(zilska, enemies.get(index));
				totalEnemiesFought++;
			}
		}
	}
	
	private void fight(Player zilska, Enemy enemy) throws Exception {
		do {
			zilska.fight(enemy);
			if(enemy.isAlive()){
				enemy.fight(zilska);
			}
		} while(enemy.isAlive());
		this.getDeadEnemies().add(enemy);
	}

	public static void main(String args[]) {
		PropertyConfigurator.configure(getLog4jProperties());
		Game game = new Game();
		game.newGame();
	}
	
	public static Properties getLog4jProperties(){
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
