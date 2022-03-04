package Model;

public enum Servico {
    AGUA('A'),
    LUZ('L');
    private char tipo;

    private Servico(char tipo) {
        this.tipo = tipo;
    }
    public char getTipo(){
        return this.tipo;
    }

}
