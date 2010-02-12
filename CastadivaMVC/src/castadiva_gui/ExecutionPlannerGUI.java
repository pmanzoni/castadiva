/*
 * executionPlannerGUI.java
 *
 * Created on 13 de marzo de 2009, 11:10
 */
package castadiva_gui;

import castadiva.*;
import castadiva.TableModels.ExecutionPlannerTableModel;
import castadiva.TrafficRecords.ExecutionRecord;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author  nacho
 */
public class ExecutionPlannerGUI extends javax.swing.JFrame {
    CastadivaModel model;
    Vector<String> simulaciones = new Vector<String>();
    public Vector<String>paths = new Vector<String>();
    int numSim = 0;
    public int scenario = 0;
    ExecutionPlannerTableModel tableModel = new ExecutionPlannerTableModel();

    /** Creates new form executionPlannerGUI */
    public ExecutionPlannerGUI(CastadivaModel model) {
        initComponents();

        setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - (int) (this.getWidth() / 2),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - (int) (this.getHeight() / 2));
        this.model = model;
        
        JTplanner.setModel(tableModel);


        JViewport scroll = (JViewport) JTplanner.getParent();
        int width = scroll.getWidth();
        int columnWidth = 0;
        TableColumnModel modeloColumna = JTplanner.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < JTplanner.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch (i) {
                case 0:
                    columnWidth = (20 * width) / 100;
                    break;
                case 1:
                    columnWidth = (70 * width) / 100;
                    break;
                case 2:
                    columnWidth = (10 * width) / 100;
                    break;
            }
            columnaTabla.setPreferredWidth(columnWidth);
        }
    }

    public void newRow(String name) {                
        ExecutionRecord exe = new ExecutionRecord();

        exe.setSourceFolder(name);
        exe.setResultsFolder(name);
        exe.setRuns(1);
        
        tableModel.addRow(exe);
        updateTable();
    }
    
    public int getNumberSelectedRow() {
            return JTplanner.getSelectedRow();
    }

    public int getNumberOfRows() {
         return JTplanner.getRowCount();
    }
    public int getTotalScenarios() {
         return JTplanner.getRowCount();
    }
    
    public int getRuns(int n) {
         String temp = tableModel.getValueAt(n, 2).toString();
         Integer i = Integer.parseInt(temp);
         return i;
    }
    
    public String getSimulationName() {
            if(this.getNumberSelectedRow() != -1) {
                return JTplanner.getValueAt(this.getNumberSelectedRow(), 0).toString();
            }
            else return "";
    }
    
    public String getSimulationName(int n) {
         String temp = tableModel.getValueAt(n, 0).toString();
         return temp;
    }
    
    public String getTargetFolder(int n) {
            String target = "";
            target = tableModel.getValueAt(n, 1).toString();
            return target;
    }
    
    public ExecutionRecord getRow(int row) {
        return tableModel.getRow(row);
    }

    public void deleteRow(int row) {
        tableModel.delRow(row);
        updateTable();
    }

     public void updateTable() {
        tableModel.fireTableDataChanged();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTplanner = new javax.swing.JTable();
        ButtonsPanel = new javax.swing.JPanel();
        JBedit = new javax.swing.JButton();
        JBdelete = new javax.swing.JButton();
        JBgenerate = new javax.swing.JButton();
        JBclose = new javax.swing.JButton();
        JBimportcity = new javax.swing.JButton();
        JBimportsc = new javax.swing.JButton();
        JBloadsim = new javax.swing.JButton();
        JBnewsim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CASTADIVA - Execution Planner");

        JTplanner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Target Folder", "Runs"
            }
        ));
        jScrollPane1.setViewportView(JTplanner);

        JBedit.setText("Edit Simulation");

        JBdelete.setText("Delete Simulation");

        JBgenerate.setText("Generate Simulations");

        JBclose.setText("Close");

        JBimportcity.setText("Import CityMob Scenario");

        JBimportsc.setText("Import NS-2 Scenario");

        JBloadsim.setText("Load Scenario");

        JBnewsim.setText("New Simulation");

        javax.swing.GroupLayout ButtonsPanelLayout = new javax.swing.GroupLayout(ButtonsPanel);
        ButtonsPanel.setLayout(ButtonsPanelLayout);
        ButtonsPanelLayout.setHorizontalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBnewsim, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBloadsim, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBimportsc, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBimportcity, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBclose, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBgenerate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBdelete, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(JBedit, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        ButtonsPanelLayout.setVerticalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(JBnewsim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBloadsim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBimportsc)
                .addGap(16, 16, 16)
                .addComponent(JBimportcity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(JBedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBdelete)
                .addGap(136, 136, 136)
                .addComponent(JBgenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBclose)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addNewSimulationListener(ActionListener a1) {
        JBnewsim.addActionListener(a1);
    }
    
    public void addEditSimulationListener(ActionListener a1) {
        JBedit.addActionListener(a1);
    }
        
    public void addCloseButtonListener(ActionListener al) {
        JBclose.addActionListener(al);
    }
    
    public void addDeleteButtonListener(ActionListener a1) {
        JBdelete.addActionListener(a1);
    }

    public void addLoadScenarioButtonListener(ActionListener a1) {
        JBloadsim.addActionListener(a1);
    }

    public void addImportScenarioButtonListener(ActionListener a1) {
        JBimportsc.addActionListener(a1);
    }

    public void addImportCityMobScenarioButtonListener(ActionListener a1) {
        JBimportcity.addActionListener(a1);
    }

    public void addGenerateSimulationButtonListener(ActionListener a1) {
        JBgenerate.addActionListener(a1);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JButton JBclose;
    private javax.swing.JButton JBdelete;
    private javax.swing.JButton JBedit;
    private javax.swing.JButton JBgenerate;
    private javax.swing.JButton JBimportcity;
    private javax.swing.JButton JBimportsc;
    private javax.swing.JButton JBloadsim;
    private javax.swing.JButton JBnewsim;
    private javax.swing.JTable JTplanner;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}