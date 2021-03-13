package com.gateway.com.design;

/**
 * @author ym.y
 * @description 开闭原则：程序的设计应该对扩展开放，对修改关闭
 * @package com.gateway.com.design
 * @updateUser
 * @date 17:54 2021/3/9
 */
public class OPenClose {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.draw(new Triangle());
        editor.draw(new Circle());
        editor.draw(new Rectangle());
    }
}

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("绘制三角形");
    }
}

class GraphicEditor {
    public void draw(Shape shape) {
        shape.draw();
    }
}