/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author Chen
 */
public class PickerForm extends BaseForm {

    public PickerForm() {
        setTitle("Pickers");
    }

    @Override
    protected void initUI() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        
        Image info = FontImage.createMaterial(FontImage.MATERIAL_INFO_OUTLINE, getUIManager().getComponentSelectedStyle("TitleCommand"));
        getToolbar().addCommandToRightBar("", info, ev -> {
            Dialog.show("About", "Pickers use the native picker components when running on a device, therefore "
                    + "the Popup will have a different look between the simulator and the devices.", "Ok", null);
        });
        
        Label lbl = new Label("Strings Picker");
        Picker strings = new Picker();
        strings.setType(Display.PICKER_TYPE_STRINGS);
        strings.setStrings("option0", "option1", "option2", "option3", "option4",
                "option5", "option6", "option7", "option8", "option9");
        strings.setSelectedString("option1");
        add(lbl);
        add(strings);

        lbl = new Label("Date Picker");
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        add(lbl);
        add(datePicker);

        lbl = new Label("Time Picker");
        Picker timePicker = new Picker();
        timePicker.setType(Display.PICKER_TYPE_TIME);
        add(lbl);
        add(timePicker);
        
        lbl = new Label("Date & Time Picker");
        Picker dateTimePicker = new Picker();
        dateTimePicker.setType(Display.PICKER_TYPE_DATE_AND_TIME);
        add(lbl);
        add(dateTimePicker);
        
    }

}
