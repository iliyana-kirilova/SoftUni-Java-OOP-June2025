package ExamPrep.picking.entities.pickers;

import ExamPrep.picking.entities.bag.Bag;
import ExamPrep.picking.entities.bag.BagImpl;

import static ExamPrep.picking.common.ExceptionMessages.PICKER_NAME_NULL_OR_EMPTY;
import static ExamPrep.picking.common.ExceptionMessages.PICKER_VITALITY_LESS_THAN_ZERO;

public abstract class BasePicker implements Picker {
    private static final int VITALITY_DECREASING_FACTOR = 10;
    private String name;
    private int vitality;
    private Bag bag;

    public BasePicker(String name, int vitality) {
        this.setName(name);
        this.setVitality(vitality);
        this.bag = new BagImpl();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(PICKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    public void setVitality(int vitality) {
        if (vitality<0){
            throw new IllegalArgumentException(PICKER_VITALITY_LESS_THAN_ZERO);
        }
        this.vitality = vitality;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }


    @Override
    public void pick() {
        this.vitality = Math.max(0, this.vitality - VITALITY_DECREASING_FACTOR);

        /*this.vitality-=10;
        if(this.vitality<0){
            setVitality(0);
        }*/
    }
}

