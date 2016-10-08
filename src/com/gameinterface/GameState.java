package com.gameinterface;

import com.gameImplementation.GameOverImpl;
import com.gameImplementation.MonkeyHopImpl;
import com.gameImplementation.RestartCountDownImpl;

public interface GameState {
	
	public MonkeyHopImpl startCountDown();
	public com.gameImplementation.MonkeyHopImpl motion();
	public void set_Direction(int i);
	public RestartCountDownImpl eatBanana();
	public RestartCountDownImpl callEatBanana();
	public GameOverImpl TimerRestart();
	public void checkGameOver();

}
