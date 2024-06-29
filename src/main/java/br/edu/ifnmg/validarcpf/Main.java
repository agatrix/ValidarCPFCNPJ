package br.edu.ifnmg.validarcpf;

/**
 * 
 * @author Gustavo
 */
public class Main {
    public static void main(String[] args) {
        ValidarCPFCNPJ objeto = new ValidarCPFCNPJ();
        try {
            objeto.setCpf_long(456789014L);
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            objeto.setCpf_String("002.307.030-58");
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            objeto.setCnpj_long(35017120000186L);
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            objeto.setCnpj_String("35.017.120/0001-86");
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
