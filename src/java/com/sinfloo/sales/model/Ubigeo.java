
package com.sinfloo.sales.model;

public class Ubigeo {
    private int ubigeoId;
    private Departament departament;
    private Province province;
    private District district;

    public Ubigeo() {
    }

    public Ubigeo(int ubigeoId, Departament departament, Province province, District district) {
        this.ubigeoId = ubigeoId;
        this.departament = departament;
        this.province = province;
        this.district = district;
    }

    public int getUbigeoId() {
        return ubigeoId;
    }

    public void setUbigeoId(int ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
    
}
