package examManager;

import java.util.ArrayList;
import java.util.List;

public class ExamManager {

	private List<Double> myScores;

	public interface CalculationFunctionInterface {
		public Double execute(List<Double> scores);
	}

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

	public Double customCalculation(CalculationFunctionInterface calculator) {
		return calculator.execute(myScores);
	}
}
