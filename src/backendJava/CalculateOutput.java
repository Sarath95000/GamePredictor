package backendJava;

public class CalculateOutput {

	public static void calculate() {
		finalCalculation();
	}

	private static int firstCalculation() {
		int number = DataJavaBean.getPeriod();
		int sum = 0;
		while (number > 0) {
			sum = (number % 10) + sum;
			number = number / 10;
		}
		System.out.println("First Calculation : " + sum);
		return sum;
	}

	private static int secondCalculation() {
		int secondCalc = firstCalculation() + DataJavaBean.getCurrentNumber();
		int sum2 = 0;
		while (secondCalc > 0) {
			sum2 = (secondCalc % 10) + sum2;
			secondCalc = secondCalc / 10;
		}
		System.out.println("second Calculation : " + sum2);
		return sum2 * DataJavaBean.getPreviousNumber();
	}

	private static void finalCalculation() {
		int thirdCalc = secondCalculation();
		System.out.println("third Calculation : " + thirdCalc);
		System.out.println("-------------------------------------------------");

		if (thirdCalc % 2 == 0) {
			System.out.println("Even");
			DataJavaBean.setStatus(true);
		} else {
			System.out.println("Odd");
			DataJavaBean.setStatus(false);
		}
	}

}
