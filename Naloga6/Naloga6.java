package Naloga6;

import java.io.*;
import java.util.*;

public class Naloga6{
    static class Tocka{
        public Tocka next;
        public String tocka;
        public boolean obiskan;

        public Tocka(String tocka){
            this.next = null;
            this.tocka = tocka;
            this.obiskan = false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int steviloVnosov = sc.nextInt();
        String[][] tabela = new String[2*steviloVnosov+1][2*steviloVnosov+1]
        for(int i = 0; i < steviloVnosov; i++){
            String vrstica = sc.next();
            String[] vnos = vrstica.split("-");
            String prviDel = vnos[0];
            String drugiDel = vnos[1];
            int i = 0;
            while(tabela[i][0]!=null || tabela[i][0].equals(prviDel)){
                i++;
            }
            tabela[i][0] = prviDel;
            int j = 0;
            while(tabela[j][0]!= null || tabela[j][0].equals(drugiDel)){
                j++;
            }
            tabela[0][i] = prviDel;
            tabela[0][j] = drugiDel;

            
        }

    }

}
