package com.abn.pojo;

public enum FileFormat {

	RECORD_CODE(1,3),
	CLIENT_TYPE(4,7),
	CLIENT_NUMBER(8,11),
	ACCOUNT_NUMBER(12,15),
	SUBACCOUNT_NUMBER(16,19),
	OPPOSITE_PARTY_CODE(20,25),
	PRODUCT_GROUP_CODE(26,27),
	EXCHANGE_CODE(28,31),
	SYMBOL(32,37),
	EXPIRATION_DATE(38,45),
	CURRENCY_CODE(46,48),
	MOVEMENT_CODE(49,50),
	BUY_SELL_CODE(51,51),
	QTY_LONG_SIGN(52,52),
	QTY_LONG(53,62),
	QTY_SHORT_SIGN(63,63),
	QTY_SHORT(64,73);
	
	
	private int startPosition;
	private int endPosition;
	
	private FileFormat(int startPosition, int endPosition) {
	      this.startPosition = startPosition;
	      this.endPosition = endPosition;
	   }

	   public int getStartPosition() {
	      return this.startPosition;
	   }

	   public int getEndPosition() {
	      return this.endPosition;
	   }
	

}
