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

import javax.swing.JCheckBox;

/**
 *
 * @author martin
 */
public class DomainCheckBox {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;

    public DomainCheckBox(JCheckBox checkBox1, JCheckBox checkBox2, JCheckBox checkBox3, JCheckBox checkBox4) {
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
        this.checkBox3 = checkBox3;
        this.checkBox4 = checkBox4;
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(JCheckBox checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public JCheckBox getCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(JCheckBox checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public JCheckBox getCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(JCheckBox checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public JCheckBox getCheckBox4() {
        return checkBox4;
    }

    public void setCheckBox4(JCheckBox checkBox4) {
        this.checkBox4 = checkBox4;
    }
}
