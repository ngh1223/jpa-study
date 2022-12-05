package com.ngh.util;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface EntityTransactionFunction<T> {
    T doFunction(EntityManager em);
}
