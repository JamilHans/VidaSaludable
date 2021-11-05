package com.example.vidasaludable.control.bd;

public class Imc {
    private Integer id;
    private float peso, estatura, resultImc;
    private String categoria;

    public Imc() {
    }

    public Imc(float peso, float estatura, float resultImc, String categoria) {
        this.peso = peso;
        this.estatura = estatura;
        this.resultImc = resultImc;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getResultImc() {
        return resultImc;
    }

    public void setResultImc(float resultImc) {
        this.resultImc = resultImc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
