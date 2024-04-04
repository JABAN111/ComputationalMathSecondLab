package Computational.math.Methods.NewtonsMethod;

import Computational.math.Functions.Functions;
import Computational.math.Functions.SystemFunctions;
import Computational.math.LinearSystem.SimpleIterationLinSystem;
import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.exception.MalformedTableException;
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

    public void solve() {
        try {
            builder.columns("№", "delta_x", "delta_y", "|x_i - x_0|", "|y_i - y_0|");
            double x_0 = 0;
            double y_0 = 0;
            //начальное приближение
            double x_i = a;
            double y_i = b;
            int iteration = 0;
            double delta_x, delta_y;
            do {
                x_0 = x_i;
                y_0 = y_i;
                iteration++;

                Double[] deltas = function.getCalculatedChosenFunction(x_0, y_0);
                if(deltas == null){
                    System.err.println("Систему не удалось решить из-за невозможности привести ее к диагональному виду");
                    return;
                }
                delta_x = deltas[0];
                 delta_y = deltas[1];
//                System.out.println("delta x = " + delta_x);
//                System.out.println("delta y= " + delta_y);
                x_i = x_0 + delta_x;
                y_i = y_0 + delta_y;
                builder.row(iteration+"",String.format("%.3f",delta_x),String.format("%.3f",delta_y),String.format("%.3f",Math.abs(x_i - x_0)),String.format("%.3f",Math.abs(y_i-y_0)));
                if (iteration > 200) {
                    break;
                }
            } while (Math.abs(x_i - x_0) > epsilon || Math.abs(y_i - y_0) > epsilon);
            table = builder.getTable();
            System.out.println(table.toStringHorizontal());
            System.out.println("Финальный ответ: ");
            System.out.println("delta x = " + x_i + " delta y = "  + y_i);
        } catch (MalformedTableException e) {
            System.out.println(e.getMessage());
        }


    }
}
