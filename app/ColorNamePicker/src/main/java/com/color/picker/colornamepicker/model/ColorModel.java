package com.color.picker.colornamepicker.model;

public class ColorModel {
    String color_name,color_hex;

    public ColorModel(){

    }

    public ColorModel(String color_name, String color_hex) {
        this.color_name = color_name;
        this.color_hex = color_hex;
    }

    public String getColor_hex() {
        return color_hex;
    }

    public void setColor_hex(String color_hex) {
        this.color_hex = color_hex;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }
}

