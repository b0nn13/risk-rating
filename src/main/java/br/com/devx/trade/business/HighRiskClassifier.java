package br.com.devx.trade.business;

import br.com.devx.trade.domain.Category;
import br.com.devx.trade.domain.Constants;
import br.com.devx.trade.domain.ITrade;
import br.com.devx.trade.domain.TradeAnalysisRequest;

public class HighRiskClassifier extends Classifier {

    @Override
    public Category rank(TradeAnalysisRequest request) {
        if (riskMatched(request)) {
            return Category.HIGHRISK;
        } else {
            return nextClassifier(request);
        }
    }

    private boolean riskMatched(TradeAnalysisRequest request) {
        ITrade trade = request.getTrade();
        boolean isPrivate = Constants.PRIVATE.equalsIgnoreCase(trade.getClientSector());
        return isPrivate && trade.getValue() > Constants.MAX_VALUE;
    }
}
