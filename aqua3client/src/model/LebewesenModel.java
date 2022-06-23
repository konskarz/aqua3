package model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import dao.LebewesenDao;
import domain.Lebewesen;


public class LebewesenModel extends DefaultTreeModel {

	private static final long serialVersionUID = 1L;
	private final TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
	private String strRoot;
	private DefaultMutableTreeNode treeRoot;
	private List<Lebewesen> dbLebewesen;

	public LebewesenModel(String strRoot, LebewesenDao dao) {
		super(null);
		this.strRoot = strRoot;
		this.dbLebewesen = dao.findAll();
		buildDbLebewesenTree();
	}
	
	private void buildDbLebewesenTree() {
		treeRoot = new DefaultMutableTreeNode(strRoot);
		LebewesenNode parent;
		for(Lebewesen lw : dbLebewesen) {
			parent = findOrCreateParentNode(lw);
			parent.add(new LebewesenNode(lw, true));
		}
		this.setRoot(treeRoot);
	}

	private LebewesenNode findOrCreateParentNode(Lebewesen lw) {
		LebewesenNode node;
		for (int i=0; i<treeRoot.getChildCount(); i++) {
			node = (LebewesenNode)treeRoot.getChildAt(i);
			if (node.isOfTheSameTyp(lw)) {
				return node;
			}
		}
		node = new LebewesenNode(lw, false);
		this.treeRoot.add(node);
		return node;
	}

	public TreeSelectionModel getSelectionModel() {
		return selectionModel;
	}
	
	public Lebewesen[] getSelectedLebewesen() {
		if(!selectionModel.isSelectionEmpty()) {
			TreePath[] paths = selectionModel.getSelectionPaths();
			Lebewesen[] lebewesen = new Lebewesen[paths.length];
			LebewesenNode node;
			for(int i=0; i<paths.length; i++) {
				node = (LebewesenNode)paths[i].getLastPathComponent();
				lebewesen[i] = node.toLebewesen();
			}
			return lebewesen;
		}
		return null;
	}

}
