package com.epam.java.rt.museco.model.general;

import java.util.UUID;

/**
 * museco
 */
public interface SubEntitable {
    UUID getId();
    UUID setId();
    UUID setId(UUID id);
    Aggregatable getAggregator();
    boolean setAggregator(Aggregatable aggregator);
    boolean setAggregatorToNull();
}
