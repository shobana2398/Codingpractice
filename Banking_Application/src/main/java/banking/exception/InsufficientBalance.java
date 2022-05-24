package banking.exception;

public class InsufficientBalance extends Exception {
	//idhu edhuku add pannanumnu paru
	static final long serialVersionUID = -3387516993124229948L;

	public InsufficientBalance(String message) {
		super(message);
	}

}
