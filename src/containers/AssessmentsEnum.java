/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Администратор
 */
public enum AssessmentsEnum {
    bad(2), satisfactory(3), good(4), exelent(5);
    
    private final int id;
    AssessmentsEnum(int id) { this.id = id; }
    public int getValue() { return id; }
    
    @Override
    public String toString() {
        String lowercase = name().toLowerCase(java.util.Locale.US); 
        return lowercase;
    }
}
