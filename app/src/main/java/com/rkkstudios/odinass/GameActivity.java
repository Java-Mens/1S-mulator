package com.rkkstudios.odinass;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class GameActivity extends Activity {
	
	private LinearLayout gamemenuOrganism;
	private LinearLayout playerinfo;
	private LinearLayout gamebuttons;
	private CircleImageView avatarImage;
	private LinearLayout stats_linear;
	private TextView playernameText;
	private LinearLayout lvl_molecule;
	private LinearLayout hungry_molecule;
	private LinearLayout enjoy_molecule;
	private LinearLayout money_molecule;
	private TextView textlevel;
	private TextView level;
	private TextView hungertext;
	private TextView hunger;
	private TextView enjoytext;
	private TextView enjoy;
	private TextView moneytext;
	private TextView money;
	private Button oneassimulatorButton;
	private Button enjoyingButton;
	private Button shopButton;
	private Button tasksButton;
	
	private Intent ActivityChanger = new Intent();
	private SharedPreferences saver;
	private AlertDialog.Builder warn_start;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		gamemenuOrganism = findViewById(R.id.gamemenuOrganism);
		playerinfo = findViewById(R.id.playerinfo);
		gamebuttons = findViewById(R.id.gamebuttons);
		avatarImage = findViewById(R.id.avatarImage);
		stats_linear = findViewById(R.id.stats_linear);
		playernameText = findViewById(R.id.playernameText);
		lvl_molecule = findViewById(R.id.lvl_molecule);
		hungry_molecule = findViewById(R.id.hungry_molecule);
		enjoy_molecule = findViewById(R.id.enjoy_molecule);
		money_molecule = findViewById(R.id.money_molecule);
		textlevel = findViewById(R.id.textlevel);
		level = findViewById(R.id.level);
		hungertext = findViewById(R.id.hungertext);
		hunger = findViewById(R.id.hunger);
		enjoytext = findViewById(R.id.enjoytext);
		enjoy = findViewById(R.id.enjoy);
		moneytext = findViewById(R.id.moneytext);
		money = findViewById(R.id.money);
		oneassimulatorButton = findViewById(R.id.oneassimulatorButton);
		enjoyingButton = findViewById(R.id.enjoyingButton);
		shopButton = findViewById(R.id.shopButton);
		tasksButton = findViewById(R.id.tasksButton);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		warn_start = new AlertDialog.Builder(this);
		
		avatarImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ActivityChanger.setClass(getApplicationContext(), AvatarsActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		oneassimulatorButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (saver.getString("opengamer", "").equals("1")) {
					warn_start.setTitle("Приступить к работе?");
					warn_start.setMessage("Вы не сможете вернуться обратно, если начнёте задание.");
					warn_start.setPositiveButton("Я готов!", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							ActivityChanger.setClass(getApplicationContext(), SimulatorActivity.class);
							saver.edit().putString("opengamer", "0").commit();
							saver.edit().putString("aftergame", "2").commit();
							startActivity(ActivityChanger);
							finish();
						}
					});
					warn_start.setNegativeButton("Не готов", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					warn_start.create().show();
				}
				else {
					warn_start.setTitle("Упс...");
					warn_start.setMessage("Вы не приняли задание, а значит не можете работать!");
					warn_start.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					warn_start.create().show();
				}
			}
		});
		
		enjoyingButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ActivityChanger.setClass(getApplicationContext(), MemesActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		shopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ActivityChanger.setClass(getApplicationContext(), ShopActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		tasksButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ActivityChanger.setClass(getApplicationContext(), ChatActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		if (Double.parseDouble(saver.getString("avatar", "")) == 1) {
			avatarImage.setImageResource(R.drawable.cock1);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 2) {
			avatarImage.setImageResource(R.drawable.cock2);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 3) {
			avatarImage.setImageResource(R.drawable.cock3);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 4) {
			avatarImage.setImageResource(R.drawable.cock4);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 5) {
			avatarImage.setImageResource(R.drawable.cock5);
		}
		playernameText.setText(saver.getString("nick", ""));
		level.setText(saver.getString("level", ""));
		hunger.setText(saver.getString("hunger", ""));
		enjoy.setText(saver.getString("enjoy", ""));
		money.setText(saver.getString("money", ""));
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}