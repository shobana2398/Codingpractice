package banking.exception;

public class DailyLimitExceed extends Exception {
	static final long serialVersionUID = -3387516993124229948L;
	
		public DailyLimitExceed(String message) {
			super(message);
		}
	}


