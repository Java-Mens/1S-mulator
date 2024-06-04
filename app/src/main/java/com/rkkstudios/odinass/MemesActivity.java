package com.rkkstudios.odinass;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
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
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MemesActivity extends Activity {
	
	private LinearLayout linear5;
	private ScrollView enjoy_vscroll;
	private TextView textview6;
	private TextView money;
	private TextView textview8;
	private TextView enjoy;
	private LinearLayout enjoyOrganism;
	private LinearLayout fun_things;
	private LinearLayout anecdots;
	private TextView fun_textview;
	private Button funbutton1;
	private Button funbutton2;
	private Button funbutton3;
	private Button funbutton4;
	private TextView anecdot_textview;
	private TextView funny_text;
	private Button buyanecdotbutton;
	
	private Intent ActivityChanger = new Intent();
	private SharedPreferences saver;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.memes);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear5 = findViewById(R.id.linear5);
		enjoy_vscroll = findViewById(R.id.enjoy_vscroll);
		textview6 = findViewById(R.id.textview6);
		money = findViewById(R.id.money);
		textview8 = findViewById(R.id.textview8);
		enjoy = findViewById(R.id.enjoy);
		enjoyOrganism = findViewById(R.id.enjoyOrganism);
		fun_things = findViewById(R.id.fun_things);
		anecdots = findViewById(R.id.anecdots);
		fun_textview = findViewById(R.id.fun_textview);
		funbutton1 = findViewById(R.id.funbutton1);
		funbutton2 = findViewById(R.id.funbutton2);
		funbutton3 = findViewById(R.id.funbutton3);
		funbutton4 = findViewById(R.id.funbutton4);
		anecdot_textview = findViewById(R.id.anecdot_textview);
		funny_text = findViewById(R.id.funny_text);
		buyanecdotbutton = findViewById(R.id.buyanecdotbutton);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		funbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 111) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 111)));
					enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) + 11)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		funbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 200) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 200)));
					enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) + 21)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		funbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 400) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 400)));
					enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) + 42)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		funbutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 1000) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 1000)));
					enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) + 100)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		buyanecdotbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 100) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 100)));
					enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) + SketchwareUtil.getRandom((int)(1), (int)(20)))));
					_random_fun(SketchwareUtil.getRandom((int)(1), (int)(6)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
	}
	
	private void initializeLogic() {
		money.setText(saver.getString("money", ""));
		enjoy.setText(saver.getString("enjoy", ""));
	}
	
	@Override
	public void onBackPressed() {
		ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
		startActivity(ActivityChanger);
		finish();
	}
	public void _random_fun(final double _funny) {
		if (_funny == 1) {
			funny_text.setText("Анекдот #1:\n\nПрограммист 1С и С++ пришли в бухгалтерию за зарплатой. Но там всё перепутали, и зарплату 1Сника заплатили программисту С++.");
		}
		if (_funny == 2) {
			funny_text.setText("Анекдот #2:\n\nПрограммист 1С с десятилетним стажем смог устроиться стажёром по Java.");
		}
		if (_funny == 3) {
			funny_text.setText("Анекдот #3:\n\nСобрались анимешники прогуляться. Идут, разговаривают.\n\n— А я вчера смотрел аниме!\n— Оооо, аниме!\n\n— Ну а я – рисовал аниме!\n— Оооо, аниме!\n\n— А я вчера весь вечер 1С настраивал.\n— Ну и что в этом такого?\n— Так у меня нога затекла и ОНЕМЕЛА\n— Оооо, онемела");
		}
		if (_funny == 4) {
			funny_text.setText("Анекдот #4:\n\nНашел 1Сник джина. А его на работе так достали клиенты, ламеры, менеджеры, бухгалтеры... 1Сник загадал, чтобы все, кроме программистов, исчезли, и исчез.");
		}
		if (_funny == 5) {
			funny_text.setText("Анекдот #5:\n\nВстретились как-то программист на PHP и 1Сник в школе:\n\nPhP: А ты вкурсе, что васька вчера в вестибюле свою ORM писал?\n\n1C: А что такое ORM и что такое вестибюль?");
		}
		if (_funny == 6) {
			funny_text.setText("Анекдот #6:\n\n1Сник пришел устраиваться на новую работу, так как старая контора разорилась.\n\n— Ну, включайте компьютер, открывайте 1С, делайте тестовое задание.\n\n1Сник достал телефон, зашел на форум 1Сников и написал: \"помогите включить компьютер\".");
		}
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