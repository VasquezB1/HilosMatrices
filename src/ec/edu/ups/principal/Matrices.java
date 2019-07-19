/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.principal;

/**
 *
 * @author Byron PC
 */
public class Matrices extends Thread{
    private final int[][] matriz1;
    private final int[][] matriz2;
    private final int[][] matriz3;
    private final int filasmi;
    private final int filasmax;

    public Matrices(int[][] matriz1, int[][] matriz2, int[][] matriz3, int filasmi, int filasmax) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matriz3 = matriz3;
        this.filasmi = filasmi;
        this.filasmax = filasmax;
    }
    @Override
    public void run(){
        for(int i= filasmi; i<filasmax;i++){
            for(int j=0; j<matriz3[i].length; j++){
                matriz3[i][j] = matriz1[i][j]+matriz2[i][j];
            }
        }
    }
    
}
