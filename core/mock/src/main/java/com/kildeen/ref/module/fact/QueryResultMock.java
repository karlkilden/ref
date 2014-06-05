package com.kildeen.ref.module.fact;

import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.mapping.QueryInOutMapper;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-06-05
 */
public class QueryResultMock<E> implements QueryResult<E> {

    List<E> result;

    public QueryResultMock(List<E> result) {
                   this.result = result;
    }

    @Override
    public <X> QueryResult<E> orderAsc(SingularAttribute<E, X> attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> orderAsc(String attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> QueryResult<E> orderDesc(SingularAttribute<E, X> attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> orderDesc(String attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <X> QueryResult<E> changeOrder(SingularAttribute<E, X> attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> clearOrder() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> changeOrder(String attribute) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> maxResults(int max) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> firstResult(int first) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> lockMode(LockModeType lockMode) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> flushMode(FlushModeType flushMode) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> hint(String hint, Object value) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getResultList() {
        List mustCast = new ArrayList<>();

        for (E e :result) {
            if (e instanceof FactDTO) {
                FactDTO dto = (FactDTO) e;
                Fact fact = new Fact();
                fact.setName(dto.getName());
                if (dto.getContent() != null) {
                    String[] words = dto.getContent().split(" ");

                    int index = 0;
                    for (String word : words) {
                        fact.addWord(new WordOccurrence(new Word(word), index));
                    }
                }

                mustCast.add(fact);
            }
        }
        return mustCast;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public E getSingleResult() {
        return result.get(0);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public E getOptionalResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public E getAnyResult() {
        return result.get(0);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long count() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> withPageSize(int pageSize) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> toPage(int page) {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> nextPage() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public QueryResult<E> previousPage() {
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int countPages() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int currentPage() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int pageSize() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
