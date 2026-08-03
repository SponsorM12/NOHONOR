package zver.nohonor.utilit;

import net.minecraft.network.chat.Component;
import java.util.function.Consumer;

public class TooltipHelper {
//ХЕЛПЕР
//====================================ЦВЕТОВЫЕ ПРЕСЕТЫ========================================
    public static final int GOLD = 0xFFD700; //Золотой
    public static final int YELLOWGREEN = 0xA3E330; //Зелёный
    public static final int LAVENDER = 0xFFE6F4; //Жемчужно-серебряный
    public static final int MEDIUM_PURPLE = 0x9783DF; //Фиолетовый
    public static final int EDWARD = 0x929593; //Зеленоватый но серый
    public static final int SUBMARINE = 0x85A2A1; //Зеленоватый но не болотный
    public static final int CHETWODE = 0x6367A3; //Фиолетово-синий
    public static final int HOPBUSH = 0xD95E9F; //Темно-розовый
    public static final int PERFUME = 0xBBA0E8; //Лаванда
    public static final int COLUMBIA = 0x95E6FC; //Люмель - голубой
    public static final int ILLUSION = 0xF69CAF; //Щерба'руна - розовый
    public static final int VISTA = 0x9CD4BA; //Висмут - светло-зеленый
    public static final int CARAMEL = 0xFED791; //Латунь - бледно желтоватый
    public static final int CUMULUS = 0xFFFEBA; //Цвет как у облаков в закате +-
    public static final int MARGUERITE = 0x6E4FBD; //Чистый Фиолетовый
    public static final int CASABLANCA = 0xF0B057; //Оранжевый
    public static final int ORCHID = 0xE073C2; //Фиолетовый
    public static final int LIPSTICK = 0x9B2346; //NOUS - малиновый
    public static final int PERANO = 0xA8BBFF; //Звездно голубой

    //Метод для добавления строк описания
    public static void appendLines(String descKey, int lines, Consumer<Component> tooltip) {
        if (descKey == null) return;
        if (lines == 1) {
            tooltip.accept(Component.translatable(descKey));
        } else {
            for (int i = 1; i <= lines; i++) {
                tooltip.accept(Component.translatable(descKey + ".line" + i));
            }
        }
    }

    //Покраска названия предмета
    public static Component getColoredName(Component originalName, Integer color) {
        if (color == null) {
            return originalName; // Если цвет не передан, возвращаем обычное имя
        }
        //Копируем компонент и применяем кастомный цвет
        return originalName.copy().withStyle(style -> style.withColor(color));
    }
    //я всё еще не понимаю почему мы МОЖЕМ применять цвет какой хотим по hex?

}