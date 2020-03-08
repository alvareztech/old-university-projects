package a3d;

import org.netbeans.saas.twitter.TwitterWhatAreYouDoingService;
import org.netbeans.saas.RestResponse;
import twitter.whatareyoudoingservice.twitterresponse.StatusType;

/**
 *
 * @author Daniel
 */
public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonTweet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoTweet = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonTweet.setText("Tweet");
        botonTweet.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTweetActionPerformed(evt);
            }
        });

        textoTweet.setColumns(20);
        textoTweet.setRows(2);
        jScrollPane1.setViewportView(textoTweet);

        jLabel1.setText("imagen");
        jLabel1.setMaximumSize(new java.awt.Dimension(48, 48));
        jLabel1.setMinimumSize(new java.awt.Dimension(48, 48));
        jLabel1.setPreferredSize(new java.awt.Dimension(48, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(botonTweet).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(botonTweet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)).addGap(241, 241, 241)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTweetActionPerformed
        iniciarInformacionUsuario();
    }//GEN-LAST:event_botonTweetActionPerformed

    private void iniciarInformacionUsuario() {
        try {
            String since = null;
            String sinceId = null;
            String page = null;
            String count = "1";
            String format = "xml";

            RestResponse result = TwitterWhatAreYouDoingService.getUserTimeline(since, sinceId, page, count, format);
            if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.Statuses) {
                twitter.whatareyoudoingservice.twitterresponse.Statuses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class);
                StatusType estatus = resultObj.getStatus().get(0);
                textoTweet.setText(estatus.getText());
            } else if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.NilClasses) {
                twitter.whatareyoudoingservice.twitterresponse.NilClasses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class);
            }
            //TODO - Uncomment the print Statement below to print result.
            //System.out.println("The SaasService returned: "+result.getDataAsString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonTweet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoTweet;
    // End of variables declaration//GEN-END:variables
}
