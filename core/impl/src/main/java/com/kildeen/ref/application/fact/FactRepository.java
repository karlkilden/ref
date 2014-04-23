package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Book;
import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository
public interface FactRepository extends EntityRepository<Fact, Long> {

}
