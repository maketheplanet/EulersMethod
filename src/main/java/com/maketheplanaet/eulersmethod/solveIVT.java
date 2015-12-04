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
     * @param args step size, initial x, initial y,x_final
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double stepSize = new BigDecimal(args[0]).setScale(3, RoundingMode.HALF_UP).floatValue();
        double x_n = new BigDecimal(args[1]).setScale(3, RoundingMode.HALF_UP).floatValue(); //given by Initial value y(0)=1;
        double y_n = new BigDecimal(args[2]).setScale(3, RoundingMode.HALF_UP).floatValue(); //given by Initial value y(0)=1;
        double x_final =new BigDecimal(args[3]).setScale(3, RoundingMode.HALF_UP).floatValue(); //given by Initial value y(0)=1;
         //function f(x,y) = 0.1*sqrt(y)+0.4*x^2
        double y_prime = 0.1*Math.sqrt(y_n)+0.4*Math.pow(x_n, 2);
        double y_nPlusOne;
       
        
        System.out.printf("x value\t\ty value\t\ty' value\t\t\n");
        System.out.printf("-------\t\t-------\t\t-------\t\t\n");
        
        
        do {
           System.out.printf("%.3f\t\t%.3f\t\t%.3f\t\t\n", x_n,y_n,y_prime); 
           x_n=x_n+stepSize;
           y_nPlusOne=y_n + (stepSize*y_prime);
           y_prime=0.1*Math.sqrt(y_nPlusOne)+0.4*Math.pow(x_n, 2);
           y_n=y_nPlusOne;
           
           
        }while (x_n < (x_final+stepSize));

    }

}
