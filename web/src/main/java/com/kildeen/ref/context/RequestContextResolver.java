package com.kildeen.ref.context;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>File created: 2014-05-25 10:15</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class RequestContextResolver {


    private void init() {


        Factory<Date> factory = new Factory<Date>() {
            public Date create() {
                return new Date();
            }
        };

        Map<String, Date> lazy = LazyMap.lazyMap(new HashMap<String, Date>(), factory);
        Date date = lazy.get("NOW");
    }
}
