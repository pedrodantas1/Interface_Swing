public class Interseccao extends Operacao {
    
    public Interseccao() {
        maxAutomaton = 2;
        qtdAutomaton = 0;
        automatons = new Automato[maxAutomaton];
    }

    public Automato makeOperation() {
        Automato aut1 = getAutomaton(0);
        Automato aut2 = getAutomaton(1);
        if (aut1 == null || aut2 == null){
            System.out.println("Os autômatos necessários não estão setados!");
            return null;
        }

        
        return null;
    }

    

}