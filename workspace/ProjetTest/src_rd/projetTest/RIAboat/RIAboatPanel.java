package projetTest.RIAboat;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogBorderPanel;
import ch.ivyteam.ivy.richdialog.widgets.components.RTextArea;
import ch.ivyteam.ivy.richdialog.widgets.components.RTextField;
import ch.ivyteam.ivy.richdialog.widgets.components.RButton;

/**
 * <p>RIAboatPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class RIAboatPanel extends RichDialogBorderPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RTextField TextField = null;
private RTextField TextField1 = null;
private RButton Button = null;
  
  /**
   * Create a new instance of RIAboatPanel
   */
  public RIAboatPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes RIAboatPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(703,397));
        this.add(getTextField(), com.ulcjava.base.application.ULCBorderLayoutPane.SOUTH);
        this.add(getTextField1(), com.ulcjava.base.application.ULCBorderLayoutPane.NORTH);
        this.add(getButton(), com.ulcjava.base.application.ULCBorderLayoutPane.EAST);
  }

/**
 * This method initializes TextField	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getTextField() {
	if (TextField == null) {
		TextField = new RTextField();
		TextField.setText("TextField");
		TextField.setName("TextField");
	}
	return TextField;
}

/**
 * This method initializes TextField1	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getTextField1() {
	if (TextField1 == null) {
		TextField1 = new RTextField();
		TextField1.setText("TextField1");
		TextField1.setName("TextField1");
	}
	return TextField1;
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