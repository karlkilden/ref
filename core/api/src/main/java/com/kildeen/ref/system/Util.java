package com.kildeen.ref.system;

/**
 * <p>File created: 2014-05-17 00:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class Util {

    public static String getClassNameFromProxy(Class<?> clazz, boolean simple) {
        String[] temp;
        if (simple) {
            temp = clazz.getSimpleName().split("\\$");
        } else {
            temp = clazz.getName().split("\\$");
        }

        return temp[0];
    }

    public static Class<?> viewController(String clazz) {
        try {
            return Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
