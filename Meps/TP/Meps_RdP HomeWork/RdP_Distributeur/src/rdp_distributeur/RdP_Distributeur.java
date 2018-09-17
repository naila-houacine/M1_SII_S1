
package rdp_distributeur;

import java.util.Scanner;

/**
 *
 * @author HOUACINE Naila
 */

public class RdP_Distributeur {
    
    int S5 = 5; //Stock de pièce de 5 DA
    int S10 = 3; //Stock de pièce de 10 DA
    int S20 = 0; //Stock de pièce de 20 DA
    
    /*methode pour ajouter 1 piéce de 5 DA au stock S5*/
    void AjouterAuStock5(){
        S5++;
    }
    
    /*methode pour ajouter 1 piéce de 10 DA au stock S10*/
    void AjouterAuStock10(){
        S10++;
    }
    
   /*methode pour ajouter 1 piéce de 20 DA au stock S20*/
    void AjouterAuStock20(){
        S20++;
    }
    
    /*methode pour soustraire 1 piéce de 5 DA au stock S5*/
    boolean Soustraire1AuStock5(){
        if(S5 > 0){
            S5--;
            return true;
        }
        else System.err.println("[5]- Stock inssufisant !!");
        return false;
    }
    
    /*methode pour soustraire 3 piéces de 5 DA au stock S5*/
    boolean Soustraire3AuStock5(){
        if(S5 > 2){
            S5 = S5 - 3;
            return true;
        }
        else System.err.println("[5]- Stock inssufisant !!");
        return false;
    }
    
    /*methode pour ajouter 1 piéce de 10 DA au stock S10*/
    boolean Soustraire1AuStock10(){
        if(S10 > 0){
            S10--;
            return true;
        }
        else System.err.println("[10]- Stock inssufisant !!");
            return false;
        
    }
    
    /*affichage*/
    void Affichage(int rendu5 , int rendu10){
                    
            //Donner la sucrerie
            System.out.println("*********** Voici votre sucrerie ************");
            System.out.println("        **        ***********        **      ");
            System.out.println("        * *      *           *      * *      ");
            System.out.println("        *   *   *             *   *   *      ");
            System.out.println("        *    ****    bonbon   ****    *      ");
            System.out.println("        *    ****      au     ****    *      ");
            System.out.println("        *    ****    caramel  ****    *      ");
            System.out.println("        *   *   *             *   *   *      ");
            System.out.println("        * *      *           *      * *      ");
            System.out.println("        **        ***********        **      ");


            //Affichage des pieces rendu
            System.out.println(" ");System.out.println(" ");
            System.out.println("******************* RENDU ********************");
            System.out.println("**********************************************");
            System.out.println("    ****      "+ rendu5 +" pièce(s) de 5 DA      ****");
            System.out.println("**********************************************");
            System.out.println("    ****      "+ rendu10 +" pièce(s) de 10 DA     ****");
            System.out.println("**********************************************");
            System.out.println(" ");

            //Affichage des stock
            System.out.println("******************* STOCK ********************");
            System.out.println("**********************************************");
            System.out.println("  ***  Stock de pièce(s) de 5 DA  = "+ S5 +"  ***");
            System.out.println("**********************************************");
            System.out.println("  ***  Stock de pièce(s) de 10 DA  = "+ S10 +"  ***");
            System.out.println("**********************************************");
            System.out.println("  ***  Stock de pièce(s) de 20 DA  = "+ S20 +"  ***");
            System.out.println("**********************************************");
            System.out.println(" ");
    }
    
    
    
    public static void main(String[] args) {
        int piece;
        int rendu5 = 0,rendu10 = 0;
        
        Scanner lectureClavier = new Scanner(System.in);
        RdP_Distributeur D = new RdP_Distributeur();
        
        while(true){
            rendu5 = 0;
            rendu10 = 0;
            //introduire la piece
            do{
                System.out.println("Veuillez introduire une pièce de 5 DA ou 10 DA ou meme 20 DA :");
                piece = lectureClavier.nextInt();}
            while(piece != 5 && piece != 10 && piece != 20 );

            if(piece == 5){
                D.AjouterAuStock5();
                D.Affichage(rendu5, rendu10);

            }else if(piece == 10){
                D.AjouterAuStock10();
                if(D.Soustraire1AuStock5()){
                    rendu5 = 1;
                    D.Affichage(rendu5, rendu10);
                }

            }else{
                D.AjouterAuStock20();
                if(D.Soustraire1AuStock10()){
                    rendu10 = 1;
                    if(D.Soustraire1AuStock5()){
                        rendu5 = 1;
                        D.Affichage(rendu5, rendu10);
                    }
                    
                    
                }
                else{
                    if(D.Soustraire3AuStock5()){
                        rendu5 = 3;
                        D.Affichage(rendu5, rendu10);
                    }
                }

            }
        }
    }
    
}
