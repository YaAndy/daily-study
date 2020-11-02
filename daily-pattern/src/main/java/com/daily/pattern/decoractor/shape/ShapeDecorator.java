package com.daily.pattern.decoractor.shape;

/**
 * @Description 创建一个装饰抽象类
 * @Author ROCIA
 * @Date 2020/11/2
 */
public class ShapeDecorator implements Shape{

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }

}
