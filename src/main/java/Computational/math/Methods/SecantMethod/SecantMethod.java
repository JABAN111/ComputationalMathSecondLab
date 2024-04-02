//package Computational.math.Methods.secant_method;
//
//import Computational.math.Functions;
//import org.netirc.library.jtables.JTablesBuilder;
//import org.netirc.library.jtables.exception.MalformedTableException;
//import org.netirc.library.jtables.table.MonospaceTable;
//
//public class SecantMethod {
//    private double a;
//    private double b;
//    private final float epsilon;
//    private final Functions functions;
//    //for beautiful tables:D
//    private JTablesBuilder<MonospaceTable> builder = MonospaceTable.build();
//    private MonospaceTable table;
//
//
//    public SecantMethod(double a, double b, float epsilon, int numberOfChosenFunction) {
//        this.a = a;
//        this.b = b;
//        this.epsilon = epsilon;
//        this.functions = new Functions(numberOfChosenFunction);
//    }
//
//    public void solve() {
//        try {
//            builder.columns("№", "a", "b", "x", "f(a)", "f(b)", "f(x)", "|a-b|");
//            double x_next;
//            double x_prev;
//            double x_i;
//            double fx;
//            int iterationsCounter = 0;
//            do {
//                if (iterationsCounter != 0) {
//                    x_prev = x_i;
//                    x_i = x_next;
//                }
//                iterationsCounter++;
//                fx = functions.getValueOfChosenFunction(x_i);
//            }
//            while (Math.abs(21 - 1) > epsilon);
//        } catch (MalformedTableException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
