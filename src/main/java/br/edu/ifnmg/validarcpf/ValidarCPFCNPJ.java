package br.edu.ifnmg.validarcpf;

/**
 * Classe utilizada para verificar se um CPF é válido.
 * @author Gustavo
 */
public class ValidarCPFCNPJ {
    long cpf_long;
    String cpf_String;
    
    //<editor-fold defaultstate="collapsed" desc="Set e Get CPF">
    
    public double getCpf_long() {
        return cpf_long;
    }

    public void setCpf_long(long cpf_long)  throws Exception{
        if(!ValidarCPFCNPJ.isCPFValido(cpf_long)){
            throw new Exception("Invalido");
        }
        this.cpf_long = cpf_long;
    }

    public String getCpf_String() {
        return cpf_String;
    }

    public void setCpf_String(String cpf_String) throws Exception{
        if(!ValidarCPFCNPJ.isCPFValido(cpf_String)){
            throw new Exception("Invalido");
        }
        this.cpf_String = cpf_String;
    }
    //</editor-fold>
    
    
    
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
    
    /**
    *Esse metodo faz a contagem de digitos, caso tenha +11 digitos
    *o CPF é invalido.
    * @param cpf
    * @return int
    */
    static int contagemDigito(Long cpf){
        int contador = 0;
        while(cpf >= 1){
            cpf /= 10;
            contador++;
            
        }   
        return contador;
    }
    
    /**
     * Método que utiliza os calculos para validar um CPF.
     * @param cpf
     * @return bool
     */
    static boolean isCPFValido(long cpf){
        int digitos = ValidarCPFCNPJ.contagemDigito(cpf);
        int soma = 0;
        
        if(digitos>11)
            return false;
        
        for(int i = digitos; i > 2; i--){
            soma += (ValidarCPFCNPJ.obterDigito(cpf, i)*(i-1));
        }

        if(11-(soma%11)==10)
            soma = 0;
        if((11-(soma%11))!= ValidarCPFCNPJ.obterDigito(cpf, 2))
            return false;
        
        soma = 0;
        for(int i = digitos; i > 1; i--)
            soma += (ValidarCPFCNPJ.obterDigito(cpf, i)*i);
        
        
        if(11-(soma%11)==10)
            soma = 0;
        
        return (11-(soma%11)) == ValidarCPFCNPJ.obterDigito(cpf, 1);
    }
    
    /**
     * Método Sobrecarregado de validar o CPF, utilizando String de parametro
     * @param cpf
     * @return 
     */
    static boolean isCPFValido(String cpf){
        cpf = cpf.replace(".", "").replace("-", "");
        if(ValidarCPFCNPJ.isCPFValido(Long.parseLong(cpf))){
            return true;
        }
        return false;
    }

}
