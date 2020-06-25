package com.jhw.swing.models.detail;

import com.jhw.swing.notification.toast.TOAST;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.container.panels._MaterialPanel;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table._MaterialPanelActions;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellEditor;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellRender;
import com.jhw.swing.material.components.table.editors_renders.header.HeaderCellRender;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;
import com.jhw.utils.others.KMP;
import com.jhw.utils.security.SHA;
import com.jhw.swing.util.JOP;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standars.MaterialColors;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T> Tipo de modelo de la clase
 */
@Getter
@Setter
public abstract class _MaterialPanelDetail<T> extends _MaterialPanel implements Update {

    private final String modelColumnName = "_" + SHA.hash256(String.valueOf(new SecureRandom().nextLong())) + "_";
    private final String actionsColumnName = "_" + SHA.hash256(String.valueOf(new SecureRandom().nextLong())) + "_";

    private final _MaterialPanelActions.builder builder = new _MaterialPanelActions.builder();
    private final List<T> list = new ArrayList<>();

    public _MaterialPanelDetail() {
        this(new Column[]{});
    }

    public _MaterialPanelDetail(Column[] arr) {
        initComponents();
        setColumns(arr);
        addListeners();
        personalizationInner();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHeader = new com.jhw.swing.material.components.labels._MaterialLabel();
        searchField = new com.jhw.swing.material.components.searchfield._MaterialSearchField();
        panelOptions = new com.jhw.swing.material.components.container.panels._PanelTransparent();
        buttonAdd = new com.jhw.swing.material.components.button.prepared._buttonAddEdit();
        panelOptionsExtra = new com.jhw.swing.material.components.container.panels._PanelTransparent();
        table = new com.jhw.swing.material.components.table._MaterialTableByPage();

        labelHeader.setForeground(new java.awt.Color(0, 0, 0));
        labelHeader.setText("Operaciones");
        labelHeader.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N

        buttonAdd.setText("Nuevo");

        panelOptionsExtra.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout panelOptionsLayout = new javax.swing.GroupLayout(panelOptions);
        panelOptions.setLayout(panelOptionsLayout);
        panelOptionsLayout.setHorizontalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOptionsLayout.createSequentialGroup()
                .addComponent(panelOptionsExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOptionsLayout.setVerticalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOptionsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOptionsExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.button.prepared._buttonAddEdit buttonAdd;
    private com.jhw.swing.material.components.labels._MaterialLabel labelHeader;
    private com.jhw.swing.material.components.container.panels._PanelTransparent panelOptions;
    private com.jhw.swing.material.components.container.panels._PanelTransparent panelOptionsExtra;
    private com.jhw.swing.material.components.searchfield._MaterialSearchField searchField;
    private com.jhw.swing.material.components.table._MaterialTableByPage table;
    // End of variables declaration//GEN-END:variables

    public void setHeaderText(String text) {
        this.labelHeader.setText(text);
    }

    public void addButtonNuevoActionListener(ActionListener action) {
        buttonAdd.addActionListener(action);
    }

    public void addTableDoubleClickAction(MouseAdapter action) {
        table.addMouseListener(action);
    }

    private void addListeners() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoActionListener();
            }
        });

        table.getJTable().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTableMouseDoubleClicked(evt);
            }
        });

        searchField.setSearchActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setCollection(new ArrayList<>(list));
            }
        });

        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onTableKeyTyped(evt);
            }
        });
    }

    private void onTableKeyTyped(KeyEvent evt) {
        searchField.clear(evt);
    }

    public void setSearchFieldVisibile(boolean vis) {
        searchField.setVisible(vis);
    }

    protected abstract void buttonNuevoActionListener();

    protected void tableDoubleCickMouseListener(T obj) {
        editAction(obj);
    }

    public abstract Object[] getRowObject(T obj);

    protected abstract T deleteAction(T obj);

    protected abstract void editAction(T obj);

    protected abstract void viewAction(T obj);

    private void deleteActionInternal() {
        try {
            T before = getSelectedElement();
            if (JOP.confirmDelete(before)) {
                T after = deleteAction(before);
                if (after != null) {
                    TOAST.makeNotificationDelete(after);
                    update();
                }
            }
        } catch (Exception e) {
        }
    }

    public void setColumns(Column[] arr) {
        Column columnsReal[] = new Column[arr.length + 2];
        columnsReal[0] = Column.builder().name(modelColumnName).build();
        columnsReal[columnsReal.length - 1] = Column.builder().name(actionsColumnName).editable(true).build();

        for (int i = 0; i < arr.length; i++) {
            columnsReal[i + 1] = arr[i];
        }

        String columnNames[] = new String[arr.length + 2];
        columnNames[0] = modelColumnName;
        columnNames[columnNames.length - 1] = actionsColumnName;
        for (int i = 0; i < arr.length; i++) {
            columnNames[i + 1] = arr[i].getColumnName();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(
                columnNames, 0
        ) {
            Column array[] = columnsReal;

            @Override
            public Class getColumnClass(int columnIndex) {
                return array[columnIndex].getColumnsClass();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return array[columnIndex].isEditable();
            }
        });

        table.getColumn(modelColumnName).setMinWidth(0);
        table.getColumn(modelColumnName).setPreferredWidth(0);
        table.getColumn(modelColumnName).setMaxWidth(0);

        setActionColumnVisivility(true);

        for (int i = 0; i < arr.length; i++) {
            table.getColumnModel().getColumn(i + 1).setPreferredWidth(arr[i].getPreferedWidth());
        }
        configureTable();
    }

    public T getSelectedElement() {
        int row = table.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return (T) table.getValueAt(row, 0);
    }

    private void onTableMouseDoubleClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {//double click en la fila
            tableDoubleCickMouseListener(getSelectedElement());
        }
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (labelHeader != null) {//este if tiene que estar porque se llama al background en el super sin inicializar los componentes y la primera vel el label es null y lanza NullPointerException
            this.labelHeader.setForeground(getForeground());
        }
    }

    public void clearTable() {
        DefaultTableModel model = table.getModel();
        model.setRowCount(0);
    }

    public void setCollection(List<T> list) {
        this.list.clear();
        addCollection(list);
    }

    public void addCollection(List<T> list) {
        this.list.addAll(list);
        table.clear();
        for (int i = 0; i < this.list.size(); i++) {
            addRow(this.list.get(i));
        }
    }

    public void addObject(T object) {
        this.list.add(object);
        addRow(object);
    }

    public void removeRow(int row) {
        table.removeRow(row);
    }

    private void addRow(T object) {
        if (contain(getObjectString(object), searchField.getText())) {
            table.addRow(getObjectRow(object));
        }
    }

    private Object[] getObjectRow(T object) {
        Object obj[] = getRowObject(object);
        Object row[] = new Object[obj.length + 2];
        row[0] = object;
        row[row.length - 1] = builder.build();
        System.arraycopy(obj, 0, row, 1, obj.length);
        return row;
    }

    private String getObjectString(T object) {
        Object[] row = getObjectRow(object);
        String resp = "";
        /*for (int i = 0; i < row.length - 1; i++) {
         resp += " " + String.valueOf(row[i]);
         }*/
        for (Object obj : row) {
            resp += " " + String.valueOf(obj);
        }
        return resp;
    }

    private boolean contain(String text, String key) {
        //return text.toLowerCase().contains(key.toLowerCase());
        if (key.isEmpty()) {
            return true;
        }
        StringTokenizer st = new StringTokenizer(key, "+");
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            if (!KMP.contain(text, tok)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.modelColumnName);
        hash = 47 * hash + Objects.hashCode(this.buttonAdd);
        hash = 47 * hash + Objects.hashCode(this.labelHeader);
        hash = 47 * hash + Objects.hashCode(this.table);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final _MaterialPanelDetail<?> other = (_MaterialPanelDetail<?>) obj;
        if (!Objects.equals(this.modelColumnName, other.modelColumnName)) {
            return false;
        }
        if (!Objects.equals(this.buttonAdd, other.buttonAdd)) {
            return false;
        }
        if (!Objects.equals(this.labelHeader, other.labelHeader)) {
            return false;
        }
        /*if (!Objects.equals(this.scrollPane, other.scrollPane)) {
         return false;
         }*/
        if (!Objects.equals(this.table, other.table)) {
            return false;
        }
        return true;
    }

    private void configureTable() {
        ComponentCellRender action = new ComponentCellRender();
        table.getTable().getColumn(actionsColumnName).setCellRenderer(action);
        table.getTable().getColumn(actionsColumnName).setCellEditor(new ComponentCellEditor(action));

        table.getTable().getColumn(actionsColumnName).setHeaderRenderer(new HeaderCellRender());
        createBuilder();
    }

    private void createBuilder() {
        builder.deleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteActionInternal();
            }
        });
        builder.editListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAction(getSelectedElement());
            }
        });
        builder.viewListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAction(getSelectedElement());
            }
        });
        //builder.buttonsVisibility(true, true, true);//por defecto vienen true
    }
    /*private boolean contain(String key, String text) {
     if (key.trim().isEmpty()) {
     return true;
     }
     StringTokenizer st = new StringTokenizer(key, " ");
     while (st.hasMoreTokens()) {
     String tok = st.nextToken();
     if (text.toLowerCase().contains(tok.toLowerCase())) {
     return true;
     }
     }
     return false;
     }*/

    public void setActionColumnVisivility(boolean b) {
        int size = b ? table.getRowHeight() : 0;
        int width = builder.getComponents() * size;
        table.getColumn(actionsColumnName).setMinWidth(width);
        table.getColumn(actionsColumnName).setPreferredWidth(width);
        table.getColumn(actionsColumnName).setMaxWidth(width);
    }

    public void setActionColumnButtonsVisivility(boolean delete, boolean edit, boolean view) {
        builder.buttonsVisibility(delete, edit, view);
        update();
        setActionColumnVisivility(true);
    }

    public void addOptionElement(Component element) {
        addOptionElement(element, panelOptionsExtra.getComponentCount());
    }

    public void addOptionElement(Component element, int index) {
        int heigth = (int) panelOptionsExtra.getSize().getHeight();
        int width = heigth * panelOptionsExtra.getComponentCount() + 1;
        panelOptionsExtra.setSize(width, heigth);
        panelOptionsExtra.add(element);
    }

    public void setOptionPanelVisibility(boolean visible) {
        buttonAdd.setVisible(visible);
        panelOptionsExtra.setVisible(visible);
    }

    private void personalizationInner() {
        this.labelHeader.setBackground(this.getBackground());
        table.getScrollPane().getViewport().setOpaque(false);
        table.getScrollPane().getViewport().setBackground(MaterialColors.TRANSPARENT);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        buttonAdd.setEnabled(enabled);
        for (Component component : panelOptionsExtra.getComponents()) {
            component.setEnabled(enabled);
        }
        searchField.setEnabled(enabled);
        table.setEnabled(enabled);
        this.labelHeader.setEnabled(enabled);
    }

    public void addActionExtra(_MaterialIconButtonTranspRect c) {
        builder.extra(c);
        setActionColumnVisivility(true);
    }

    public JTable getJTable() {
        return table.getJTable();
    }
}
