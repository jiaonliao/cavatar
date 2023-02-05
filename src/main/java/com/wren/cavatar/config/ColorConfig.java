package com.wren.cavatar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wren
 */
@Configuration
@ConfigurationProperties(prefix = "cavatar-color")
public class ColorConfig {
    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String[] getBackgroundColors() {
        return backgroundColors;
    }

    public void setBackgroundColors(String[] backgroundColors) {
        this.backgroundColors = backgroundColors;
    }

    private String[] colors = {"#6BD9E9",
            "#FC909F",
            "#F4D150",
            "#E0DDFF",
            "#D2EFF3",
            "#FFEDEF",
            "#FFEBA4",
            "#506AF4",
            "#F48150",
            "#48A99A",
            "#C09FFF",
            "#FD6F5D"};

    private String[] backgroundColors = {"#6BD9E9",
            "#FC909F",
            "#F4D150",
            "#E0DDFF",
            "#D2EFF3",
            "#FFEDEF",
            "#FFEBA4",
            "#506AF4",
            "#F48150",
            "#48A99A",
            "#C09FFF",
            "#FD6F5D",
            "linear-gradient(45deg, #E3648C, #D97567)",
            "linear-gradient(62deg, #8EC5FC, #E0C3FC)",
            "linear-gradient(90deg, #ffecd2, #fcb69f)",
            "linear-gradient(120deg, #a1c4fd, #c2e9fb)",
            "linear-gradient(-135deg, #fccb90, #d57eeb)"};
}
