package br.edu.ifnmg.validarcpf;

/**
 * Classe utilizada para verificar se um CPF é válido.
 * @author Gustavo
 */
public class ValidarCpf {
    /**
     * Metodo para obter cada digito do numero obtido.
     * @param cpf
     * @param pos
     * @return int
     */
    static int obterDigito(Long cpf, int pos){
        int div = 10; int mod = 10;
        Double digito = (cpf.doubleValue()
                        %(Math.pow(mod, pos))
                        /(Math.pow(div, pos-1)));
        //Digito recebe o wrapper Double, por conta dos metodos Math
        //retornarem double
        
        return digito.intValue(); 
    }

}
