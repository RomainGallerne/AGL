package org.example;

import org.example.polynomes.DegreNegatifException;
import org.example.polynomes.Monome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.polynomes.Monome.produit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class


TestMonome {
    Monome m0;
    Monome m1;
    Monome m2;

    @BeforeEach
    void setUp() {
        this.m0 = new Monome(4,0);
        this.m1 = new Monome(4,1);
        this.m2 = new Monome(6,3);
    }

    @Test
    void toStringTest0(){assertEquals(m0.toString(),"+4");
    }

    @Test
    void toStringTest1(){assertEquals(m1.toString(),"+4x");
    }

    @Test
    void degreeNegativeException(){
        try{
            Monome mn1 = new Monome(4,-1);
        }
        catch(DegreNegatifException d){
            assert(true);
        }
    }

    @Test
    void toStringProduitTest(){
        assertEquals(produit(m1,m2).toString(),"+24x^4");
    }

    @Test
    void evalTest(){
        assertEquals(m2.eval(2),48.0);
    }

}