package com.efebyte.sqlitetrabajo.Model;

public class ItemSave {
    private String Ubicacion;
    private String Calle;
    private String Lote;
    private String Fecha;
    private String Rut;

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }


    @Override
    public String toString() {
        return "ItemSave [ubicacion=" + Ubicacion + ",calle=" + Calle + ", lote="+ Lote + ",fecha=" + Fecha + ",rut=" + Rut +"]";
    }
}
