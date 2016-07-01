/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.BubbleTransition;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Chen
 */
public class DialogsForm extends BaseForm {

    public DialogsForm() {
        setTitle("Dialog & Toast");
    }

    @Override
    protected void initUI() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        add("Dialog");
        final TextField body = new TextField("Dialog Body");
        body.setHint("Dialog Body");
        add(body);
        final ComboBox transition = new ComboBox("Slide", "Fade", "Pulsate", "Bubble");
        add(transition);
        Button showDialog = new Button("Show Dialog");
        showDialog.setName("showDialog");
        showDialog.addActionListener((e) -> {
            final Dialog d = new Dialog();
            d.setLayout(new BorderLayout());
            d.setTitle("Dialog");
            SpanLabel content = new SpanLabel(body.getText());
            d.add(BorderLayout.CENTER, content);
            switch (transition.getSelectedIndex()) {
                case 0:
                    d.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 400));
                    d.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, false, 400));
                    break;
                case 1:
                    d.setTransitionInAnimator(CommonTransitions.createFade(400));
                    d.setTransitionOutAnimator(CommonTransitions.createFade(400));
                    break;
                case 2:
                    d.setTransitionInAnimator(CommonTransitions.createDialogPulsate());
                    d.setTransitionOutAnimator(CommonTransitions.createDialogPulsate());
                    break;
                case 3:
                    d.setTransitionInAnimator(new BubbleTransition(400, "showDialog"));
                    d.setTransitionOutAnimator(new BubbleTransition(400, "showDialog"));
                    break;
            }
            d.add(BorderLayout.SOUTH, new Button(new Command("OK") {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    d.dispose();
                }

            }));
            d.showDialog();

        });
        add(showDialog);
        add("Toast");
        Button showError = new Button("Show Error");
        Button showNotification = new Button("Show Notification");
        Button showWarning = new Button("Show Warning");

        showError.addActionListener(e -> ToastBar.showErrorMessage("This is an error"));
        showNotification.addActionListener(e -> ToastBar.showMessage("This is a notification", FontImage.MATERIAL_INFO));
        showWarning.addActionListener(e -> ToastBar.showMessage("This is a warning!", FontImage.MATERIAL_WARNING));

        add(showError);
        add(showNotification);
        add(showWarning);

    }

}
