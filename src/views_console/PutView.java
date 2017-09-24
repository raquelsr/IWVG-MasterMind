package views_console;

import controllers.CombinationController;
import controllers.CombinationControllerVisitor;
import controllers.PutController;
import controllers.RandomCombinationController;
import controllers.UserCombinationController;
import models.Combination;
import utils.IO;

public class PutView implements CombinationControllerVisitor {

    Combination combination;

    public void interact(PutController putController) {
        IO io = new IO();
        io.writeln();
        io.writeln("Introduce una combinación:  ");
        Error error = null;
        Combination combination;
        do {
            combination = this.getCombination(putController.getCombinationController());
            if (error != null) {
                io.writeln("" + error);
            }
        } while (error != null);
        putController.put(combination);
        putController.finish();
        if (putController.win()) {
            new CombinationView(combination).win();
        } else {
            io.write("Hay " + putController.getDead() + " muertos");
            io.writeln(" y " + putController.getInjured() + " heridos.");
            io.writeln("Te quedan " + putController.getAttempts() + " intentos.");
        }
        if (putController.finishCounter()) {
            io.writeln("¡HAS PERDIDO! Se han agotado los intentos. ");
        }
        putController.addAttempt();
    }

    private Combination getCombination(CombinationController combinationController) {
        combinationController.accept(this);
        return combination;
    }

    @Override
    public void visit(UserCombinationController userCombinationController) {
        combination = userCombinationController.getCombination();
    }

    @Override
    public void visit(RandomCombinationController randomCombinationController) {
        combination = randomCombinationController.getCombination();
        IO io = new IO();
        new CombinationView(combination).write();
        io.readString("    --- Pulse enter para continuar.");
    }
}
