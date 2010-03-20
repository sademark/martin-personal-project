/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.web.martinusadyh.launcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process pcs = null;
            String parameter = "Halo Sayang Muach.. muach... :D";
            pcs = rt.exec("java -jar /home/martinus/Desktop/Target/dist/CobaCobaAh/Target.jar " + parameter);
            InputStream is = pcs.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            bf.close();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
