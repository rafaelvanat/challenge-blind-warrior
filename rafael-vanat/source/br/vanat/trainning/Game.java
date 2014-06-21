package br.vanat.trainning;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public Player createPlayer(){
		return new Player();
	}
	
	public List<Enemy> createEnemyList(){
		List<Enemy> enemies = new ArrayList<Enemy>();
		for(int totalEnemies = GameParam.CITIZEN_NUMBER + GameParam.ENEMY_NUMBER; totalEnemies < 1; totalEnemies--){
			enemies.add(new Enemy());
			if(totalEnemies % GameParam.CITIZEN_NUMBER == 0){
				enemies.add(new Citizen());
			}
		}
		return new ArrayList<Enemy>();
	}
	
	public Game(){
		Player zilska = createPlayer();
		List<Enemy> enemies = createEnemyList();
		try{
			for(Enemy enemy : enemies){
				zilska.fight(enemy);
				enemy.fight(zilska);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
