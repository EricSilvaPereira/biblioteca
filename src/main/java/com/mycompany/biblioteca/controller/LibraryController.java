/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.controller;
import com.mycompany.biblioteca.view.LibraryView;
/**
 *
 * @author erics
 */
public class LibraryController {
    public static void selectOption() {
        String option = LibraryView.showMenu();
        
        switch(option) {
            case "1": // criar livro
                BookController.createBook();
                break;
            case "2": // listar kivros
                BookController.listBooks();
                break;
            case "3": // fazer emprestimo
                BookController.borrowBook();
                break;
            case "4": // devolver livro
                BookController.returnBook();
                break;
                
        }
    }
}
