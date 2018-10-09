package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;

import static java.lang.Class.*;

public class Factory {
    final static Logger log = Logger.getLogger(Factory.class.getName());

    private static final String PACKAGE = "edu.upc.eetac.dsa";
    private static Factory instance;
    private HashMap<String, Command> cache;

    private Factory() {
        this.cache = new HashMap<String, Command>();
    }

    public static Factory getInstance() {
        if (instance==null) instance = new Factory();

        return instance;
    }

    //We use this private function to load the class, whose name is entered by the user
    private Command getCommand2(String idCommand) {

        Command command = null;
        Class theClass = null;
        try {
            //We try to load the classes, specially the classes C1,C2 and C3
            theClass = Class.forName(PACKAGE+"."+idCommand);
            command = (Command)theClass.newInstance();
        } catch (InstantiationException e) {
            //Error message because the class that we're trying to load isn't instantiated
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //Error message because we don't have permission in the class that we're trying to load
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //Error message because the class that we're trying to load doesn't exist
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //We return a Command
        return command;
    }

    //This function has the same structure than the Singleton Project
    public Command getCommand(String idCommand) {
        Command c = cache.get(idCommand);
        if (c==null) {
            //If the class doesn't exist in the cache HashMap, we have to put it
            log.info("utilitzem el carregador de classes");
            c = getCommand2(idCommand);
            cache.put(idCommand, c);
        }
        else {
            log.info("CACHE!!!");
        }
        //Return the Command
        return c;
    }
}
