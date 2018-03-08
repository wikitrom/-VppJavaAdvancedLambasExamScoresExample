package examManager;

import examManager.ExamManager.CalculationFunctionInterface;

public class Main {

	static CalculationFunctionInterface average = (scores) -> {
		Double sum = 0d;
		for (Double nextScore : scores) {
			sum += nextScore;
		}
		return sum / scores.size();
	};

	static CalculationFunctionInterface highest = (scores) -> {
		Double highest = 0d;
		for (Double nextScore : scores) {
			highest = Math.max(highest, nextScore);
		}
		return highest;
	};

	static CalculationFunctionInterface lowest = (scores) -> {
		Double lowest= Double.MAX_VALUE;
		for (Double nextScore : scores) {
			lowest= Math.min(lowest,nextScore);
		}
		return lowest;
	};

	public static void main(String[] args) {
		ExamManager examManager = new ExamManager();

		System.out.println();
		System.out.println("Using lamba functions:"); // passing lambda function as argument
		System.out.println("The average score is " + examManager.customCalculation(average));
		System.out.println("The highest score is " + examManager.customCalculation(highest));
		System.out.println(" The lowest score is " + examManager.customCalculation(lowest));
	}

}
