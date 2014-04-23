package com.kildeen.ref.persistence;

import com.kildeen.ref.domain.Book;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * <p>File created: 2014-04-19 11:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository
public interface BookRepository extends EntityRepository<Book, Integer> {
}
