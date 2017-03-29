package com.lld.vm.seven;

/**
 * @author michael
 * @date 2017年3月15日
 */
public class Main {

    public static int i = 1;
    static {
        i = 0;
        System.out.println(i);
    }

    
    public static Byte[] getBytes(int size) {
        return new Byte[size * 1024 * 1024];
    }
    
    
    public static class VM {
        private Integer[] is = new Integer[10];
    }

    public static void main(String[] args) throws InterruptedException {
//        int i = 0;
//        while (true) {
////            Thread.sleep(500);
//            VM vm1 = new VM();
//            VM vm2 = new VM();
//            VM vm3 = new VM();
////            System.out.println("1111");
//        }
    }
}
