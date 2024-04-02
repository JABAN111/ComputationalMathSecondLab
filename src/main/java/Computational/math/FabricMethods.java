package Computational.math;

import Computational.math.Methods.HalfDivision.HalfDivision;
import Computational.math.Methods.SecantMethod.SecantMethod;
import Computational.math.Methods.SimpleIteration.SimpleIteration;

import static Computational.math.MethodName.HALF_DIVISION;

public class FabricMethods {

    public FabricMethods(){

    }
    public void executeMethod(MethodName methodName,double a, double b, float epsilon,int numberOfChosenFunction){
        switch (methodName){
            case HALF_DIVISION:
                new HalfDivision(a,b,epsilon,numberOfChosenFunction).solve();
                break;
            case SECANT_METHOD:
                new SecantMethod(a,b,epsilon,numberOfChosenFunction).solve();
                break;
            case SIMPLE_ITERATION:
                new SimpleIteration(a,b,epsilon,numberOfChosenFunction).solve();
                break;
            default:
                System.err.println("Something went wrong");
                System.exit(-1);
        }
    }
}
