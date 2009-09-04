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
package id.web.martinusadyh.jcheckbox.standart;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author martin
 */
public class TableModelStandart extends AbstractTableModel {

    private final String[] HEADER = new String[]{"KOLOM1", "KOLOM2", "KOLOM3", "KOLOM4"};
    private List<Domain> listDomain;

    public TableModelStandart(List<Domain> listDomain) {
        this.listDomain = listDomain;
    }

    public int getRowCount() {
        return listDomain.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class tipe = super.getColumnClass(columnIndex);
        if (columnIndex == 0) {
            tipe = Boolean.class;
        } else if (columnIndex == 1) {
            tipe = Boolean.class;
        } else if (columnIndex == 2) {
            tipe = Boolean.class;
        } else if (columnIndex == 3) {
            tipe = Boolean.class;
        }

        return tipe;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return true;
        } else if (columnIndex == 1) {
            return true;
        } else if (columnIndex == 2) {
            return true;
        } else if (columnIndex == 3) {
            return true;
        } else {
            return false;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Domain domain = listDomain.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return domain.isData1();
            case 1:
                return domain.isData2();
            case 2:
                return domain.isData3();
            case 3:
                return domain.isData4();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Domain model = listDomain.get(rowIndex);
        if (columnIndex == 0 && aValue instanceof Boolean) {
            model.setData1((Boolean) aValue);
        } else if (columnIndex == 1 && aValue instanceof Boolean) {
            model.setData2((Boolean) aValue);
        } else if (columnIndex == 2 && aValue instanceof Boolean) {
            model.setData3((Boolean) aValue);
        } else if (columnIndex == 3 && aValue instanceof Boolean) {
            model.setData4((Boolean) aValue);
        }
    }
}
