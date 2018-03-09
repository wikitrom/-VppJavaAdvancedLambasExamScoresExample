package examManager;

import java.util.List;
import java.util.function.DoubleToLongFunction;
import java.util.function.ToDoubleFunction;

public class Main {

	public static void main(String[] args) {

		// define lambda functions
		ToDoubleFunction<List<Double>> average = (scores) -> {
			Double sum = 0d;
			for (Double nextScore : scores) {
				sum += nextScore;
			}
			return sum / scores.size();
		};

		ToDoubleFunction<List<Double>> highest = (scores) -> {
			Double currentHighest = 0d;
			for (Double nextScore : scores) {
				currentHighest = Math.max(currentHighest, nextScore);
			}
			return currentHighest;
		};

		ToDoubleFunction<List<Double>> lowest = (scores) -> {
			Double currentLowest = Double.MAX_VALUE;
			for (Double nextScore : scores) {
				currentLowest = Math.min(currentLowest, nextScore);
			}
			return currentLowest;
		};

		ExamManager examManager = new ExamManager();

		System.out.println();

		// passing defined lambda functios as argument
		System.out.println("Using lamba functions:");
		System.out.println("The average score is " + examManager.customCalculation(average));
		System.out.println("The highest score is " + examManager.customCalculation(highest));
		System.out.println("The lowest score is " + examManager.customCalculation(lowest));

		// use in-line lambda functions
		System.out.println("The first score is " + examManager.customCalculation(scores -> scores.get(0)));
		System.out
				.println("The last score is " + examManager.customCalculation(scores -> scores.get(scores.size() - 1)));

		System.out.println();
		System.out.println("All scores:");
		examManager.printScores();

		System.out.println();
		int limit = 60;
		System.out.println("Selected Scores where score >= " + limit);
		examManager.printSelectedScores(s -> s >= limit);

		System.out.println();
		System.out.println("Total of all scores: " + examManager.getTotalOfAllScores());

		System.out.println();
		System.out.println("Double the scores and print them out.");
		examManager.doubleAllScores();

		System.out.println();
		System.out.println("Double the scores, save in new list and print out the scores.");
		List<Double> doubledScores = examManager.getListOfDoubledScores();

		for (Double dScore : doubledScores) {
			System.out.println(dScore);
		}

		System.out.println();
		System.out.println("Printing out again using more compact code");
		doubledScores.forEach(s -> System.out.println(s));
	}

}
