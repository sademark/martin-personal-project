/*
 * Copyright (c) 2009, Martinus Ady H <mrt.itnewbies@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * o Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * o Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * o Neither the name of the <ORGANIZATION> nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package id.web.martinusadyh.jcheckbox.custom;

import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author martin
 */
public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
    private List<DomainCheckBox> listCk;

    public CheckBoxRenderer(List<DomainCheckBox> listCk) {
        this.listCk = listCk;
    }

    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row, int column) {

        JCheckBox checkBox = null;
        for (DomainCheckBox ck : listCk) {
            if (ck.getCheckBox1().getText().equals((String) value)) {
                checkBox = ck.getCheckBox1();
            } else  if (ck.getCheckBox2().getText().equals((String) value)) {
                checkBox = ck.getCheckBox2();
            } else  if (ck.getCheckBox3().getText().equals((String) value)) {
                checkBox = ck.getCheckBox3();
            } else  if (ck.getCheckBox4().getText().equals((String) value)) {
                checkBox = ck.getCheckBox4();
            }
        }
        
        if (!isSelected) {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        } else {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }
        return checkBox;
    }
}
