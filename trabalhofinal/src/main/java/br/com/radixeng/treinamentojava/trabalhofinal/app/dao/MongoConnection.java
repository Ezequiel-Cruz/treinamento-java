package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import com.mongodb.*;
import java.net.UnknownHostException;

public class MongoConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "treinamento";

    private static MongoConnection uniqInstance;
    private static int mongoInstance = 1;

    private Mongo mongo;
    private DB db;

    private MongoConnection() {
    }

    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    public DB getDB() {
        if (mongo == null) {
            try {
                mongo = new Mongo(HOST, PORT);
                db = mongo.getDB(DB_NAME);
                System.out.println("Mongo instance equals :> " + mongoInstance++);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return db;
    }
}
