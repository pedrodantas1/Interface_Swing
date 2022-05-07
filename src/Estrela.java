import java.util.ArrayList;

public class Estrela implements Operacao {
    private Automato autEntrada;
    
    public Estrela() {
    }

    public void setAutomatoEntrada(Automato automato) {
        this.autEntrada = automato;
    }

    public Automato makeOperation() {
        Automato autSaida = new Automato(autEntrada);
        ArrayList<Estado> estadosFinais = autSaida.getEstadosFinais();
        if (estadosFinais == null){
            System.out.println("Não existem estados finais.");
            return null;
        }
        Estado antigoInicial = autSaida.getEstadoInicial();
        if (antigoInicial == null){
            System.out.println("Não existe estado inicial.");
            return null;
        }
        //Criar um estado novo (inicial e final)
        antigoInicial.unsetInicial();
        Estado novoInicial = autSaida.addEstado();
        novoInicial.setInicial();
        novoInicial.setFinal();
        //Colocar epsilon desse novo estado para o antigo inicial
        novoInicial.addTransicao(antigoInicial.getId(), "lambda");
        //Colocar epsilon dos estados finais para o antigo inicial
        for (Estado estado : estadosFinais){
            estado.addTransicao(antigoInicial.getId(), "lambda");
        }

        return autSaida;
    }

}