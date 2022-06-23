package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

import main.Resources;


/**
 * Panel mit zwei Spinners
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class PanelSpinners extends JPanel {

	private static final long serialVersionUID = 5460207612321317629L;
	private JSpinner firstSpinner = new JSpinner();
	private JSpinner secondSpinner = new JSpinner();

	public PanelSpinners(String keyTitle, String keyLabel1, String keyLabel2) {
		super(new GridLayout(2,2,5,5));
		setBorder(BorderFactory.createTitledBorder(Resources.getString(keyTitle)));
		add(new JLabel(Resources.getString(keyLabel1),JLabel.RIGHT));
		add(firstSpinner);
		add(new JLabel(Resources.getString(keyLabel2),JLabel.RIGHT));
		add(secondSpinner);
	}
	
	public void setModels(SpinnerModel[] models) {
		firstSpinner.setModel(models[0]);
		secondSpinner.setModel(models[1]);
	}

	public void setModels(SpinnerModel[] models, String dateEditorPattern) {
		firstSpinner.setModel(models[0]);
		firstSpinner.setEditor(new JSpinner.DateEditor(firstSpinner,dateEditorPattern));
		secondSpinner.setModel(models[1]);
		secondSpinner.setEditor(new JSpinner.DateEditor(secondSpinner,dateEditorPattern));
	}

}
