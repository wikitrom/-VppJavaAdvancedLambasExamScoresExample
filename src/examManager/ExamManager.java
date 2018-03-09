package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ExamManager {

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
		Comparator<Double> dComp = (o1, o2) -> {
			return (o1 < o2) ? 1 : ((o1 > o2) ? -1 : 0);
			// same as below
			//			if (o1 < o2)
			//				return 1;
			//			if (o1 > o2)
			//				return -1;
			//			return 0;
		};
		Collections.sort(myScores, dComp);
		myScores.forEach(s -> System.out.println(s.toString()));
	}

	public void printSelectedScores(Predicate<Double> testCriteria) {
		myScores.forEach(s -> {
			if (testCriteria.test(s)) {
				System.out.println(s);
			}
		});
	}

}
