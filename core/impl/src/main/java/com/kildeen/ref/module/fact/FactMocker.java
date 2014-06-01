package com.kildeen.ref.module.fact;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * <p>File created: 2014-05-30 11:41</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class FactMocker {

    @Inject
    FactService factService;

    @PostConstruct
    private void init() {

        for (int i =0; i <200 ; i++) {

            FactDTO dto = new FactDTO();

            dto.setName(RandomStringUtils.random(10));
            StringBuilder sb = new StringBuilder();
            for (int j =0; j <10 ; j++) {
                 sb.append(RandomStringUtils.random(10)).append(" ");
            }
            dto.setContent(sb.toString());
            factService.save(dto);
        }

    }


}
