package br.com.devx.trade.domain;

import br.com.devx.trade.business.*;

import java.time.LocalDate;
import java.util.List;

public class Context {


    private final Classifier pep = new PEPClassifier();
    private final Classifier defaulted = new DefaultedClassifier();
    private final Classifier high = new HighRiskClassifier();
    private final Classifier medium = new MediumRiskClassifier();

    private final LocalDate referenceDate;
    private final List<ITrade> trades;

    public Context(final LocalDate referenceDate, final List<ITrade> trades) {
        this.referenceDate = referenceDate;
        this.trades = trades;
        this.pep.setNextClassifier(this.defaulted);
        this.defaulted.setNextClassifier(this.high);
        this.high.setNextClassifier(this.medium);
    }

    public void checkRiskAnalysis() {
        this.getTrades().forEach(trade -> {
            TradeAnalysisRequest request = new TradeAnalysisRequest(getReferenceDate(), trade);
            Category rank = this.pep.rank(request);
            System.out.println(rank);
        });
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public Integer getCountTrades() {
        return this.trades != null ? this.trades.size() : 0;
    }

    public List<ITrade> getTrades() {
        return trades;
    }

}
