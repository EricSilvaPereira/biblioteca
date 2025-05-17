/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.controller;

import com.mycompany.biblioteca.model.Book;
import com.mycompany.biblioteca.view.BookView;
import com.mycompany.biblioteca.view.LibraryView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author erics
 */
public class BookController {

    private static List<Book> books = new ArrayList<>();

    // validating user input
    public static String getValidatedStringInput(Supplier<String> prompt, String errorMessage) {
        String input;
        while (true) {
            input = prompt.get();
            if (input.trim().isEmpty()) {
                BookView.showMessage(errorMessage);
                continue;
            }
            break;
        }
        return input;
    }

    // validating int input
    public static int getValidatedIntInput(Supplier<String> prompt, String errorMessage) {
        int value = 0;
        while (true) {
            try {
                value = Integer.parseInt(prompt.get());
                if (value <= 0) {
                    BookView.showMessage(errorMessage);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                BookView.showMessage(errorMessage);
            }
        }
        return value;
    }

    public static void createBook() {
        // title
        String bookTitle = getValidatedStringInput(() -> BookView.requestTitle(), "O título do livro não pode ser vazio.");

        // author
        String bookAuthor = getValidatedStringInput(() -> BookView.requestAuthor(bookTitle), "O autor do título do livro não pode ser vazio.");

        // publisher
        String bookPublisher = getValidatedStringInput(() -> BookView.requestPublisher(bookTitle), "A editora do título do livro não pode ser vazia.");

        // yearOfPublication
        int yearOfPublication = getValidatedIntInput(() -> BookView.requestYearOfPublication(bookTitle), "Ano inválido.");

        // genre
        String bookGenre = getValidatedStringInput(() -> BookView.requestGenre(bookTitle), "O gênero do título do livro não pode ser vazia.");

        // numberOfPages
        int numberOfPages = getValidatedIntInput(() -> BookView.requestNumberOfPages(bookTitle), "Número de páginas inválido.");

        Book book = new Book(bookTitle, bookAuthor, bookPublisher, yearOfPublication, bookGenre, numberOfPages);
        books.add(book);

        BookView.showMessage("Livro cadastrado com sucesso!");

    }

    public static void listBooks() {
        if (books.isEmpty()) {
            BookView.showMessage("Nenhum livro cadastrado.");
            return;
        }

        StringBuilder allBooks = new StringBuilder("Livros cadastrados: \n\n");
        for (Book book : books) {
            allBooks.append("Título: ").append(book.getTitle()).append("\n")
                    .append("Autor: ").append(book.getAuthor()).append("\n")
                    .append("Editora: ").append(book.getGenre()).append("\n")
                    .append("Ano: ").append(book.getYearOfPublication()).append("\n")
                    .append("Gênero: ").append(book.getGenre()).append("\n")
                    .append("Páginas: ").append(book.getNumberOfPages()).append("\n")
                    .append(book.getAvailability()).append("\n")
                    .append("-------------------------\n");
        }
        BookView.showMessage(allBooks.toString());
    }

    public static void borrowBook() {
        String id = listAvailableBooks();
        if (id == null) return;
        
        boolean found = false;
        
        for (Book book : books) {
            if (book.getId() == Integer.parseInt(id)) {
                found = true;
                if (!book.getIsAvaliable()) {
                    BookView.showMessage("O livro não está disponível.");
                } else {
                    book.markAsUnavailable();
                    BookView.showMessage("O livro emprestado com sucesso.");
                }
                break;
            }
        }         
        if(!found) BookView.showMessage("Livro não encontrado, digite o código corretamente.");
    }

    public static String listAvailableBooks() {
        StringBuilder availableBooks = new StringBuilder("Livros disponíveis: \n\n");
        boolean hasAvailable = false;
        for (Book book : books) {
            if (book.getIsAvaliable()) {
                hasAvailable = true;
                availableBooks.append("Código: ").append(book.getId()).append("\n")
                        .append("Título: ").append(book.getTitle()).append("\n")
                        .append("----------------------\n");
            }
        }
        
        if (!hasAvailable) {
            BookView.showMessage("Não há livros disponíveis. ");
            return null;
        } else {
            availableBooks.append("Digite o código do livro escolhido: ");
            return BookView.showInputMessage(availableBooks.toString());
        }
    }
    
    public static String listBorrowBooks() {
        StringBuilder borrowBooks = new StringBuilder("Livros emprestados: \n\n");
        boolean hasBorrow = false;
        for (Book book : books) {
            if (!book.getIsAvaliable()) {
                hasBorrow = true;
                borrowBooks.append("Código: ").append(book.getId()).append("\n")
                        .append("Título: ").append(book.getTitle()).append("\n")
                        .append("----------------------\n");
            }
        }
        
        if (!hasBorrow) {
            BookView.showMessage("Não há livros emprestados. ");
            return null;
        } else {
            borrowBooks.append("Digite o código do livro que deseja devolver: ");
            return BookView.showInputMessage(borrowBooks.toString());
        }
    }
    
    public static void returnBook() {
        String id = listBorrowBooks();
        if (id == null) return;
        
        boolean found = false;
        
        for (Book book : books) {
            if (book.getId() == Integer.parseInt(id)) {
                found = true;
                if (book.getIsAvaliable()) {
                    BookView.showMessage("O livro já devolvido");
                } else {
                    book.markAsAvailable();
                    BookView.showMessage("O livro devolvido com sucesso.");
                }
                break;
            }
        }         
        if(!found) BookView.showMessage("Livro não encontrado, digite o código corretamente.");
        
    }
}
