package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
/*import android.view.Menu;*/
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;

public class SubActivity extends Activity implements TextWatcher, OnClickListener {

	// 計算用
	TextView mTextView1;
	Calculator mCalculator = new Calculator();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		mTextView1 = (TextView) findViewById(R.id.textView1);
		// ボタンアクション
		findViewById(R.id.button0).setOnClickListener(this);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		findViewById(R.id.button4).setOnClickListener(this);
		findViewById(R.id.button5).setOnClickListener(this);
		findViewById(R.id.button6).setOnClickListener(this);
		findViewById(R.id.button7).setOnClickListener(this);
		findViewById(R.id.button8).setOnClickListener(this);
		findViewById(R.id.button9).setOnClickListener(this);
		findViewById(R.id.button_clear).setOnClickListener(this);
/*		findViewById(R.id.button_delete).setOnClickListener(this);*/
/*		findViewById(R.id.button_output).setOnClickListener(this);*/
		findViewById(R.id.button_equal).setOnClickListener(this);
		findViewById(R.id.button_plus).setOnClickListener(this);
		findViewById(R.id.button_minus).setOnClickListener(this);
		findViewById(R.id.button_multiply).setOnClickListener(this);
		findViewById(R.id.button_divide).setOnClickListener(this);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

	@Override
	public void afterTextChanged(Editable s){
		String input = s.toString();
		Log.d("SubActivity", "input=" + input);
		if(input.length() > 0){
			String dispText = mCalculator.putInput(input);
			if(dispText != null){
				mTextView1.setText(dispText);
			}
			s.clear();
		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after){

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int after){

	}

	@Override
	public void onClick(View v){
		Button btn = (Button) v;
		if(btn.getId() == R.id.button_clear){
			mCalculator.reset();
			mTextView1.setText("0");
		}else{
			String input = btn.getText().toString();
			Log.d("SubActivity", "input=" + input);

			String dispText = mCalculator.putInput(input);
			if(dispText != null){
				mTextView1.setText(dispText);
			}
		}
	}
}


