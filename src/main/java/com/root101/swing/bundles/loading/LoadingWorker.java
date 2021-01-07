/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.bundles.loading;

import com.root101.swing.bundles.dialog.DialogPanel;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * Clase para ejecutar tareas en segundo plano con un cartel de cargando en
 * espera a que termine. <\br>
 * NOTA: NO INCLUYE: <\br>
 * - Timeout. <\br>
 * - Progreso. <\br>
 * - Timeout. <\br>
 *
 * Ejemplo de como se usa. <\br>
 *
 * <pre>
 *  new LoadingWorker{@code <Integer>}(new LoadingProcess{@code <Integer>}() {
 *     {@code @Override}
 *      public Integer process() throws Exception {
 *          Thread.sleep(3 * 1000);
 *          return 5;
 *      }
 *
 *     {@code @Override}
 *      public void completed(Integer result) throws Exception {
 *          System.out.println(result);
 *          throw new Exception("Errro en el completed");
 *      }
 *
 *     {@code @Override}
 *      public void errorInProcess(Exception result) {
 *          System.out.println(result);
 *      }
 *  });
 *
 * </pre>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 * @param <T> Tipo de dato del return del doInBackground();
 */
public class LoadingWorker<T> extends SwingWorker<T, Void> {

    private JDialog dialogLoading;
    private final LoadingProcess<T> process;
    private Exception exception;

    public LoadingWorker(LoadingProcess p) {
        this(new LoadingDialog(), p);
    }

    public LoadingWorker(JPanel dialogLoading, LoadingProcess<T> process) {
        this(new DialogPanel(dialogLoading), process);
    }

    public LoadingWorker(JDialog dialogLoading, LoadingProcess<T> process) {
        this.dialogLoading = dialogLoading;
        this.process = process;
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
            dialogLoading.dispose();
            dialogLoading = null;
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
