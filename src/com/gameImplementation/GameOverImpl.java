package com.gameImplementation;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.Position;


import com.gameinterface.GameState;

public class GameOverImpl implements GameState {

	private int headX = 20;
	private int headY = 20;
	private int[] PostionsX = new int[300];
	private int[] PostionsY = new int[300];

	private final int Oval_size = 20;

	public GameOverImpl() {
		for (int i = 0; i < 1; i++) {
			PostionsX[i] = 20;
			PostionsY[i] = 20;
		}
	}

	public void Move_monkey() {
		for (int i = 0; i < 1; i++) {
			PostionsX[1 - i] = PostionsX[1 - (i + 1)];
			PostionsY[1 - i] = PostionsY[1 - (i + 1)];
		}
		PostionsX[0] = headX;
		PostionsY[0] = headY;

	}

	public void put_Head_postion(int x, int y) {
		if (headX + x < 630 && headY + y < 630 && headX + x >= 0 && headY + y >= 0) {
			headX += x;
			headY += y;
		}

	}

	public boolean check_game_over() {

		return false;
	}

	public boolean compare_with_foodPostion(int x, int y) {
		for (int i = 0; i < 1; i++) {
			if (x == PostionsX[i] && y == PostionsY[i]) {
				return true;
			}
		}
		return false;
	}

	public void checkGameOver() {

		if (MonkeyHaltImpl.bananaCount >= 7 && MonkeyHaltImpl.bananaEaten == 7) {
			// win game
			JOptionPane.showConfirmDialog(null, "Score = " + Integer.toString(MonkeyHopImpl.Score),
					"Win Game Your Score",

			JOptionPane.DEFAULT_OPTION);

			System.exit(0);
		} else {
			// Game lost
			JOptionPane.showConfirmDialog(null, "Score = " + Integer.toString(MonkeyHopImpl.Score),
					"Lost Game Your Score", JOptionPane.DEFAULT_OPTION);
			System.exit(0);
		}

	}

	public int get_lenght() {
		return 1;
	}

	public int getOval_Size() {
		return Oval_size;
	}

	public int[] get_All_postionsX() {
		return PostionsX;
	}

	public int[] get_All_postionsY() {
		return PostionsY;
	}

	public int getHeadX() {
		return PostionsX[0];
	}

	public int getHeadY() {
		return PostionsY[0];
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
		return null;
	}

	@Override
	public RestartCountDownImpl callEatBanana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameOverImpl TimerRestart() {
		// TODO Auto-generated method stub
		return null;
	}

}
