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

public class ShopActivity extends Activity {
	
	private LinearLayout data_linear;
	private ScrollView shop_scroll;
	private TextView textmoney;
	private TextView money;
	private TextView textfood;
	private TextView food;
	private LinearLayout shopOrganism;
	private Button buytwixbutton;
	private Button buttonbuynormaltwix;
	private Button buttonbuylargetwix;
	private Button buttonbuycoffee;
	private Button buttonenergydrink;
	private Button button_tigerpizza;
	
	private Intent ActivityChanger = new Intent();
	private SharedPreferences saver;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.shop);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		data_linear = findViewById(R.id.data_linear);
		shop_scroll = findViewById(R.id.shop_scroll);
		textmoney = findViewById(R.id.textmoney);
		money = findViewById(R.id.money);
		textfood = findViewById(R.id.textfood);
		food = findViewById(R.id.food);
		shopOrganism = findViewById(R.id.shopOrganism);
		buytwixbutton = findViewById(R.id.buytwixbutton);
		buttonbuynormaltwix = findViewById(R.id.buttonbuynormaltwix);
		buttonbuylargetwix = findViewById(R.id.buttonbuylargetwix);
		buttonbuycoffee = findViewById(R.id.buttonbuycoffee);
		buttonenergydrink = findViewById(R.id.buttonenergydrink);
		button_tigerpizza = findViewById(R.id.button_tigerpizza);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		buytwixbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 19) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 19)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 1)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		buttonbuynormaltwix.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 53) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 53)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 4)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		buttonbuylargetwix.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 105) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 105)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 10)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		buttonbuycoffee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 240) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 240)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 24)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		buttonenergydrink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 480) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 480)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 48)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
		
		button_tigerpizza.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Double.parseDouble(money.getText().toString()) > 999) {
					money.setText(String.valueOf((long)(Double.parseDouble(money.getText().toString()) - 999)));
					food.setText(String.valueOf((long)(Double.parseDouble(food.getText().toString()) + 100)));
					saver.edit().putString("money", money.getText().toString()).commit();
					saver.edit().putString("hunger", food.getText().toString()).commit();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "недостаточно денег");
				}
			}
		});
	}
	
	private void initializeLogic() {
		money.setText(saver.getString("money", ""));
		food.setText(saver.getString("hunger", ""));
	}
	
	@Override
	public void onBackPressed() {
		ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
		startActivity(ActivityChanger);
		finish();
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