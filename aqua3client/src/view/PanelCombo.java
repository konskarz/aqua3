package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import main.Resources;


/**
 * Panel mit ComboBox und Buttons
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class PanelCombo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox comboBox = new JComboBox();
	private JButton firstButton = new JButton();
	private JButton secondButton = new JButton();
	private JButton thirdButton = new JButton();

	public PanelCombo() {
		BoxLayout szenarioPanelLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(szenarioPanelLayout);
		Dimension comboBoxSize = new Dimension(222,23);
		comboBox.setPreferredSize(comboBoxSize);
		comboBox.setMinimumSize(comboBoxSize);
		comboBox.setMaximumSize(comboBoxSize);
		add(comboBox);
		add(Box.createRigidArea(new Dimension(5,0)));
		add(getInnerPanel());
	}
	
	public PanelCombo(String titleKey) {
		this();
		setBorder(BorderFactory.createTitledBorder(Resources.getString(titleKey)));
	}

	private JPanel getInnerPanel() {
		JPanel panel = new JPanel(new GridLayout(1,3,5,5));
		panel.setMinimumSize(new Dimension(250,23));
		panel.setMaximumSize(new Dimension(400,40));
		panel.add(firstButton);
		panel.add(secondButton);
		panel.add(thirdButton);
		return panel;
	}

	/**
	 * ComboBox Model und Editor einstellen
	 * @param aModel
	 * @param anEditor
	 */
	public void setModels(ComboBoxModel aModel, ComboBoxEditor anEditor) {
		comboBox.setModel(aModel);
		if(anEditor!=null) {
			comboBox.setEditable(true);
			comboBox.setEditor(anEditor);
		}
	}

	public void setActions(Action[] actions) {
		comboBox.addActionListener(actions[0]);
		firstButton.setAction(actions[1]);
		secondButton.setAction(actions[2]);
		thirdButton.setAction(actions[3]);
	}

}
