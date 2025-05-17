/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.view;

import javax.swing.JOptionPane;

/**
 *
 * @author erics
 */
public class LibraryView {
    public static String showMenu() {
        // menu de opções
        String option = JOptionPane.showInputDialog("==== Sistema Biblioteca ====\n\n" +
            "Pressione...\n" +
            "1 - para Cadastrar novo livro\n" +
            "2 - para Listar livros cadastrados\n" + 
            "3 - para fazer emprestímo de um livro\n" +
            "4 - para devolver um livro"); 
        return option;
    }
    
}

