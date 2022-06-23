package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SwingUtilities;

import main.Resources;


/**
 * Dimensionen-Editor Dialog
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class PanelDimensionen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	private JSpinner firstSpinner = new JSpinner();
	private JSpinner secondSpinner = new JSpinner();
	private JSpinner thirdSpinner = new JSpinner();
	private JButton firstButton = new JButton();
	private JButton secondButton = new JButton();
	
	public PanelDimensionen() {
		super(new BorderLayout());
		add(getCenterPanel(),BorderLayout.CENTER);
		add(getSouthPanel(),BorderLayout.SOUTH);
	}
	
	private JPanel getCenterPanel() {
		JPanel innerPanel = new JPanel(new GridLayout(3,2,5,5));
		innerPanel.add(new JLabel(Resources.getString("DimPanel.length_label")));
		innerPanel.add(firstSpinner);
		innerPanel.add(new JLabel(Resources.getString("DimPanel.width_label")));
		innerPanel.add(secondSpinner);
		innerPanel.add(new JLabel(Resources.getString("DimPanel.height_label")));
		innerPanel.add(thirdSpinner);

		JPanel outerPanel = new JPanel();
		outerPanel.add(innerPanel);
		return outerPanel;
	}
	
	private JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		panel.add(firstButton);
		panel.add(secondButton);
		return panel;
	}

	public void setModels(SpinnerModel[] models) {
		firstSpinner.setModel(models[0]);
		secondSpinner.setModel(models[1]);
		thirdSpinner.setModel(models[2]);
	}

	public void setActions(Action[] actions) {
		firstButton.setAction(actions[0]);
		secondButton.setAction(actions[1]);
	}

	/**
	 * Zeigt Dimensionen-Editor Dialog
	 * @param parent
	 */
	public void showDialog(Component parent) {
		Frame owner = parent instanceof Frame?(Frame)parent:(Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent);
		if (dialog==null || dialog.getOwner()!=owner) {
			dialog = new JDialog(owner, true);
			dialog.add(this);
			dialog.pack();
		}
		dialog.setLocationRelativeTo(owner);
		dialog.setTitle(Resources.getString("DimDialog.title"));
		dialog.setResizable(false);
		dialog.setVisible(true);
	}

	/**
	 * Versteckt Dimensionen-Editor Dialog
	 */
	public void hideDialog() {
		dialog.setVisible(false);
	}
	
}
