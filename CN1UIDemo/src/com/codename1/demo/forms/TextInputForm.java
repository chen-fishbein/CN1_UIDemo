/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

/**
 *
 * @author Chen
 */
public class TextInputForm extends BaseForm {

    public TextInputForm() {
        setTitle("Text Input");
    }

    @Override
    protected void initUI() {
        TableLayout tl;
        int spanButton = 2;
        if (Display.getInstance().isTablet()) {
            tl = new TableLayout(7, 2);
        } else {
            tl = new TableLayout(14, 1);
            spanButton = 1;
        }
        tl.setGrowHorizontally(true);
        setLayout(tl);

        TextField firstName = new TextField("", "First Name", 20, TextArea.ANY);
        TextField surname = new TextField("", "Surname", 20, TextArea.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextArea.EMAILADDR);
        TextField url = new TextField("", "URL", 20, TextArea.URL);
        TextField phone = new TextField("", "Phone", 20, TextArea.PHONENUMBER);

        final TextField num1 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num1.setMaxSize(4);
        final TextField num2 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num2.setMaxSize(4);
        final TextField num3 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num3.setMaxSize(4);
        final TextField num4 = new TextField("", "1234", 4, TextArea.NUMERIC);
        num4.setMaxSize(4);

        num1.addDataChangeListener((i, j) -> {
            if (num1.getText().length() == 4) {
                num1.stopEditing();
                new Thread(new Runnable() {

                    public void run() {
                        //start editing can start once the previous field was
                        //closed
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                        num2.startEditing();
                        num2.requestFocus();
                    }
                }).start();
            }

        });
        num2.addDataChangeListener((i, j) -> {
            if (num2.getText().length() == 4) {
                num2.stopEditing();
                new Thread(new Runnable() {

                    public void run() {
                        //start editing can start once the previous field was
                        //closed
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                        num3.startEditing();
                        num3.requestFocus();
                    }
                }).start();
            }

        });
        num3.addDataChangeListener((i, j) -> {
            if (num3.getText().length() == 4) {
                num3.stopEditing();
                new Thread(new Runnable() {

                    public void run() {
                        //start editing can start once the previous field was
                        //closed
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                        num4.startEditing();
                        num4.requestFocus();
                    }
                }).start();
            }

        });

        Button submit = new Button("Submit");
        TableLayout.Constraint cn = tl.createConstraint();
        cn.setHorizontalSpan(spanButton);
        cn.setHorizontalAlign(Component.RIGHT);
        add("First Name").add(firstName).
                add("Surname").add(surname).
                add("E-Mail").add(email).
                add("URL").add(url).
                add("Phone").add(phone).
                add("Credit Card").
                add(GridLayout.encloseIn(4, num1, num2, num3, num4)).
                add(cn, submit);
        Validator v = new Validator();
        v.addConstraint(firstName, new LengthConstraint(2)).
                addConstraint(surname, new LengthConstraint(2)).
                addConstraint(url, RegexConstraint.validURL()).
                addConstraint(email, RegexConstraint.validEmail()).
                addConstraint(phone, new RegexConstraint("^[0-9]*$", "Must be valid phone number")).
                addConstraint(num1, new LengthConstraint(4)).
                addConstraint(num2, new LengthConstraint(4)).
                addConstraint(num3, new LengthConstraint(4)).
                addConstraint(num4, new LengthConstraint(4));

    }

}
