package com.gateway.com.design;

/**
 * @author ym.y
 * @description 里氏替换原则:所有使用基类对象的地方，都可以透明的使用子类对象
 * @package com.gateway.com.design
 * @updateUser
 * @date 17:37 2021/3/9
 */
public class Liskov {
    public static void main(String[] args) {

    }
}


/**
 * @description   创建一个基类，把更加基础的方法和成员写到基类中
 * @author ym.y
 * @updateUser
 * @date  17:46 2021/3/9
 */
class  Base{

}
class A extends  Base{
    public int function(int num1,int num2){
     return  num1 + num2;
    }
}

class B  extends  Base{
    A a = new  A();
    public int function2(int num1, int num2) {
        return a.function(num1, num2)+9;
    }
}