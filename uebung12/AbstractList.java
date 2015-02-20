import java.util.*;
/** 
 * Interface, das alle relevanten List-Operationen enthält
 * 
 * @author folz
 * @version 2013
 */
public interface AbstractList extends java.lang.Iterable {
    /**
     * Ein Objekt an einer bestimmten Stelle hinzufügen
     *
     * @param index Der Index vor dem eingefügt werden soll (0 <= index <= size)
     * @param o das einzufügende Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public void add(int index, Object o);
    /**
     * Element am Anfang der Liste einfuegen 
     *
     * @param o einzufügendes Element
     */
    public void addFirst(Object o);
    /** 
     * Element am Ende der Liste anhaengen   
     *
     * @param o einzufügendes Element
     */
    public void addLast(Object o);
    /** 
     * Komplette Liste loeschen        
     */
    public void clear();
    /** 
     * Enthaelt die Liste das Objekt?
     *
     * @param o einzufügendes Element
     * @return true, falls das Objekt in der Liste vorkommt, false sonst
     */
    public boolean contains(Object o);
    /** 
     * Objekt an der Stelle index zurueckgeben 
     * 
     * @param index Der Index dessen zugehöriges Objekt zurückzugeben ist (0 <= index < size)
     * @return das gefundene Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public Object get(int index);
    /** 
     * Das erste Element zurückgeben 
     * 
     * @return das erste Objekt
     * @exception NoSuchElementException falls es die Liste leer ist
     */
    public Object getFirst();
    /** 
     * Das letzte Element zurückgeben 
     * 
     * @return das letzte Objekt
     * @exception NoSuchElementException falls es die Liste leer ist
     */
    public Object getLast();
    /** 
     * An welcher Stelle steht das Objekt?     
     * @param o das zu suchende Objekt
     * @return den Index des Objektes oder -1
     */
    public int indexOf(Object o);
    /** 
     *  Ein Iteratorobjekt zurueckgeben, mit dem über die Liste
     *  iteriert werden kann
     *  @return Iteratorobjekt
     */
    public Iterator iterator();
    /** 
     * Entferne Element mit einem bestimmten Inhalt
     * 
     * @param o das zu entferndende Objekt
     */
    public void remove(Object o);
    /**
     * Lösche Element an der Stelle index
     * 
     * @param index Der Index dessen zugehöriges Objekt zu löschen ist (0 <= index < size)
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public void remove(int index);
    /**
     * Das erste Element löschen
     */
    public void removeFirst();
    /**
     * Das letzte Element löschen
     */
    public void removeLast();
    /** 
     * Wert eines Elementes veraendern, den alten Wert zurueckgeben 
     * 
     * @param index Der Index des zu ändernden Objektes (0 <= index < size)
     * @param o das neue Objekt
     * @exception IndexOutOfBoundsException falls index nicht im vorgegebenen Intervall ist
     */
    public Object set(int index, Object o);
    /**
     * @return Anzahl der Elemente
     */
    public int size();
}
