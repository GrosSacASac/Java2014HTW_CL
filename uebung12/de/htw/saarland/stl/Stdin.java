package de.htw.saarland.stl;
import java.util.*;

/**
 * <H1>Die Toolbox : <B>de.htw.saarland.stl.Stdin</B></H1>
 * <BR>
 * Stellt für die Datentypen :
 * <UL>
 * <LI> float  </LI>
 * <LI> double</LI>
 * <LI> byte</LI>
 * <LI> short</LI>
 * <LI> int</LI>
 * <LI> long</LI>
 * <LI> boolean</LI>
 * <LI> char</LI>
 * <LI> String</LI>
 * </UL>
 * Einlese-Methoden <B>readXX</B> und <B>readlnXX</B> von der Standard-Eingabe
 * zur Verfügung
 * 
 * 
 * @version 1.0  2001/2.0 Redesign 2008
 * @author Wolfgang Pauly / Helmut Folz
 * 
 */
public class Stdin {
    private static Scanner input = new Scanner(System.in);

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine float-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * </UL>
     * 
     * @return die eingelesene Float-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static float readFloat() {
        checkEOF();
        if (input.hasNextFloat())
            return input.nextFloat();
        else
            throw new StdinException(input.next(), "readFloat");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine float-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Float-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static float readFloat(String prompt) {
        printPrompt(prompt);
        return readFloat();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine float-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * </UL>
     * 
     * @return die eingelesene Float-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static float readlnFloat() {
        checkEOF();
        float eingabe;
        if (input.hasNextFloat()) {
            eingabe = input.nextFloat();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnFloat");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine float-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Float-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static float readlnFloat(String prompt) {
        printPrompt(prompt);
        return readlnFloat();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine double-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * </UL>
     * 
     * @return die eingelesene Double-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static double readDouble() {
        checkEOF();
        if (input.hasNextDouble())
            return input.nextDouble();
        else
            throw new StdinException(input.next(), "readDouble");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine double-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Double-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static double readDouble(String prompt) {
        printPrompt(prompt);
        return readDouble();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine double-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return die eingelesene Double-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static double readlnDouble() {
        checkEOF();
        double eingabe;
        if (input.hasNextDouble()) {
            eingabe = input.nextDouble();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnDouble");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine double-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Double-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static double readlnDouble(String prompt) {
        printPrompt(prompt);
        return readlnDouble();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine byte-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return die eingelesene Byte-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static byte readByte() {
        checkEOF();
        if (input.hasNextByte())
            return input.nextByte();
        else
            throw new StdinException(input.next(), "readByte");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine byte-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Byte-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static byte readByte(String prompt) {
        printPrompt(prompt);
        return readByte();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine byte-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return die eingelesene Byte-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static byte readlnByte() {
        checkEOF();
        byte eingabe;
        if (input.hasNextByte()) {
            eingabe = input.nextByte();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnByte");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine byte-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Byte-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     * 
     */
    public static byte readlnByte(String prompt) {
        printPrompt(prompt);
        return readlnByte();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine short-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return die eingelesene Short-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static short readShort() {
        checkEOF();
        if (input.hasNextShort())
            return input.nextShort();
        else
            throw new StdinException(input.next(), "readShort");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine short-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Short-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static short readShort(String prompt) {
        printPrompt(prompt);
        return readShort();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine short-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return die eingelesene Short-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static short readlnShort() {
        checkEOF();
        short eingabe;
        if (input.hasNextShort()) {
            eingabe = input.nextShort();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnShort");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine short-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Short-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static short readlnShort(String prompt) {
        printPrompt(prompt);
        return readlnShort();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine int-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return die eingelesene Int-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static int readInt() {
        checkEOF();
        if (input.hasNextInt())
            return input.nextInt();
        else
            throw new StdinException(input.next(), "readInt");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine int-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Int-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static int readInt(String prompt) {
        printPrompt(prompt);
        return readInt();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine int-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return die eingelesene Int-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static int readlnInt() {
        checkEOF();
        int eingabe;
        if (input.hasNextInt()) {
            eingabe = input.nextInt();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnInt");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine int-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Int-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static int readlnInt(String prompt) {
        printPrompt(prompt);
        return readlnInt();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine long-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return die eingelesene Long-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static long readLong() {
        checkEOF();
        if (input.hasNextLong())
            return input.nextLong();
        else
            throw new StdinException(input.next(), "readLong");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine long-Zahl um.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Long-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder auss erhalb des
     *                Wertebereiches
     */
    public static long readLong(String prompt) {
        printPrompt(prompt);
        return readLong();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine long-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return die eingelesene Long-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static long readlnLong() {
        checkEOF();
        long eingabe;
        if (input.hasNextLong()) {
            eingabe = input.nextLong();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnLong");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein und wandelt ihn in eine long-Zahl um.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return die eingelesene Long-Zahl
     * @exception StdinException
     *                falls Eingabe KEINE Zahl oder ausserhalb des
     *                Wertebereiches
     */
    public static long readlnLong(String prompt) {
        printPrompt(prompt);
        return readlnLong();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String von der
     * Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return den eingelesenen String
     */
    public static String readString() {
        checkEOF();
        return input.next();
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String von der
     * Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return den eingelesenen String
     */
    public static String readString(String prompt) {
        printPrompt(prompt);
        return readString();
    }

    /**
     * <UL>
     * <LI> liest eine komplette Zeile von der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt.
     * 
     * </UL>
     * 
     * @return den eingelesenen String
     */

    public static String readlnString() {
        checkEOF();
        String eingabe;
        if (input.hasNextLine()) {
            eingabe = input.nextLine();
        } else
            throw new StdinException(input.next(), "readlnString");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach eine komplette Zeile von der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return den eingelesenen String
     */
    public static String readlnString(String prompt) {
        printPrompt(prompt);
        return readlnString();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String, der die
     * Zeichenfolgen "true, True, T, t, false, False, F, f" enthalten darf von
     * der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return den eingelesenen Boolean-Wert
     * @exception StdinException
     *                falls Eingabe KEIN Booleanwert wir True || true || T || t ||
     *                False || false || F || f ist.
     */
    public static boolean readBoolean() {
        checkEOF();
        if (input.hasNextBoolean())
            return input.nextBoolean();
        else
            throw new StdinException(input.next(), "readBoolean");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String, der die
     * Zeichenfolgen "true, True, T, t, false, False, F, f" enthalten darf von
     * der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter den eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return den eingelesenen Boolean-Wert
     * @exception StdinException
     *                falls Eingabe KEIN Booleanwert wir True|| true || T || t ||
     *                False || false || F || f ist.
     */
    public static boolean readBoolean(String prompt) {
        printPrompt(prompt);
        return readBoolean();
    }

    /**
     * <UL>
     * <LI> liest einen von white-spaces begrenzten String, der die
     * Zeichenfolgen "true, True, T, t, false, False, F, f" enthalten darf von
     * der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return den eingelesenen Boolean-Wert
     * @exception StdinException
     *                falls Eingabe KEIN Booleanwert wir True || true || T || t ||
     *                False || false || F || f ist.
     */
    public static boolean readlnBoolean() {
        checkEOF();
        boolean eingabe;
        if (input.hasNextBoolean()) {
            eingabe = input.nextBoolean();
            input.nextLine();
        } else
            throw new StdinException(input.nextLine(), "readlnBoolean");
        return eingabe;
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach einen von white-spaces begrenzten String, der die
     * Zeichenfolgen "true, True, T, t, false, False, F, f" enthalten darf von
     * der Standardeingabe ein.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return den eingelesenen Boolean-Wert
     * @exception StdinException
     *                falls Eingabe KEIN Booleanwert wir True|| true || T || t ||
     *                False || false || F || f ist.
     */
    public static boolean readlnBoolean(String prompt) {
        printPrompt(prompt);
        return readlnBoolean();
    }

    /**
     * <UL>
     * <LI> liest ein von white-spaces begrenztes Zeichen von der
     * Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter dem eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @return das eingelesene Zeichen
     * @exception StdinException
     *                falls Eingabe KEIN durch white-spaces begrenztes Zeichen
     *                eingegeben wurde
     */
    public static char readChar() {
        checkEOF();
        char c;
        String s = null;
        if (input.hasNext()) { 
            s = input.next();
            if (s.length() == 1) {
                c = s.charAt(0);
                return c;
            }
        }
            
        throw new StdinException(s, "readChar");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach ein von white-spaces begrenztes Zeichen von der
     * Standardeingabe ein.
     * 
     * <LI> der Lesezeiger bleibt hinter dem eingelesenen Zeichen in der
     * aktuellen Zeile stehen.
     * 
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return das eingelesene Zeichen
     * @exception StdinException
     *                falls Eingabe KEIN durch white-spaces begrenztes Zeichen
     *                eingegeben wurde
     */
    public static char readChar(String prompt) {
        printPrompt(prompt);
        return readChar();
    }

    /**
     * <UL>
     * <LI> liest ein von white-spaces begrenztes Zeichen von der
     * Standardeingabe ein.
     * 
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * 
     * </UL>
     * 
     * @return das eingelesene Zeichen
     * @exception StdinException
     *                falls Eingabe KEIN durch white-spaces begrenztes Zeichen
     *                eingegeben wurde
     */
    public static char readlnChar() {
        checkEOF();
        char c;
        String s = null;
        if (input.hasNext()) { 
            s = input.next();
            if (s.length() == 1) {
                c = s.charAt(0);
                if (input.hasNextLine())
                    input.nextLine();
                return c;
            }
        }
            
        throw new StdinException(s, "readChar");
    }

    /**
     * <UL>
     * <LI> gibt den Eingabe-Aufforderungs-String <CODE>prompt</CODE> aus und
     * liest danach ein von white-spaces begrenztes Zeichen von der
     * Standardeingabe ein.
     * <LI> der Lesezeiger wird hinter das EOLN der aktuellen Zeile gestellt,
     * d.h. der Rest der Eingabezeile wird ueberlesen.
     * </UL>
     * 
     * @param prompt
     *            ist der Eingabe-Aufforderungs-String
     * @return das eingelesene Zeichen
     * @exception StdinException
     *                falls Eingabe KEIN durch white-spaces begrenztes Zeichen
     *                eingegeben wurde
     */
    public static char readlnChar(String prompt) {
        printPrompt(prompt);
        return readlnChar();
    }
    
    /**
     * Umschalten auf das Lesen einer Datei
     * 
     * @param in Referenz auf ein File-Objekt
     * @exception StdinException
     *            falls Datei nicht vorhanden
     */
//    public static void switchToFile(File in) {
//        Scanner tmp;
//        try {
//            tmp = new Scanner(in);
//        } catch (FileNotFoundException e) {
//            throw new StdinException(StdinException.msgFILE);
//        }
//        input = tmp;
//    }

    /**
     * Umschalten auf das Lesen einer Datei
     * 
     * @param in Dateiname
     * @exception StdinException
     *            falls Datei nicht vorhanden
     */
//    public static void switchToFile(String in) {
//        Scanner tmp;
//        try {
//            File f = new File(in);
//            tmp = new Scanner(f);
//        } catch (FileNotFoundException e) {
//            throw new StdinException(StdinException.msgFILE);
//        }
//        input = tmp;
//    }

    private static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }
    
    private static void checkEOF() {
        if (!input.hasNext()) {
            throw new StdinException(StdinException.msgEOF);
        }
    }
}

