package ua.lviv.lgs;

import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Animal animal = new Animal("Cat", 12, "Sphynx");

        System.out.println("Class name: " + animal.getClass().getName());

        System.out.println("Superclass name: " + animal.getClass().getSuperclass().getName());

        Field[] fields = animal.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Fields: " + field.getName() + " " + field.getType().getName());
        }

        Method[] methods = animal.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Methods: " + "Name: " + method.getName());
            if (method.getName().equals("makeSound")) {
                method.invoke(animal);
                animal.makeSound();
            }
        }

        Field breedField = animal.getClass().getDeclaredField("breed");
        breedField.setAccessible(true);
        System.out.println("Breed before: " + breedField.get(animal));
        breedField.set(animal, "Bengal");
        String breed = (String) breedField.get(animal);
        System.out.println("New breed: " + breed);


        Constructor<?> constructor = animal.getClass().getDeclaredConstructor(String.class, int.class, String.class);
        System.out.println("Animal constructor: " + constructor.getName());
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("Constructor parameters: " + parameter.getName() + " " + "type: " + parameter.getType().getName());
        }


    }
}
