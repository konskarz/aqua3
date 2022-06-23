package model;

import javax.swing.tree.DefaultMutableTreeNode;

import domain.SzenarienLebewesen;


public class SzenarienLebewesenNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;
	private SzenarienLebewesen szlw;
	private boolean isLeaf;


	public SzenarienLebewesenNode(SzenarienLebewesen szlw, boolean isLeaf) {
		super(isLeaf ? szlw : szlw.getLebewesen().getTypen());
		this.szlw = szlw;
		this.isLeaf = isLeaf;
	}

	public boolean isOfTheSameTyp(SzenarienLebewesen sl) {
		return szlw.getLebewesen().isOfTheSameTyp(sl.getLebewesen());
	}

	public SzenarienLebewesen toSzenarienLebewesen() {
		return szlw;
	}

	@Override
	public String toString() {
		return isLeaf ? szlw.toString() : szlw.getLebewesen().getTypen().toString();
	}

}
