package com.kildeen.ref.api;

import com.kildeen.ref.application.module.fact.WordService;
import com.kildeen.ref.domain.Word;

/**
 * <p>File created: 2014-05-10 17:11</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class WordServiceMock implements WordService {
    @Override
    public Word retrieveByString(final String string) {
        return null;
    }
}
