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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AvatarsActivity extends Activity {
	
	private ScrollView avatar_scroll;
	private LinearLayout avatarOrganism;
	private TextView avatarpickertext;
	private TextView lvl12text;
	private LinearLayout linear3;
	private TextView lvl34text;
	private LinearLayout linear4;
	private TextView lvl5text;
	private CircleImageView lvl5_image;
	private CircleImageView lvl1_image;
	private CircleImageView lvl2_image;
	private CircleImageView lvl3_image;
	private CircleImageView lvl4_image;
	
	private SharedPreferences saver;
	private Intent ActivityChanger = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.avatars);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		avatar_scroll = findViewById(R.id.avatar_scroll);
		avatarOrganism = findViewById(R.id.avatarOrganism);
		avatarpickertext = findViewById(R.id.avatarpickertext);
		lvl12text = findViewById(R.id.lvl12text);
		linear3 = findViewById(R.id.linear3);
		lvl34text = findViewById(R.id.lvl34text);
		linear4 = findViewById(R.id.linear4);
		lvl5text = findViewById(R.id.lvl5text);
		lvl5_image = findViewById(R.id.lvl5_image);
		lvl1_image = findViewById(R.id.lvl1_image);
		lvl2_image = findViewById(R.id.lvl2_image);
		lvl3_image = findViewById(R.id.lvl3_image);
		lvl4_image = findViewById(R.id.lvl4_image);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		lvl5_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("avatar", "5").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		lvl1_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("avatar", "1").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		lvl2_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("avatar", "2").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		lvl3_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("avatar", "3").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		lvl4_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("avatar", "4").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		if (!(Double.parseDouble(saver.getString("level", "")) > 1)) {
			lvl2_image.setVisibility(View.GONE);
			lvl12text.setVisibility(View.GONE);
		}
		if (!(Double.parseDouble(saver.getString("level", "")) > 2)) {
			lvl3_image.setVisibility(View.GONE);
			lvl34text.setVisibility(View.GONE);
		}
		if (!(Double.parseDouble(saver.getString("level", "")) > 3)) {
			lvl4_image.setVisibility(View.GONE);
			lvl34text.setVisibility(View.GONE);
		}
		if (!(Double.parseDouble(saver.getString("level", "")) > 4)) {
			lvl5_image.setVisibility(View.GONE);
			lvl5text.setVisibility(View.GONE);
		}
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