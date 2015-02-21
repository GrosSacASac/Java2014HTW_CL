import java.util.*;
public class Info  {  

    private ArrayList<Integer> values;
    private String fileName;

    public Info(String fileName) {
        this.values = new ArrayList<Integer>();
        this.fileName = fileName;
    }
    
    public void add(int n) {
        this.values.add(n);
    }
    
    public int get(int i) {
        return (this.values.get(i));
    }
    
    public double getRatio() {
        return ((double)this.get(1) / (double)this.get(0))*100.0;
    }
    
    public String getFilename() {
        return this.fileName;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        builder.append(this.getFilename());
        builder.append(":\n");
        builder.append("Lines of code: " + this.get(0));
        builder.append("\n");
        builder.append("Lines of comment: " + this.get(1));
        builder.append("\n");
        builder.append("Lines that are empty: " + this.get(2));
        builder.append("\n");
        builder.append("Total Number of lines: " + this.get(3));
        builder.append("\n");
        builder.append("Percentage of comments: " + this.getRatio() + "%");
        builder.append("\n");
        builder.append(" ");
        return builder.toString();
    }
}
