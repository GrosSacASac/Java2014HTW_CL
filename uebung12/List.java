import java.util.*;
/** 
 * Implementierung einer einfach-verketteten linearen Liste
 * 
 * @author folz
 * @version 2011
 */
public class List implements AbstractList {
    private int size;
    private ListElement first;
    private ListElement last;

    /** 
     * Leere Liste erzeugen  
     */
    public List() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Ein Objekt an einer bestimmten Stelle hinzufügen
     *
     * @param index Der Index vor dem eingefügt werden soll (0 <= index <= size)
     * @param o das einzufügende Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public void add(int index, Object o) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index:" + index +
                                                ", size:" + size);
        if (index == size)
            addLast(o);
        else if (index == 0)
            addFirst(o);
        else {
            // beginne beim erstem Element
            ListElement le = first;
            // gehe bis zum Element index-1
            for (int i = 0; i < index-1; i++)
                le = le.next;
            // dort anhaengen
            ListElement tmp = new ListElement(o, le.next);
            le.next = tmp;
            size++;
        }
    }

    /**
     * Element am Anfang der Liste einfuegen 
     *
     * @param o einzufügendes Element
     */
    public void addFirst(Object o) {
        ListElement tmp = new ListElement(o, first);
        first = tmp;
        size++;
        if (last == null)
           last = first;
    }

    /** 
     * Element am Ende der Liste anhaengen   
     *
     * @param o einzufügendes Element
     */
    public void addLast(Object o) {
        if (last == null)
            addFirst(o);
        else {
            last.next = new ListElement(o, null);
            last = last.next;
            size++;
        }
    }

    /** 
     * Komplette Liste loeschen        
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /** 
     * Enthaelt die Liste das Objekt?
     *
     * @param o einzufügendes Element
     * @return true, falls das Objekt in der Liste vorkommt, false sonst
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /** 
     *  Ein Iteratorobjekt zurueckgeben, mit dem über die Liste
     *  iteriert werden kann
     *  @return Iteratorobjekt
     */
    public Iterator iterator() {
        return new ListItr(first);
    }

    /** 
     * Objekt an der Stelle index zurueckgeben 
     * 
     * @param index Der Index dessen zugehöriges Objekt zurückzugeben ist (0 <= index < size)
     * @return das gefundene Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index:" + index +
                                                ", size:" + size);
        ListElement le = first;
        int i = 0;
        while (i < index) {
            le = le.next;
            i++;
        }
        return le.data;
    }

    /** 
     * Das erste Element zurückgeben 
     * 
     * @return das erste Objekt
     * @exception NoSuchElementException falls es die Liste leer ist
     */
    public Object getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return first.data;
    }

    /** 
     * Das letzte Element zurückgeben 
     * 
     * @return das letzte Objekt
     * @exception NoSuchElementException falls es die Liste leer ist
     */
    public Object getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return last.data;
    }

    /** 
     * An welcher Stelle steht das Objekt?     
     * @param o das zu suchende Objekt
     * @return den Index des Objektes oder -1
     */
    public int indexOf(Object o) {
        int index = 0;
        ListElement le = first;
        while (le != null) {
            if (le.data.equals(o))
                return index;
            le = le.next;
            index++;
        }
        return -1;
     }

    /** 
     * Entferne Element mit einem bestimmten Inhalt
     * 
     * @param o das zu entferndende Objekt
     */
    public void remove(Object o) {
        if (size == 0 || o == null ) return;
        if (first.data.equals(o))
            removeFirst();
        else if (last.data.equals(o))
            removeLast();
        else {
            ListElement le = first;
            // gehe bis zum Element vor dem gesuchten
            while (le.next != last) {
                if (le.next.data.equals(o)) {
                    le.next = le.next.next;
                    size--;
                    break;
                }
                le = le.next;
            }
        }
    }
    /**
     * Lösche Element an der Stelle index
     * 
     * @param index Der Index dessen zugehöriges Objekt zu löschen ist (0 <= index < size)
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index:" + index +
                                                ", size:" + size);
        if (index == size-1)
            removeLast();
        else if (index == 0)
            removeFirst();
        else {
            // beginne beim erstem Element
            ListElement le = first;
            // gehe bis zum Element index-1
            for (int i = 0; i < index-1; i++)
                le = le.next;
            // Das i-te Element einfach überspringen
            le.next = le.next.next;
            size--;
        }
    }

    /**
     * Das erste Element löschen
     */
    public void removeFirst() {
        if (size == 0) return;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        size--;
    }

    /**
     * Das letzte Element löschen
     */
    public void removeLast() {
        if (size == 0) return;	// leere Liste ?
        if (first == last) {    // Nur ein Listenelement
            first = null;
            last = null;
        } else {
            ListElement tmp = first;
            // vorletztes Element suchen
            while (tmp.next != last)
                tmp = tmp.next;
            last = tmp;// tmp zeigt nun auf das vorletzte Listenelement
            last.next = null;
        }
        size--;
    }

    /** 
     * Wert eines Elementes veraendern, den alten Wert zurueckgeben 
     * 
     * @param index Der Index des zu ändernden Objektes (0 <= index < size)
     * @param o das neue Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public Object set(int index, Object o) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index:" + index +
                                                ", size:" + size);
        // beginne beim erstem Element
        ListElement le = first;
        // gehe bis zum Element index
        for (int i = 0; i < index; i++)
                le = le.next;
        Object alterWert = le.data;
        le.data = o;
        return alterWert;
    }

    /**
     * @return Anzahl der Elemente
     */
    public int size() {
        return size;
    }

    /**
     * @return die Liste als zeichenkette
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
//         ListElement le = first;
//         while (le != null) {
//             sb.append(" -> ").append(le.data.toString());
//             le = le.next;
//         }
        for (Object o : this) 
             sb.append(" -> ").append(o);
           
        return sb.toString();
    }
}


/**
 *  Listenelement, zeigt auf ein Inhaltsobjekt und auf das
 *  naechste Listenelement
 */
class ListElement {
    protected Object data;
    protected ListElement next;

    /**
     * Der Konstruktor ist protected, da er nur von der Liste verwendet werden soll.
     *
     * @param o Inhalt des Elementes
     * @param le Vorgabe für die next-Referenz
     */
    protected ListElement (Object o, ListElement le) {
        data = o;
        next = le;
    }
}

/**
 * Implementierung eines Iterator-Typs für die Liste
 */
class ListItr implements Iterator {
    private ListElement le;
    /**
     * Ein Iteratorobjekt erzeugen
     *
     * @param start das Listenelement mit dem gestartet werden soll
     */
    public ListItr(ListElement start) {
        le = start;
    }
    /**
     * Gibt es ein nachfolgendes Element?
     *
     * @return true, falls ja andernfalls false
     */
    public boolean hasNext() {
        return le != null;
    }

    /**
     * Gehe zum naechsten Element weiter
     *
     * @return Referenz auf das naechste Element
     * @exception NoSuchElementException falls es kein naechstes Element 
     * mehr gibt
     */
    public Object next() throws NoSuchElementException {
        if (le == null)
            return new NoSuchElementException();
        Object o = le.data;
        le = le.next;
        return  o;
    }
    /**
     * Diese Methode ist nicht implementiert
     * 
     * @exception UnsupportedOperationException falls die Methode aufgerufen wird
     */
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
