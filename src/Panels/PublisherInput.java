/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

/**
 *
 * @author tictoc
 */
public class PublisherInput extends javax.swing.JPanel {

    /**
     * Creates new form PublisherInput
     */
    public PublisherInput() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_PublisherName = new javax.swing.JTextField();
        txt_PublisherAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_PublisherPhone = new javax.swing.JTextField();

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("Phone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_PublisherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_PublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_PublisherPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_PublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_PublisherPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_PublisherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_PublisherAddress;
    private javax.swing.JTextField txt_PublisherName;
    private javax.swing.JTextField txt_PublisherPhone;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txt_PublisherAddress
     */
    public javax.swing.JTextField getTxt_PublisherAddress() {
        return txt_PublisherAddress;
    }

    /**
     * @param txt_PublisherAddress the txt_PublisherAddress to set
     */
    public void setTxt_PublisherAddress(javax.swing.JTextField txt_PublisherAddress) {
        this.txt_PublisherAddress = txt_PublisherAddress;
    }

    /**
     * @return the txt_PublisherName
     */
    public javax.swing.JTextField getTxt_PublisherName() {
        return txt_PublisherName;
    }

    /**
     * @param txt_PublisherName the txt_PublisherName to set
     */
    public void setTxt_PublisherName(javax.swing.JTextField txt_PublisherName) {
        this.txt_PublisherName = txt_PublisherName;
    }

    /**
     * @return the txt_PublisherPhone
     */
    public javax.swing.JTextField getTxt_PublisherPhone() {
        return txt_PublisherPhone;
    }

    /**
     * @param txt_PublisherPhone the txt_PublisherPhone to set
     */
    public void setTxt_PublisherPhone(javax.swing.JTextField txt_PublisherPhone) {
        this.txt_PublisherPhone = txt_PublisherPhone;
    }
}
