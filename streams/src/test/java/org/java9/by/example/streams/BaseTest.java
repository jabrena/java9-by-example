package org.java9.by.example.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

abstract class BaseTest {
    private static Logger logger;
    static Consumer<Object> trace;

    static <T> void setupLogger(Class<T> myClass){
        logger = LoggerFactory.getLogger(myClass);
        trace =  o -> logger.trace(o.toString());
    }
}
