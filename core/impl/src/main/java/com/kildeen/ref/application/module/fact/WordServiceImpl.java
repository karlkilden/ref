package com.kildeen.ref.application.module.fact;

import com.kildeen.ref.domain.Word;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * <p>File created: 2014-04-26 20:49</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Stateless
public class WordServiceImpl implements WordService {

    @Inject
    private WordRepository wordRepository;

@Override
    public Word retrieveByString(String string) {
        Word w = wordRepository.findOptionalByStringEqual(string);
        if (w == null) {
            w = new Word(string);
        }
        wordRepository.save(w);
        return w;
    }

}
