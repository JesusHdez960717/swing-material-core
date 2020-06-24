package com.jhw.swing.material.components.login;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import lombok.Getter;
import lombok.Setter;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Getter
@Setter
public class _LoginPanel extends javax.swing.JPanel {

    public _LoginPanel() {
        initComponents();
        addListeners();
        personalize();//no implementado por interfaz para que los hijos no lo sobreescriban
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new com.jhw.swing.material.components.container.panels._PanelGradient();
        panelBackgroundLogin = new com.jhw.swing.material.components.container.panels._MaterialPanel();
        labelSecure = new com.jhw.swing.material.components.labels._MaterialLabel();
        textFieldUsuario = new com.jhw.swing.material.components.textfield._MaterialTextField();
        passwordUsuario = new com.jhw.swing.material.components.passwordfield._MaterialPasswordField();
        buttonLogin = new com.jhw.swing.material.components.button._MaterialButton();
        labelAnswer = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(692, 460));
        setMinimumSize(new java.awt.Dimension(692, 460));

        panelBackgroundLogin.setBackground(new java.awt.Color(230, 230, 230));
        panelBackgroundLogin.setBorderRadius(10);

        labelSecure.setPreferredSize(new java.awt.Dimension(50, 150));

        textFieldUsuario.setAccent(new java.awt.Color(0, 0, 0));
        textFieldUsuario.setHint("Introduzca el nombre de usuario");
        textFieldUsuario.setLabel("Usuario");

        passwordUsuario.setAccent(new java.awt.Color(0, 0, 0));
        passwordUsuario.setHint("Introduzca la contraseņa");
        passwordUsuario.setLabel("Contraseņa");

        buttonLogin.setBackground(new java.awt.Color(0, 0, 0));
        buttonLogin.setText("Login");
        buttonLogin.setBorderRadius(7);

        labelAnswer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAnswer.setForeground(new java.awt.Color(200, 0, 0));
        labelAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBackgroundLoginLayout = new javax.swing.GroupLayout(panelBackgroundLogin);
        panelBackgroundLogin.setLayout(panelBackgroundLoginLayout);
        panelBackgroundLoginLayout.setHorizontalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(passwordUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSecure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        panelBackgroundLoginLayout.setVerticalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelSecure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(labelAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.button._MaterialButton buttonLogin;
    private javax.swing.JLabel labelAnswer;
    private com.jhw.swing.material.components.labels._MaterialLabel labelSecure;
    private com.jhw.swing.material.components.container.panels._PanelGradient panelBackground;
    private com.jhw.swing.material.components.container.panels._MaterialPanel panelBackgroundLogin;
    private com.jhw.swing.material.components.passwordfield._MaterialPasswordField passwordUsuario;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables

    public String getUser() {
        return textFieldUsuario.getString();
    }

    public String getPass() {
        return new String(passwordUsuario.getPassword());
    }

    /**
     * Clear the answer label and reduce the panel background size
     */
    private void clearAnswer() {
        this.labelAnswer.setText("");
        this.labelAnswer.setIcon(null);
    }

    /**
     * Add the listeners.
     */
    private void addListeners() {
        textFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                clearAnswer();
                onTextFieldUsuarioKeyTyped(evt);
            }
        });

        passwordUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                clearAnswer();
            }
        });

    }

    public void addLoginAction(ActionListener action) {
        buttonLogin.addActionListener(action);
        passwordUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (evt.getKeyChar() == '\n') {//enter pressed
                    action.actionPerformed(null);
                }
            }
        });
    }

    private void onTextFieldUsuarioKeyTyped(KeyEvent evt) {
        if (evt.getKeyChar() == '\n') {//enter pressed
            passwordUsuario.requestFocusInWindow();
        }
    }

    public void setUpAnswer(boolean answ) {
        if (answ) {
            displayCorrectCredentials();
        } else {
            displayWrongCredentials();
        }
        this.repaint();
    }

    private void displayWrongCredentials() {
        labelAnswer.setText("Contraseņa incorrecta".toUpperCase());
        labelAnswer.setIcon(MaterialIcons.CLOSE.deriveIcon(MaterialColors.RED_900));
        labelAnswer.setForeground(MaterialColors.RED_900);
    }

    private void displayCorrectCredentials() {
        labelAnswer.setText("Bienvenido".toUpperCase());
        labelAnswer.setIcon(MaterialIcons.CHECK.deriveIcon(MaterialColors.GREEN_900));
        labelAnswer.setForeground(MaterialColors.GREEN_900);
    }

    /**
     * Start the panel, set up the default colors and add the listeners
     */
    private void personalize() {
        //set up colors
        this.panelBackground.setPrimaryColor(MaterialColors.GREY_400);
        this.panelBackground.setSecundaryColor(MaterialColors.BLACK);
        this.panelBackgroundLogin.setBackground(MaterialColors.BLUEA_400);
        this.labelSecure.setIcon(MaterialIcons.VERIFIED_USER.deriveIcon(130f));
    }
}
