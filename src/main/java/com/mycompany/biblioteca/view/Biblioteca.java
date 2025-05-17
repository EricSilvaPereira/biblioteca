/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.biblioteca.view;

import com.mycompany.biblioteca.controller.LibraryController;

/**
 *
 * @author erics
 */
public class Biblioteca {

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        while (true) {
            controller.selectOption();
        }
    }
}
