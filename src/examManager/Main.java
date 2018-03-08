package examManager;

import java.util.List;
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
		System.out.println("The last score is " + examManager.customCalculation(scores -> scores.get(scores.size()-1))); 
		
		examManager.printScores();
	}

}
