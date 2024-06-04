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
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ChatActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout bossOrganism;
	private LinearLayout evilOrganism;
	private ScrollView chat_vscroll;
	private CircleImageView boss_chatavatar;
	private TextView boss_textview;
	private TextView evilboss_textview;
	private ProgressBar boss_progressbar;
	private LinearLayout chat_linear;
	private LinearLayout player_linear1;
	private LinearLayout boss_linear1;
	private LinearLayout money_linear;
	private LinearLayout player_linear2;
	private LinearLayout boss_linear2;
	private LinearLayout boss_linear3;
	private LinearLayout player_linearprint;
	private LinearLayout answer_linear;
	private TextView player_textview1;
	private CircleImageView playeravatar1;
	private CircleImageView circleimageview3;
	private TextView boss_textview1;
	private TextView textplus;
	private TextView money;
	private TextView textmoney;
	private TextView player_textview2;
	private CircleImageView playeravatar2;
	private CircleImageView circleimageview6;
	private TextView boss_textview2;
	private CircleImageView circleimageview9;
	private TextView boss_textview3;
	private TextView player_printing;
	private CircleImageView playeravatar3;
	private Button button_yes;
	private Button button_no;
	
	private SharedPreferences saver;
	private Intent ActivityChanger = new Intent();
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chat);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bossOrganism = findViewById(R.id.bossOrganism);
		evilOrganism = findViewById(R.id.evilOrganism);
		chat_vscroll = findViewById(R.id.chat_vscroll);
		boss_chatavatar = findViewById(R.id.boss_chatavatar);
		boss_textview = findViewById(R.id.boss_textview);
		evilboss_textview = findViewById(R.id.evilboss_textview);
		boss_progressbar = findViewById(R.id.boss_progressbar);
		chat_linear = findViewById(R.id.chat_linear);
		player_linear1 = findViewById(R.id.player_linear1);
		boss_linear1 = findViewById(R.id.boss_linear1);
		money_linear = findViewById(R.id.money_linear);
		player_linear2 = findViewById(R.id.player_linear2);
		boss_linear2 = findViewById(R.id.boss_linear2);
		boss_linear3 = findViewById(R.id.boss_linear3);
		player_linearprint = findViewById(R.id.player_linearprint);
		answer_linear = findViewById(R.id.answer_linear);
		player_textview1 = findViewById(R.id.player_textview1);
		playeravatar1 = findViewById(R.id.playeravatar1);
		circleimageview3 = findViewById(R.id.circleimageview3);
		boss_textview1 = findViewById(R.id.boss_textview1);
		textplus = findViewById(R.id.textplus);
		money = findViewById(R.id.money);
		textmoney = findViewById(R.id.textmoney);
		player_textview2 = findViewById(R.id.player_textview2);
		playeravatar2 = findViewById(R.id.playeravatar2);
		circleimageview6 = findViewById(R.id.circleimageview6);
		boss_textview2 = findViewById(R.id.boss_textview2);
		circleimageview9 = findViewById(R.id.circleimageview9);
		boss_textview3 = findViewById(R.id.boss_textview3);
		player_printing = findViewById(R.id.player_printing);
		playeravatar3 = findViewById(R.id.playeravatar3);
		button_yes = findViewById(R.id.button_yes);
		button_no = findViewById(R.id.button_no);
		saver = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		button_yes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("opengamer", "1").commit();
				ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
				startActivity(ActivityChanger);
				finish();
			}
		});
		
		button_no.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saver.edit().putString("game", "0").commit();
				button_yes.setVisibility(View.GONE);
				button_no.setVisibility(View.GONE);
				player_linear2.setVisibility(View.VISIBLE);
				player_textview2.setText("У меня сегодня что-то плохое самочувствие...");
				boss_linear2.setVisibility(View.VISIBLE);
				boss_textview2.setText("Вот как значит!? Уволен!");
				boss_linear3.setVisibility(View.GONE);
				player_linearprint.setVisibility(View.GONE);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								saver.edit().putString("reason", "Уволили с работы не дав поработать.").commit();
								ActivityChanger.setClass(getApplicationContext(), GameoverActivity.class);
								startActivity(ActivityChanger);
								finish();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
			}
		});
	}
	
	private void initializeLogic() {
		if (saver.getString("game", "").equals("2")) {
			money_linear.setVisibility(View.GONE);
			player_linear2.setVisibility(View.GONE);
			boss_linear2.setVisibility(View.GONE);
		}
		if (saver.getString("game", "").equals("3")) {
			money_linear.setVisibility(View.GONE);
			_random_hello(SketchwareUtil.getRandom((int)(1), (int)(7)));
			boss_textview1.setText("Ты что, совсем дурак?!?! Всё испортил, как всегда! Худший работник нашей компании!");
			_random_antifired(SketchwareUtil.getRandom((int)(1), (int)(7)));
			boss_textview2.setText("Так уж и быть, дам тебе ещё один шанс. Ещё раз не справишься с работой – сразу уволю.");
			if (saver.getString("boss_task", "").equals("0")) {
				boss_progressbar.setProgress((int)Double.parseDouble(saver.getString("angryboss", "")) + 10);
				saver.edit().putString("angryboss", String.valueOf((long)(boss_progressbar.getProgress()))).commit();
			}
		}
		if (saver.getString("game", "").equals("4")) {
			boss_linear2.setVisibility(View.GONE);
			if (saver.getString("aftergame", "").equals("2")) {
				money.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(1), (int)(100)))));
				saver.edit().putString("money", String.valueOf((long)(Double.parseDouble(saver.getString("money", "")) + Double.parseDouble(money.getText().toString())))).commit();
				saver.edit().putString("aftergame", "1").commit();
				if (Double.parseDouble(saver.getString("level", "")) < 5) {
					saver.edit().putString("level", String.valueOf((long)(Double.parseDouble(saver.getString("level", "")) + 1))).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Уровень повышен!");
				}
			}
			else {
				money_linear.setVisibility(View.GONE);
			}
			_random_hello(SketchwareUtil.getRandom((int)(1), (int)(7)));
			boss_textview1.setText("Ну, коряво сделано, конечно, но так уж и быть, приму работу. Деньги перевёл на счёт, а теперь марш за работу!");
			player_textview2.setText("Спасибо! Что мне делать дальше, Босс?");
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 1) {
			playeravatar1.setImageResource(R.drawable.cock1);
			playeravatar2.setImageResource(R.drawable.cock1);
			playeravatar3.setImageResource(R.drawable.cock1);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 2) {
			playeravatar1.setImageResource(R.drawable.cock2);
			playeravatar2.setImageResource(R.drawable.cock2);
			playeravatar3.setImageResource(R.drawable.cock2);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 3) {
			playeravatar1.setImageResource(R.drawable.cock3);
			playeravatar2.setImageResource(R.drawable.cock3);
			playeravatar3.setImageResource(R.drawable.cock3);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 4) {
			playeravatar1.setImageResource(R.drawable.cock4);
			playeravatar2.setImageResource(R.drawable.cock4);
			playeravatar3.setImageResource(R.drawable.cock4);
		}
		if (Double.parseDouble(saver.getString("avatar", "")) == 5) {
			playeravatar1.setImageResource(R.drawable.cock5);
			playeravatar2.setImageResource(R.drawable.cock5);
			playeravatar3.setImageResource(R.drawable.cock5);
		}
		if (Double.parseDouble(saver.getString("angryboss", "")) > 99) {
			saver.edit().putString("reason", "Вы очень сильно разозлили босса, что он вас прям вышвырнул с работы.").commit();
			ActivityChanger.setClass(getApplicationContext(), GameoverActivity.class);
			saver.edit().putString("game", "0").commit();
			startActivity(ActivityChanger);
			finishAffinity();
		}
		if (saver.getString("boss_task", "").equals("0")) {
			_random_quest(SketchwareUtil.getRandom((int)(1), (int)(3)), SketchwareUtil.getRandom((int)(1), (int)(3)), SketchwareUtil.getRandom((int)(1), (int)(3)), 1);
		}
		boss_textview3.setText(saver.getString("boss_task", ""));
	}
	
	@Override
	public void onBackPressed() {
		ActivityChanger.setClass(getApplicationContext(), GameActivity.class);
		startActivity(ActivityChanger);
		finish();
	}
	public void _random_hello(final double _rh_number) {
		if (_rh_number == 1) {
			player_textview1.setText("Я выполнил задание, Босс. Где моя зарплата!?");
		}
		if (_rh_number == 2) {
			player_textview1.setText("Дело сделано, Капитан!");
		}
		if (_rh_number == 3) {
			player_textview1.setText("Закончил все задачи, \nно честно говоря, \nсейчас просто хочется отдохнуть.");
		}
		if (_rh_number == 4) {
			player_textview1.setText("Закончил все задачи, но честно говоря, сейчас просто хочется отдохнуть.");
		}
		if (_rh_number == 5) {
			player_textview1.setText("Работа выполнена. \nТеперь можете отправить меня в отпуск на Гавайи, \nчтобы я смог восстановить душевные силы");
		}
		if (_rh_number == 6) {
			player_textview1.setText("Ну вот, я сделал все, что вы просили. \nТеперь можете меня повысить или хотя бы купить мне кофе, \nчтобы я не уснул прямо здесь.");
		}
		if (_rh_number == 7) {
			player_textview1.setText("Задание закрыто! Может, \nтеперь я заслужил небольшой перерыв?");
		}
	}
	
	
	public void _random_antifired(final double _af_number) {
		if (_af_number == 1) {
			player_textview2.setText("Если меня уволят, я начну писать код в 1С, \nкоторый будет менять все названия переменных на шуточные. \nВы хотите, чтобы ваша база данных стала клоунской?");
		}
		if (_af_number == 2) {
			player_textview2.setText("Босс, если меня уволят, \nя начну менять все пароли в базе данных и конфигурациях 1С на '123456'. \nВы точно хотите рисковать таким образом?");
		}
		if ((_af_number == 3) || (_af_number == 4)) {
			player_textview2.setText("Не увольняйте меня, пожалуйста. \nТакого больше не повторится. \nВ следующий раз я сделаю всё на отлично!");
		}
		if (_af_number == 5) {
			player_textview2.setText("Босс, ваше профессионализм \nи умение вдохновлять нас на большие свершения \nделают нашу команду по-настоящему сильной. \nЯ обещаю усердно работать, \nчтобы соответствовать вашим высоким стандартам.");
		}
		if (_af_number == 6) {
			player_textview2.setText("Босс, ваше лидерство для меня как код без комментариев - \nнепонятно и запутанно! \nПомогите мне разобраться, \nдайте шанс продолжить работу \nпод вашим 'комментарием'!");
		}
		if (_af_number == 7) {
			player_textview2.setText("Босс, моя клавиатура начала бунтовать \nи печатает не те символы, которые я нажимаю. \nНо я уже начал переговоры с ней и убеждаю, \nчто скоро вернется к нормальному режиму работы! \nНе увольняйте меня, пожалуйста.");
		}
	}
	
	
	public void _ref_builder(final double _type, final double _word) {
		if (_type == 1) {
			if (_word == 1) {
				saver.edit().putString("ref_custom", "Дата создания записи\n").commit();
			}
			if (_word == 2) {
				saver.edit().putString("ref_custom", "Ответственный сотрудник\n").commit();
			}
			if (_word == 3) {
				saver.edit().putString("ref_custom", "Паспортные данные\n").commit();
			}
			if (_word == 4) {
				saver.edit().putString("ref_custom", "Должность\n").commit();
			}
			if (_word == 5) {
				saver.edit().putString("ref_custom", "Отдел\n").commit();
			}
			if (_word == 6) {
				saver.edit().putString("ref_custom", "Уровень доступа\n").commit();
			}
			if (_word == 7) {
				saver.edit().putString("ref_custom", "Комментарии\n").commit();
			}
			if (_word == 8) {
				saver.edit().putString("ref_custom", "ИНН\n").commit();
			}
		}
		if (_type == 2) {
			if (_word == 1) {
				saver.edit().putString("ref_custom", "Статус документа\n").commit();
			}
			if (_word == 2) {
				saver.edit().putString("doc_custom", "Сумма документа\n").commit();
			}
			if (_word == 3) {
				saver.edit().putString("doc_custom", "Обслуживающий\n").commit();
			}
			if (_word == 4) {
				saver.edit().putString("doc_custom", "Товары в накладной\n").commit();
			}
			if (_word == 5) {
				saver.edit().putString("doc_custom", "Услуги в счете\n").commit();
			}
			if (_word == 6) {
				saver.edit().putString("doc_custom", "Статья затрат\n").commit();
			}
			if (_word == 7) {
				saver.edit().putString("doc_custom", "Статус оплаты\n").commit();
			}
			if (_word == 8) {
				saver.edit().putString("doc_custom", "Данные о контрагенте\n").commit();
			}
		}
		if (_type == 3) {
			if (_word == 1) {
				saver.edit().putString("report_code", "Процедура ВывестиHelloWorld()\n    Сообщить(\"Hello, World!\");\nКонецПроцедуры").commit();
			}
			if (_word == 2) {
				saver.edit().putString("report_code", "Справочник Контрагенты\n    Реквизиты\n        Наименование Как Строка(100);\n        ИНН Как Строка(12);\n    КонецРеквизитов\nКонецСправочника\n\nДокумент ЗаказПокупателя\n    Реквизиты\n        Номер Как Число;\n        Дата Как Дата;\n        Контрагент Как СправочникСсылка.Контрагенты;\n    КонецРеквизитов\n\n    ТабличнаяЧасть Товары\n        Реквизиты\n            Наименование Как Строка(100);\n            Количество Как Число;\n            Цена Как Число;\n        КонецРеквизитов\n    КонецТабличнойЧасти\nКонецДокумента").commit();
			}
			if (_word == 3) {
				saver.edit().putString("report_code", "Справочник Отделы\n    Реквизиты\n        Наименование Как Строка(100);\n        Руководитель Как СправочникСсылка.Сотрудники;\n    КонецРеквизитов\nКонецСправочника").commit();
			}
			if (_word == 4) {
				saver.edit().putString("report_code", "Документ НовыйДокумент\n    Реквизиты\n        Номер Как Число;\n        Дата Как Дата;\n        Описание Как Строка(255);\n    КонецРеквизитов\nКонецДокумента").commit();
			}
			if (_word == 5) {
				saver.edit().putString("report_code", "Отчет ОтчетПоПровальнымПродажам\n    Реквизиты\n        ДатаНачала Как Дата;\n        ДатаОкончания Как Дата;\n        Владелец Как Строка(100); // Добавляем реквизит для указания владельца компании\n    КонецРеквизитов\n\n    Процедура Печать()\n        // Логика для формирования отчета по провальным продажам с указанием Валерия Жмышенко\n        Сообщить(\"Формирование отчета по провальным продажам с \" + Строка(ДатаНачала) + \" по \" + Строка(ДатаОкончания));\n        Сообщить(\"Владелец компании: Валерий Жмышенко\");\n    КонецПроцедуры\nКонецОтчета").commit();
			}
		}
	}
	
	
	public void _random_quest(final double _rq_number, final double _type1, final double _type2, final double _type3) {
		saver.edit().putString("ref_standart", "0").commit();
		saver.edit().putString("ref_custom", "0").commit();
		saver.edit().putString("doc_standart", "0").commit();
		saver.edit().putString("doc_custom", "0").commit();
		saver.edit().putString("doc_link", "Справочник1\n").commit();
		saver.edit().putString("report_code", "0").commit();
		saver.edit().putString("report_reg", "0").commit();
		saver.edit().putString("report_anal", "0").commit();
		saver.edit().putString("time", "0").commit();
		saver.edit().putString("task", "0").commit();
		saver.edit().putString("boss_task", "Работничек! Вот что нужно сделать в 1С:\n").commit();
		if (_rq_number == 1) {
			if (_type1 < 3) {
				_ref_builder(_type1, SketchwareUtil.getRandom((int)(1), (int)(8)));
				saver.edit().putString("ref_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("doc_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			}
			else {
				_ref_builder(3, SketchwareUtil.getRandom((int)(1), (int)(5)));
				saver.edit().putString("report_reg", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("report_anal", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			}
		}
		if (_rq_number == 2) {
			if (_type2 == 1) {
				_ref_builder(1, SketchwareUtil.getRandom((int)(1), (int)(8)));
				_ref_builder(2, SketchwareUtil.getRandom((int)(1), (int)(8)));
				saver.edit().putString("ref_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("doc_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			}
			if (_type2 == 2) {
				_ref_builder(1, SketchwareUtil.getRandom((int)(1), (int)(8)));
				_ref_builder(3, SketchwareUtil.getRandom((int)(1), (int)(5)));
				saver.edit().putString("ref_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("report_reg", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("report_anal", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			}
			if (_type2 == 3) {
				_ref_builder(2, SketchwareUtil.getRandom((int)(1), (int)(8)));
				_ref_builder(3, SketchwareUtil.getRandom((int)(1), (int)(5)));
				saver.edit().putString("doc_standart", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("report_reg", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
				saver.edit().putString("report_anal", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			}
		}
		if (_rq_number == 3) {
			_ref_builder(1, SketchwareUtil.getRandom((int)(1), (int)(8)));
			_ref_builder(2, SketchwareUtil.getRandom((int)(1), (int)(8)));
			_ref_builder(3, SketchwareUtil.getRandom((int)(1), (int)(5)));
			saver.edit().putString("report_reg", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
			saver.edit().putString("report_anal", String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))))).commit();
		}
		if (!saver.getString("ref_custom", "").equals("0")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Справочник: ".concat(saver.getString("ref_custom", "")))).commit();
		}
		if (saver.getString("ref_standart", "").equals("1")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Должны быть включены стандартные реквизиты справочника\n")).commit();
		}
		if (!saver.getString("doc_custom", "").equals("0")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Документ: ".concat(saver.getString("doc_custom", "")))).commit();
		}
		if (saver.getString("doc_standart", "").equals("1")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Должны быть включены стандартные реквизиты документа\n")).commit();
		}
		if (SketchwareUtil.getRandom((int)(1), (int)(3)) == 2) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Ссылка на справочник: ".concat(saver.getString("doc_link", "")))).commit();
		}
		if (!saver.getString("report_code", "").equals("0")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Должен быть составлен отчёт\n")).commit();
		}
		if (saver.getString("report_reg", "").equals("1")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Должны быть включены отчёты по регистрам\n")).commit();
		}
		if (saver.getString("report_anal", "").equals("1")) {
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Должны быть включен аналитический отчёт")).commit();
		}
		if (SketchwareUtil.getRandom((int)(1), (int)(3)) == 2) {
			saver.edit().putString("time", String.valueOf((long)(SketchwareUtil.getRandom((int)(30), (int)(99))))).commit();
			saver.edit().putString("boss_task", saver.getString("boss_task", "").concat("Время выполнения: ".concat(saver.getString("time", "")))).commit();
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