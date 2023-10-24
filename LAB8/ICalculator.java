
import java.util.Vector;
public interface ICalculator {

    public static String NullParameterException = "ParamettersShouldNotBeNull";
    public static String OverflowException = "Numbers are over the limit " + Double.POSITIVE_INFINITY;
    public static String UnderflowException = "Numbers are under the limit " + Double.NEGATIVE_INFINITY;

    public Double Add (Double x , Double y) throws Exception;
    public Double Divide (Double x , Double y) throws Exception;
    public Double Average (Vector<Double> elements);
}
