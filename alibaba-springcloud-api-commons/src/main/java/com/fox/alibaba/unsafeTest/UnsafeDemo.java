package com.fox.alibaba.unsafeTest;
import sun.misc.Unsafe;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-17 16:51
* @version 1.0
*/

/**
 * 异常原因:
 * 这是因为在getUnsafe方法中，会对调用者的classLoader进行检查，判断当前类是否由Bootstrap classLoader加载，如果不是的话就会抛出一个SecurityException异常。
 * 也就是说，只有启动类加载器加载的类才能够调用 Unsafe 类中的方法，这是为了防止这些方法在不可信的代码中被调用。
 * @author F1337248
 *
 */
public class UnsafeDemo {
    volatile long state = 0;//变量
    static final Unsafe UNSAFE = Unsafe.getUnsafe();//获取Unsafe的实例
    static long stateOffset;//记录变量state在类UnSafeDemo类中的偏移值
    static {
        try {
            //获取state变量在类UnSafeDemo中的偏移值
            stateOffset = UNSAFE.objectFieldOffset(UnsafeDemo.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        UnsafeDemo uDemo=new UnsafeDemo();
        //将state的值更新为1
        Boolean success=UNSAFE.compareAndSwapInt(uDemo, stateOffset,0,1);
        System.out.println(success);
    }
}
