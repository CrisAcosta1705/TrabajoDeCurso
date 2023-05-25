package GestionamientoDeLibreria;

import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String autor;
    private boolean prestado;
    private LocalDate fechaRetorno;
    private int año;
    private String editorial;

    public Libro(String titulo, String autor, String editorial, int año, LocalDate fechaRetorno) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
        this.fechaRetorno = fechaRetorno;
        this.año = año;
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }
}