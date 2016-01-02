/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Personajes.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author David Campos Rodríguez <david.campos@rai.usc.es>
 */
public class PropiedadesEnemigo extends javax.swing.JDialog{
    //TODO todo lo respectivo a la mochila

    private final Enemigo enemigo;
    private final Editor editor;
    /**
     * Creates new form PropiedadesEnemigo
     */
    public PropiedadesEnemigo(Editor contexto, Enemigo enemigo) {
        this.enemigo = enemigo;
        this.editor = contexto;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panGeneral = new javax.swing.JTabbedPane();
        panPest1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtVidaMax = new javax.swing.JFormattedTextField();
        panVida = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sldVida = new javax.swing.JSlider();
        lblVida = new javax.swing.JLabel();
        panEnergia = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtEnergia = new javax.swing.JFormattedTextField();
        panArmasYArmadura = new javax.swing.JPanel();
        lblArmadura = new javax.swing.JLabel();
        lblArmaDer = new javax.swing.JLabel();
        lblArmaIzq = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        panMochila = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMochila = new javax.swing.JList();
        panAceptarCancelar = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 5));

        panPest1.setMaximumSize(new java.awt.Dimension(219, 32767));
        panPest1.setMinimumSize(new java.awt.Dimension(219, 265));
        panPest1.setPreferredSize(new java.awt.Dimension(219, 100));

        jPanel1.setPreferredSize(new java.awt.Dimension(363, 20));

        txtNombre.setBackground(java.awt.SystemColor.control);
        txtNombre.setText(enemigo.getNombre());
        txtNombre.setBorder(null);
        txtNombre.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNombreMouseExited(evt);
            }
        });
        txtNombre.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e) {
                txtNombreTextoCambiado();
            }
            public void removeUpdate(DocumentEvent e) {
                txtNombreTextoCambiado();
            }
            public void insertUpdate(DocumentEvent e) {
                txtNombreTextoCambiado();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        panPest1.add(jPanel1);

        jLabel1.setText("Tipo:");
        panPest1.add(jLabel1);

        cbxTipo.setModel(new ModeloCbxTipoEnemigo());
        cbxTipo.setSelectedItem(enemigo.getClass()
        );
        cbxTipo.setRenderer(new RenderizadorClases());
        panPest1.add(cbxTipo);

        jLabel2.setText("Vida máx:");
        panPest1.add(jLabel2);

        txtVidaMax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtVidaMax.setText(String.valueOf(enemigo.getMaxVida()));
        txtVidaMax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVidaMaxFocusLost(evt);
            }
        });
        txtVidaMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVidaMaxActionPerformed(evt);
            }
        });
        panPest1.add(txtVidaMax);

        panVida.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Vida:");
        panVida.add(jLabel3, java.awt.BorderLayout.LINE_START);

        sldVida.setMaximum(enemigo.getMaxVida());
        sldVida.setMinimum(1);
        sldVida.setPaintLabels(true);
        sldVida.setToolTipText("Vida del enemigo");
        sldVida.setValue(enemigo.getVida()
        );
        sldVida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldVidaStateChanged(evt);
            }
        });
        panVida.add(sldVida, java.awt.BorderLayout.CENTER);

        lblVida.setText(String.valueOf(sldVida.getValue()));
        panVida.add(lblVida, java.awt.BorderLayout.LINE_END);
        lblVida.getAccessibleContext().setAccessibleDescription("");

        panPest1.add(panVida);

        panEnergia.setLayout(new java.awt.BorderLayout(5, 0));

        jLabel4.setText("Energía por turno:");
        panEnergia.add(jLabel4, java.awt.BorderLayout.LINE_START);

        txtEnergia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEnergia.setText(String.valueOf(enemigo.getEnergiaPorTurno()));
        txtEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnergiaActionPerformed(evt);
            }
        });
        panEnergia.add(txtEnergia, java.awt.BorderLayout.CENTER);

        panPest1.add(panEnergia);

        panArmasYArmadura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblArmadura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArmadura.setText(textoArmadura());
        lblArmadura.setToolTipText("Armadura...");
        lblArmadura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panArmasYArmadura.add(lblArmadura, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 40, 90, 150));

        lblArmaDer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArmaDer.setText(textoArmaDer());
        lblArmaDer.setToolTipText("Arma derecha...");
        lblArmaDer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panArmasYArmadura.add(lblArmaDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, 50));

        lblArmaIzq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArmaIzq.setText(textoArmaIzq());
        lblArmaIzq.setToolTipText("Arma izquierda...");
        lblArmaIzq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panArmasYArmadura.add(lblArmaIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 180, 50, 50));

        lblFondo.setIcon(new javax.swing.ImageIcon("C:\\NetBeansProjects\\proyecto-poo\\img\\cuerpo.png")); // NOI18N
        panArmasYArmadura.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panPest1.add(panArmasYArmadura);

        panGeneral.addTab("General", null, panPest1, "");

        panMochila.setMaximumSize(new java.awt.Dimension(219, 32767));
        panMochila.setMinimumSize(new java.awt.Dimension(219, 27));
        panMochila.setPreferredSize(new java.awt.Dimension(219, 386));
        panMochila.setLayout(new javax.swing.BoxLayout(panMochila, javax.swing.BoxLayout.LINE_AXIS));

        lstMochila.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstMochila);

        panMochila.add(jScrollPane1);

        panGeneral.addTab("Mochila", panMochila);

        getContentPane().add(panGeneral, java.awt.BorderLayout.CENTER);

        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAceptarCancelarLayout = new javax.swing.GroupLayout(panAceptarCancelar);
        panAceptarCancelar.setLayout(panAceptarCancelarLayout);
        panAceptarCancelarLayout.setHorizontalGroup(
            panAceptarCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAceptarCancelarLayout.createSequentialGroup()
                .addGap(0, 198, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar))
        );
        panAceptarCancelarLayout.setVerticalGroup(
            panAceptarCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAceptarCancelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panAceptarCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)))
        );

        getContentPane().add(panAceptarCancelar, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        txtNombre.setBackground(Color.white);
        txtNombre.setBorder(new javax.swing.border.LineBorder(Color.black, 1, false));
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setBackground(Color.getColor("control"));
        txtNombre.setBorder(null);
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        if(txtNombre.getBorder() == null)
            txtNombre.setBorder(new javax.swing.border.LineBorder(Color.gray, 1, false));
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseExited
        if(txtNombre.getBorder() != null &&
                txtNombre.getBorder() instanceof javax.swing.border.LineBorder
                && ((javax.swing.border.LineBorder)txtNombre.getBorder()).getLineColor().equals(Color.gray))
            txtNombre.setBorder(null);
    }//GEN-LAST:event_txtNombreMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtVidaMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVidaMaxActionPerformed
        Integer n = Integer.parseInt(txtVidaMax.getText());
        if(n < 1){
            txtVidaMax.setText("1");
            txtVidaMaxActionPerformed(evt);
        }else sldVida.setMaximum(n);
    }//GEN-LAST:event_txtVidaMaxActionPerformed

    private void sldVidaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldVidaStateChanged
        lblVida.setText(String.valueOf(sldVida.getValue()));
    }//GEN-LAST:event_sldVidaStateChanged

    private void txtVidaMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVidaMaxFocusLost
        txtVidaMaxActionPerformed(null);
    }//GEN-LAST:event_txtVidaMaxFocusLost

    private void txtEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnergiaActionPerformed
        Integer n = Integer.parseInt(txtVidaMax.getText());
        if(n < 1)
            txtEnergia.setText("1");
    }//GEN-LAST:event_txtEnergiaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO al aceptar, poner las propiedades del enemigo (o si se cambió la clase, crear un enemigo nuevo de la clase adecuada)
        // puede que haya que hacer un "setEnemigo" en celda o así, para que esté en la misma posición
        // aunque lo veo un poco innecesario.
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreTextoCambiado(){
        //Recalculamos el ancho del cuadro de texto
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
        int ancho = (int)(txtNombre.getFont().getStringBounds(txtNombre.getText(), frc).getWidth())+2;
        ancho = Math.min(Math.max(20, ancho), panGeneral.getWidth());
        txtNombre.setSize(new Dimension(ancho, txtNombre.getPreferredSize().height));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblArmaDer;
    private javax.swing.JLabel lblArmaIzq;
    private javax.swing.JLabel lblArmadura;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblVida;
    private javax.swing.JList lstMochila;
    private javax.swing.JPanel panAceptarCancelar;
    private javax.swing.JPanel panArmasYArmadura;
    private javax.swing.JPanel panEnergia;
    private javax.swing.JTabbedPane panGeneral;
    private javax.swing.JPanel panMochila;
    private javax.swing.JPanel panPest1;
    private javax.swing.JPanel panVida;
    private javax.swing.JSlider sldVida;
    private javax.swing.JFormattedTextField txtEnergia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtVidaMax;
    // End of variables declaration//GEN-END:variables

    private String textoArmadura() {
        if(enemigo.getArmadura() != null)
            return enemigo.getArmadura().toString();
        else
            return "<html>Sin<br>armadura</html>";
    }

    private String textoArmaDer() {
        if(enemigo.getArma() != null)
            return "Editar";
        else
            return "No";
    }

    private String textoArmaIzq() {
        if(enemigo.getArma_izq()!= null)
            return "Editar";
        else
            return "No";        
    }

    private static class ModeloCbxTipoEnemigo extends AbstractListModel<Class> implements ComboBoxModel<Class> {
        ArrayList<Class> tipos;
        Class selecto;
        
        public ModeloCbxTipoEnemigo() {
            tipos = new ArrayList(4);
            tipos.add(Floater.class);
            tipos.add(LightFloater.class);
            tipos.add(HeavyFloater.class);
            tipos.add(Sectoid.class);
            
            selecto = tipos.get(0);
        }

        @Override
        public int getSize() {
            return tipos.size();
        }

        @Override
        public Class getElementAt(int index) {
            return tipos.get(index);
        }

        @Override
        public void setSelectedItem(Object anItem) {
            if(anItem instanceof Class && tipos.contains((Class)anItem))
                selecto = (Class)anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selecto;
        }
    }

    private static class RenderizadorClases extends JLabel implements ListCellRenderer<Class> {
        public RenderizadorClases() {
            super();
        }
        
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Class> list,
                Class value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            if(value == null)
                setText("null");
            else{
                setText(value.getSimpleName());
            }
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);
            return this;
        }
    }
}
