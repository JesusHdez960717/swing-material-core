package com.jhw.swing.bundles.loading;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public abstract class LoadingProcess<T> {

    public abstract T process() throws Exception;

    public abstract void completed(T result) throws Exception;

    public void errorInProcess(Exception result) {
        System.out.println("Excepcion en el proceso, imprimiendo StackTrace:");
        result.printStackTrace();
    }

}
