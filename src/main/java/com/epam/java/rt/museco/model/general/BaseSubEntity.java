package com.epam.java.rt.museco.model.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Municipal Service Company
 * This class defines opportunity entity to be collected
 */
public abstract class BaseSubEntity implements SubEntitable {
    private final static Logger BASE_SUB_ENTITY_LOG = LoggerFactory.getLogger(BaseSubEntity.class);
    private UUID id;
    private Aggregatable aggregator;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID setId() {
        this.id = UUID.randomUUID();
        BASE_SUB_ENTITY_LOG.info("SubEntity id set to {}", this.id);
        return this.id;
    }

    @Override
    public UUID setId(UUID id) {
        this.id = id;
        BASE_SUB_ENTITY_LOG.info("SubEntity id set to {}", this.id);
        return this.id;
    }

    @Override
    public Aggregatable getAggregator() {
        return this.aggregator;
    }

    @Override
    public boolean setAggregator(Aggregatable aggregator) {
        if (this.aggregator == aggregator) return true;
        if (this.aggregator != null) this.aggregator.removeSubEntity(this.id);
        if (aggregator == null) return setAggregatorToNull();
        if (aggregator.containsSubEntity(this.id)) {
            this.aggregator = aggregator;
            BASE_SUB_ENTITY_LOG.info("SubEntity({}) aggregator set", this.id);
            return true;
        }
        BASE_SUB_ENTITY_LOG.warn("Trying to set aggregator-link, but aggregator not contains subEntity({})", this.id);
        return false;
    }

    @Override
    public boolean setAggregatorToNull() {
        if (this.aggregator != null && this.aggregator.containsSubEntity(this.id)) {
            BASE_SUB_ENTITY_LOG.warn("Trying to set aggregator-link to null, but aggregator still contains subEntity({})", this.id);
            return false;
        }
        this.aggregator = null;
        BASE_SUB_ENTITY_LOG.info("SubEntity({}) aggregator set to null", this.id);
        return true;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                "{" +
                "id=" + id +
                ", aggregator=" + aggregator +
                '}';
    }
}
