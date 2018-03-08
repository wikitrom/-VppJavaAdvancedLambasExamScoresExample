package examManager;

import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		// lambda functions
		Function<List<Double>, Double> average = (scores) -> {
			Double sum = 0d;
			for (Double nextScore : scores) {
				sum += nextScore;
			}
			return sum / scores.size();
		};

		Function<List<Double>, Double> highest = (scores) -> {
			Double currentHighest = 0d;
			for (Double nextScore : scores) {
				currentHighest = Math.max(currentHighest, nextScore);
			}
			return currentHighest;
		};

		Function<List<Double>, Double> lowest = (scores) -> {
			Double currentLowest = Double.MAX_VALUE;
			for (Double nextScore : scores) {
				currentLowest = Math.min(currentLowest, nextScore);
			}
			return currentLowest;
		};

		ExamManager examManager = new ExamManager();

		System.out.println();
		System.out.println("Using lamba functions:"); // passing lambda function as argument
		System.out.println("The average score is " + examManager.customCalculation(average));
		System.out.println("The highest score is " + examManager.customCalculation(highest));
		System.out.println(" The lowest score is " + examManager.customCalculation(lowest));
	}

}
