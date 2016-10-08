package com.gameImplementation;

import com.gameinterface.GameState;

public class RestartCountDownImpl implements GameState {
	
	
	public GameOverImpl TimerRestart(){
		
		
			// Game restarts
			MonkeyHaltImpl.monkeyTime = 20;
		 
		
		return new GameOverImpl();
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
	public void checkGameOver() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
