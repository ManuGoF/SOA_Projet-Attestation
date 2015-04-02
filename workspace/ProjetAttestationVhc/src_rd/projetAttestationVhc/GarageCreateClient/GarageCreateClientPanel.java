package projetAttestationVhc.GarageCreateClient;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogBorderPanel;
import ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane;
import ch.ivyteam.ivy.richdialog.widgets.components.RTextField;
import ch.ivyteam.ivy.richdialog.widgets.components.RProgressBar;
import ch.ivyteam.ivy.richdialog.widgets.menus.RMenuBar;
import ch.ivyteam.ivy.richdialog.widgets.components.RList;
import com.ulcjava.base.application.util.Color;
import com.ulcjava.base.application.ULCTextField;
import com.ulcjava.base.application.util.ComponentOrientation;
import ch.ivyteam.ivy.richdialog.widgets.components.RButton;
import ch.ivyteam.ivy.richdialog.widgets.containers.RSplitPane;
import ch.ivyteam.ivy.richdialog.widgets.menus.RMenu;
import ch.ivyteam.ivy.richdialog.widgets.components.RHtmlPane;
import ch.ivyteam.ivy.richdialog.widgets.components.RLabel;
import com.ulcjava.base.application.ULCLabel;
import ch.ivyteam.ivy.richdialog.widgets.components.RComboBox;

/**
 * <p>GarageCreateClientPanel is a rich dialog panel implementation.
 *
 * <p>Please note that a rich dialog panel is not an instance of a Swing 
 * container, but of an ULCContainer. As such it can not be run 
 * or instantiated outside the ULC framework.
 */
@SuppressWarnings("all")
public class GarageCreateClientPanel extends RichDialogBorderPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RMenuBar MenuBar = null;
private RMenuBar Footer = null;
private RGridLayoutPane Right = null;
private RGridLayoutPane Left = null;
private RGridLayoutPane Center = null;
private RGridLayoutPane CertificateGrille = null;
private RGridLayoutPane CarGrille = null;
private RGridLayoutPane ClientGrille = null;
private RGridLayoutPane WorkerGrille = null;
private RLabel Certificates = null;
private RLabel Cars = null;
private RLabel Clients = null;
private RLabel Workers = null;
private RTextField Serial_number = null;
private RTextField Brand = null;
private RTextField Model = null;
private RTextField Type = null;
private RTextField Color = null;
private RTextField Price = null;
private RList ListClient = null;
private RButton CreateCar = null;
private RTextField LastnameClient = null;
private RTextField FirstnameClient = null;
private RTextField Email = null;
private RTextField Birthday = null;
private RTextField Licence_type = null;
private RTextField Licence_date = null;
private RLabel VideClient1 = null;
private RButton CreateClient = null;
private RTextField LastnameWorker = null;
private RTextField EmailWorker = null;
private RTextField FirstnameWorker = null;
private RList ListPosition = null;
private RLabel VideCar1 = null;
private RLabel VideCar2 = null;
private RLabel VideCar3 = null;
private RButton CreateWorker = null;
private RButton CreateCertificate = null;
private RList ListWorkers = null;
private RComboBox ComboboxCars = null;
private RComboBox ComboCar = null;
private RComboBox ComboWorker = null;
private RTextField Number = null;
/**
   * Create a new instance of GarageCreateClientPanel
   */
  public GarageCreateClientPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes GarageCreateClientPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(951,515));
        this.add(getMenuBar(), com.ulcjava.base.application.ULCBorderLayoutPane.NORTH);
        this.add(getCenter(), com.ulcjava.base.application.ULCBorderLayoutPane.CENTER);
        this.add(getLeft(), com.ulcjava.base.application.ULCBorderLayoutPane.WEST);
        this.add(getRight(), com.ulcjava.base.application.ULCBorderLayoutPane.EAST);
        this.add(getFooter(), com.ulcjava.base.application.ULCBorderLayoutPane.SOUTH);
  }

/**
 * This method initializes MenuBar	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.menus.RMenuBar	
 */
private RMenuBar getMenuBar() {
	if (MenuBar == null) {
		MenuBar = new RMenuBar();
		MenuBar.setName("MenuBar");
		MenuBar.setPreferredSize(new com.ulcjava.base.application.util.Dimension(200,40));
	}
	return MenuBar;
}

/**
 * This method initializes Footer	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.menus.RMenuBar	
 */
private RMenuBar getFooter() {
	if (Footer == null) {
		Footer = new RMenuBar();
		Footer.setName("Footer");
		Footer.setPreferredSize(new com.ulcjava.base.application.util.Dimension(200,40));
	}
	return Footer;
}

