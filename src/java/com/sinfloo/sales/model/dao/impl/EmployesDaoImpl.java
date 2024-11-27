package com.sinfloo.sales.model.dao.impl;

import com.sinfloo.sales.config.ConnectDB;
import com.sinfloo.sales.model.Departament;
import com.sinfloo.sales.model.District;
import com.sinfloo.sales.model.Employes;
import com.sinfloo.sales.model.Profile;
import com.sinfloo.sales.model.Province;
import com.sinfloo.sales.model.Ubigeo;
import com.sinfloo.sales.model.User;
import com.sinfloo.sales.model.dao.EmployesDao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployesDaoImpl implements EmployesDao {

    private static final Logger LOGGER=Logger.getLogger(EmployesDaoImpl.class.getName());
    
    @Override
    public Employes getObjectByUser(User user) {
        Employes employe = new Employes();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("e.n_id_employe  ");
        query.append(",e.c_code ");
        query.append(",p.n_id_person ");
        query.append(",p.c_name ");
        query.append(",p.c_first_name ");
        query.append(",p.c_last_name ");
        query.append(",e.c_address ");
        query.append(",e.c_phone_main ");
        query.append(",e.c_email_main ");
        query.append(",e.c_username ");
        query.append(",mp.n_id_profile ");
        query.append(",mp.c_description ");
        query.append(",mp.c_state ");
        query.append(",u.n_id_ubigeo ");
        query.append(",u.c_departamento_inei ");
        query.append(",u.c_departamento ");
        query.append(",u.c_provincia_inei ");
        query.append(",u.c_provincia ");
        query.append(",u.c_ubigeo_inei ");
        query.append(",u.c_distrito ");
        query.append("from m_employes e INNER JOIN m_person p ");
        query.append("on e.n_id_person=p.n_id_person INNER JOIN m_profile mp ");
        query.append("on e.n_id_profile=mp.n_id_profile INNER JOIN m_ubigeo u ");
        query.append("ON e.n_id_ubigeo=u.n_id_ubigeo ");
        query.append("WHERE e.c_username=? and e.c_password=? and e.c_state='1'");
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query.toString());
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                employe.setEmployeId(rs.getInt("n_id_employe"));
                employe.setEmployeCode(rs.getString("c_code"));
                employe.setPersonId(rs.getInt("n_id_person"));
                employe.setName(rs.getString("c_name"));
                employe.setFirstName(rs.getString("c_first_name"));
                employe.setLastName(rs.getString("c_last_name"));
                employe.setAddress(rs.getString("c_address"));
                employe.setNumberPhone(rs.getString("c_phone_main"));
                employe.setEmail(rs.getString("c_email_main"));
                employe.setUser(new User(rs.getString("c_username"), "", new Profile(rs.getInt("mp.n_id_profile"), rs.getString("mp.c_description"), rs.getString("mp.c_state"))));
                employe.setUbigeo(new Ubigeo(rs.getInt("n_id_ubigeo"),
                        new Departament(rs.getString("c_departamento_inei"), rs.getString("c_departamento")),
                        new Province(rs.getString("c_provincia_inei"), rs.getString("c_provincia")),
                        new District(rs.getString("c_ubigeo_inei"), rs.getString("c_distrito"))));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}",e.getLocalizedMessage());
        }catch(Exception e){
            LOGGER.log(Level.INFO, "ERROR:{0}",e.getLocalizedMessage());
            throw new RuntimeException(e.getLocalizedMessage());
        }finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(conn!=null){
                    ConnectDB.releaseConnection(conn);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}",e.getLocalizedMessage());
            }
        }

        return employe;

    }

}
