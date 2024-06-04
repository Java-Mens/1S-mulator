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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SimulatorActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout stats_linear;
	private LinearLayout choose_sim_buttons_organism;
	private ScrollView oneassmulator_scroll;
	private TextView hungry_textview;
	private TextView hungry;
	private TextView enjoy_textview;
	private TextView enjoy;
	private TextView timer_textview;
	private TextView timer;
	private CheckBox ref_button_checkbox;
	private CheckBox doc_button_checkbox;
	private CheckBox report_button_checkbox;
	private LinearLayout simulatorOrganism;
	private LinearLayout ref_linear;
	private LinearLayout doc_linear;
	private LinearLayout report_linear;
	private Button end_button;
	private TextView ref_text1;
	private TextView ref_textstandart;
	private CheckBox ref_checkbox;
	private TextView ref_textcustom;
	private EditText ref_edittext;
	private TextView doc_text;
	private TextView doc_textstandart;
	private CheckBox doc_checkbox;
	private TextView doc_textcustom;
	private EditText doc_edittext;
	private TextView doc_reftext;
	private EditText doc_editref;
	private TextView report_textview;
	private TextView report_textexample;
	private TextView report_example_textview;
	private EditText report_edittext;
	private CheckBox req_checkbox;
	private CheckBox anal_checkbox;
	
	private Intent ActivityChanger = new Intent();
	private SharedPreferences saver;
	private TimerTask time_counter;
	private TimerTask hurter;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.simulator);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		stats_linear = findViewById(R.id.stats_linear);
		choose_sim_buttons_organism = findViewById(R.id.choose_sim_buttons_organism);
		oneassmulator_scroll = findViewById(R.id.oneassmulator_scroll);
		hungry_textview = findViewById(R.id.hungry_textview);
		hungry = findViewById(R.id.hungry);
		enjoy_textview = findViewById(R.id.enjoy_textview);
		enjoy = findViewById(R.id.enjoy);
		timer_textview = findViewById(R.id.timer_textview);
		timer = findViewById(R.id.timer);
		ref_button_checkbox = findViewById(R.id.ref_button_checkbox);
		doc_button_checkbox = findViewById(R.id.doc_button_checkbox);
		report_button_checkbox = findViewById(R.id.report_button_checkbox);
		simulatorOrganism = findViewById(R.id.simulatorOrganism);
		ref_linear = findViewById(R.id.ref_linear);
		doc_linear = findViewById(R.id.doc_linear);
		report_linear = findViewById(R.id.report_linear);
		end_button = findViewById(R.id.end_button);
		ref_text1 = findViewById(R.id.ref_text1);
		ref_textstandart = findViewById(R.id.ref_textstandart);
		ref_checkbox = findViewById(R.id.ref_checkbox);
		ref_textcustom = findViewById(R.id.ref_textcustom);
		ref_edittext = findViewById(R.id.ref_edittext);
		doc_text = findViewById(R.id.doc_text);
		doc_textstandart = findViewById(R.id.doc_textstandart);
		doc_checkbox = findViewById(R.id.doc_checkbox);
		doc_textcustom = findViewById(R.id.doc_textcustom);
		doc_edittext = findViewById(R.id.doc_edittext);
		doc_reftext = findViewById(R.id.doc_reftext);
		doc_editref = findViewById(R.id.doc_editref);
		report_textview = findViewById(R.id.report_textview);
		report_textexample = findViewById(R.id.report_textexample);
		report_example_textview = findViewById(R.id.report_example_textview);
		report_edittext = findViewById(R.id.report_edittext);
		req_checkbox = findViewById(R.id.req_checkbox);
		anal_checkbox = findViewById(R.id.anal_checkbox);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		ref_button_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					ref_linear.setVisibility(View.VISIBLE);
				}
				else {
					ref_linear.setVisibility(View.GONE);
				}
			}
		});
		
		doc_button_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					doc_linear.setVisibility(View.VISIBLE);
				}
				else {
					doc_linear.setVisibility(View.GONE);
				}
			}
		});
		
		report_button_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					report_linear.setVisibility(View.VISIBLE);
				}
				else {
					report_linear.setVisibility(View.GONE);
				}
			}
		});
		
		end_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("game", "4").commit();
				if (ref_checkbox.isChecked()) {
					_oneass_verification(1, 1);
				}
				else {
					_oneass_verification(1, 0);
				}
				if (doc_checkbox.isChecked()) {
					_oneass_verification(2, 1);
				}
				else {
					_oneass_verification(2, 0);
				}
				if (req_checkbox.isChecked()) {
					_oneass_verification(3, 1);
				}
				else {
					_oneass_verification(3, 0);
				}
				if (anal_checkbox.isChecked()) {
					_oneass_verification(4, 1);
				}
				else {
					_oneass_verification(4, 0);
				}
				if (!saver.getString("report_code", "").contains(report_edittext.getText().toString()) || !saver.getString("report_code", "").equals("0")) {
					saver.edit().putString("game", "3").commit();
				}
				hurter.cancel();
				if (!saver.getString("time", "").equals("0")) {
					time_counter.cancel();
				}
				saver.edit().putString("boss_task", "0").commit();
				saver.edit().putString("hunger", hungry.getText().toString()).commit();
				saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
				ActivityChanger.setClass(getApplicationContext(), ChatActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		ref_linear.setVisibility(View.GONE);
		doc_linear.setVisibility(View.GONE);
		report_linear.setVisibility(View.GONE);
		hungry.setText(saver.getString("hunger", ""));
		enjoy.setText(saver.getString("enjoy", ""));
		if (Double.parseDouble(saver.getString("time", "")) > 0) {
			timer.setText(saver.getString("time", ""));
			time_counter = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							timer.setText(String.valueOf((long)(Double.parseDouble(timer.getText().toString()) - 1)));
							if (Double.parseDouble(timer.getText().toString()) < 0) {
								hurter.cancel();
								time_counter.cancel();
								enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) - SketchwareUtil.getRandom((int)(1), (int)(15)))));
								saver.edit().putString("game", "3").commit();
								saver.edit().putString("hunger", hungry.getText().toString()).commit();
								saver.edit().putString("enjoy", enjoy.getText().toString()).commit();
								ActivityChanger.setClass(getApplicationContext(), ChatActivity.class);
								startActivity(ActivityChanger);
								finish();
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(time_counter, (int)(1500), (int)(1000));
		}
		hurter = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						hungry.setText(String.valueOf((long)(Double.parseDouble(hungry.getText().toString()) - 1)));
						if (Double.parseDouble(hungry.getText().toString()) < 0) {
							if (!saver.getString("time", "").equals("0")) {
								time_counter.cancel();
							}
							hurter.cancel();
							saver.edit().putString("reason", "Ваш персонаж умер от голода. Недостаток пищи привел к истощению организма, остановке жизненно важных функций и, в конечном итоге, к смерти. Помните, важно следить за питанием своего персонажа, чтобы избежать подобных исходов в будущем.").commit();
							saver.edit().putString("game", "0").commit();
							ActivityChanger.setClass(getApplicationContext(), GameoverActivity.class);
							startActivity(ActivityChanger);
							finishAffinity();
						}
						enjoy.setText(String.valueOf((long)(Double.parseDouble(enjoy.getText().toString()) - 1)));
						if (Double.parseDouble(enjoy.getText().toString()) < 0) {
							if (!saver.getString("time", "").equals("0")) {
								time_counter.cancel();
							}
							hurter.cancel();
							saver.edit().putString("reason", "Ваш персонаж умер от недостатка настроения. Постоянное плохое настроение привело к депрессии, отчаянию и потере желания жить, что в итоге привело к трагическому исходу. Помните, важно уделять внимание эмоциональному состоянию своего персонажа, чтобы избежать подобных последствий в будущем.").commit();
							ActivityChanger.setClass(getApplicationContext(), GameoverActivity.class);
							saver.edit().putString("game", "0").commit();
							startActivity(ActivityChanger);
							finishAffinity();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(hurter, (int)(2000), (int)(1500));
		if (!saver.getString("report_code", "").equals("0")) {
			report_example_textview.setText(saver.getString("report_code", ""));
		}
	}
	
	@Override
	public void onBackPressed() {
		saver.edit().putString("game", "4").commit();
		if (ref_checkbox.isChecked()) {
			_oneass_verification(1, 1);
		}
		else {
			_oneass_verification(1, 0);
		}
		if (doc_checkbox.isChecked()) {
			_oneass_verification(2, 1);
		}
		else {
			_oneass_verification(2, 0);
		}
		if (req_checkbox.isChecked()) {
			_oneass_verification(3, 1);
		}
		else {
			_oneass_verification(3, 0);
		}
		if (anal_checkbox.isChecked()) {
			_oneass_verification(4, 1);
		}
		else {
			_oneass_verification(4, 0);
		}
		if (!ref_edittext.getText().toString().equals(saver.getString("ref_custom", "")) || !saver.getString("ref_custom", "").equals("0")) {
			saver.edit().putString("game", "3").commit();
		}
		if (!doc_edittext.getText().toString().equals(saver.getString("doc_custom", "")) || !saver.getString("doc_custom", "").equals("0")) {
			saver.edit().putString("game", "3").commit();
		}
		if (!doc_editref.getText().toString().equals(saver.getString("doc_link", "")) || !saver.getString("doc_link", "").equals("0")) {
			saver.edit().putString("game", "3").commit();
		}
		if (!report_edittext.getText().toString().equals(saver.getString("report_code", "")) || !saver.getString("report_code", "").equals("0")) {
			saver.edit().putString("game", "3").commit();
		}
		hurter.cancel();
		if (!saver.getString("time", "").equals("0")) {
			time_counter.cancel();
		}
		saver.edit().putString("boss_task", "0").commit();
		ActivityChanger.setClass(getApplicationContext(), ChatActivity.class);
		startActivity(ActivityChanger);
		finish();
	}
	public void _oneass_verification(final double _type, final double _enabled) {
		if (_type == 1) {
			if (!(_enabled == Double.parseDouble(saver.getString("ref_standart", "")))) {
				saver.edit().putString("game", "3").commit();
			}
		}
		if (_type == 2) {
			if (!(_enabled == Double.parseDouble(saver.getString("doc_standart", "")))) {
				saver.edit().putString("game", "3").commit();
			}
		}
		if (_type == 3) {
			if (!(_enabled == Double.parseDouble(saver.getString("report_reg", "")))) {
				saver.edit().putString("game", "3").commit();
			}
		}
		if (_type == 4) {
			if (!(_enabled == Double.parseDouble(saver.getString("report_anal", "")))) {
				saver.edit().putString("game", "3").commit();
			}
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