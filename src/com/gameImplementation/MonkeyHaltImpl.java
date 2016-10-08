package com.gameImplementation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.gameinterface.GameState;

public class MonkeyHaltImpl extends JPanel implements GameState {

	private MonkeyHopImpl my_engin = new MonkeyHopImpl();
	// private engin banana_engin = new engin();
	private int Parts_X[];
	private int Parts_Y[];
	private int direction = 2;
	private BufferedImage monkey, banana;
	private final MY_Thread mythread = new MY_Thread();
	private LineBorder my_border = new LineBorder(Color.black.darker(), 3);
	static int monkeyTime = 20;
	public static int bananaCount = 0;
	public static int bananaEaten = 0;

	/** Creates a new instance of myPanel */
	/** Creates a new instance of myPanel */
	public MonkeyHaltImpl() {

		setBorder(my_border);
		// mythread.setPriority(1);
		mythread.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		try {
			g2D.setColor(Color.RED);
			Parts_X = my_engin.return_Snake_postionsX();
			Parts_Y = my_engin.return_Snake_postionsY();
			for (int i = 0; i < my_engin.get_my_snake_lenght(); i++) {
				monkey = ImageIO.read(getClass().getResource("/images/monkey.jpg"));
				g.drawImage(monkey, Parts_X[0], Parts_Y[0], 40, 40, this);
			}
			banana = ImageIO.read(getClass().getResource("/images/banana.jpg"));
			g.drawImage(banana, my_engin.get_Food_X(), my_engin.get_Food_Y() + 5, 40, 40, this);
			g.drawString("Timer :" + monkeyTime, 50, 670);
			g.drawString("Banana target:7" + "     Bananas Eaten:" + bananaEaten, 500, 670);
			g.drawString("Score :" + MonkeyHopImpl.Score, 250, 670);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MY_Thread extends Thread {
		public void run() {
			while (true) {
				// my_engin.Move_mySnake(direction,false);
				monkeyTime -= 1;

				try {

					// snakeCheck.check_game_over();
					if (monkeyTime == 0) {
						bananaCount++;
						// Restart the game
						if (bananaCount < 7) {
							// Game restarts
							monkeyTime = 20;
							MonkeyEatImpl monkeyFood = new MonkeyEatImpl();
							monkeyFood.getFood();
							my_engin = new MonkeyHopImpl();

						} else if (bananaCount >= 7 && bananaEaten == bananaCount) {
							// win game
							JOptionPane.showConfirmDialog(null, "Score = " + Integer.toString(MonkeyHopImpl.Score),
									"Win Game Your Score", JOptionPane.DEFAULT_OPTION);
						} else {
							// Game lost
							JOptionPane.showConfirmDialog(null, "Score = " + Integer.toString(MonkeyHopImpl.Score),
									"Lost Game Your Score", JOptionPane.DEFAULT_OPTION);
						}

					}
					repaint();
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		}
	}

	public void set_Direction(int newDirection) {
		direction = newDirection;
		my_engin.monkey_run(direction, false);
		repaint();
	}

	public RestartCountDownImpl callEatBanana() {
		RestartCountDownImpl restart = my_engin.eatBanana();
		repaint();
		return restart;
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
	public RestartCountDownImpl eatBanana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameOverImpl TimerRestart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkGameOver() {
		// TODO Auto-generated method stub

	}

}
