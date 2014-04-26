package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.domain.Word;
import org.apache.deltaspike.data.api.*;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository
public interface WordRepository extends EntityRepository<Word, Long> {

    public Word findOptionalByStringEqual(String string);

}
