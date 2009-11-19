/*
 *  Copyright (c) 2009 Martinus Ady H <mrt.itnewbies@gmail.com>.
 *  All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  o Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  o Neither the name of the <ORGANIZATION> nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 *  OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 *  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 *  OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 *  MTaskButton.java
 *  
 *  Created on Nov 20, 2009, 12:42:35 AM
 */

package id.web.martinusadyh.swingaccordionmenu;

import javax.swing.JComponent;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 */
public class MTaskButton extends javax.swing.JToggleButton {

    private JComponent  parentComp;
    private boolean     resizeComponent = false;

    /** Buat agar panjang komponen ini sama panjangnya dengan parentComponen
     * jika ditambahkan pada Container dengan BoxLayout */
    @Override public int getWidth() {
        if (resizeComponent && parentComp != null) {
            super.setSize(parentComp.getWidth(), super.getHeight());
        }

        return super.getWidth();
    }

    public JComponent getParentComp() {
        return parentComp;
    }

    public void setParentComp(JComponent parentComp) {
        this.parentComp = parentComp;
    }

    public boolean isResizeComponent() {
        return resizeComponent;
    }

    public void setResizeComponent(boolean resizeComponent) {
        this.resizeComponent = resizeComponent;
    }
}
