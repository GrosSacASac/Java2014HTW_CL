package de.htw.saarland.stl;


/**
 *    StdinTest.java    Testet im Package de.htw.saarland.stl
 *                                    die ToolBox : Stdin fuer
 *                                    die Einlese-Methoden readXX und readlnXX von
 *                                    der Standard-Eingabe
 *
 *          fuer die Datentypen : boolean,
 *                                float, double,
 *                                byte, short, int, long
 *                                char,
 *                                String
 *
 *
 * @version 1.0 11.08.2000
 * @author  Wolfgang Pauly
 *
 */
public class StdinTest {

  public static void main ( String[] args ) {

         int     i;
         String  s;
         double  d;
         boolean b, hilf;
         char c;

     System.out.println ( "\nEinfaches Lesen einer int-Zahl mit readlnInt\n" );
     System.out.print ( "Gebe Integer-Zahl ein : " );
     i = Stdin.readlnInt();
     System.out.println ("readlnInt : i = " + i );

     System.out.println ( "\nEinfaches Lesen einer int-Zahl MIT readInt( prompt )\n" );
     i = Stdin.readInt( "Gebe Integer-Zahl ein : " );
     System.out.println ("readInt : i = " + i );

     System.out.println ( "\nEinfaches Lesen einer int-Zahl mit readlnInt\n" );
     System.out.print ( "Gebe Integer-Zahl ein : " );
     i = Stdin.readlnInt();
     System.out.println ("readlnInt : i = " + i );

     System.out.println ( "\nEinfaches Lesen einer int-Zahl MIT readInt( prompt )\n" );
     i = Stdin.readInt( "Gebe Integer-Zahl ein : " );
     System.out.println ("readInt : i = " + i );

     System.out.println ( "\nEinfaches Lesen eines Strings MIT readlnString( prompt )\n" );
     s = Stdin.readlnString( "Gebe String ein : " );
     System.out.println ("readlnString : s = " + s );




     System.out.print ( "\nAbwechselndes Lesen einer Int-Zahl, eines Strings, einer Double-Zahl");
     System.out.print ( "\neines Boolean und eines Char aus einer Zeile\n");
     System.out.print ( "\nGebe ein : Int String Double Boolean Char durch Leerzeichen getrennt ein!\n");
     i = Stdin.readInt();
     s = Stdin.readString();
     d = Stdin.readDouble();
     b = Stdin.readBoolean();
     c = Stdin.readlnChar();

     System.out.print ( "\nGelesen wurde : " + i + " " + s + " " + d + " " + b + " " + c + 
                        "\n\n"
                      );


     System.out.println( "\nLesen einer int-Zahl MIT readlnInt( prompt ) " +
                         "und Abfangen von Eingabefehlern\n" 
                       );
     for ( hilf = false;!hilf; )
       {
         try
           {
            i = Stdin.readlnInt( "\nGebe Integer-Zahl ein : " );
            System.out.println ("readlnInt : i = " + i );
            hilf = true;
           }
         catch ( NumberFormatException e )
           {
            System.out.println( "\nEingabefehler --->\n" + e.toString() );
           }
        }

     System.out.println( "\nLesen einer double-Zahl MIT readlnDouble( prompt ) " +
                         "und Abfangen von Eingabefehlern\n" 
                       );
     for ( hilf = false;!hilf; )
       {
         try
           {
            d = Stdin.readlnDouble( "\nGebe Double-Zahl ein : " );
            System.out.println ("readlnDouble : d = " + d );
            hilf = true;
           }
         catch ( NumberFormatException e )
           {
            System.out.println( "\nEingabefehler --->\n" + e.toString() );
           }
        }
   }
 }
