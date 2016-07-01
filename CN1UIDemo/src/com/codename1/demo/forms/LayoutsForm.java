/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author Chen
 */
public class LayoutsForm extends BaseForm {

    public LayoutsForm() {
        setTitle("Layouts");
    }

    protected void initUI() {
        setLayout(new BorderLayout());
        final Container layouts = new Container();
        final Button borderLayout = new Button("Border");
        final Button boxYLayout = new Button("Box Y");
        final Button boxXLayout = new Button("Box X");
        final Button flowLayout = new Button("Flow");
        final Button flowCenterLayout = new Button("Flow Center");
        final Button gridLayout = new Button("Grid");
        final Button tableLayout = new Button("Table");

        layouts.addComponent(borderLayout);
        layouts.addComponent(boxYLayout);
        layouts.addComponent(boxXLayout);
        layouts.addComponent(flowLayout);
        layouts.addComponent(flowCenterLayout);
        layouts.addComponent(gridLayout);
        layouts.addComponent(tableLayout);

        add(BorderLayout.CENTER, layouts);

        borderLayout.addActionListener((e) -> {
            layouts.setLayout(new BorderLayout());

            // need to re-add the components since the layout requires a contraint
            layouts.removeComponent(boxYLayout);
            layouts.removeComponent(boxXLayout);
            layouts.removeComponent(flowLayout);
            layouts.removeComponent(flowCenterLayout);
            layouts.removeComponent(gridLayout);
            borderLayout.setVisible(false);
            tableLayout.setVisible(false);
            layouts.addComponent(BorderLayout.CENTER, boxYLayout);
            layouts.addComponent(BorderLayout.EAST, boxXLayout);
            layouts.addComponent(BorderLayout.WEST, flowLayout);
            layouts.addComponent(BorderLayout.NORTH, flowCenterLayout);
            layouts.addComponent(BorderLayout.SOUTH, gridLayout);

            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        boxYLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            layouts.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        boxXLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            layouts.setLayout(new BoxLayout(BoxLayout.X_AXIS));
            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        flowLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            layouts.setLayout(new FlowLayout());
            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        flowCenterLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            layouts.setLayout(new FlowLayout(Component.CENTER));
            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        gridLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            GridLayout g = new GridLayout(1, 1);
            g.setAutoFit(true);
            layouts.setLayout(g);
            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });
        tableLayout.addActionListener(e -> {
            borderLayout.setVisible(true);
            tableLayout.setVisible(true);
            TableLayout tl = new TableLayout(2, 4);
            layouts.setLayout(tl);

            // need to re-add the components since the layout requires a contraint
            layouts.removeAll();
            layouts.addComponent(borderLayout);
            layouts.addComponent(boxYLayout);
            layouts.addComponent(boxXLayout);
            layouts.addComponent(flowLayout);

            TableLayout.Constraint c = tl.createConstraint();
            c.setHorizontalSpan(2);
            layouts.addComponent(c, flowCenterLayout);
            layouts.addComponent(gridLayout);
            layouts.addComponent(tableLayout);

            layouts.setShouldCalcPreferredSize(true);
            layouts.animateLayout(800);
        });

    }

}
