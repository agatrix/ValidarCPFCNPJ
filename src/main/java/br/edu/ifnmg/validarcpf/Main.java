package br.edu.ifnmg.validarcpf;

/**
 * 
 * @author Gustavo
 */
public class Main {
    public static void main(String[] args) {
        ValidarCPFCNPJ cpf = new ValidarCPFCNPJ();
        try {
            cpf.setCpf_long(456789014L);
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            cpf.setCpf_String("002.307.030-58");
            System.out.println("Valido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
