package io.github.jiaonliao.cavatar;


import io.github.jiaonliao.cavatar.constant.BaseWrapperShape;

/**
 * @author wren
 */
public class Widget<T extends BaseWrapperShape> {

    private final T widget;
    private String fillColor;

    public Widget(T widget, String fillColor) {
        this.widget = widget;
        this.fillColor = fillColor;
    }

    public Widget(T widget) {
        this.widget = widget;
    }

    public T getWidget() {
        return widget;
    }


    public String getFillColor() {
        return fillColor;
    }


}
