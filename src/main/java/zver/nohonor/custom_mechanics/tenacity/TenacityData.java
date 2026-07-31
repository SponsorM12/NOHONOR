package zver.nohonor.custom_mechanics.tenacity;

public interface TenacityData {
    //СТОЙКОСТЬ
    float getTenacity();
    void setTenacity(float tenacity);
    float getMaxTenacity();

    float MAX_TENACITY = 20f;                 //Максимальный запас
    float DAMAGE_REDUCTION_PER_UNIT = 0.125f;//Процент снижения урона за 1 трату едениц Стойкости
    float MAX_TENACITY_SPENT_PER_HIT = 5f;//Сколько тратится за 1 удар МАКСИМУМ
    //Тело
    default float applyTenacityReduction(float incomingDamage, float maxHp) {
        float currentTenacity = getTenacity();
        if (maxHp <= 0f || incomingDamage <= 0f || currentTenacity <= 0f) {
            return incomingDamage;
        }

        float damageFraction = incomingDamage / maxHp;
        float tenacityToSpend = Math.min(damageFraction * MAX_TENACITY, MAX_TENACITY_SPENT_PER_HIT);
        tenacityToSpend = Math.min(tenacityToSpend, currentTenacity);

        float reduction = tenacityToSpend * DAMAGE_REDUCTION_PER_UNIT;
        float reducedAmount = incomingDamage * (1f - reduction);

        setTenacity(currentTenacity - tenacityToSpend);
        return reducedAmount;
    }
}