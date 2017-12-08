package com.example.dann.pcsilos;

 import java.util.ArrayList;

/**
 * Created by jdann on 11/10/2017.
 */

public class Silo {
    int id;
    String nombre;
    int fk_id_empresa;
    double tara;
    double capacidad;
    double peso_tara;
    double cell_ouput;
    double cell_gain;
    double cell_adc_range;
    double cell_vcc;
    double cell_cuantity;
    ArrayList<Float>listPeso;




    public Silo(int id, String nombre, ArrayList<Float> listPeso, int fk_id_empresa, double tara, double capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.listPeso = listPeso;
        this.fk_id_empresa = fk_id_empresa;
        this.tara = tara;
        this.capacidad = capacidad;
    }

    public Silo(int id, String nombre, int fk_id_empresa, double tara, double capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.fk_id_empresa = fk_id_empresa;
        this.tara = tara;
        this.capacidad = capacidad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Float> getListPeso() {
        return listPeso;
    }

    public void setPeso(ArrayList<Float> listPeso) {
        this.listPeso = listPeso;
    }

    public int getFk_id_empresa() {
        return fk_id_empresa;
    }

    public void setFk_id_empresa(int fk_id_empresa) {
        this.fk_id_empresa = fk_id_empresa;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}