/**
 * This method initializes Right	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getRight() {
	if (Right == null) {
		Right = new RGridLayoutPane();
		Right.setName("Right");
		Right.setName("Right");
		Right.setBackground(new Color(238, 233, 235));
	}
	return Right;
}

/**
 * This method initializes Left	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getLeft() {
	if (Left == null) {
		Left = new RGridLayoutPane();
		Left.setName("Left");
		Left.setBackground(new Color(238, 233, 235));
	}
	return Left;
}

/**
 * This method initializes Center	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getCenter() {
	if (Center == null) {
		Center = new RGridLayoutPane();
		Center.setName("Center");
		Center.setColumns(4);
		Center.add(getCertificateGrille());
		Center.add(getCarGrille());
		Center.add(getClientGrille());
		Center.add(getWorkerGrille());
	}
	return Center;
}

/**
 * This method initializes CertificateGrille	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getCertificateGrille() {
	if (CertificateGrille == null) {
		CertificateGrille = new RGridLayoutPane();
		CertificateGrille.setName("CertificateGrille");
		CertificateGrille.setRows(10);
		CertificateGrille.setColumns(1);
		CertificateGrille.add(getCertificates());
		CertificateGrille.add(getNumber());
		CertificateGrille.add(getComboCar());
		CertificateGrille.add(getComboWorker());
		CertificateGrille.add(getCreateCertificate());
	}
	return CertificateGrille;
}

/**
 * This method initializes CarGrille	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getCarGrille() {
	if (CarGrille == null) {
		CarGrille = new RGridLayoutPane();
		CarGrille.setName("CarGrille");
		CarGrille.setRows(10);
		CarGrille.setColumns(1);
		CarGrille.add(getCars());
		CarGrille.add(getComboboxCars());
		CarGrille.add(getSerial_number());
		CarGrille.add(getBrand());
		CarGrille.add(getModel());
		CarGrille.add(getType());
		CarGrille.add(getColor());
		CarGrille.add(getPrice());
		CarGrille.add(getListClient());
		CarGrille.add(getCreateCar());
	}
	return CarGrille;
}

/**
 * This method initializes ClientGrille	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getClientGrille() {
	if (ClientGrille == null) {
		RList ListClients = new RList();
		ListClients.setModelConfiguration("{/result \"result=entry.firstname\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
		ListClients.setName("ListClients");
		ClientGrille = new RGridLayoutPane();
		ClientGrille.setName("ClientGrille");
		ClientGrille.setRows(10);
		ClientGrille.setColumns(1);
		ClientGrille.add(getClients());
		ClientGrille.add(getLastnameClient());
		ClientGrille.add(getFirstnameClient());
		ClientGrille.add(getEmail());
		ClientGrille.add(getBirthday());
		ClientGrille.add(getLicence_type());
		ClientGrille.add(getLicence_date());
		ClientGrille.add(getVideClient1());
		ClientGrille.add(ListClients);
		ClientGrille.add(getCreateClient());
	}
	return ClientGrille;
}

/**
 * This method initializes WorkerGrille	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RGridLayoutPane	
 */
private RGridLayoutPane getWorkerGrille() {
	if (WorkerGrille == null) {
		WorkerGrille = new RGridLayoutPane();
		WorkerGrille.setName("WorkerGrille");
		WorkerGrille.setRows(10);
		WorkerGrille.setColumns(1);
		WorkerGrille.add(getWorkers());
		WorkerGrille.add(getListWorkers());
		WorkerGrille.add(getLastnameWorker());
		WorkerGrille.add(getFirstnameWorker());
		WorkerGrille.add(getEmailWorker());
		WorkerGrille.add(getListPosition());
		WorkerGrille.add(getVideCar1());
		WorkerGrille.add(getVideCar2());
		WorkerGrille.add(getVideCar3());
		WorkerGrille.add(getCreateWorker());
	}
	return WorkerGrille;
}

