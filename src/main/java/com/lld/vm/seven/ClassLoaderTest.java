package com.lld.vm.seven;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author michael
 * @date 2017年3月28日
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader cl = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String path = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream in = getClass().getResourceAsStream(path);
                    if (in == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name , b, 0 , b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        
        Object object = cl.loadClass("com.lld.vm.seven.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.lld.vm.seven.ClassLoaderTest);
        System.out.println(object.equals(new ClassLoaderTest()));
    }
}
