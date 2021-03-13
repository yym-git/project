package shop.user.com.test;

/**
 * @author ym.y
 * @description
 * @package shop.user.com.test
 * @updateUser
 * @date 14:51 2021/2/20
 */
public class JVMTest {
    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造块");
    }

    public JVMTest(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList<String>();
//        linkedList.add("12");
//        System.out.println("main方法");
//        new JVMTest();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
