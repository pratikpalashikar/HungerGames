package com.gameImplementation;

import javax.swing.JOptionPane;

import com.gameinterface.GameState;
import com.gameImplementation.GameOverImpl;

public class MonkeyHopImpl implements GameState {

	private int direction = 2;
	private boolean Game_Over;
	private boolean Moving_vertical = false;
	private GameOverImpl GameOverImpl = new GameOverImpl();
	private final MonkeyEatImpl monkeyFood = new MonkeyEatImpl();
	private int step_to_move = 20;
	static int Score;

	public void monkey_run(int newDirection, boolean food_eaten) {

		if (!Game_Over) {
			switch (newDirection) {
			case 1:
				GameOverImpl.put_Head_postion(0, -step_to_move);
				break;// UP
			case 2:
				GameOverImpl.put_Head_postion(step_to_move, 0);
				break;// RIGHT
			case 3:
				GameOverImpl.put_Head_postion(0, step_to_move);
				break;// DOWN
			case 4:
				GameOverImpl.put_Head_postion(-step_to_move, 0);
				break;// LEFT
			}

			this.setGameOverImpl(GameOverImpl);

			GameOverImpl.Move_monkey();

		}

	}

	public boolean check_food_place() {
		int xfood = (int) monkeyFood.getX();
		int yfood = (int) monkeyFood.getY();
		if (xfood > 800 || yfood > 800)
			return true;
		else
			return GameOverImpl.compare_with_foodPostion(xfood, yfood);
	}

	public int[] return_Snake_postionsX() {
		return GameOverImpl.get_All_postionsX();
	}

	public int[] return_Snake_postionsY() {
		return GameOverImpl.get_All_postionsY();
	}

	public int get_Oval_size() {
		return GameOverImpl.getOval_Size();
	}

	public int get_my_snake_lenght() {
		return GameOverImpl.get_lenght();
	}

	public void set_step_length() {
		step_to_move = 5;
	}

	public int get_Food_X() {
		return (int) monkeyFood.getX();
	}

	public int get_Food_Y() {
		return (int) monkeyFood.getY();
	}

	public boolean get_Game_over() {
		return Game_Over;
	}

	@Override
	public MonkeyHopImpl startCountDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonkeyHopImpl motion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set_Direction(int i) {

		// TODO Auto-generated method stub

	}

	@Override
	public RestartCountDownImpl eatBanana() {
		// TODO Auto-generated method stub

		if ((GameOverImpl.getHeadX() == monkeyFood.get_int_X())
				&& (GameOverImpl.getHeadY() == monkeyFood.get_int_Y())) {
			monkeyFood.getFood();
			Score += 20;
			MonkeyHaltImpl.bananaEaten += 1;
			MonkeyHaltImpl.bananaCount += 1;

			while (check_food_place()) {
				monkeyFood.getFood();
			}

		}

		return new RestartCountDownImpl();
	}

	public GameOverImpl getGameOverImpl() {
		return GameOverImpl;
	}

	public void setGameOverImpl(GameOverImpl gameOverImpl) {
		GameOverImpl = gameOverImpl;
	}

	@Override
	public RestartCountDownImpl callEatBanana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.gameImplementation.GameOverImpl TimerRestart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkGameOver() {
		// TODO Auto-generated method stub

	}

}
