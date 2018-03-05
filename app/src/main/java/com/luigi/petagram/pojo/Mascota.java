package com.luigi.petagram.pojo;


public class Mascota {
    private int id;
    private String nombre;
    private int rating;
    private int imagen;

    public Mascota(String nombre, int rating, int imagen) {
        this.nombre = nombre;
        this.rating = rating;
        this.imagen = imagen;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
