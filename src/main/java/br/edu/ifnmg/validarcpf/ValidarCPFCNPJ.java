package br.edu.ifnmg.validarcpf;

/**
 * Classe utilizada para verificar se um CPF é válido.
 * @author Gustavo
 */
public class ValidarCPFCNPJ {
    private long cpf_long;
    private String cpf_String;
    private long cnpj_long;
    private String cnpj_String;
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

    //<editor-fold defaultstate="collapsed" desc="Set e Get CNPJ">
    public long getCnpj_long() {
        return cnpj_long;
    }

    public void setCnpj_long(long cnpj_long)throws Exception {
        if(!ValidarCPFCNPJ.isCNPJValido(cnpj_long)){
            throw new Exception("Invalido");
        }
        
        this.cnpj_long = cnpj_long;
    }

    public String getCnpj_String() {
        return cnpj_String;
    }

    public void setCnpj_String(String cnpj_String) throws Exception{
        if(!ValidarCPFCNPJ.isCNPJValido(cnpj_String)){
            throw new Exception("Invalido");
        }
        
        this.cnpj_String = cnpj_String;
    }
    //</editor-fold>
    
    
    /**
     * Metodo para obter cada digito do numero obtido.
     * @param cpf
     * @param pos
     * @return int
     */
    private static int obterDigito(Long cpf, int pos){
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
    private static int contagemDigito(Long cpf){
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
    public static boolean isCPFValido(long cpf){
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
    public static boolean isCPFValido(String cpf){
        cpf = cpf.replace(".", "").replace("-", "");
        
        return ValidarCPFCNPJ.isCPFValido(Long.parseLong(cpf));
    }
    
    public static boolean isCNPJValido(long cnpj){
        int digitos = ValidarCPFCNPJ.contagemDigito(cnpj);
        int vetor[] = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        int soma = 0;

        if(digitos>14)
            return false;
        
        for(int i = digitos; i > 2; i--){

            soma += (ValidarCPFCNPJ.obterDigito(cnpj, i)*vetor[15-i]);
        }

        if(11-(soma%11)==10)
            soma = 0;
        
        if((11-(soma%11))!= ValidarCPFCNPJ.obterDigito(cnpj, 2))
            return false;
        
        soma = 0;
         for(int i = digitos; i > 1; i--)
            soma += (ValidarCPFCNPJ.obterDigito(cnpj, i)*vetor[14-i]);
        
        
        if(11-(soma%11)==10)
            soma = 0;

        return (11-(soma%11)) == ValidarCPFCNPJ.obterDigito(cnpj, 1);
    }
    
    public static boolean isCNPJValido(String cnpj){
        cnpj = cnpj.replace(".", "").replace("-", "").replace("/","");
        return ValidarCPFCNPJ.isCNPJValido(Long.parseLong(cnpj));
    }
}
