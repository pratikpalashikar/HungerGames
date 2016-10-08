package com.gameContext;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import javax.swing.JFrame;

import com.gameImplementation.MonkeyHaltImpl;
import com.gameinterface.GameState;

public class HungerGames extends JApplet implements KeyListener {

	GameState state, gameoverstate;

	private final int LEFT = 37;
	private final int RIGHT = 39;
	private final int UP = 38;
	private final int DOWN = 40;

	MonkeyHaltImpl grass = new MonkeyHaltImpl();

	public void init() {
		setSize(800, 800);
		Container cpane = getContentPane();
		// initalize the grass
		grass.setBackground(Color.GREEN);
		cpane.add(grass);
		addKeyListener(this);
	}

	public void startGameFrame() {

		HungerGames game = new HungerGames();
		JFrame myFrame = new JFrame("Monkey Banana Game");
		myFrame.setSize(750, 750);
		myFrame.getContentPane().add(game);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.addKeyListener(game);
		game.init();
		game.start();
		game.setVisible(true);
		myFrame.setVisible(true);

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		this.setState(grass);
		if (e.getKeyCode() == UP) {
			state.set_Direction(1);
		} else if (e.getKeyCode() == RIGHT) {
			state.set_Direction(2);
		} else if (e.getKeyCode() == DOWN) {
			state.set_Direction(3);
		} else if (e.getKeyCode() == LEFT) {
			state.set_Direction(4);
		}
		int x = MonkeyHaltImpl.bananaEaten;
		state = state.callEatBanana();
		// Timer restart if banana is less than 7
		if (MonkeyHaltImpl.bananaCount < 7 && x < MonkeyHaltImpl.bananaEaten) {
			state = state.TimerRestart();
			this.setGameoverstate(state);
		} else if (MonkeyHaltImpl.bananaCount == 7) {
			gameoverstate.checkGameOver();
		}
	}

	public GameState getGameoverstate() {
		return gameoverstate;
	}

	public void setGameoverstate(GameState gameoverstate) {
		this.gameoverstate = gameoverstate;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public GameState getState() {
		return state;
	}

	@Override
	public void keyReleased(KeyEvent paramKeyEvent) {

	}

	public static void main(String[] args) {
		HungerGames hg = new HungerGames();
		hg.startGameFrame();
	}

}
