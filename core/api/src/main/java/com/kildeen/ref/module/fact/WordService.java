package com.kildeen.ref.module.fact;

import com.kildeen.ref.domain.Word;

/**
 * <p>File created: 2014-04-27 00:54</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface WordService {
    Word retrieveByString(String string);

}
