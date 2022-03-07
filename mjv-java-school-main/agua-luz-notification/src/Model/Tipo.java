package Model;

public enum Tipo {
    AGUA('A'),
    LUZ('L');
    private char Tipo;

    private Tipo(char Tipo) {
        this.Tipo = Tipo;
    }
    public char getTipo(){
        return this.Tipo;
    }

}