/**
 * This method initializes Certificates	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getCertificates() {
	if (Certificates == null) {
		Certificates = new RLabel();
		Certificates.setText("Certificates");
		Certificates.setBackground(new Color(238, 238, 238));
		Certificates.setHorizontalTextPosition(ULCLabel.CENTER);
		Certificates.setHorizontalAlignment(ULCTextField.CENTER);
		Certificates.setName("Certificate");
	}
	return Certificates;
}

/**
 * This method initializes Cars	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getCars() {
	if (Cars == null) {
		Cars = new RLabel();
		Cars.setBackground(new Color(238, 238, 238));
		Cars.setHorizontalAlignment(ULCTextField.CENTER);
		Cars.setHorizontalTextPosition(ULCLabel.CENTER);
		Cars.setText("Cars");
		Cars.setName("Cars");
	}
	return Cars;
}

/**
 * This method initializes Clients	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getClients() {
	if (Clients == null) {
		Clients = new RLabel();
		Clients.setBackground(new Color(238, 238, 238));
		Clients.setHorizontalAlignment(ULCTextField.CENTER);
		Clients.setHorizontalTextPosition(ULCLabel.CENTER);
		Clients.setText("Clients");
		Clients.setName("Clients");
	}
	return Clients;
}

/**
 * This method initializes Workers	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getWorkers() {
	if (Workers == null) {
		Workers = new RLabel();
		Workers.setBackground(new Color(238, 238, 238));
		Workers.setHorizontalAlignment(ULCTextField.CENTER);
		Workers.setHorizontalTextPosition(ULCLabel.CENTER);
		Workers.setText("Workers");
		Workers.setName("Workers");
	}
	return Workers;
}

/**
 * This method initializes Serial_number	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getSerial_number() {
	if (Serial_number == null) {
		Serial_number = new RTextField();
		Serial_number.setText("Serial_number");
		Serial_number.setName("Serial_number");
	}
	return Serial_number;
}

/**
 * This method initializes Brand	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getBrand() {
	if (Brand == null) {
		Brand = new RTextField();
		Brand.setText("Brand");
		Brand.setName("Brand");
	}
	return Brand;
}

/**
 * This method initializes Model	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getModel() {
	if (Model == null) {
		Model = new RTextField();
		Model.setText("Model");
		Model.setName("Model");
	}
	return Model;
}

/**
 * This method initializes Type	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getType() {
	if (Type == null) {
		Type = new RTextField();
		Type.setText("Type");
		Type.setName("Type");
	}
	return Type;
}

/**
 * This method initializes Color	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getColor() {
	if (Color == null) {
		Color = new RTextField();
		Color.setText("Color");
		Color.setName("Color");
	}
	return Color;
}

/**
 * This method initializes Price	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getPrice() {
	if (Price == null) {
		Price = new RTextField();
		Price.setText("Price");
		Price.setName("Price");
	}
	return Price;
}

/**
 * This method initializes ListClient	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RList	
 */
private RList getListClient() {
	if (ListClient == null) {
		ListClient = new RList();
		ListClient.setName("ListClient");
	}
	return ListClient;
}

/**
 * This method initializes CreateCar	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getCreateCar() {
	if (CreateCar == null) {
		CreateCar = new RButton();
		CreateCar.setText("Create car");
		CreateCar.setName("CreateCar");
	}
	return CreateCar;
}

/**
 * This method initializes LastnameClient	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getLastnameClient() {
	if (LastnameClient == null) {
		LastnameClient = new RTextField();
		LastnameClient.setText("Lastname");
		LastnameClient.setName("LastnameClient");
	}
	return LastnameClient;
}

/**
 * This method initializes FirstnameClient	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getFirstnameClient() {
	if (FirstnameClient == null) {
		FirstnameClient = new RTextField();
		FirstnameClient.setText("Firstname");
		FirstnameClient.setName("FirstnameClient");
	}
	return FirstnameClient;
}

/**
 * This method initializes Email	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getEmail() {
	if (Email == null) {
		Email = new RTextField();
		Email.setText("Email");
		Email.setName("Email");
	}
	return Email;
}

/**
 * This method initializes Birthday	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getBirthday() {
	if (Birthday == null) {
		Birthday = new RTextField();
		Birthday.setText("Birthday");
		Birthday.setName("Birthday");
	}
	return Birthday;
}

/**
 * This method initializes Licence_type	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getLicence_type() {
	if (Licence_type == null) {
		Licence_type = new RTextField();
		Licence_type.setText("Licence_type");
		Licence_type.setValueAsString("Licence");
		Licence_type.setName("Licence_type");
	}
	return Licence_type;
}

/**
 * This method initializes Licence_date	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getLicence_date() {
	if (Licence_date == null) {
		Licence_date = new RTextField();
		Licence_date.setText("Licence_date");
		Licence_date.setValueAsString("Licence");
		Licence_date.setName("Licence_date");
	}
	return Licence_date;
}

/**
 * This method initializes VideClient1	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getVideClient1() {
	if (VideClient1 == null) {
		VideClient1 = new RLabel();
		VideClient1.setText("");
		VideClient1.setName("VideClient1");
	}
	return VideClient1;
}

/**
 * This method initializes CreateClient	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getCreateClient() {
	if (CreateClient == null) {
		CreateClient = new RButton();
		CreateClient.setText("Create client");
		CreateClient.setName("CreateClient");
	}
	return CreateClient;
}

/**
 * This method initializes LastnameWorker	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getLastnameWorker() {
	if (LastnameWorker == null) {
		LastnameWorker = new RTextField();
		LastnameWorker.setText("Lastname");
		LastnameWorker.setName("LastnameWorker");
	}
	return LastnameWorker;
}

/**
 * This method initializes EmailWorker	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getEmailWorker() {
	if (EmailWorker == null) {
		EmailWorker = new RTextField();
		EmailWorker.setText("Email");
		EmailWorker.setName("EmailWorker");
	}
	return EmailWorker;
}

/**
 * This method initializes FirstnameWorker	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getFirstnameWorker() {
	if (FirstnameWorker == null) {
		FirstnameWorker = new RTextField();
		FirstnameWorker.setText("Firstname");
		FirstnameWorker.setName("FirstnameWorker");
	}
	return FirstnameWorker;
}

/**
 * This method initializes ListPosition	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RList	
 */
