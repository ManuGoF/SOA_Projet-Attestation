package projetTest.RIAtest;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogGridBagPanel;
import ch.ivyteam.ivy.richdialog.widgets.components.RButton;

/**
 * <p>RIAtestPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class RIAtestPanel extends RichDialogGridBagPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RButton Button = null;
  
  /**
   * Create a new instance of RIAtestPanel
   */
  public RIAtestPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes RIAtestPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(841,416));
        this.add(getButton(), new com.ulcjava.base.application.GridBagConstraints(0, 0, 1, 1, -1, -1, com.ulcjava.base.application.GridBagConstraints.CENTER, com.ulcjava.base.application.GridBagConstraints.NONE, new com.ulcjava.base.application.util.Insets(0,0,0,0), 0, 0));
  }

/**
 * This method initializes Button	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getButton() {
	if (Button == null) {
		Button = new RButton();
		Button.setText("Button");
		Button.setName("Button");
	}
	return Button;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"