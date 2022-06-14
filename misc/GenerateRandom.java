import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) {
        Random rng = new Random();
        double r = rng.nextGaussian();

        System.out.printf("Random number: %.2f\n", r);

        // Sets the generator's seed value -- useful for repeating experiments.
        rng.setSeed(42);

        System.out.println(rng.nextInt());
    }
}
