package com.epam.java.rt.museco.model.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Municipal Service Company
 * This class defines opportunity to collect sub-entities
 */
public abstract class BaseAggregator implements Aggregatable {
    private final static Logger BASE_AGG_LOG = LoggerFactory.getLogger(BaseAggregator.class);
    private Map<UUID, SubEntitable> subEntities = new HashMap<>();

    @Override
    public boolean containsSubEntity(SubEntitable subEntity) {
        return subEntity != null && this.subEntities.containsValue(subEntity);
    }

    @Override
    public boolean containsSubEntity(UUID subEntityId) {
        return subEntityId != null && this.subEntities.containsKey(subEntityId);
    }

    @Override
    public boolean addSubEntity(SubEntitable subEntity) {
        if (subEntity == null) {
            BASE_AGG_LOG.warn("Trying to add null-subEntity to aggregator");
            return false;
        }
        this.subEntities.put(subEntity.getId(), subEntity);
        subEntity.setAggregator(this);
        BASE_AGG_LOG.info("SubEntity({}) added to aggregator", subEntity.getId());
        return true;
    }

    @Override
    public SubEntitable getSubEntity(UUID subEntityId) {
        if (subEntityId == null) {
            BASE_AGG_LOG.warn("Trying to get subEntity by null-subEntityId from aggregator");
            return null;
        }
        return this.subEntities.get(subEntityId);
    }

    @Override
    public List<SubEntitable> getSubEntities(Class<?> subEntitiesClass){
        List<SubEntitable> subEntities = new ArrayList<>();
        if (this.subEntities.size() > 0) {
            if (subEntitiesClass != null) {
                for (Map.Entry<UUID, SubEntitable> subEntity : this.subEntities.entrySet()) {
                    if (subEntitiesClass.isInstance(subEntity.getValue())) {
                        subEntities.add(subEntity.getValue());
                    }
                }
            }
        }
        return subEntities;
    }

    @Override
    public List<Class> getSubEntitiesClasses() {
        List<Class> classes = new ArrayList<>();
        if (this.subEntities.size() > 0) {
            Set<Class> classSet = new HashSet<>();
            for (Map.Entry<UUID, SubEntitable> subEntity : this.subEntities.entrySet()) {
                classSet.add(subEntity.getClass());
            }
            classes.addAll(classSet);
        }
        return classes;
    }

    @Override
    public boolean removeSubEntity(UUID subEntityId) {
        if (subEntityId == null) {
            BASE_AGG_LOG.warn("Trying to get subEntity by null-subEntityId from aggregator");
            return false;
        }
        SubEntitable subEntity = this.subEntities.get(subEntityId);
        subEntity.setAggregatorToNull();
        this.subEntities.remove(subEntityId);
        BASE_AGG_LOG.info("SubEntity({}) removed from aggregator", subEntity.getId());
        return true;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                "{" +
                "subEntities number=" + subEntities.size() +
                '}';
    }
}