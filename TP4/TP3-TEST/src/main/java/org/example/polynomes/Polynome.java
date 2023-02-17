package org.example.polynomes;

import java.util.ArrayList;

public class Polynome {
    private ArrayList<Monome> monomes; // on maintient la liste par ordre de degrés croissants

    public Polynome() {
        monomes=new ArrayList<>();
    }

    public String toString(){
        String result="";
        for (Monome m:monomes){
            result+=m;
        }
        if (monomes.isEmpty()){result="polynôme nul";}
        return result;
    }
    // ajout d'une copie de m au polynome
    public void ajoutMonome(Monome m){

        if (!monomes.isEmpty()) {
            int posCourante=0;
            Monome courant=monomes.get(posCourante);
            // on cherche la position d'insertion
            while (courant.getDegre()<m.getDegre() && posCourante< monomes.size()-1){
                // on passe au monome suivant
                posCourante++;
                courant=monomes.get(posCourante);
            }
            if (courant.getDegre()==m.getDegre()){
                // on avait déjà un monome de même degré, on ajoute les coeff
                courant.ajoutAuCoeff(m.getCoeff());
                if (courant.getCoeff()==0){
                    // on retire le monome nul de la liste
                    monomes.remove(courant);
                }
            }else if (courant.getDegre()>m.getDegre()){
                // on a dépassé la position d'insertion, insertion de m avant le monome courant
                monomes.add(posCourante, new Monome(m)); // juste m dans les premières questions
            } else {
                // on insère à la fin
                monomes.add(new Monome(m)); // juste m dans les premières questions
            }
        }else{ // premier monome du polynome
            monomes.add(new Monome(m)); // juste m dans les premières questions
        }
    }

    /**
     * Multiplication par un monome
     * @param facteur monome par lequel on multiplie le polynome
     * @return le produit du polynpome receveur par facteur
     */
    public Polynome produit(Monome facteur){
        Polynome result=new Polynome();
        for (Monome m:monomes){
            result.ajoutMonome(Monome.produit(m,facteur));
        }
        return result;
    }
    public Polynome somme(Polynome terme){
            Polynome result=new Polynome();
            // on duplique this dans result (prévoir un autre constructeur par copie !!)
            for (Monome m:monomes){
                result.ajoutMonome(m);
            }
            // on ajoute les monomes de terme
            for (Monome mterme:terme.monomes){
                result.ajoutMonome(mterme);
            }
            return result;
}
    public Polynome produit(Polynome facteur){
        Polynome result=new Polynome();
        for (Monome m:monomes){
            result=result.somme(facteur.produit(m));
        }
        return result;
    }



}
