/**
 * 
 */
package net.sf.jtreemap.swing.provider;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

class AboutAction extends AbstractAction {
    private static final long serialVersionUID = -8559400862920393294L;

    /**
     * Constructor
     * 
     */
    public AboutAction() {
        super("About");
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(null, "<html>JXTreeMap powered by <a href=\"http://www.ObjectLab.co.uk\">ObjectLab.co.uk</a></html>");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.Action#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}