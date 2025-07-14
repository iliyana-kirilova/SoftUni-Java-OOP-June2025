package Lab3_Animals;

public abstract class Animal {
    //abstract class
    //клас, от който не можем да създаваме обекти
    //може да съдържа полета, методи и абстрактни методи

    protected String name;
    protected String favouriteFood;

    public abstract String explainSelf();//няма имплементация
}
