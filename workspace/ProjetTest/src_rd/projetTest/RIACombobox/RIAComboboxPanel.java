package projetTest.RIACombobox;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogBorderPanel;
import ch.ivyteam.ivy.richdialog.widgets.components.RComboBox;

/**
 * <p>RIAComboboxPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class RIAComboboxPanel extends RichDialogBorderPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RComboBox ComboBox = null;
  
  /**
   * Create a new instance of RIAComboboxPanel
   */
  public RIAComboboxPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes RIAComboboxPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(549,426));
        this.add(getComboBox(), com.ulcjava.base.application.ULCBorderLayoutPane.NORTH);
  }

/**
 * This method initializes ComboBox	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RComboBox	
 */
private RComboBox getComboBox() {
	if (ComboBox == null) {
		ComboBox = new RComboBox();
		ComboBox.setName("ComboBox");
		ComboBox.setModelConfiguration("{/result \"\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
	}
	return ComboBox;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"