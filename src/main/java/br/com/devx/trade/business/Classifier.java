package br.com.devx.trade.business;

import br.com.devx.trade.domain.Category;
import br.com.devx.trade.domain.TradeAnalysisRequest;


public abstract class Classifier {

    private Classifier nextClassifier;

    public abstract Category rank(TradeAnalysisRequest request);

    public Classifier getNextClassifier() {
        return nextClassifier;
    }

    public void setNextClassifier(Classifier classifier) {
        this.nextClassifier = classifier;
    }

    protected Category nextClassifier(TradeAnalysisRequest request) {
        if (this.getNextClassifier() != null) {
            return this.getNextClassifier().rank(request);
        } else {
            return null;
        }
    }

}
