
package com.mycompany.api.nom;

public class APINOM {

    
    private int npermisos; 
    private int nvacaciones;
    private double shora;
    private double sdia;
    private int ndías;
    private int nhora;
    private double pagoh;
    private double pagod;

    public APINOM(int npermisos, int nvacaciones, double shora, double sdia, int ndías, int nhora, double pagoh, double pagod) {
        this.npermisos = npermisos;
        this.nvacaciones = nvacaciones;
        this.shora = shora;
        this.sdia = sdia;
        this.ndías = ndías;
        this.nhora = nhora;
        this.pagoh = pagoh;
        this.pagod = pagod;
    }

    public int getNpermisos() {
        return npermisos;
    }

    public void setNpermisos(int npermisos) {
        this.npermisos = npermisos;
    }

    public int getNvacaciones() {
        return nvacaciones;
    }

    public void setNvacaciones(int nvacaciones) {
        this.nvacaciones = nvacaciones;
    }

    public double getShora() {
        return shora;
    }

    public void setShora(double shora) {
        this.shora = shora;
    }

    public double getSdia() {
        return sdia;
    }

    public void setSdia(double sdia) {
        this.sdia = sdia;
    }

    public int getNdías() {
        return ndías;
    }

    public void setNdías(int ndías) {
        this.ndías = ndías;
    }

    public int getNhora() {
        return nhora;
    }

    public void setNhora(int nhora) {
        this.nhora = nhora;
    }

    public double getPagoh() {
        return pagoh;
    }

    public void setPagoh(double pagoh) {
        this.pagoh = pagoh;
    }

    public double getPagod() {
        return pagod;
    }

    public void setPagod(double pagod) {
        this.pagod = pagod;
    }
    
    
   public void calcularnominah(){
   int nd = (this.getNdías()-this.getNpermisos()+this.getNvacaciones());
   this.setNdías(nd);
   double pd = (this.getSdia()*this.getNdías());
   this.setPagod(pd);
   }

  public void calcularnominad(){
  int nd = (this.getNdías()-this.getNpermisos()+this.getNvacaciones());
   this.setNdías(nd);
   double ph = (this.getShora()*this.getNdías());
   this.setPagoh(ph);
  }
}