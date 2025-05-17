/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.view;
import com.mycompany.biblioteca.model.Book;
import javax.swing.JOptionPane;

/**
 *
 * @author erics
 */
public class BookView {
    
    // create book
    public static String requestTitle () {
        return JOptionPane.showInputDialog("Digite o título do livro: \n");
    }

    public static String requestAuthor (String bookTitle) {
      return JOptionPane.showInputDialog("Livro: " + bookTitle + "\nDigite o autor do livro: \n");
    }
    
    public static String requestPublisher (String bookTitle) {
        return JOptionPane.showInputDialog("Livro: " + bookTitle + "\nDigite a editora do livro: \n");
    }
    
    public static String requestYearOfPublication (String bookTitle) {
      return JOptionPane.showInputDialog("Livro: " + bookTitle + "\nDigite o ano de publicação do livro: \n");
    }
    
    public static String requestGenre (String bookTitle) {
        return JOptionPane.showInputDialog("Livro: " + bookTitle + "\nDigite o genero do livro: \n");
    }
    
    public static String requestNumberOfPages (String bookTitle) {
        return JOptionPane.showInputDialog("Livro: " + bookTitle + "\nDigite a quantidade de pagínas do livro: \n");
    }
    
   public static void showMessage(String message) {
       JOptionPane.showMessageDialog(null, message);
   }
   
   public static String showInputMessage(String message) {
       return JOptionPane.showInputDialog(null, message);
   }
   
   
}