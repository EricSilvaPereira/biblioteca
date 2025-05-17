/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.model;

/**
 *
 * @author erics
 */
public class Book {
    private static int counterId = 0;
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublication;
    private String genre;
    private int numberOfPages;
    private boolean isAvailable = true;

    public Book () {
        this.id = counterId++;
    }

    public Book (String titulo, String autor, String editora, int anoPublicacao, String genero, int quantidadeTotal) {
        this();
        this.title = titulo;
        this.author = autor;
        this.publisher = editora;
        this.yearOfPublication = anoPublicacao;
        this.genre = genero;
        this.numberOfPages = quantidadeTotal;
    }
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getYearOfPublication() {
        return this.yearOfPublication;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }
    
    public String getAvailability() {
        return isAvailable ? "Disponível" : "Indisponível";
    }
    
    public boolean getIsAvaliable() {
        return isAvailable;
    }
    
    public void markAsAvailable() {
        isAvailable = true;
    }
    
    public void markAsUnavailable() {
        isAvailable = false;
    }

    public void setBookTitle(String bookTitle) {
        this.title = bookTitle;
    }
    
    public void setAutorLivro(String novoAutor) {
        this.author = novoAutor;
    }
    
    public void setEditoraLivro(String novaEditora) {
        this.publisher = novaEditora;
    }
    
    public void setAnoPublicacaoLivro(int novoAnoPublicacao) { // tipo int
        this.yearOfPublication = novoAnoPublicacao;
    }
    
    public void setGeneroLivro(String novoGenero) {
        this.genre = novoGenero;
    }
    
    public void setQuantidadeTotalLivro(int novaQuantidadeTotal) { // tipo int
        this.numberOfPages = novaQuantidadeTotal;
    }
       
}
