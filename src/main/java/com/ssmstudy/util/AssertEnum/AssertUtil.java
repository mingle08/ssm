package com.ssmstudy.util.AssertEnum;

import java.util.Arrays;

public class AssertUtil {
    public static boolean assertWithEnumObj(Object obj, Enum<? extends Enum<?>> enumObj) {
        Class<? extends Enum<?>> clazz = enumObj.getDeclaringClass();
        Enum<? extends Enum<?>> [] enumValues = clazz.getEnumConstants();
    
        if (obj instanceof String) {
            try {
                // clazz.asSubclass(Enum.class) can solve compile issue
                Enum<?> enumValue = Enum.valueOf(clazz.asSubclass(Enum.class), (String) obj);
                return Arrays.asList(enumValues).contains(enumValue);
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else if (obj instanceof Integer) {
            for (Enum<?> value : enumValues) {
                if (((Integer) obj).equals(value.ordinal())) {
                    return true;
                }
            }
            return false;
        }
    
        return false;
    }


    public static void getEnumInstances(Enum<? extends Enum<?>> enumObj) {
        Class<? extends Enum<?>> clazz = enumObj.getDeclaringClass();
    
        if (clazz.isEnum()) {
            Enum<?>[] enumInstances = clazz.getEnumConstants();
    
            for (Enum<?> instance : enumInstances) {
                // 处理枚举实例
                System.out.println(instance.name());
            }
        }
    }

    public static boolean assertWithEnumClass(Object obj, Class<? extends Enum<?>> enumClass) {
        Enum<?>[] enumValues = enumClass.getEnumConstants();
    
        if (obj instanceof String) {
            try {
                Enum<?> enumValue = Enum.valueOf(enumClass.asSubclass(Enum.class), (String) obj);
                return Arrays.asList(enumValues).contains(enumValue);
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else if (obj instanceof Integer) {
            int ordinal = (Integer) obj;
            if (ordinal >= 0 && ordinal < enumValues.length) {
                Enum<?> enumValue = enumValues[ordinal];
                return true;
            }
            return false;
        }
    
        return false;
    }
}
