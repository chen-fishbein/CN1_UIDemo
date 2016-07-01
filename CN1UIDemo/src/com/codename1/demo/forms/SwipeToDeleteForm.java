/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Chen
 */
public class SwipeToDeleteForm extends BaseForm {

    public SwipeToDeleteForm() {
        setTitle("Swipeable");
    }

    @Override
    protected void initUI() {
        setLayout(BoxLayout.y());
        setScrollableY(true);

        Image info = FontImage.createMaterial(FontImage.MATERIAL_INFO_OUTLINE, getUIManager().getComponentSelectedStyle("TitleCommand"));
        getToolbar().addCommandToRightBar("", info, ev -> {
            Dialog.show("About", "Drag the entries to the left and to the right to reveal more options.", "Ok", null);
        });
        
        
        add(createRankWidget("A Game of Thrones", "1996"));
        add(createRankWidget("A Clash Of Kings", "1998"));
        add(createRankWidget("A Storm Of Swords", "2000"));
        add(createRankWidget("A Feast For Crows", "2005"));
        add(createRankWidget("A Dance With Dragons", "2011"));
        add(createRankWidget("The Winds of Winter", "TBD"));
        add(createRankWidget("A Dream of Spring", "TBD"));
    }

    public SwipeableContainer createRankWidget(String title, String year) {
        MultiButton button = new MultiButton(title);
        button.setTextLine2(year);
        
        Image icon = FontImage.createMaterial(FontImage.MATERIAL_DELETE, getUIManager().getComponentSelectedStyle("TitleCommand"));
        Button delete = new Button(icon);
        
        SwipeableContainer swipable = new SwipeableContainer(FlowLayout.encloseCenterMiddle(createStarRankSlider()), 
                BorderLayout.centerAbsolute(delete), button);
        delete.addActionListener((e)->{
            removeComponent(swipable);
            getContentPane().animateLayout(150);
        });
        return swipable;
    }

    private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

}
