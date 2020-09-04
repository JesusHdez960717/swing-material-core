package com.jhw.swing.material.components.table;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.EventObject;
import javax.accessibility.AccessibleContext;
import javax.print.PrintService;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTable extends _PanelTransparent {

    public _MaterialTable() {
        initComponents();
        addListeners();
    }

    private void initComponents() {

        scrollPane = new com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPane.setViewportView(table);

        this.setLayout(new BorderLayout());
        this.add(scrollPane);
        this.setPreferredSize(new Dimension(150, 200));

    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration                   

    public _MaterialScrollPaneCore getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(_MaterialScrollPaneCore scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) table.getModel();
    }

    public void setModel(TableModel dataModel) {
        table.setModel(dataModel);
    }

    public TableColumn getColumn(Object identifier) {
        return table.getColumn(identifier);
    }

    public TableColumnModel getColumnModel() {
        return table.getColumnModel();
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Object getValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }

    public void clear() {
        getModel().setRowCount(0);
    }

    public void addRow(Object[] row) {
        getModel().addRow(row);
    }

    public void removeRow(int row) {
        getModel().removeRow(row);
    }

    public int getRowHeight() {
        return table.getRowHeight();
    }

    public int getRowCount() {
        return table.getRowCount();
    }

    private void addListeners() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleRowClick(e);
            }
        });
    }

    private void handleRowClick(MouseEvent e) {
        int clickedRow = table.rowAtPoint(e.getPoint());
        if (e.getButton() == MouseEvent.BUTTON3) {//esto es solo para el click derecho, sino no lo proceso
            if (clickedRow >= 0 && clickedRow < table.getRowCount()) {
                table.setRowSelectionInterval(clickedRow, clickedRow);
            } else {
                table.clearSelection();
            }
        }
    }

    //delegate, - los que son en comun
    public static JScrollPane createScrollPaneForTable(JTable aTable) {
        return JTable.createScrollPaneForTable(aTable);
    }

    public void setTableHeader(JTableHeader tableHeader) {
        table.setTableHeader(tableHeader);
    }

    public JTableHeader getTableHeader() {
        return table.getTableHeader();
    }

    public void setRowHeight(int rowHeight) {
        table.setRowHeight(rowHeight);
    }

    public void setRowHeight(int row, int rowHeight) {
        table.setRowHeight(row, rowHeight);
    }

    public int getRowHeight(int row) {
        return table.getRowHeight(row);
    }

    public void setRowMargin(int rowMargin) {
        table.setRowMargin(rowMargin);
    }

    public int getRowMargin() {
        return table.getRowMargin();
    }

    public void setIntercellSpacing(Dimension intercellSpacing) {
        table.setIntercellSpacing(intercellSpacing);
    }

    public Dimension getIntercellSpacing() {
        return table.getIntercellSpacing();
    }

    public void setGridColor(Color gridColor) {
        table.setGridColor(gridColor);
    }

    public Color getGridColor() {
        return table.getGridColor();
    }

    public void setShowGrid(boolean showGrid) {
        table.setShowGrid(showGrid);
    }

    public void setShowHorizontalLines(boolean showHorizontalLines) {
        table.setShowHorizontalLines(showHorizontalLines);
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        table.setShowVerticalLines(showVerticalLines);
    }

    public boolean getShowHorizontalLines() {
        return table.getShowHorizontalLines();
    }

    public boolean getShowVerticalLines() {
        return table.getShowVerticalLines();
    }

    public void setAutoResizeMode(int mode) {
        table.setAutoResizeMode(mode);
    }

    public int getAutoResizeMode() {
        return table.getAutoResizeMode();
    }

    public void setAutoCreateColumnsFromModel(boolean autoCreateColumnsFromModel) {
        table.setAutoCreateColumnsFromModel(autoCreateColumnsFromModel);
    }

    public boolean getAutoCreateColumnsFromModel() {
        return table.getAutoCreateColumnsFromModel();
    }

    public void createDefaultColumnsFromModel() {
        table.createDefaultColumnsFromModel();
    }

    public void setDefaultRenderer(Class<?> columnClass, TableCellRenderer renderer) {
        table.setDefaultRenderer(columnClass, renderer);
    }

    public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
        return table.getDefaultRenderer(columnClass);
    }

    public void setDefaultEditor(Class<?> columnClass, TableCellEditor editor) {
        table.setDefaultEditor(columnClass, editor);
    }

    public TableCellEditor getDefaultEditor(Class<?> columnClass) {
        return table.getDefaultEditor(columnClass);
    }

    public void setDragEnabled(boolean b) {
        table.setDragEnabled(b);
    }

    public boolean getDragEnabled() {
        return table.getDragEnabled();
    }

    public final void setDropMode(DropMode dropMode) {
        table.setDropMode(dropMode);
    }

    public final DropMode getDropMode() {
        return table.getDropMode();
    }

    public final JTable.DropLocation getDropLocation() {
        return table.getDropLocation();
    }

    public void setAutoCreateRowSorter(boolean autoCreateRowSorter) {
        table.setAutoCreateRowSorter(autoCreateRowSorter);
    }

    public boolean getAutoCreateRowSorter() {
        return table.getAutoCreateRowSorter();
    }

    public void setUpdateSelectionOnSort(boolean update) {
        table.setUpdateSelectionOnSort(update);
    }

    public boolean getUpdateSelectionOnSort() {
        return table.getUpdateSelectionOnSort();
    }

    public void setRowSorter(RowSorter<? extends TableModel> sorter) {
        table.setRowSorter(sorter);
    }

    public RowSorter<? extends TableModel> getRowSorter() {
        return table.getRowSorter();
    }

    public void setSelectionMode(int selectionMode) {
        table.setSelectionMode(selectionMode);
    }

    public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
        table.setRowSelectionAllowed(rowSelectionAllowed);
    }

    public boolean getRowSelectionAllowed() {
        return table.getRowSelectionAllowed();
    }

    public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
        table.setColumnSelectionAllowed(columnSelectionAllowed);
    }

    public boolean getColumnSelectionAllowed() {
        return table.getColumnSelectionAllowed();
    }

    public void setCellSelectionEnabled(boolean cellSelectionEnabled) {
        table.setCellSelectionEnabled(cellSelectionEnabled);
    }

    public boolean getCellSelectionEnabled() {
        return table.getCellSelectionEnabled();
    }

    public void selectAll() {
        table.selectAll();
    }

    public void clearSelection() {
        table.clearSelection();
    }

    public void setRowSelectionInterval(int index0, int index1) {
        table.setRowSelectionInterval(index0, index1);
    }

    public void setColumnSelectionInterval(int index0, int index1) {
        table.setColumnSelectionInterval(index0, index1);
    }

    public void addRowSelectionInterval(int index0, int index1) {
        table.addRowSelectionInterval(index0, index1);
    }

    public void addColumnSelectionInterval(int index0, int index1) {
        table.addColumnSelectionInterval(index0, index1);
    }

    public void removeRowSelectionInterval(int index0, int index1) {
        table.removeRowSelectionInterval(index0, index1);
    }

    public void removeColumnSelectionInterval(int index0, int index1) {
        table.removeColumnSelectionInterval(index0, index1);
    }

    public int getSelectedColumn() {
        return table.getSelectedColumn();
    }

    public int[] getSelectedRows() {
        return table.getSelectedRows();
    }

    public int[] getSelectedColumns() {
        return table.getSelectedColumns();
    }

    public int getSelectedRowCount() {
        return table.getSelectedRowCount();
    }

    public int getSelectedColumnCount() {
        return table.getSelectedColumnCount();
    }

    public boolean isRowSelected(int row) {
        return table.isRowSelected(row);
    }

    public boolean isColumnSelected(int column) {
        return table.isColumnSelected(column);
    }

    public boolean isCellSelected(int row, int column) {
        return table.isCellSelected(row, column);
    }

    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
        table.changeSelection(rowIndex, columnIndex, toggle, extend);
    }

    public Color getSelectionForeground() {
        return table.getSelectionForeground();
    }

    public void setSelectionForeground(Color selectionForeground) {
        table.setSelectionForeground(selectionForeground);
    }

    public Color getSelectionBackground() {
        return table.getSelectionBackground();
    }

    public void setSelectionBackground(Color selectionBackground) {
        table.setSelectionBackground(selectionBackground);
    }

    public int convertColumnIndexToModel(int viewColumnIndex) {
        return table.convertColumnIndexToModel(viewColumnIndex);
    }

    public int convertColumnIndexToView(int modelColumnIndex) {
        return table.convertColumnIndexToView(modelColumnIndex);
    }

    public int convertRowIndexToView(int modelRowIndex) {
        return table.convertRowIndexToView(modelRowIndex);
    }

    public int convertRowIndexToModel(int viewRowIndex) {
        return table.convertRowIndexToModel(viewRowIndex);
    }

    public int getColumnCount() {
        return table.getColumnCount();
    }

    public String getColumnName(int column) {
        return table.getColumnName(column);
    }

    public Class<?> getColumnClass(int column) {
        return table.getColumnClass(column);
    }

    public void setValueAt(Object aValue, int row, int column) {
        table.setValueAt(aValue, row, column);
    }

    public boolean isCellEditable(int row, int column) {
        return table.isCellEditable(row, column);
    }

    public void addColumn(TableColumn aColumn) {
        table.addColumn(aColumn);
    }

    public void removeColumn(TableColumn aColumn) {
        table.removeColumn(aColumn);
    }

    public void moveColumn(int column, int targetColumn) {
        table.moveColumn(column, targetColumn);
    }

    public int columnAtPoint(Point point) {
        return table.columnAtPoint(point);
    }

    public int rowAtPoint(Point point) {
        return table.rowAtPoint(point);
    }

    public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
        return table.getCellRect(row, column, includeSpacing);
    }

    public void doLayout() {
        table.doLayout();
    }

    public void sizeColumnsToFit(boolean lastColumnOnly) {
        table.sizeColumnsToFit(lastColumnOnly);
    }

    public void sizeColumnsToFit(int resizingColumn) {
        table.sizeColumnsToFit(resizingColumn);
    }

    public void setSurrendersFocusOnKeystroke(boolean surrendersFocusOnKeystroke) {
        table.setSurrendersFocusOnKeystroke(surrendersFocusOnKeystroke);
    }

    public boolean getSurrendersFocusOnKeystroke() {
        return table.getSurrendersFocusOnKeystroke();
    }

    public boolean editCellAt(int row, int column) {
        return table.editCellAt(row, column);
    }

    public boolean editCellAt(int row, int column, EventObject e) {
        return table.editCellAt(row, column, e);
    }

    public boolean isEditing() {
        return table.isEditing();
    }

    public Component getEditorComponent() {
        return table.getEditorComponent();
    }

    public int getEditingColumn() {
        return table.getEditingColumn();
    }

    public int getEditingRow() {
        return table.getEditingRow();
    }


    public void setUI(TableUI ui) {
        table.setUI(ui);
    }

    public void setSelectionModel(ListSelectionModel newModel) {
        table.setSelectionModel(newModel);
    }

    public ListSelectionModel getSelectionModel() {
        return table.getSelectionModel();
    }

    public void sorterChanged(RowSorterEvent e) {
        table.sorterChanged(e);
    }

    public void tableChanged(TableModelEvent e) {
        table.tableChanged(e);
    }

    public void columnAdded(TableColumnModelEvent e) {
        table.columnAdded(e);
    }

    public void columnRemoved(TableColumnModelEvent e) {
        table.columnRemoved(e);
    }

    public void columnMoved(TableColumnModelEvent e) {
        table.columnMoved(e);
    }

    public void columnMarginChanged(ChangeEvent e) {
        table.columnMarginChanged(e);
    }

    public void columnSelectionChanged(ListSelectionEvent e) {
        table.columnSelectionChanged(e);
    }

    public void valueChanged(ListSelectionEvent e) {
        table.valueChanged(e);
    }

    public void editingStopped(ChangeEvent e) {
        table.editingStopped(e);
    }

    public void editingCanceled(ChangeEvent e) {
        table.editingCanceled(e);
    }

    public void setPreferredScrollableViewportSize(Dimension size) {
        table.setPreferredScrollableViewportSize(size);
    }

    public Dimension getPreferredScrollableViewportSize() {
        return table.getPreferredScrollableViewportSize();
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return table.getScrollableUnitIncrement(visibleRect, orientation, direction);
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return table.getScrollableBlockIncrement(visibleRect, orientation, direction);
    }

    public boolean getScrollableTracksViewportWidth() {
        return table.getScrollableTracksViewportWidth();
    }

    public boolean getScrollableTracksViewportHeight() {
        return table.getScrollableTracksViewportHeight();
    }

    public void setFillsViewportHeight(boolean fillsViewportHeight) {
        table.setFillsViewportHeight(fillsViewportHeight);
    }

    public boolean getFillsViewportHeight() {
        return table.getFillsViewportHeight();
    }

    public TableCellEditor getCellEditor() {
        return table.getCellEditor();
    }

    public void setCellEditor(TableCellEditor anEditor) {
        table.setCellEditor(anEditor);
    }

    public void setEditingColumn(int aColumn) {
        table.setEditingColumn(aColumn);
    }

    public void setEditingRow(int aRow) {
        table.setEditingRow(aRow);
    }

    public TableCellRenderer getCellRenderer(int row, int column) {
        return table.getCellRenderer(row, column);
    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        return table.prepareRenderer(renderer, row, column);
    }

    public TableCellEditor getCellEditor(int row, int column) {
        return table.getCellEditor(row, column);
    }

    public Component prepareEditor(TableCellEditor editor, int row, int column) {
        return table.prepareEditor(editor, row, column);
    }

    public void removeEditor() {
        table.removeEditor();
    }

    public boolean print() throws PrinterException {
        return table.print();
    }

    public boolean print(JTable.PrintMode printMode) throws PrinterException {
        return table.print(printMode);
    }

    public boolean print(JTable.PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) throws PrinterException {
        return table.print(printMode, headerFormat, footerFormat);
    }

    public boolean print(JTable.PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat, boolean showPrintDialog, PrintRequestAttributeSet attr, boolean interactive) throws PrinterException, HeadlessException {
        return table.print(printMode, headerFormat, footerFormat, showPrintDialog, attr, interactive);
    }

    public boolean print(JTable.PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat, boolean showPrintDialog, PrintRequestAttributeSet attr, boolean interactive, PrintService service) throws PrinterException, HeadlessException {
        return table.print(printMode, headerFormat, footerFormat, showPrintDialog, attr, interactive, service);
    }

    public Printable getPrintable(JTable.PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
        return table.getPrintable(printMode, headerFormat, footerFormat);
    }


}
