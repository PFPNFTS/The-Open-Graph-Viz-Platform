/*
Copyright 2008-2010 Gephi
Authors : Eduardo Ramos <eduramiba@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */

package org.gephi.ui.components;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * UI for showing a JFreeChart with the advantages of ChartPanel and also allows to resize the chart up to a maximum dimension.
 *
 * @author Eduardo Ramos
 */
public class JFreeChartDialog extends javax.swing.JDialog {

    private static final int MAX_DIMENSION = 3000;
    private ChartPanel chartPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton resetButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton zoomInButton;
    private javax.swing.JButton zoomOutButton;
    // End of variables declaration//GEN-END:variables

    public JFreeChartDialog(java.awt.Frame parent, String title, JFreeChart chart, int initialWidth,
                            int initialHeight) {
        super(parent, false);
        setTitle(title);
        initialize(chart);
        setSize(initialWidth, initialHeight);
        setLocationRelativeTo(parent);
    }

    public JFreeChartDialog(java.awt.Frame parent, JFreeChart chart) {
        super(parent, false);
        initialize(chart);
        setLocationRelativeTo(parent);
    }

    private void initialize(JFreeChart chart) {
        initComponents();
        if (chart == null) {
            throw new IllegalArgumentException("Chart panel can't be null");
        }
        this.chartPanel = new ChartPanel(chart, true);

        scroll.setViewportView(chartPanel);
        adaptChartPanelSizeToScrollSize();
        scroll.revalidate();
        scroll.repaint();
        setVisible(true);
    }

    private void adaptChartPanelSizeToScrollSize() {
        chartPanel.setPreferredSize(new Dimension(0, 0));//Let the chartPanel adjust to scroll pane current size.
        chartPanel.revalidate();
        chartPanel.repaint();
    }

    private void applyZoom(float multiplier) {
        int width = (int) (chartPanel.getSize().width * multiplier);
        int heigth = (int) (chartPanel.getSize().height * multiplier);

        width = width > MAX_DIMENSION ? MAX_DIMENSION : width;
        heigth = heigth > MAX_DIMENSION ? MAX_DIMENSION : heigth;

        chartPanel.setPreferredSize(new Dimension(width, heigth));
        chartPanel.revalidate();
        chartPanel.repaint();
    }

    public JFreeChart getChart() {
        return chartPanel.getChart();
    }

    public void setChart(JFreeChart chart) {
        if (chart == null) {
            throw new IllegalArgumentException("Chart panel can't be null");
        }
        chartPanel.setChart(chart);
    }

    public Dimension getChartSize() {
        return chartPanel.getSize();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        closeButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        zoomOutButton = new javax.swing.JButton();
        zoomInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 200));

        scroll.setMinimumSize(new java.awt.Dimension(10, 10));
        scroll.setPreferredSize(new java.awt.Dimension(10, 10));

        closeButton.setText(org.openide.util.NbBundle
            .getMessage(JFreeChartDialog.class, "JFreeChartDialog.closeButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        resetButton.setIcon(new javax.swing.ImageIcon(
            getClass().getResource("/org/gephi/ui/components/resources/magnifier-history.png"))); // NOI18N
        resetButton.setText(org.openide.util.NbBundle
            .getMessage(JFreeChartDialog.class, "JFreeChartDialog.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        zoomOutButton.setIcon(new javax.swing.ImageIcon(
            getClass().getResource("/org/gephi/ui/components/resources/magnifier--minus.png"))); // NOI18N
        zoomOutButton.setText(org.openide.util.NbBundle
            .getMessage(JFreeChartDialog.class, "JFreeChartDialog.zoomOutButton.text")); // NOI18N
        zoomOutButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutButtonActionPerformed(evt);
            }
        });

        zoomInButton.setIcon(new javax.swing.ImageIcon(
            getClass().getResource("/org/gephi/ui/components/resources/magnifier--plus.png"))); // NOI18N
        zoomInButton.setText(org.openide.util.NbBundle
            .getMessage(JFreeChartDialog.class, "JFreeChartDialog.zoomInButton.text")); // NOI18N
        zoomInButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(zoomOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(zoomInButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetButton))
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resetButton)
                        .addComponent(zoomInButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zoomOutButton)
                        .addComponent(closeButton))
                    .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(
        java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void resetButtonActionPerformed(
        java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        adaptChartPanelSizeToScrollSize();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void zoomInButtonActionPerformed(
        java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInButtonActionPerformed
        applyZoom(1.5f);
    }//GEN-LAST:event_zoomInButtonActionPerformed

    private void zoomOutButtonActionPerformed(
        java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutButtonActionPerformed
        applyZoom(0.5f);
    }//GEN-LAST:event_zoomOutButtonActionPerformed
}
