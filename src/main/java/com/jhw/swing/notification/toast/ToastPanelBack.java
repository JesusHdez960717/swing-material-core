package com.jhw.swing.notification.toast;

import com.jhw.swing.material.components.container.panel._PanelTransparent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ToastPanelBack extends _PanelTransparent {

    public ToastPanelBack() {
        initComponents();
    }

    ToastPanelBack(int duration) {
        initComponents();
        toastDisplayer1.setDelayUp(duration);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toastDisplayer1 = new com.jhw.swing.notification.toast.ToastDisplayer();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toastDisplayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toastDisplayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.notification.toast.ToastDisplayer toastDisplayer1;
    // End of variables declaration//GEN-END:variables

    public void displayToast(ToastComponent toast) {
        toastDisplayer1.display(toast);
    }

    public int getTotalTime() {
        return toastDisplayer1.getTotalTime();
    }

    public void dispose() {
        toastDisplayer1.dispose();
    }

}
