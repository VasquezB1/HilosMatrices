/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.principal;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Byron PC
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        long inicio;
        long finalpro;
        long inicio1;
        long finalpro2;

        inicio = System.currentTimeMillis();

        System.out.println("********** Hilos de Ejecución *********");
        System.out.println("Realizado por:");
        System.out.println("\t Byron Vàsquez");
        System.out.println("**** Programa Hilos ****");
        System.out.println("Ingrese el número de la matriz");
        int matriz = scanner.nextInt();

        int matrizA[][] = new int[matriz][matriz];
        int matrizB[][] = new int[matriz][matriz];
        int matrizRes[][] = new int[matriz][matriz];

        JOptionPane.showMessageDialog(null, "Generando la Matriz A");
        System.out.println("*************************************\n");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA.length; j++) {
                matrizA[i][j] = (int) (Math.random() * 10);
                System.out.print("|" + matrizA[i][j]);
            }
            System.out.println("|" + "\n");
        }
        System.out.println("\n");

        JOptionPane.showMessageDialog(null, "Generando Matriz B");
        System.out.println("*************************************\n");
        System.out.println(" ----- Matriz B ----- ");
        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {

                matrizB[i][j] = (int) (Math.random() * 10);
                System.out.print("|" + matrizB[i][j]);
            }
            System.out.println("|" + "\n");
        }
        System.out.println("\n");

        JOptionPane.showMessageDialog(null, "Generando Matriz Resultante");
        System.out.println("*************************************\n");
        for (int i = 0; i < matriz; i++) {
            for (int j = 0; j < matriz; j++) {
                matrizRes[i][j] = matrizA[i][j] + matrizB[i][j];
                System.out.print("|" + matrizRes[i][j]);
            }
            System.out.println("|" + "\n");
        }

        finalpro = System.currentTimeMillis() - inicio;
        System.out.println((finalpro / 1000) + " segundos");
        System.out.println("\n");

        inicio1 = System.currentTimeMillis();
        System.out.println("Ingrese los hilos a realizar");
        int hilos = scanner.nextInt();
        int hilosdi = matriz % hilos;

        Matrices[] hilo = new Matrices[hilos];
        int filas = 0;
        int siguiente;

        for (int i = 0; i < hilos; i++) {

            siguiente = filas + matriz / hilos;

            if (i < hilosdi) {
                ++siguiente;
            }
            hilo[i] = new Matrices(matrizA, matrizB, matrizRes, filas, siguiente);
            hilo[i].start();
            filas = siguiente;
        }

        for (int i = 0; i < hilos; i++) {
            hilo[i].join();
        }
        System.out.println("\n");

        JOptionPane.showMessageDialog(null, "Realizando resultado con hilos");
        System.out.println("*************************************\n");
        System.out.println("Matriz Resultado");
        for (int i = 0; i < matrizRes.length; i++) {
            for (int j = 0; j < matrizRes.length; j++) {

                System.out.print("|" + matrizRes[i][j]);

            }
            System.out.println("\n");
        }

        finalpro2 = System.currentTimeMillis() - inicio1;
        
        //System.out.println((finalpro2 / 1000000) + " milisegundos");
        long tiempo1 = finalpro / 1000;

        long tiempo2 = finalpro2 / 1000;

        JOptionPane.showMessageDialog(null, "Tiempos Realizados Correctamente");
        System.out.println("**********  Resultados de los procesos **********");
        System.out.println("Proceso suma secuencial: " + (tiempo1) + " segundos");
        System.out.println("Proceso suma paralelo: " + (tiempo2) + " segundos");

    }

}
