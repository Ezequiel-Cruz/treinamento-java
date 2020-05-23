package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import java.util.Map;

public interface IDao {
    void save(Map<String, Object> mapEntity);

    void save(Map<String, Object> mapEntity, String indexKey, boolean unique);
}
