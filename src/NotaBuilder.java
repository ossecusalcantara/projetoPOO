package src;

public class NotaBuilder {
    public static NotaFiscal criarNota(String nota){
        if(nota.equals("NotaFiscalServico")){
            return new NotaFiscalServico();
        } else {
            return new NotaFiscalVenda();
        }
    }
}
