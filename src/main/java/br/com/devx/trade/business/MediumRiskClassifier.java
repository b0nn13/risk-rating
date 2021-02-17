package br.com.devx.trade.business;

import br.com.devx.trade.domain.Category;
import br.com.devx.trade.domain.Constants;
import br.com.devx.trade.domain.ITrade;
import br.com.devx.trade.domain.TradeAnalysisRequest;

public class MediumRiskClassifier extends Classifier {


    @Override
    public Category rank(TradeAnalysisRequest request) {
        if (riskMatched(request)) {
            return Category.MEDIUMRISK;
        } else {
            return nextClassifier(request);
        }
    }

    private boolean riskMatched(TradeAnalysisRequest request) {
        ITrade trade = request.getTrade();
        boolean isPublic = Constants.PUBLIC.equalsIgnoreCase(trade.getClientSector());
        return isPublic && trade.getValue() > Constants.MAX_VALUE;
    }
}
