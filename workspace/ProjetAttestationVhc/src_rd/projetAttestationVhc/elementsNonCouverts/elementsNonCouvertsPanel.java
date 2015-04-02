package projetAttestationVhc.elementsNonCouverts;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogBorderPanel;
import ch.ivyteam.ivy.richdialog.widgets.containers.RCardPane;
import ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane;
import ch.ivyteam.ivy.richdialog.widgets.components.RTable;
import ch.ivyteam.ivy.richdialog.widgets.components.RList;
import ch.ivyteam.ivy.richdialog.widgets.components.RButton;
import ch.ivyteam.ivy.richdialog.widgets.components.RTextArea;

/**
 * <p>elementsNonCouvertsPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class elementsNonCouvertsPanel extends RichDialogBorderPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RCardPane CardPane = null;
private RCardPane CardPane1 = null;
private RCardPane CardPane2 = null;
private RGridLayoutPane GridLayoutPane = null;
private RList List = null;
private RButton Button = null;
private RButton Button1 = null;
/**
   * Create a new instance of elementsNonCouvertsPanel
   */
  public elementsNonCouvertsPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes elementsNonCouvertsPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(490,288));
        this.add(getGridLayoutPane(), com.ulcjava.base.application.ULCBorderLayoutPane.EAST);
        this.add(getCardPane(), com.ulcjava.base.application.ULCBorderLayoutPane.NORTH);
  }

/**
 * This method initializes CardPane	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RCardPane	
 */
private RCardPane getCardPane() {
	if (CardPane == null) {
		CardPane = new RCardPane();
		CardPane.setName("CardPane");
		CardPane.addCard("List", getList());
	}
	return CardPane;
}

/**
 * This method initializes CardPane1	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RCardPane	
 */
private RCardPane getCardPane1() {
	if (CardPane1 == null) {
		CardPane1 = new RCardPane();
		CardPane1.setName("CardPane1");
		CardPane1.addCard("Button", getButton1());
	}
	return CardPane1;
}

/**
 * This method initializes CardPane2	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RCardPane	
 */
private RCardPane getCardPane2() {
	if (CardPane2 == null) {
		CardPane2 = new RCardPane();
		CardPane2.setName("CardPane2");
		CardPane2.setPreferredSize(new com.ulcjava.base.application.util.Dimension(245,20));
		CardPane2.addCard("Button", getButton());
	}
	return CardPane2;
}

/**
 * This method initializes GridLayoutPane	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getGridLayoutPane() {
	if (GridLayoutPane == null) {
		GridLayoutPane = new RGridLayoutPane();
		GridLayoutPane.setName("GridLayoutPane");
		GridLayoutPane.add(getCardPane2());
		GridLayoutPane.add(getCardPane1());
	}
	return GridLayoutPane;
}

/**
 * This method initializes List	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RList	
 */
private RList getList() {
	if (List == null) {
		List = new RList();
		List.setName("List");
		List.setPreferredSize(new com.ulcjava.base.application.util.Dimension(0,250));
	}
	return List;
}

/**
 * This method initializes Button	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getButton() {
	if (Button == null) {
		Button = new RButton();
		Button.setText("Non couvert");
		Button.setName("Button");
	}
	return Button;
}

/**
 * This method initializes Button1	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getButton1() {
	if (Button1 == null) {
		Button1 = new RButton();
		Button1.setText("Couvert");
		Button1.setName("Button1");
	}
	return Button1;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"