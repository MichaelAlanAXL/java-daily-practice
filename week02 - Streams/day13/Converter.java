
import java.util.function.Function;

public class Converter {
    public static final Function<Double, Double> C_TO_F = c -> c * 9.0 / 5.0 + 32.0;
    public static final Function<Double, Double> F_TO_C = f -> (f - 32) * 5.0 / 9.0;
    public static final Function<Double, Double> C_TO_K = c -> c + 273.15;
    public static final Function<Double, Double> K_TO_C = k -> k - 273.15;

    public static final Function<Double, Double> F_TO_K = F_TO_C.andThen(C_TO_K);
    public static final Function<Double, Double> K_TO_F = K_TO_C.andThen(C_TO_F);
}
