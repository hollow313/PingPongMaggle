package com.retrogaming.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.retrogaming.pong.R;

public class Pong extends Activity {

	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.act_title);
		setListeners();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
            case R.id.menu_preferences:
			    Intent i = new Intent(this, PongPreferencesActivity.class);
			    startActivity(i);
			break;
		}
		return false;
	}
	
	
	protected void setListeners () {



        this.findViewById(R.id.imageView7)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Pong.this, NamePlayer.class);
                        startActivity(i);
                    }
                });

        this.findViewById(R.id.imageView8)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Pong.this, Score.class);
                        startActivity(i);
                    }
                });


		this.findViewById(R.id.title_btnOnePlayer)
		.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startGame(false,true);
			}
		});
		
		this.findViewById(R.id.title_btnTwoPlayer)
	    .setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startGame(true,true);
			}
		});
	}
	
	protected void startGame(boolean redPlayer, boolean bluePlayer) {
		Intent i = new Intent(this, GameActivity.class);
		i.putExtra(GameActivity.EXTRA_BLUE_PLAYER, bluePlayer);
		i.putExtra(GameActivity.EXTRA_RED_PLAYER, redPlayer);
		startActivity(i);
	}
	
	
	public static final String
		PREF_BALL_SPEED = "ball_speed",
		PREF_STRATEGY = "strategy",
		PREF_LIVES = "lives",
		PREF_HANDICAP = "handicap",
		PREF_MUTED = "muted";
	
	public static final String
		KEY_AI_STRATEGY = "key_ai_strategy";
}