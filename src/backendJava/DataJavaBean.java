package backendJava;

public class DataJavaBean {

	private static int period;
	private static int currentNumber;
	private static int previousNumber;
	private static boolean status;

	public static int getPeriod() {
		return period;
	}

	public static void setPeriod(int period) {
		DataJavaBean.period = period;
	}

	public static int getCurrentNumber() {
		return currentNumber;
	}

	public static void setCurrentNumber(int currentNumber) {
		DataJavaBean.currentNumber = currentNumber;
	}

	public static int getPreviousNumber() {
		return previousNumber;
	}

	public static void setPreviousNumber(int previousNumber) {
		DataJavaBean.previousNumber = previousNumber;
	}

	public static boolean getStatus() {
		return status;
	}

	public static void setStatus(boolean status) {
		DataJavaBean.status = status;
	}

}
