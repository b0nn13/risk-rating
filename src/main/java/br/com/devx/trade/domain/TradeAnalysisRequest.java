package br.com.devx.trade.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TradeAnalysisRequest {

    private final LocalDate dateReference;
    private final ITrade trade;

    public TradeAnalysisRequest(final LocalDate dateReference, final ITrade trade) {
        this.dateReference = dateReference;
        this.trade = trade;
    }

    public Long getElapsedTime() {
        if (this.dateReference != null && this.trade != null && this.trade.getNextPaymentDate() != null) {
            return ChronoUnit.DAYS.between(this.trade.getNextPaymentDate(), this.dateReference);
        } else  {
            return 0L;
        }
    }

    public LocalDate getDateReference() {
        return dateReference;
    }

    public ITrade getTrade() {
        return trade;
    }

}
