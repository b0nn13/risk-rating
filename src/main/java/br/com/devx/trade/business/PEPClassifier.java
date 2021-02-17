package br.com.devx.trade.business;

import br.com.devx.trade.domain.Category;
import br.com.devx.trade.domain.ITrade;
import br.com.devx.trade.domain.TradeAnalysisRequest;

public class PEPClassifier extends Classifier {


    @Override
    public Category rank(TradeAnalysisRequest request) {
        if (riskMatched(request)) {
            return Category.PEP;
        } else {
            return nextClassifier(request);
        }
    }

    private boolean riskMatched(TradeAnalysisRequest request) {
        ITrade trade = request.getTrade();
        return trade.isPoliticallyExposed();
    }
}
