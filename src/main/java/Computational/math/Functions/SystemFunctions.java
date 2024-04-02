package Computational.math.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class SystemFunctions {
    private int chosenFunction;

    private List<BinaryOperator<Double>> firstSystem = new ArrayList<>(
            List.of((x,y) -> 4 - Math.pow(x,2) - Math.pow(y,2), (x,y) ->  3 * Math.pow(x,2) - y)
    );

    //df/dx df/dy dg/dx dg/dy
    private List<BinaryOperator<Double>> difFirstSystem = new ArrayList<>(
            List.of((x,y) -> 2*x,
                    (x,y) -> 2*y,
                    (x,y) -> -6*x,
                    (x,y) -> 1d)
    );

    public SystemFunctions(int chosenFunction){

    }

    //todo тут нужно добавить логику для нескольких систем
    public List<BinaryOperator<Double>> getChosenFunction(){
        return firstSystem;
    }
    public List<BinaryOperator<Double>> getChosenDifFunction(){
        return difFirstSystem;
    }

}
