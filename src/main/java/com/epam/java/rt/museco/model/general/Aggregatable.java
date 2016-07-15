package com.epam.java.rt.museco.model.general;

import java.util.List;
import java.util.UUID;

/**
 * museco
 */
public interface Aggregatable {
    boolean containsSubEntity(SubEntitable subEntity);

    boolean containsSubEntity(UUID subEntityId);

    boolean addSubEntity(SubEntitable subEntity);

    SubEntitable getSubEntity(UUID subEntityId);

    public List<SubEntitable> getSubEntities(Class<?> subEntitiesClass);

    public List<Class> getSubEntitiesClasses();

    boolean removeSubEntity(UUID subEntityId);

}
