package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ExamManager {

	public static boolean isItLowerThan50(Double d) {
		return (d < 50);
	}

	private List<Double> myScores;

	public ExamManager() {
		myScores = new ArrayList<Double>();
		myScores.add(78.3);
		myScores.add(69.2);
		myScores.add(44.7);
		myScores.add(61.6);
		myScores.add(80.2);
		myScores.add(66.9);
		myScores.add(54.1);
	}

	public Double customCalculation(ToDoubleFunction<List<Double>> calculator) {
		return calculator.applyAsDouble(myScores);
	}

	public void printScores() {
		Collections.sort(myScores, (o1, o2) -> {
			return (o1 < o2) ? 1 : ((o1 > o2) ? -1 : 0);
		});
		myScores.forEach(s -> System.out.println(s.toString()));
	}

	// using stream
	// old code
	// myScores.forEach(s -> {
	// if (testCriteria.test(s)) {
	// System.out.println(s);
	// }
	// });

	public void printSelectedScores(Predicate<Double> testCriteria) {
		myScores.stream().filter(testCriteria).forEach(s -> System.out.println(s));
		return;
	}

	// Using a 'Stream' to sum all scores.
	// Reason: A lambda expression can not change a variable defined in the
	// enclosing scope.
	// Thus we can't have a variable that we increment inside the lambda
	// expression to sum up all values.

	public double getTotalOfAllScores() {
		// separated into multiple lines
		// Stream<Double> myStream = myScores.stream();
		// return myStream.reduce(0d, (t, s) -> t + s);

		// more compact version
		return myScores.stream().reduce(0d, (t, s) -> t + s);
	}

	public void doubleAllScores() {
		// using a stream to double all scores (manipulate collection data)
		myScores.stream().map(d -> d * 2).forEach(s -> System.out.println(s));
	}

	public List<Double> getListOfDoubledScores() {
		// using a stream to double all scores (manipulate collection data)
		return myScores.stream().map(d -> d * 2).collect(Collectors.toList());
	}

}
