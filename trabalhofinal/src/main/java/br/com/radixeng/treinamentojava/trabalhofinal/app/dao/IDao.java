package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import com.mongodb.DBObject;

import java.util.List;
import java.util.Map;

public interface IDao {
    void save(Map<String, Object> mapEntity);

    void save(Map<String, Object> mapEntity, String indexKey, boolean unique);
}
