package com.kildeen.ref.api;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
 * <p>File created: 2014-05-10 17:10</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class EntityManagerMock implements EntityManager {
    @Override
    public void persist(final Object entity) {

    }

    @Override
    public <T> T merge(final T entity) {
        return null;
    }

    @Override
    public void remove(final Object entity) {

    }

    @Override
    public <T> T find(final Class<T> entityClass, final Object primaryKey) {
        return null;
    }

    @Override
    public <T> T find(final Class<T> entityClass, final Object primaryKey, final Map<String, Object> properties) {
        return null;
    }

    @Override
    public <T> T find(final Class<T> entityClass, final Object primaryKey, final LockModeType lockMode) {
        return null;
    }

    @Override
    public <T> T find(final Class<T> entityClass, final Object primaryKey, final LockModeType lockMode, final Map<String, Object> properties) {
        return null;
    }

    @Override
    public <T> T getReference(final Class<T> entityClass, final Object primaryKey) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public void setFlushMode(final FlushModeType flushMode) {

    }

    @Override
    public FlushModeType getFlushMode() {
        return null;
    }

    @Override
    public void lock(final Object entity, final LockModeType lockMode) {

    }

    @Override
    public void lock(final Object entity, final LockModeType lockMode, final Map<String, Object> properties) {

    }

    @Override
    public void refresh(final Object entity) {

    }

    @Override
    public void refresh(final Object entity, final Map<String, Object> properties) {

    }

    @Override
    public void refresh(final Object entity, final LockModeType lockMode) {

    }

    @Override
    public void refresh(final Object entity, final LockModeType lockMode, final Map<String, Object> properties) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void detach(final Object entity) {

    }

    @Override
    public boolean contains(final Object entity) {
        return false;
    }

    @Override
    public LockModeType getLockMode(final Object entity) {
        return null;
    }

    @Override
    public void setProperty(final String propertyName, final Object value) {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public Query createQuery(final String qlString) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(final CriteriaQuery<T> criteriaQuery) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(final String qlString, final Class<T> resultClass) {
        return null;
    }

    @Override
    public Query createNamedQuery(final String name) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(final String name, final Class<T> resultClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(final String sqlString) {
        return null;
    }

    @Override
    public Query createNativeQuery(final String sqlString, final Class resultClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(final String sqlString, final String resultSetMapping) {
        return null;
    }

    @Override
    public void joinTransaction() {

    }

    @Override
    public <T> T unwrap(final Class<T> cls) {
        return null;
    }

    @Override
    public Object getDelegate() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return null;
    }

    @Override
    public Metamodel getMetamodel() {
        return null;
    }
}
