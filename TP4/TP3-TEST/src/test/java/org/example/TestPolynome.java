package org.example;

import org.example.polynomes.DegreNegatifException;
import org.example.polynomes.Monome;
import org.example.polynomes.Polynome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TestPolynome {
    Monome m0;
    Monome m1;
    Monome m2;
    Monome m3;
    Polynome p1;
    Polynome p2;

    @BeforeEach
    void setUp() {
        this.p1 = new Polynome();
        this.p2 = new Polynome();
        this.m0 = new Monome(0,2);
        this.m1 = new Monome(4,2);
        this.m2 = new Monome(5,3);
        this.m3 = new Monome(2,2);
        p1.ajoutMonome(m1);
        p2.ajoutMonome(m2);
    }

    @Test
    void toStringTestDegreeZero(){
        p1.ajoutMonome(m0);
        assertEquals(p1.toString(),"+4x^2");
    }

    @Test
    void toStringTestMemeDegree(){
        p1.ajoutMonome(m1);
        assertEquals(p1.toString(),"+8x^2");
    }

    @Test
    void toStringTestDegreeDiff(){
        p1.ajoutMonome(m2);
        assertEquals(p1.toString(),"+4x^2+5x^3");
    }

    @Test
    void toStringProduit(){
        assertEquals(p1.produit(p2).toString(),"+20x^5");
    }

}
