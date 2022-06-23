package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.Action;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import main.Resources;




/**
 * Hauptpanel des Szenario-Editors
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class Aqua3EditorViewRoot {

	private Container parent;
	private Container contentPane;
	private PanelLebewesen lebewesenPanel;
	private PanelCombo szenarienPanel;
	private PanelCombo aquariumPanel;
	private PanelSpinners tempPanel;
	private PanelSpinners phPanel;
	private PanelSpinners lichtPanel;
	private PanelFutterzeit futterzeitPanel;
	private PanelDimensionen dimensionenPanel;
	private MenuProgram menuProgram;
	private MenuLaf menuLaf;
//	private int selectedSzenario = -1;
//	private Szenarien szenModel = null;
//	private DimensionenList aquaModel = null;

	public Aqua3EditorViewRoot(JFrame frame) {
		this.parent = frame;
		this.contentPane = frame.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		init(menuBar);
	}

	public Aqua3EditorViewRoot(JApplet applet) {
		this.parent = applet;
		this.contentPane = applet.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		applet.setJMenuBar(menuBar);
		init(menuBar);
	}

	private void init(JMenuBar menuBar) {
		initMenu(menuBar);
		initContent();
	}

	private void initMenu(JMenuBar mb) {
		if(parent instanceof JFrame) {
			menuProgram = new MenuProgram(parent);
			mb.add(menuProgram);
		}
		menuLaf = new MenuLaf(parent);
		mb.add(menuLaf);
	}

	private void initContent() {
		szenarienPanel = new PanelCombo();
		aquariumPanel = new PanelCombo("Szen.aqp_border");
		tempPanel = new PanelSpinners("Szen.tempp_border","Szen.tempp_minLabel","Szen.tempp_maxLabel");
		phPanel = new PanelSpinners("Szen.php_border","Szen.php_minLabel","Szen.php_maxLabel");
		lichtPanel = new PanelSpinners("Szen.lichtp_border","Szen.lichtp_einLabel","Szen.lichtp_ausLabel");
		futterzeitPanel = new PanelFutterzeit();
		lebewesenPanel = new PanelLebewesen();
		dimensionenPanel=new PanelDimensionen();

		JPanel northPanel = new JPanel(new GridBagLayout());
		northPanel.add(szenarienPanel, new Constraints(0,0,6,1).setWeight(1,0).setAnchor(Constraints.NORTHWEST).setFill(Constraints.HORIZONTAL).setInsets(5, 5, 0, 5));
		northPanel.add(aquariumPanel, new Constraints(0,1,6,1).setWeight(1,0).setAnchor(Constraints.WEST).setFill(Constraints.HORIZONTAL));
		northPanel.add(tempPanel, new Constraints(0,2,2,2).setWeight(1,0).setAnchor(Constraints.WEST).setFill(Constraints.HORIZONTAL));
		northPanel.add(phPanel, new Constraints(2,2,2,2).setWeight(1,0).setAnchor(Constraints.WEST).setFill(Constraints.HORIZONTAL));
		northPanel.add(lichtPanel, new Constraints(4,2,2,2).setWeight(1,0).setAnchor(Constraints.WEST).setFill(Constraints.HORIZONTAL));
		northPanel.add(futterzeitPanel, new Constraints(6,1,4,3).setWeight(1,0).setAnchor(Constraints.WEST).setFill(Constraints.BOTH));
	
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(lebewesenPanel, BorderLayout.CENTER);
	}

	public void setSzenarienModels(ComboBoxModel aModel, ComboBoxEditor anEditor) {
		szenarienPanel.setModels(aModel, anEditor);
	}

	public void setAquariumModels(ComboBoxModel aModel, ComboBoxEditor anEditor) {
		aquariumPanel.setModels(aModel, anEditor);
	}

	public void setDbLebewesenModels(TreeModel newModel, TreeSelectionModel selectionModel) {
		lebewesenPanel.setDbLebewesenModels(newModel, selectionModel);
	}

	public void setTempModels(SpinnerModel[] models) {
		tempPanel.setModels(models);
	}

	public void setPhModels(SpinnerModel[] models) {
		phPanel.setModels(models);
	}

	public void setLichtModels(SpinnerModel[] models, String dateEditorPattern) {
		lichtPanel.setModels(models, dateEditorPattern);
	}

	public void setFutterzeitModels(ListModel listModel, ListSelectionModel selectionModel, SpinnerDateModel spinnerDateModel, String dateEditorPattern) {
		futterzeitPanel.setModels(listModel, selectionModel, spinnerDateModel, dateEditorPattern);
	}

	public void setSzLebewesenModels(TreeModel newModel, TreeSelectionModel selectionModel) {
		lebewesenPanel.setSzLebewesenModels(newModel, selectionModel);
	}

	public void setDimensionenModels(SpinnerModel[] models) {
		dimensionenPanel.setModels(models);
	}

	public void addMenuProgramItem(Action a) {
		menuProgram.addItem(a);
	}

	public void setSzenarienActions(Action[] actions) {
		szenarienPanel.setActions(actions);
	}

	public void setAquariumActions(Action[] actions) {
		aquariumPanel.setActions(actions);
	}

	public void setFutterzeitActions(Action[] actions) {
		futterzeitPanel.setActions(actions);
	}

	public void setLebewesenActions(Action[] actions) {
		lebewesenPanel.setActions(actions);
	}

	public void setDimensionenActions(Action[] actions) {
		dimensionenPanel.setActions(actions);
	}

	public void showDimensionenDialog() {
		dimensionenPanel.showDialog(parent);
	}

	public void hideDimensionenDialog() {
		dimensionenPanel.hideDialog();
	}

	public int getLebewesenMenge(String name, int initialValue) {
		String value = JOptionPane.showInputDialog(
				Resources.getString("Szen.lwp_howMuch")+" "+name+"?", initialValue);
		if (value==null || value.length()==0)
			return 0;
		return Integer.parseInt(value);
	}

//	private void setDefaults() throws AquaDaoException {
//		szenPanel.setSelectedItem(Resources.getString("Szen.default_name"));
//		selectedSzenario = -1;
//		if(aquaModel.getSize()==0)
//			aquaModel.create();
//		fzPanel.setListModel(0);
//		setSpinnerModels();
//		lwPanel.setDefaults();
//	}
//
//	private void saveSzenario() throws AquaDaoException {
//		String name=szenPanel.getSelectedItem().toString();
//		if(name.length()>0 &&
//				tempPanel.checkNumbers() && 
//				phPanel.checkNumbers() && 
//				fzPanel.checkList()) {
//			int szen_id = szenModel.save(
//					selectedSzenario, name,
//					aquaModel.getId(aquaPanel.getSelectedIndex()),
//					tempPanel.getValues(),
//					phPanel.getValues(),
//					lichtPanel.getFirstDate(), lichtPanel.getSecondDate());
//			fzPanel.saveList(szen_id);
//			lwPanel.saveSzenarioLebewesen(szen_id);
//			if (selectedSzenario==-1)
//				selectedSzenario=szenModel.getSize()-1;
//			szenPanel.setSelectedIndex(selectedSzenario);
//		}
//	}
//	
//	private void deleteSzenario() throws AquaDaoException {
//		int szen_id = szenModel.delete(szenPanel.getSelectedIndex());
//		fzPanel.deleteList(szen_id);
//		lwPanel.deleteSzenarioLebewesen(szen_id);
//		if(szenModel.getSize()==0)
//			setDefaults();
//	}
//	
//	private void createAquarium() throws AquaDaoException {
//		Object object = aquaModel.create();
//		if(showDimensionenDialog(object))
//			aquaModel.save(object);
//		else
//			aquaModel.removeElement(object);
//	}
//
//	private void editAquarium() throws AquaDaoException {
//		Object object = aquaPanel.getSelectedItem();
//		if(showDimensionenDialog(object))
//			aquaModel.save(object);
//	}
//	
//	private void deleteAquarium() throws AquaDaoException {
//		int index = aquaPanel.getSelectedIndex();
//		String name = szenModel.isInUse(aquaModel.getId(index));
//		if(name==null)
//			aquaModel.delete(index);
//		else
//			ErrorMessage.show(ErrorMessage.DIMENSION_IN_USE, name);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		String cmd = e.getActionCommand();
//		try {
//			if (cmd.equals("szenchange") && szenPanel.getSelectedIndex()!=-1)
//				setValues();
//			else if (cmd.equals("szennew"))
//				setDefaults();
//			else if (cmd.equals("szensave"))
//				saveSzenario();
//			else if (cmd.equals("szendel") && szenPanel.getSelectedIndex()!=-1)
//				deleteSzenario();
//			else if (cmd.equals("aquanew"))
//				createAquarium();
//			else if (cmd.equals("aquaedit"))
//				editAquarium();
//			else if (cmd.equals("aquadel") && aquaPanel.getSelectedIndex()!=-1)
//				deleteAquarium();
//		} catch (AquaDaoException ade) {
//			ErrorMessage.show(ErrorMessage.CONNECTION);
//		}
//	}
//
}
