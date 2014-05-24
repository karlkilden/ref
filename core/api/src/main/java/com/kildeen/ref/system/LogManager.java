package com.kildeen.ref.system;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>File created: 2014-05-16 23:39</p>
*
* @version 1.0
* @author: Karl Kildén
* @since 1.0
*/
public class LogManager {

    public static Logger getLogger() {
        return LoggerFactory.getLogger(new Throwable().getStackTrace()[2].getClass());

    }


}
