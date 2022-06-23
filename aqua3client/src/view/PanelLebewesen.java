package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import main.Resources;


public class PanelLebewesen extends JPanel 
//implements ActionListener//, ILebewesenRefresher 
{

	private static final long serialVersionUID = 1L;
	private PanelTree dblwPanel;
	private PanelTree szlwPanel;
	private JButton firstButton = new JButton();
	private JButton secondButton = new JButton();
//	private int SzenarioId;
	
	public PanelLebewesen() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createTitledBorder(Resources.getString("Szen.lw_border")));
		dblwPanel = new PanelTree("Szen.lwinfp_text", true);
		szlwPanel = new PanelTree("Szen.lwszinfp_text", false);
		this.add(szlwPanel);
		this.add(getLebewesenEditPanel());
		this.add(dblwPanel);
	}

	private JPanel getLebewesenEditPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1,0,5));
		panel.setMaximumSize(new Dimension(51,51));
		panel.add(firstButton);
		panel.add(secondButton);
		return panel;
	}

	public void setActions(Action[] actions) {
		firstButton.setAction(actions[0]);
		secondButton.setAction(actions[1]);
	}

	public void setDbLebewesenModels(TreeModel newModel, TreeSelectionModel selectionModel) {
		dblwPanel.setModels(newModel, selectionModel);
	}

	public void setSzLebewesenModels(TreeModel newModel, TreeSelectionModel selectionModel) {
		szlwPanel.setModels(newModel, selectionModel);
	}
	
//	private JButton getButton(String key, String actionCommand, ActionListener l) {
//		JButton button = new JButton(Resources.getString(key));
//		button.setActionCommand(actionCommand);
//		button.addActionListener(l);
//		return button;
//	}
//
//	public void setModels() throws AquaDaoException {
//		dblwPanel.setModel("Szen.lwp_treeRoot",SzenarioId*-1);
//		szlwPanel.setModel("Szen.lwszp_treeRoot",SzenarioId);
//		dblwPanel.setRefresher(this);
//		szlwPanel.setRefresher(this);
//	}
//	
//	public void setValues(int szen_id) throws AquaDaoException {
//		this.SzenarioId = szen_id;
//		refreshLebewesenPanels();
//	}
//	
//	public void setDefaults() throws AquaDaoException {
//		this.SzenarioId = 0;
//		refreshLebewesenPanels();
//	}
//	
//	public void actionPerformed(ActionEvent e) {
//		String cmd = e.getActionCommand();
//		try {
//			if( cmd.equalsIgnoreCase("lwadd"))
//				szlwPanel.add( dblwPanel.selectedLebewesen(), getMenge(dblwPanel.selectedLebewesen()));
//			else if( cmd.equalsIgnoreCase("lwrem"))
//				szlwPanel.removeSelectedLebewesen();
//		} catch (AquaDaoException ade) {
//			ErrorMessage.show(ErrorMessage.CONNECTION);
//		}
//	}
//
//	private void refreshLebewesenPanels() throws AquaDaoException {
//		dblwPanel.refresh( SzenarioId*-1 );
//		szlwPanel.refresh( SzenarioId );
//	}
//
//	public void LebenwesenDeselected(Lebewesen curSel, PanelSzenarioTrees parent) {
//		if( szlwPanel == parent )
//			lwRemButton.setEnabled(false);
//		parent.refreshInfo( null );
//	}
//
//	public void LebenwesenSelected(Lebewesen curSel, PanelSzenarioTrees parent) {
//		if( szlwPanel == parent )
//			lwRemButton.setEnabled(true);
//		else
//			lwAddButton.setEnabled(true);
//		parent.refreshInfo( curSel );
//	}
//
//	public void refreshBothSides() {
//		dblwPanel.updateTree();
//		szlwPanel.updateTree();
//	}
//
//	public void deleteButtonPressed(PanelSzenarioTrees parent) {
//		try {
//			if( szlwPanel == parent && lwRemButton.isEnabled() )
//				szlwPanel.removeSelectedLebewesen();
//		} catch (AquaDaoException ade) {
//			ErrorMessage.show(ErrorMessage.CONNECTION);
//		}
//	}
//
//	public void addButtonPressed(PanelSzenarioTrees parent) {
//		try {
//			if(dblwPanel == parent && lwAddButton.isEnabled())
//				szlwPanel.add(dblwPanel.selectedLebewesen(), getMenge(dblwPanel.selectedLebewesen()));
//		} catch (AquaDaoException ade) {
//			ErrorMessage.show(ErrorMessage.CONNECTION);
//		}
//	}
//	
//	private int getMenge(Lebewesen l){
//		String ret = JOptionPane.showInputDialog("Wie viele " + dblwPanel.selectedLebewesen() + "?", 1);
//		if (ret == null || ret.length() == 0)
//			return 0;
//		return Integer.parseInt(ret);
//	}
//
//	public void deleteSzenarioLebewesen(int szen_id) throws AquaDaoException {
//		szlwPanel.deleteAll(szen_id);
//		refreshLebewesenPanels();
//	}
//
//	public void saveSzenarioLebewesen(int szen_id) throws AquaDaoException {
//		szlwPanel.saveAll(szen_id);
//	}
//
}
