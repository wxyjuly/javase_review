package com.leonxi.javase.juc.javaconcurrentactionbook.conc.ch5.matrix;

import com.leonxi.javase.juc.javaconcurrentactionbook.org.jmatrices.dbl.Matrix;
import com.leonxi.javase.juc.javaconcurrentactionbook.org.jmatrices.dbl.MatrixFactory;
import com.leonxi.javase.juc.javaconcurrentactionbook.org.jmatrices.dbl.operator.MatrixOperator;



public class SerialsMatrixMul {

    public static void main(String[] args) {
        Matrix m1=MatrixFactory.getRandomIntMatrix(100, 100, null);
        Matrix m2=MatrixFactory.getRandomIntMatrix(100, 100, null);
        Matrix re=MatrixOperator.multiply(m1, m2);
        System.out.print(m1+"*\n"+m2+"=\n");
        System.out.println(re);
    }

}
