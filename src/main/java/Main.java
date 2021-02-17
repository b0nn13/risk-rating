import br.com.devx.trade.business.Classifier;
import br.com.devx.trade.business.DefaultedClassifier;
import br.com.devx.trade.business.HighRiskClassifier;
import br.com.devx.trade.business.MediumRiskClassifier;
import br.com.devx.trade.domain.Context;
import br.com.devx.trade.domain.ITrade;
import br.com.devx.trade.util.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        String refDateStr = INPUT.next();
        LocalDate refDate = DateUtil.toLocalDate(refDateStr);
        Integer countTraders = INPUT.nextInt();

        List<ITrade> trades = loadTrades(countTraders);
        Context context = new Context(refDate, trades);
        context.checkRiskAnalysis();
    }

    private static List<ITrade> loadTrades(Integer countTraders) {
        List<ITrade> trades = new ArrayList<>();
        for (int i = 0; i < countTraders; i++) {
            ITrade trade = loadTrade();
            trades.add(trade);
        }
        return trades;
    }

    private static ITrade loadTrade() {
        double value = INPUT.nextDouble();
        String sector = INPUT.next();
        String nextPaymentStr = INPUT.next();
        LocalDate nextPayment = DateUtil.toLocalDate(nextPaymentStr);
        ITrade trade = new ITrade(value, sector, nextPayment);
        return trade;
    }
}
