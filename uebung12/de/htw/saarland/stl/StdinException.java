package de.htw.saarland.stl;

public class StdinException extends RuntimeException {
    protected static String msg1 = ": Falsche Eingabe gelesen:";
    protected static String msgEOF = "End Of File!";
    protected static String msgFILE = "File not found!";
    

    public StdinException(String token, String method) {
        super(method + msg1 + token);
    }
    
    public StdinException(String msg) {
        super(msg);
    }
}
