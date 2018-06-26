package assignment3;

public class Tree {
	public Node root;

	Tree(){root = null;}


	public void insert(Node p){
		if(root==null){
			root = p;
			return;
		}
		Node temp = root;
		while(true){
			if(p.num>temp.num){
				if(temp.right == null){
					temp.right = p;
					break;
				}
				temp = temp.right;
			} else {
				if(temp.left == null){
					temp.left = p;
					break;
				}
				temp = temp.left;
			}
		}
	}//End of insert

	//Size of each tree
	public int numOfNodes(Node p){
		Node temp = p;
		int count = 0;
		if(temp != null){
			count++;
			count = count + numOfNodes(temp.left);
			count = count + numOfNodes(temp.right);
		}
		return(count);
	}//End of numOfNodes

	//Print numbers in increasing order
	public void prIncOrder(Node p){
		if(p==null){
			return;
		}
		prIncOrder(p.left);
		System.out.print(" " + p.num);
		prIncOrder(p.right);
		return;
	}//End of print increasing order

	//Find Tree Height
	public int findHeight(Node p){
		if(p==null){
			return(-1);
		}
		int left = findHeight(p.left);
		int right = findHeight(p.right);
		if(left>right){
			return(left+1);
		} else {
			return(right+1);
		}
	}//End of find height

	//Prints Lever By Level
	public void printLevelByLevel(){ // 100
		if(root==null){return;}
		SLL pList = new SLL();
		SLLNode n = new SLLNode(root);
		pList.addToTail(n);
		int nextLevelCount = 0;
		int currentLevelCount = 1;
		int levelCount = 1;
		System.out.print("Level 0:");
		while(pList.head!=null){
			if(currentLevelCount==0){
				System.out.print("\nLevel " + levelCount + ":");
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;
				levelCount++;
			}
			if(pList.head.bstNode.left!=null){
				pList.addToTail(new SLLNode(pList.head.bstNode.left));
				nextLevelCount++;
			}
			if(pList.head.bstNode.right!=null){
				pList.addToTail(new SLLNode(pList.head.bstNode.right));
				nextLevelCount++;
			}
			System.out.print(" " + pList.head.bstNode.num);
			pList.delFromHead();
			currentLevelCount--;
		}
		return;
	}//End of print level by level

	//Count prime numbers
	public int countPrimeNums(Node p){
		int count = 0;
		if(p==null){
			return(count);
		}
		if(p.isPrime()==true){
			count++;
		}
		count = count + countPrimeNums(p.left) + countPrimeNums(p.right);
		return(count);
	}//End of count Prime numbers

}//End of class Tree
