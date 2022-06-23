package model;

import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import domain.Lebewesen;
import domain.Szenarien;
import domain.SzenarienLebewesen;


public class SzenarienLebewesenModel extends DefaultTreeModel {

	private static final long serialVersionUID = 1L;
	private final TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
	private String strRoot;
	private DefaultMutableTreeNode treeRoot;
	private Set<SzenarienLebewesen> szLebewesen;
	private Szenarien currentSzenario;

	public SzenarienLebewesenModel(String strRoot) {
		super(null);
		this.strRoot = strRoot;
	}
	
	public void buildSzLebewesenTree(Szenarien s, Set<SzenarienLebewesen> szLebewesen) {
		this.currentSzenario = s;
		this.szLebewesen = szLebewesen;
		rebuildSzLebewesenTree();
	}

	private void rebuildSzLebewesenTree() {
		treeRoot = new DefaultMutableTreeNode(strRoot);
		SzenarienLebewesenNode parent;
		for(SzenarienLebewesen szlw : szLebewesen) {
			parent = findOrCreateParentNode(szlw);
			parent.add(new SzenarienLebewesenNode(szlw, true));
		}
		this.setRoot(treeRoot);
	}

	private SzenarienLebewesenNode findOrCreateParentNode(SzenarienLebewesen szlw) {
		SzenarienLebewesenNode node;
		for (int i=0; i<treeRoot.getChildCount(); i++) {
			node = (SzenarienLebewesenNode)treeRoot.getChildAt(i);
			if (node.isOfTheSameTyp(szlw)) {
				return node;
			}
		}
		node = new SzenarienLebewesenNode(szlw, false);
		this.treeRoot.add(node);
		return node;
	}

	public TreeSelectionModel getSelectionModel() {
		return selectionModel;
	}
	
	public void addLebewesen (Lebewesen lw, int menge) {
		if(currentSzenario!=null && menge!=0) {
			SzenarienLebewesen szlw;
			SzenarienLebewesenNode parent;
			SzenarienLebewesenNode child;
			if((szlw = findAndUpdateLebewesen(lw, menge))!=null) {
				parent = findOrCreateParentNode(szlw);
				if((child = findNode(szlw, parent))!=null)
					fireChanged(parent, child);
			}
			else {
				szlw = new SzenarienLebewesen(currentSzenario, lw, menge);
				parent = findOrCreateParentNode(szlw);
				child = new SzenarienLebewesenNode(szlw, true);
				parent.add(child);
				szLebewesen.add(szlw);
				fireInserted(parent, child);
			}
			selectionModel.setSelectionPath(new TreePath(child.getPath()));
		}
	}
	
	private SzenarienLebewesenNode findNode(SzenarienLebewesen szlw, 
			SzenarienLebewesenNode parent) {
		SzenarienLebewesenNode child;
		for (int i=0; i<parent.getChildCount(); i++) {
			child = (SzenarienLebewesenNode)parent.getChildAt(i);
			if((child.toSzenarienLebewesen()).equals(szlw))
				return child;
		}
		return null;
	}

	private SzenarienLebewesen findAndUpdateLebewesen(Lebewesen lw, int menge) {
		for(SzenarienLebewesen szlw : szLebewesen) {
			if(szlw.isTheSame(lw)) {
				szlw.updateMenge(menge);
				return szlw;
			}
		}
		return null;
	}

	public void removeSelectedLebewesen() {
		if(!selectionModel.isSelectionEmpty()) {
			TreePath[] paths = selectionModel.getSelectionPaths();
			DefaultMutableTreeNode parent;
			SzenarienLebewesenNode child;
			for(TreePath path : paths) {
				child = (SzenarienLebewesenNode) path.getLastPathComponent();
				parent = (DefaultMutableTreeNode) child.getParent();
				if(child!=null && child.isLeaf()) {
					removeNodeFromParent(child);
					szLebewesen.remove(child.toSzenarienLebewesen());
					fireRemoved(parent, child);
					if(parent.getChildCount()==0) {
						this.removeNodeFromParent(parent);
						fireRemoved(treeRoot, parent);
					}
				}
				if(parent!=null && parent.getChildCount()!=0) {
					DefaultMutableTreeNode newSelectedNode = (DefaultMutableTreeNode) parent.getChildAt(0);
					selectionModel.setSelectionPath(new TreePath(newSelectedNode.getPath()));
				}
			}
		}
	}

	private void fireChanged(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
		int[] childIndices = {parent.getIndex(child)};
		Object[] children = {child};
		fireTreeNodesChanged(child, child.getPath(), childIndices, children);
		this.reload(child);
	}

	private void fireInserted(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
		int[] childIndices = {parent.getIndex(child)};
		Object[] children = {child};
		fireTreeNodesInserted(child, child.getPath(), childIndices, children);
		this.reload();
	}

	private void fireRemoved(DefaultMutableTreeNode parent, DefaultMutableTreeNode child) {
		int[] childIndices = {parent.getIndex(child)};
		Object[] children = {child};
		fireTreeNodesChanged(child, child.getPath(), childIndices, children);
		this.reload(child);
	}

}
