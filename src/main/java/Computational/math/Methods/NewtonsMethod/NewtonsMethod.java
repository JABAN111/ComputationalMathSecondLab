package Computational.math.Methods.NewtonsMethod;

import Computational.math.Functions.Functions;
import Computational.math.Functions.SystemFunctions;
import Computational.math.LinearSystem.SimpleIterationLinSystem;
import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.table.MonospaceTable;

//метод для системыы
public class NewtonsMethod {
    private double a;
    private double b;
    private final float epsilon;
    private final SystemFunctions function;
    //for beautiful tables:D
    private JTablesBuilder<MonospaceTable> builder = MonospaceTable.build();
    private MonospaceTable table;


    public NewtonsMethod(double a, double b, float epsilon, int numberOfChosenFunction) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
        this.function = new SystemFunctions(numberOfChosenFunction);
    }
    public void solve(){
        double x_0 = 0;
        double y_0 = 0;
        //начальное приближение
        double x_i = a;
        double y_i = b;
        int iteration = 0;
        double df_dx, df_dy, dg_dx, dg_dy;
        do{
            x_0=x_i;
            y_0 = y_i;
            iteration++;
            //fixme на этом моменте даже мне страшно стало говнокодить
            //ps это якобиан
            df_dx = function.getChosenDifFunction().get(0).apply(x_0,y_0);
            df_dy = function.getChosenDifFunction().get(1).apply(x_0,y_0);
            dg_dx = function.getChosenDifFunction().get(2).apply(x_0,y_0);
            dg_dy = function.getChosenDifFunction().get(3).apply(x_0,y_0);

            function.getChosenFunction();

        }while (Math.abs(x_i - x_0) > epsilon || Math.abs(y_i - y_0) > epsilon);
    }
}
