package com.kildeen.ref.application.module.fact;

import com.kildeen.ref.application.module.fact.WordService;
import com.kildeen.ref.domain.Word;

import javax.enterprise.inject.Alternative;

/**
 * <p>File created: 2014-05-10 17:11</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Alternative
public class WordServiceMock implements WordService {
    @Override
    public Word retrieveByString(final String string) {
        return null;
    }
}
