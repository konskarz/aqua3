package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import main.Resources;


public class PanelTree extends JPanel 
//implements ActionListener 
{

	private static final long serialVersionUID = 871598368878726765L;
	private JPanel filterPanel = new JPanel();
	private JTree tree = new JTree();
	private JTextPane infoPane = new JTextPane();
//	private LebewesenTree lebewesenModel = null;

	public PanelTree(String keyInfoText, boolean useCheckbox) {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));

		this.add(getFilterPanel(), BorderLayout.NORTH);
		this.add(getTreePane(), BorderLayout.CENTER);
		this.add(getInfoPane(), BorderLayout.SOUTH);

		this.setInfo(Resources.getString(keyInfoText));
		if (useCheckbox)
			addCheckBox();
	}

	private JPanel getFilterPanel() {
		LayoutManager layout = new BoxLayout(filterPanel, BoxLayout.X_AXIS);
		filterPanel.setLayout(layout);
		filterPanel.setPreferredSize( new Dimension(130, 30));
		return filterPanel;
	}

	private JScrollPane getTreePane() {
		tree.setEditable(false);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		JScrollPane treeScrollPane = new JScrollPane(tree);
		treeScrollPane.setPreferredSize(new Dimension(130, 140));

		return treeScrollPane;
	}

	private JScrollPane getInfoPane() {
		infoPane.setEditable(false);
		JScrollPane panel = new JScrollPane(infoPane);
		panel.setPreferredSize(new Dimension(130, 140));
		return panel;
	}

	private void addCheckBox() {
		JCheckBox cBox = new JCheckBox(Resources.getString("Szen.lwp_filter"));
//		cBox.setActionCommand("cbnotinaqua");
//		cBox.addActionListener(this);
		filterPanel.add(cBox);
	}

	public void setInfo(String info) {
		infoPane.setText(info);
	}

	public void setModels(TreeModel newModel, TreeSelectionModel selectionModel) {
		tree.setModel(newModel);
		tree.setSelectionModel(selectionModel);
	}

	//	public void setModel(String keyTreeRoot, int szenarioId) throws AquaDaoException {
//		lebewesenModel = new LebewesenTree(Resources.getString(keyTreeRoot),szenarioId);
//		lebewesenModel.setTree(lebewesenTree);
//		lebewesenTree.setModel(lebewesenModel);
//		lebewesenTree.addTreeSelectionListener(lebewesenModel);
//	}
//
//	public void setRefresher(ILebewesenRefresher r) {
//		lebewesenModel.setRefresher(r, this);
//	}
//
//	public Lebewesen selectedLebewesen() {
//		return lebewesenModel.getCurrentSelection().toLebewesen();
//	}
//
//	public void add(Lebewesen selectedLebewesen,int menge) throws AquaDaoException {
//		lebewesenModel.add(selectedLebewesen,menge);
//	}
//
//	public void removeSelectedLebewesen() throws AquaDaoException {
//		lebewesenModel.removeSelectedLebewesen();
//	}
//
//	public void refresh(int szenarioId) throws AquaDaoException {
//		lebewesenModel.refresh(szenarioId);
//	}
//
//	public void updateTree() {
//		lebewesenTree.setVisible(false);
//		lebewesenTree.setVisible(true);
//	}
//
//	public void refreshInfo(Lebewesen curSel) {
//		if (curSel != null)
//			this.setInfo(curSel.getInfo());
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		String cmd = e.getActionCommand();
//		try {
//			if (cmd.equals("cbnotinaqua"))
//				lebewesenModel.setInNotIn(((JCheckBox) e.getSource()).getModel().isSelected());
//		} catch (AquaDaoException ade) {
//			ErrorMessage.show(ErrorMessage.CONNECTION);
//		}
//	}
//
//	public void deleteAll(int szen_id) throws AquaDaoException {
//		lebewesenModel.deleteAll(szen_id);
//	}
//
//	public void saveAll(int szen_id) throws AquaDaoException {
//		lebewesenModel.saveAll(szen_id);
//	}
//
}
