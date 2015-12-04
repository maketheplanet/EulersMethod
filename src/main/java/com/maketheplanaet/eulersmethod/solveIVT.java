/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maketheplanaet.eulersmethod;

import static java.lang.Math.pow;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Heath
 */
public class solveIVT {

    /**
     *
     * @param args step size, initial x, initial y
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double stepSize = new BigDecimal(args[0]).setScale(3, RoundingMode.HALF_UP).floatValue();
        double initial_x = new BigDecimal(args[1]).setScale(3, RoundingMode.HALF_UP).floatValue(); //given by Initial value y(0)=1;
        double initial_y = new BigDecimal(args[2]).setScale(3, RoundingMode.HALF_UP).floatValue(); //given by Initial value y(0)=1;

        double initial_m = initial_y + Math.pow(initial_y, 2); //function f(x,y) = 1+y^2
        
        
        double x_n = initial_x;
        double y_n = initial_y;
        double y_nPlusOne = 0.000f;
        double m =initial_m ;
        // exact solution is given by y=tan(x+PI/4)
        double exactSolution = Math.tan(x_n+Math.PI/4);
        double error = Math.abs(exactSolution - y_n);
        System.out.printf("X value\t\tY value\t\tM value\t\tActual\t\terror\t\t\n");
        System.out.printf("-------\t\t-------\t\t-------\t\t-------\t\t-------\t\t\n");
        
        
        do {
           System.out.printf("%.3f\t\t%.3f\t\t%5.3f\t\t%.3f\t\t%.3f\t\t\n", x_n,y_n,m,exactSolution,error); 
           x_n=x_n+stepSize;
           y_nPlusOne=y_n + (stepSize*m);
           m=y_n+Math.pow(y_nPlusOne, 2);
           y_n=y_nPlusOne;
           exactSolution = Math.tan(x_n+Math.PI/4);
           error=Math.abs(exactSolution - y_n);
           
        }while (x_n <= (initial_x + 1.000f+stepSize));

    }

}
