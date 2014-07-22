package com.example.calculator;

public class Calculator{
	// 入力中文字列
	StringBuilder mInputNumber = new StringBuilder();
	// 入力中演算子
	String mOperator;
	// 結果
	int mResult = 0;

	// 数値判断
	private boolean isNumber(String key){
		try{
			Integer.parseInt(key);
			return true;
		}catch(NumberFormatException e){

		}
		return false;
	}

	// 演算子判断
	private boolean isSupportedOperator(String key){
		if(key.equals("+")){
			return true;
		}else if(key.equals("-")){
			return true;
		}else if(key.equals("*")){
			return true;
		}else if(key.equals("/")){
			return true;
		}else if(key.equals("=")){
			return true;
		}
		return false;
	}

	// 演算
	private void doCalculation(String ope){
		if(ope.equals("+")){
			mResult = mResult + Integer.parseInt(mInputNumber.toString());
		}else if(ope.equals("-")){
			mResult = mResult - Integer.parseInt(mInputNumber.toString());
		}else if(ope.equals("*")){
			mResult = mResult * Integer.parseInt(mInputNumber.toString());
		}else if(ope.equals("/")){
			mResult = mResult / Integer.parseInt(mInputNumber.toString());
		}
		mInputNumber = new StringBuilder();
	}

	// クリア処理
	public void reset(){
		mOperator = null;
		mResult = 0;
		mInputNumber = new StringBuilder();
	}

	// 処理後結果返却
	public String putInput(String key){
		if(isNumber(key)){
			// 入力待機
			mInputNumber.append(key);
			return mInputNumber.toString();
		}else if(isSupportedOperator(key)){
			// 演算処理
			if(key.equals("=")){
				if(mOperator != null){
					doCalculation(mOperator);
					mOperator = null;
				}
				return Integer.toString(mResult);
			}else{
				if(mOperator != null){
					// 入力中の演算子がある場合、前回の結果を用いて演算処理
					doCalculation(mOperator);
					mOperator = null;
				}else if(mInputNumber.length() > 0){
					mResult = Integer.parseInt(mInputNumber.toString());
					mInputNumber = new StringBuilder();
				}
				mOperator = key;
				return mOperator;
			}
		}else {
			return null;
		}
	}

}