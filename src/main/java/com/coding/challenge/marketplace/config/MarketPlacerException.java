package com.coding.challenge.marketplace.config;

/**
 * Class to define API exception handling
 */
public class MarketPlacerException extends RuntimeException {

    public MarketPlacerException(String message) {
        super(message);
    }

    public MarketPlacerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarketPlacerException(Throwable cause) {
        super(cause);
    }
}
