package com.kildeen.ref.fact;

import com.kildeen.ref.application.module.fact.FactDTO;
import com.kildeen.ref.application.module.fact.FactService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Model
public class FactBean {

    private FactDTO fact = new FactDTO();

    @Inject
    private FactService factService;

    public void saveFact() {
        factService.save(fact);
        fact = new FactDTO();
    }

    public FactDTO getFact() {
        return fact;
    }

    public void setFact(final FactDTO fact) {
        this.fact = fact;
    }
}
