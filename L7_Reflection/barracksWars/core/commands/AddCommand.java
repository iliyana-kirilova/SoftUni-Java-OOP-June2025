package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class AddCommand extends Command{

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);

        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
