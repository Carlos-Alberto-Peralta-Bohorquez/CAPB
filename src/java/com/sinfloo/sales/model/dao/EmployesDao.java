
package com.sinfloo.sales.model.dao;

import com.sinfloo.sales.model.Employes;
import com.sinfloo.sales.model.User;


public interface EmployesDao {
    public Employes getObjectByUser(User user);
}
