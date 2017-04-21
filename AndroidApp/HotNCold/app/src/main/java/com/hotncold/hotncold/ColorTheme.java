package com.hotncold.hotncold;

import android.graphics.Color;

/**
 * Created by Klaxmax on 20.04.2017.
 */

public class ColorTheme {
    private int colText;
    private int colBackgroundTheme;
    private int colBackground;
    private int colLogo;

    private static final ColorTheme ourInstance = new ColorTheme();

    static ColorTheme getInstance() {
        return ourInstance;
    }

    public ColorTheme(){}

    public int getColText() {
        return colText;
    }

    public void setColText(int colText) {
        this.colText = colText;
    }

    public int getColBackgroundTheme() {
        return colBackgroundTheme;
    }

    public void setColBackgroundTheme(int colBackgroundTheme) {
        this.colBackgroundTheme = colBackgroundTheme;
    }

    public int getColBackground() {
        return colBackground;
    }

    public void setColBackground(int colBackground) {
        this.colBackground = colBackground;
    }

    public int getColLogo() {
        return colLogo;
    }

    public void setColLogo(int colLogo) {
        this.colLogo = colLogo;
    }
}
