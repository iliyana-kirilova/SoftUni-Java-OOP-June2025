package L3_Inheritance.Lab3_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement(){
        Random random = new Random();
        int position = random.nextInt(0, size());
        return get(position);
    }
}