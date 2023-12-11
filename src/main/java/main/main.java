package main;

import java.awt.HeadlessException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("iniciando a Tabela Hash");
        // avisar que a tabela estra vazia
        System.out.println("Tabela Hash vazia!");
        
        
        mainhash hash= new mainhash();
        int escolha = 0;
        try (Scanner Scanner = new Scanner(System.in)) {
            while(escolha != 3){
                System.out.println("1-Inserir\n2-Procurar\n3-sair\n");
                escolha = Integer.valueOf(Scanner.nextLine());

                switch (escolha) {
                    case 1:
                        System.out.print("Nome: ");
                        hash.inseri_nome(Scanner.nextLine());

                        break;
                    case 2:
                        System.out.print("Nome: ");
                        String nome = Scanner.nextLine();
                        hash.procurar_nome(nome);
                        break;
                }
            }
        } catch (NumberFormatException | HeadlessException e) {
            e.printStackTrace();
        }

    }
}
