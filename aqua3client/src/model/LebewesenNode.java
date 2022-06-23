package model;

import javax.swing.tree.DefaultMutableTreeNode;

import domain.Lebewesen;


public class LebewesenNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;
	private Lebewesen lebewesen;
	private boolean isLeaf;


	public LebewesenNode(Lebewesen lebewesen, boolean isLeaf) {
		super(isLeaf ? lebewesen : lebewesen.getTypen());
		this.lebewesen = lebewesen;
		this.isLeaf = isLeaf;
	}

	public boolean isOfTheSameTyp(Lebewesen l) {
		return lebewesen.isOfTheSameTyp(l);
	}

	public Lebewesen toLebewesen() {
		return lebewesen;
	}

	@Override
	public String toString() {
		if(!isLeaf)
			return lebewesen.getTypen().toString();
		else
			return lebewesen.toString();
	}
	
	

}
