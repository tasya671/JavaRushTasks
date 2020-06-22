package com.javarush.task.task38.task3804;

public class FactoryThrowable {

    public static Throwable getException(Enum type){

        if(type != null) {
            String nameEnumClass = type.getClass().getSimpleName();
            String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replaceAll("_", " ");

            switch (nameEnumClass) {
                case "DatabaseExceptionMessage":
                    return new RuntimeException(message);
                case "ApplicationExceptionMessage":
                    return new Exception(message);
                case "UserExceptionMessage":
                    return new Error(message);
                default:
                    return new IllegalArgumentException();
            }
        } else
            return new IllegalArgumentException();
    }
}
