package demo.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceImpl implements Service {

    private final static Logger logger = Logger.getLogger("ServiceImpl");

    @Override
    public void show() {
        logger.log(Level.INFO, "Hello World");
    }
}
