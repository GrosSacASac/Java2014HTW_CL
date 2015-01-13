public class PWTest 
{
    public static void main( String[] args ) 
    {
        try 
        {
            PatientenWarteschlange pw = new PatientenWarteschlange(10);
            pw.neuerPatient( 4711, "Löw, Jogi" ); // neuen Patient anfügen
            pw.neuerPatient( 1234, "Schweinsteiger, Sebastian" );
            pw.neuerPatient( 1111, "Neuer, Manuel" );
            pw.neuerPatient( 2222, "Hummels, Mats" );
            System.out.println(pw); // Warteschlange ausgeben
            System.out.println( pw.entfernePatient(1234) ); // Patient entfernen
            Patient naechster = pw.derNaechsteBitte(); // nächsten Patient herausholen
            System.out.println( "Nächster Patient: " + naechster );
            System.out.println( pw );
        } catch (RuntimeException e) 
        {
            System.out.println( e );
        }
    }
}