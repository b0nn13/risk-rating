package br.com.devx.trade.business;

import br.com.devx.trade.domain.Category;
import br.com.devx.trade.domain.TradeAnalysisRequest;

public class DefaultedClassifier extends Classifier {

    @Override
    public Category rank(TradeAnalysisRequest request) {
        if (riskMatched(request)) {
            return Category.DEFAULTED;
        } else {
            return nextClassifier(request);
        }
    }

    private boolean riskMatched(TradeAnalysisRequest request) {
        return request.getElapsedTime() > 30;
    }
}