private RList getListPosition() {
	if (ListPosition == null) {
		ListPosition = new RList();
		ListPosition.setName("ListPosition");
	}
	return ListPosition;
}

/**
 * This method initializes VideCar1	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getVideCar1() {
	if (VideCar1 == null) {
		VideCar1 = new RLabel();
		VideCar1.setText("");
		VideCar1.setName("VideCar1");
	}
	return VideCar1;
}

/**
 * This method initializes VideCar2	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getVideCar2() {
	if (VideCar2 == null) {
		VideCar2 = new RLabel();
		VideCar2.setText("");
		VideCar2.setName("VideCar2");
	}
	return VideCar2;
}

/**
 * This method initializes VideCar3	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RLabel	
 */
private RLabel getVideCar3() {
	if (VideCar3 == null) {
		VideCar3 = new RLabel();
		VideCar3.setText("");
		VideCar3.setName("VideCar3");
	}
	return VideCar3;
}

/**
 * This method initializes CreateWorker	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getCreateWorker() {
	if (CreateWorker == null) {
		CreateWorker = new RButton();
		CreateWorker.setText("Create worker");
		CreateWorker.setName("CreateWorker");
	}
	return CreateWorker;
}

/**
 * This method initializes CreateCertificate	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RButton	
 */
private RButton getCreateCertificate() {
	if (CreateCertificate == null) {
		CreateCertificate = new RButton();
		CreateCertificate.setText("Create certificate");
		CreateCertificate.setName("CreateCertificate");
	}
	return CreateCertificate;
}

/**
 * This method initializes ListWorkers	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RList	
 */
private RList getListWorkers() {
	if (ListWorkers == null) {
		ListWorkers = new RList();
		ListWorkers.setName("ListWorkers");
		ListWorkers.setModelConfiguration("{/result \"result=entry.firstname\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
	}
	return ListWorkers;
}

/**
 * This method initializes ComboboxCars	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RComboBox	
 */
private RComboBox getComboboxCars() {
	if (ComboboxCars == null) {
		ComboboxCars = new RComboBox();
		ComboboxCars.setName("ComboboxCars");
		ComboboxCars.setModelConfiguration("{/result \"\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
	}
	return ComboboxCars;
}

/**
 * This method initializes ComboCar	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RComboBox	
 */
private RComboBox getComboCar() {
	if (ComboCar == null) {
		ComboCar = new RComboBox();
		ComboCar.setName("ComboCar");
		ComboCar.setModelConfiguration("{/result \"result=entry.serial_number\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
	}
	return ComboCar;
}

/**
 * This method initializes ComboWorker	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RComboBox	
 */
private RComboBox getComboWorker() {
	if (ComboWorker == null) {
		ComboWorker = new RComboBox();
		ComboWorker.setName("ComboWorker");
		ComboWorker.setModelConfiguration("{/result \"result=entry.lastname + \\\" \\\" + entry.firstname\"/version \"3.0\"/icon \"\"/tooltip \"\"}");
	}
	return ComboWorker;
}

/**
 * This method initializes Number	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RTextField	
 */
private RTextField getNumber() {
	if (Number == null) {
		Number = new RTextField();
		Number.setText("Number");
		Number.setName("Number");
	}
	return Number;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"