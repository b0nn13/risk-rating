package br.com.devx.trade.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ITrade {

    /** indicates the transaction amount in dollars */
    private double value;

    /** indicates the clients sector which can be "Public" or "Private" */
    private String clientSector;

    /** indicates when the next payment from the client to the bank is expected */
    private LocalDate nextPaymentDate;

    /** PEP (politically exposed person) */
    private boolean politicallyExposed;

    public ITrade(double value, String clientSector, LocalDate nextPaymentDate, boolean politicallyExposed) {
        this.value = value;
        this.clientSector = clientSector;
        this.nextPaymentDate = nextPaymentDate;
        this.politicallyExposed = politicallyExposed;
    }

    public ITrade(double value, String clientSector, LocalDate nextPaymentDate) {
        this.value = value;
        this.clientSector = clientSector;
        this.nextPaymentDate = nextPaymentDate;
        this.politicallyExposed = false;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getClientSector() {
        return clientSector;
    }

    public void setClientSector(String clientSector) {
        this.clientSector = clientSector;
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public boolean isPoliticallyExposed() {
        return politicallyExposed;
    }
}
