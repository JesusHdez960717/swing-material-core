/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.splashScreen;

import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.bundles.loading.LoadingProcess;
import javax.swing.SwingWorker;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LoadingWorkerSplash<T> extends SwingWorker<T, Void> {

    private DialogPanel dialogSplash;
    private final LoadingProcess<T> process;
    private Exception exception;

    public LoadingWorkerSplash(LoadingProcess p) {
        dialogSplash = new DialogPanel(new SplashScreen());
        this.process = p;
        this.execute();
    }

    @Override
    protected T doInBackground() throws Exception {
        try {
            return process.process();
        } catch (Exception e) {
            this.exception = e;
        }
        return null;
    }

    @Override
    protected void done() {
        try {
            dialogSplash.dispose();
            dialogSplash = null;
            if (exception != null) {//se lanzo excepcion
                process.errorInProcess(exception);
            } else {//todo ok
                process.completed(this.get());
            }
        } catch (Exception ex) {
            process.errorInProcess(ex);
        }
        super.done();
    }

}
