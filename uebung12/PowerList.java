


public class PowerList extends List{

    public PowerList clone() {
        PowerList clone = new PowerList();
        for (int i = 0; i < this.size(); i++) {
            clone.add(i, this.get(i));
        }
        return clone;
    }
    
    public void append (List list) {
        int start = this.size();
        for (int i = 0; i < list.size(); i++) {
            this.add(start + i, list.get(i));
        }
    }
    
    public boolean equals (List list) {
        for (int i = 0; i < list.size(); i++) {
            if (this.get(i) != list.get(i)) {
                return false;
            }
        }
        return true;
    }
        
}
