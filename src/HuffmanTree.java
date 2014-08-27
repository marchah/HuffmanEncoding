import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class HuffmanTree {
	
	protected TreeNode myRoot;
	protected LinkedList<TreeNode> listNode;
	
	private void addNodeInlist(TreeNode node) {
		int i = 0;
		for (; i != listNode.size() && listNode.get(i).myValue <= node.myValue; i++);
		listNode.add(i, node);
	}
	
	private void createTreeGoodWay(Map<String, Integer> tm) {
		Iterator<Map.Entry<String, Integer>> it = tm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			listNode.addLast(new TreeNode(entry.getKey(), entry.getValue()));
		}
		while (listNode.size() > 1) {
			TreeNode t1 = listNode.removeFirst();
			TreeNode t2 = listNode.removeFirst();
			TreeNode rightNode = (t1.myValue >= t2.myValue) ? t1 : t2; 
			TreeNode leftNode = (t1.myValue >= t2.myValue) ? t2 : t1;
			TreeNode t3 = new TreeNode("", rightNode.myValue + leftNode.myValue, leftNode, rightNode);
			addNodeInlist(t3);
		}
		myRoot = listNode.element();
	}
	
	public HuffmanTree(Map<String, Integer> tm) {
		myRoot = null;
		listNode = new LinkedList<>();
		createTreeGoodWay(tm);
	}
	
    public void print() {
    	if (myRoot != null) {
    		myRoot.print(0);
    	}
    }
	
	public class TreeNode {

		public String myKey;
		public Integer myValue;
		public TreeNode myLeft;
		public TreeNode myRight;

		public TreeNode(String key, Integer value) {
			myKey = key;
			myValue = value;
			myLeft = myRight = null;
		}

		public TreeNode(String key, Integer value, TreeNode left, TreeNode right) {
			myKey = key;
			myValue = value;
			myLeft = left;
			myRight = right;
		}
        
        private static final String indent1 = "    ";
        private void print(int indent) {
        	if (myRight != null)
        		myRight.print(indent+1);
        	println("[" + myKey +":"+ myValue + "] ", indent);
        	if (myLeft != null)
        		myLeft.print(indent+1);
        	
        }
        private void println (String obj, int indent) {
        	for (int k = 0; k < indent; k++) {
        		System.out.print(indent1);
        	}
        	System.out.println(obj);
        }
	}

}
