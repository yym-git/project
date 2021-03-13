package com.gateway.com.design;

/**
 * @author ym.y
 * @description 依赖倒转原则：程序的实现应该依赖于接口，而不应该依赖于具体的实现
 * @package com.gateway.com.design
 * @updateUser
 * @date 17:09 2021/3/9
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

interface  IReceive{
    public String getInfo();
}


//邮件
class  Email implements  IReceive{

    @Override
    public String getInfo() {
       return "电子邮件信息：hello world！";
    }
}


//微信
class WeChart implements  IReceive{

    @Override
    public String getInfo() {
        return "微信消息：hello  world！";
    }
}
class Person{
    public void receive(IReceive iReceive){
        System.out.println(iReceive.getInfo());
    }
}
