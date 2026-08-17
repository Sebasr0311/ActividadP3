package com.mycompany.biblioteca;

public class Libro extends Material {

    private String codigo;

    public Libro() {
    }

    public Libro(String codigo, String titulo, String autor) {
        super(titulo, autor);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Libro [codigo=" + codigo + ", titulo=" + getTitulo() + ", autor=" + getAutor() + "]";
    }
}