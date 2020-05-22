package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import java.util.Map;

public class EntityDao<T> implements IDao {

    private Class<T> persistentClass;
    private DBCollection dbCollection;

    public EntityDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection =
                MongoConnection.getInstance()
                        .getDB().getCollection(persistentClass.getSimpleName());
    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }

    public void save(Map<String, Object> mapEntity) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.save(document);

        System.out.println("Save :> " + document);

        System.out.println("Collection :> " + dbCollection.getName());
    }

    public void save(Map<String, Object> mapEntity, String indexKey, boolean unique) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.ensureIndex(new BasicDBObject(indexKey, 1), null, unique);

        dbCollection.save(document);

        System.out.println("Save :> " + document);
    }


}