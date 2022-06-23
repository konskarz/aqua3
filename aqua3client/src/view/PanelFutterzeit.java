package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;

import main.Resources;


/**
 * Futter-Zeiten Editor Panel
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class PanelFutterzeit extends JPanel {

	private static final long serialVersionUID = 7371191512126336454L;
	private JSpinner spinner = new JSpinner();
	private JList list = new JList();
	private JButton firstButton = new JButton();
	private JButton secondButton = new JButton();

	public PanelFutterzeit() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(222,0));
		setBorder(BorderFactory.createTitledBorder(Resources.getString("Szen.fzp_border")));
		add(getLeftPanel());
		add(Box.createRigidArea(new Dimension(5,0)));
		add(new JScrollPane(list));
	}

	private Component getLeftPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setMaximumSize(new Dimension(120,90));
		panel.add(spinner, BorderLayout.NORTH);
		panel.add(getButtonsPanel(), BorderLayout.SOUTH);
		return panel;
	}

	private Component getButtonsPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1,0,5));
		panel.setPreferredSize(new Dimension(90,51));
		panel.add(firstButton);
		panel.add(secondButton);
		return panel;
	}

	public void setActions(Action[] actions) {
		firstButton.setAction(actions[0]);
		secondButton.setAction(actions[1]);
	}

	public void setModels(ListModel listModel, ListSelectionModel selectionModel, SpinnerDateModel spinnerDateModel, String dateEditorPattern) {
		list.setModel(listModel);
		list.setSelectionModel(selectionModel);
		spinner.setModel(spinnerDateModel);
		spinner.setEditor(new JSpinner.DateEditor(spinner, dateEditorPattern));
	}
	
}
