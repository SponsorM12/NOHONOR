package zver.nohonor.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import zver.nohonor.utilit.TooltipHelper;

import java.util.function.Consumer;

public class ModTooltipItems extends Item {
    //Отдельный конструктор.
    //Разные методы регистрации - для цветного текста названия предмета
    //, для описания и разных комбинаций
    //пока работает только на предметы
    //работает через хелперы

    private final String descKey;
    private final int descLines;
    private final Integer nameColor;

    //1. Без цвета, 1 строка
    public ModTooltipItems(String descKey, Properties properties) {
        this(descKey, 1, null, properties);
    }

    //2. Без цвета, несколько строк
    public ModTooltipItems(String descKey, int descLines, Properties properties) {
        this(descKey, descLines, null, properties);
    }

    //3. Только цвет, БЕЗ описания
    public ModTooltipItems(int nameColor, Properties properties) {
        this(null, 0, nameColor, properties);
    }

    //4. С цветом, 1 строка
    public ModTooltipItems(String descKey, int nameColor, boolean hasColor, Properties properties) {
        this(descKey, 1, nameColor, properties);
    }

    //5. Главный конструктор
    public ModTooltipItems(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(properties);
        this.descKey = descKey;
        this.descLines = descLines;
        this.nameColor = nameColor;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, tooltip, flag);
        //Хелпер описания предмета
        TooltipHelper.appendLines(this.descKey, this.descLines, tooltip);
    }

    @Override
    public Component getName(ItemStack stack) {
        //Хелпер цвета
        return TooltipHelper.getColoredName(super.getName(stack), this.nameColor);
    }
}