import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class job1 {
	static class Stock {
		String symbol;
		double open;
		double close;
		long volume;

		Stock(String symbol, double open, double close, long volume) {
			this.symbol = symbol;
			this.open = open;
			this.close = close;
			this.volume = volume;
		}

		double change() {
			return close - open;
		}

		double percentChange() {
			if (open == 0) return 0;
			return (change() / open) * 100.0;
		}
	}

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Stock Market Demo - " + today);
		System.out.println();

		Stock[] market = new Stock[] {
			new Stock("INFY", 1300.00, 1325.00, 1_200_000),
			new Stock("TCS", 3000.00, 2950.00, 800_000),
			new Stock("RELI", 2500.00, 2550.00, 1_500_000)
		};

		System.out.println("Symbol  Open    Close   Change   %Change   Volume");
		double portfolioValue = 0.0;

		// sample holdings
		Map<String, Integer> holdings = new HashMap<>();
		holdings.put("INFY", 10);
		holdings.put("TCS", 5);
		holdings.put("RELI", 8);

		for (Stock s : market) {
			System.out.printf("%-6s %7.2f %7.2f %7.2f %8.2f%% %10d\n",
					s.symbol, s.open, s.close, s.change(), s.percentChange(), s.volume);

			int shares = holdings.getOrDefault(s.symbol, 0);
			portfolioValue += shares * s.close;
		}

		System.out.println();
		System.out.printf("Sample portfolio value: %.2f (based on sample holdings)\n", portfolioValue);
		System.out.println();

		System.out.println("Quick tips:\n- Diversify across sectors\n- Focus on long-term fundamentals\n- Use index funds for broad exposure\n- Manage risk with position sizing and stop-losses");
	}
}
