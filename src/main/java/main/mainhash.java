package main;

public class mainhash {
    
    Integer hashCode = null, chave;
    String[] tabHash = new String[26];
    
    mainhash(){
        /*for (int i = 0; i < tabHash.length; i++) {
            tabHash[i] = new String(); 
        }*/
    }
    void inseri_nome(String nome){
        System.out.println();
        // colocar o nome na tabela hash com rehashing

        hashCode = hash(nome);
        String chave = nome;

        //System.out.println("Chave: " + chave + " HashCode: " + hashCode);

        if (tabHash[hashCode] == null) {
            tabHash[hashCode] = chave;
        } else {
            Integer posicao = rehashing(tabHash, chave);
            if (posicao != null) {
                tabHash[posicao] = chave;
            } else {
                System.out.println("Tabela Hash cheia!");
            }
        }
            
            
            
            
        System.out.println("Indice\tNome");
        for (int j = 0; j < tabHash.length; j++) {
            if (tabHash[j] != null) {
            System.out.print( j + " \t");
            System.out.print(tabHash[j]);
            System.out.println();
            }
        
        }
        System.out.println();
    } 

    void procurar_nome(String nome){
        System.out.println();
        // procurar o nome na tabela hash com rehashing
        hashCode = hash(nome);
        String chave = nome;

        //System.out.println("Chave: " + chave + " HashCode: " + hashCode);

        if (tabHash[hashCode] == null) {
            System.out.println("Nome não encontrado em 1 (uma) tentativa!");
        } else {
            for (int i = hashCode; i < tabHash.length; i++) {
                if (tabHash[i] != null) {
                    if (tabHash[i].equals(chave)) {
                        System.out.println("Nome encontrado em " + (i - hashCode + 1) + " tentativas!");
                        break;
                    }
                } else {
                    System.out.println("Nome não encontrado em " + (i - hashCode + 1) + " tentativas!");
                    break;
                }
            }
        }
        System.out.println();


    }



    
    public static Integer hash(String key) {
        int numeroOrdemAlfabetica = key.length() ;
        return numeroOrdemAlfabetica;
    }
    
    
    public static Integer rehashing(String[] tabHash2, String key) {
        Integer hashCode = hash(key);
        if (tabHash2[hashCode] == null) {
            return hashCode;
        } else {
            for (int i = hashCode; i < tabHash2.length; i++) {
                if (tabHash2[i] == null) {
                    return i;
                }
            }
        }
        return null;
    }


}
