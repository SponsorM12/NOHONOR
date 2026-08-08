package zver.nohonor.custom_mechanics.hanahaki;

import net.minecraft.util.RandomSource;

import java.util.ArrayList;
import java.util.List;

public class HanahakiVariants {

    private record Entry(String id, int weight) {}

    private static final List<Entry> VARIANTS = new ArrayList<>();
    private static int totalWeight = 0;

    public static final String BASE = register("base", 100); //never used

    private static String register(String id, int weight) {//переделать???
        if (weight <= 0) { //parameter is always '100'
            throw new IllegalArgumentException("Hanahaki variant weight must be positive: " + id);
        }
        VARIANTS.add(new Entry(id, weight));
        totalWeight += weight;
        return id;
    }

    //рандом
    public static String pickRandom(RandomSource random) {
        if (VARIANTS.isEmpty()) {
            throw new IllegalStateException("No Hanahaki variants registered");//переделать
        }
        int roll = random.nextInt(totalWeight);
        int cumulative = 0;
        for (Entry entry : VARIANTS) {
            cumulative += entry.weight();
            if (roll < cumulative) {
                return entry.id();
            }
        }
        return VARIANTS.get(VARIANTS.size() - 1).id();
    }

    //Пустой метод-триггер — гарантирует загрузку класса и регистрацию вариантов
    //при старте мода (тот же паттерн, что у ModConsumeEffectTypes.init())
    public static void initialize() {}

}