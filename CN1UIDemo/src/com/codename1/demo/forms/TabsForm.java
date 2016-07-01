/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.ScaleImageLabel;
import com.codename1.io.Log;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;

/**
 *
 * @author Chen
 */
public class TabsForm extends BaseForm {

    private Tabs tabs;
    
    private Container tabsFlow;

    private boolean hiddenTabs = false;

    public TabsForm() {
        setTitle("Tabs");
    }

    protected void initUI() {
        setLayout(new BorderLayout());
        placeTabs(BOTTOM);
        getToolbar().addCommandToOverflowMenu("Bottom", null, ev -> {
            placeTabs(BOTTOM);
            revalidate();
        });
        getToolbar().addCommandToOverflowMenu("Top", null, ev -> {
            placeTabs(TOP);
            revalidate();
        });
        getToolbar().addCommandToOverflowMenu("Left", null, ev -> {
            placeTabs(LEFT);
            revalidate();
        });
        getToolbar().addCommandToOverflowMenu("Right", null, ev -> {
            placeTabs(RIGHT);
            revalidate();
        });
        getToolbar().addCommandToOverflowMenu("Hide/Show", null, ev -> {
            if (hiddenTabs) {
                tabs.showTabs();
            } else {
                tabs.hideTabs();
            }
            tabsFlow.setHidden(hiddenTabs);
            revalidate();
            hiddenTabs = !hiddenTabs;
        });
    }

    private void placeTabs(int position) {
        removeAll();
        tabs = new Tabs();
        tabs.setTabPlacement(position);
        try {
            ScaleImageLabel imageLabel = new ScaleImageLabel(Image.createImage("/landscape1.jpg"));
            imageLabel.setUIID("Container");
            tabs.addTab("Tab1", imageLabel);
            ScaleImageLabel imageLabe2 = new ScaleImageLabel(Image.createImage("/landscape2.jpg"));
            imageLabe2.setUIID("Container");
            tabs.addTab("Tab2", imageLabe2);
            ScaleImageLabel imageLabe3 = new ScaleImageLabel(Image.createImage("/landscape3.jpg"));
            imageLabe3.setUIID("Container");
            tabs.addTab("Tab3", imageLabe3);

        } catch (IOException ex) {
            Log.e(ex);
        }
        add(BorderLayout.CENTER, tabs);
        if(hiddenTabs){
            tabs.hideTabs();
        }
        RadioButton firstTab = new RadioButton("");
        RadioButton secondTab = new RadioButton("");
        RadioButton thirdTab = new RadioButton("");
        firstTab.setEnabled(false);
        secondTab.setEnabled(false);
        thirdTab.setEnabled(false);
        
        firstTab.setUIID("Container");
        secondTab.setUIID("Container");
        thirdTab.setUIID("Container");
        new ButtonGroup(firstTab, secondTab, thirdTab);
        firstTab.setSelected(true);
        tabsFlow = FlowLayout.encloseCenter(firstTab, secondTab, thirdTab);        
        add(BorderLayout.SOUTH, tabsFlow);
        tabsFlow.setHidden(!hiddenTabs);
        tabs.addSelectionListener((i1, i2) -> {
            switch (i2) {
                case 0:
                    if (!firstTab.isSelected()) {
                        firstTab.setSelected(true);
                    }
                    break;
                case 1:
                    if (!secondTab.isSelected()) {
                        secondTab.setSelected(true);
                    }
                    break;
                case 2:
                    if (!thirdTab.isSelected()) {
                        thirdTab.setSelected(true);
                    }
                    break;
            }
        });

    }

}
