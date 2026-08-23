package zver.nohonor.custom_mechanics.avatar_layers.hanahaki;

import net.minecraft.util.RandomSource;

import java.util.ArrayList;
import java.util.List;

public class HanahakiVariants {

    private record Entry(String id, int weight) {}

    private static final List<Entry> VARIANTS = new ArrayList<>();
    private static int totalWeight = 0;

    //public static final String BASE = register("base", 100);
    public static final String BASE_0 = register("base_0", 10);
    public static final String BASE_1 = register("base_1", 10);
    public static final String BASE_2 = register("base_2", 10);
    public static final String BASE_3 = register("base_3", 10);
    public static final String BASE_4 = register("base_4", 8);
    public static final String BASE_5 = register("base_5", 8);
    public static final String BASE_6 = register("base_6", 8);
    public static final String BASE_7 = register("base_7", 8);
    public static final String BASE_8 = register("base_8", 6);
    public static final String BASE_9 = register("base_9", 6);
    public static final String BASE_10 = register("base_10", 6);
    public static final String BASE_11 = register("base_11", 6);
    public static final String BASE_12 = register("base_12", 2);
    public static final String BASE_13 = register("base_13", 2);

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