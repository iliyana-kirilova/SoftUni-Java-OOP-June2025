package L3_Inheritance.Lab4_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        return this.data.removeLast();
    }

    public String peek(){
        return this.data.getLast();
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }


}
