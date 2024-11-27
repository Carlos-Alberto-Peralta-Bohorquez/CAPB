
package com.sinfloo.sales.model.dao;

import com.sinfloo.sales.model.Product;
import java.util.List;
import java.util.Map;


public interface ProductDao {
    public List<Product>getAll();
    public Product getObjectById(int id);
    public Product getObjectByCode(String code);
    public int saveObject(Map<String,Object>requestBody);
    public void deleteObjectById(int id);
    public boolean existProductByName(String name);
}
