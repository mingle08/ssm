package com.ssmstudy.util.AssertEnum;

public class AssertDemo {
    public static void main(String[] args) {
        String twoday = "Twoday";
        boolean existDay = AssertUtil.assertWithEnumObj(twoday, DayOfWeek.Friday);

        System.out.println("use enum obj:" + existDay);

        existDay = AssertUtil.assertWithEnumClass(twoday, DayOfWeek.class);
        System.out.println("use enum class:" + existDay);
    }
}
