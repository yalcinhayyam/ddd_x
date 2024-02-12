package com.test.ddd.utilities;

import org.reflections.Reflections;

import javax.swing.text.html.parser.Entity;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class TypeFinder {

   public static Set<Class<?>> find(Class<?> clazz ){

        Reflections reflections = new Reflections("com.test.ddd");

        // Reflections reflections = new Reflections(TypeFinder.class.getPackage().getName());

        // Reflections = new Reflections("com.my.project");

        // Set<Class<?>> subTypes = reflections.get(SubTypes.of(Entity.class).asClass());

       return reflections.get(SubTypes.of(clazz).asClass());
    }
}
