/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;

/**
 *
 * @author Chen
 */
public class TableForm extends BaseForm {

    public TableForm() {
        setTitle("Table");
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());
        TableModel model = new DefaultTableModel(new String[]{"Col 1", "Col 2", "Col 3"}, new Object[][]{
            {"Row 1", "Row A", "Row X"},
            {"Row 2", "Row B can now stretch", null},
            {"Row 3", "Row C", "Row Z"},
            {"Row 4", "Row D", "Row K"},}) {
            public boolean isCellEditable(int row, int col) {
                return col != 0;
            }
        };
        Table table = new Table(model) {
            @Override
            protected Component createCell(Object value, int row, int column, boolean editable) {
                Component cell;
                if (row == 1 && column == 1) {
                    Picker p = new Picker();
                    p.setType(Display.PICKER_TYPE_STRINGS);
                    p.setStrings("Row B can now stretch", "This is a good value", "So Is This", "Better than text field");
                    p.setSelectedString((String) value);
                    p.setUIID("TableCell");
                    p.addActionListener((e) -> getModel().setValueAt(row, column, p.getSelectedString()));
                    cell = p;
                } else {
                    cell = super.createCell(value, row, column, editable);
                }
                if (row > -1 && row % 2 == 0) { // pinstripe effect
                    cell.getAllStyles().setBgColor(0xeeeeee);
                    cell.getAllStyles().setBgTransparency(255);
                }
                return cell;
            }

            @Override
            protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) {
                TableLayout.Constraint con = super.createCellConstraint(value, row, column);
                if (row == 1 && column == 1) {
                    con.setHorizontalSpan(2);
                }
                con.setWidthPercentage(33);
                return con;
            }
        };
        add(BorderLayout.CENTER, table);
    }

}
