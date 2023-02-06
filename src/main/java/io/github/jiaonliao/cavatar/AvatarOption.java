package io.github.jiaonliao.cavatar;


import io.github.jiaonliao.cavatar.constant.BaseWrapperShape;
import io.github.jiaonliao.cavatar.constant.Gender;
import io.github.jiaonliao.cavatar.constant.WrapperShape;

import java.util.List;

/**
 * @author wren
 */

public class AvatarOption {

    private Integer size;

    private Gender gender;

    private WrapperShape wrapperShape;

    private String background;


    private List<Widget<BaseWrapperShape>> widgets;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public WrapperShape getWrapperShape() {
        return wrapperShape;
    }

    public void setWrapperShape(WrapperShape wrapperShape) {
        this.wrapperShape = wrapperShape;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Widget<BaseWrapperShape>> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget<BaseWrapperShape>> widgets) {
        this.widgets = widgets;
    }
}
