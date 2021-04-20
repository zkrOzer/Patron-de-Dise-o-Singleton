/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlL.ManejaDatosEst;
import datos.ModeloTabla;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author krOzer
 */
public class interfaz extends JFrame implements ActionListener, Runnable {

    private ModeloTabla mt;
    private ManejaDatosEst baseDatos;
    //ModeloTabla mt=modTabla;
    //ManipulaDatos MD;
    private JLabel titulo, numC, numCL, name, sexo, edad, semestre, creditos, carrera, carreraL;
    private JButton registrar, terminar;
    private JRadioButton radio1, radio2;
    private JTextField nameT;
    private JSpinner edadSP, semestreSP, creditosSP;
    private SpinnerNumberModel edadM, SemestreM, creditoM;
    private JTable tb1;
    private ButtonGroup botones;

    public interfaz(ModeloTabla modTabla) {
       
            setTitle("ACADEMIA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String consulta = "SELECT *FROM ADMINISTRADOR.ESTUDIANTE";
            mt = modTabla;
            baseDatos = new ManejaDatosEst();
            mt.setDatos(baseDatos.consultaDatos(consulta), baseDatos);

            tb1 = new JTable();

            tb1.setModel(mt);

            pintar();

        
    }
    
    public void pintar(){
        JPanel todo = new JPanel();

            //añadiendo el panel al frame
            add(todo);
            titulo = new JLabel("                                        "
                    + "               AGREGA , VISUALIZA Y MODIFICA DATOS DE ESTUDIANTES:              "
                    + "                                             ");

            numC = new JLabel("Num de controlL:");
            numCL = new JLabel("S.N");
            name = new JLabel("Nombre:");
            nameT = new JTextField(15);
            sexo = new JLabel("Sexo:");

            radio1 = new JRadioButton("Mujer", true);
            radio2 = new JRadioButton("Hombre", false);
            botones = new ButtonGroup();
            botones.add(radio1);
            botones.add(radio2);

            edad = new JLabel("Edad:");
            edadSP = new JSpinner();
            edadM = new SpinnerNumberModel();
            edadM.setValue(18);
            edadM.setMinimum(18);
            edadM.setMaximum(30);
            edadSP.setModel(edadM);

            semestre = new JLabel("Semestre:");
            semestreSP = new JSpinner();
            SemestreM = new SpinnerNumberModel();
            SemestreM.setValue(1);
            SemestreM.setMinimum(1);
            SemestreM.setMaximum(13);
            semestreSP.setModel(SemestreM);

            creditos = new JLabel("Creditos:");
            creditosSP = new JSpinner();
            creditoM = new SpinnerNumberModel();
            creditoM.setValue(1);
            creditoM.setMinimum(1);
            creditoM.setMaximum(200);
            creditosSP.setModel(creditoM);

            carrera = new JLabel("Carrera ID:");
            carreraL = new JLabel("3");

            registrar = new JButton("Registrar");
            terminar = new JButton("Terminar");
        
            todo.add(titulo);

            todo.add(numC);
            todo.add(numCL);
            todo.add(name);
            todo.add(nameT);
            todo.add(sexo);
            todo.add(radio1);
            todo.add(radio2);

            todo.add(edad);
            todo.add(edadSP);
            todo.add(semestre);
            todo.add(semestreSP);

            todo.add(creditos);
            todo.add(creditosSP);
            todo.add(carrera);
            todo.add(carreraL);
            todo.add(registrar);
            todo.add(terminar);
            todo.add(tb1.getTableHeader());
            todo.add(tb1);

            registrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    char sexo = ' ';

                    if (radio1.isSelected() == true) {
                        sexo = 'M';
                    } else if (radio2.isSelected() == true) {
                        sexo = 'H';
                    }

                    String datos = "INSERT INTO ADMINISTRADOR.ESTUDIANTE "
                            + "(nombre, edad, sexo,semestre,creditos,idCarrera) values"
                            + "('" + nameT.getText() + "'," + (int) edadSP.getValue() + ",'" + sexo + "'," + (int) semestreSP.getValue() + "," + (int) creditosSP.getValue() + "," + 3 + ")";
                    baseDatos.actualizaDatos(datos);
                    mt.setDatos(baseDatos.consultaDatos("SELECT * FROM ADMINISTRADOR.ESTUDIANTE"), baseDatos);
                    mt.fireTableDataChanged();

                }
            });

            terminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (baseDatos.cerrarSesion()) {
                        System.exit(0);
                    } else {
                        dispose();
                    }
                }
            });
    }

    
    public void run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PRACTICA_02");
        this.setVisible(true);
        this.setSize(725, 500);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
