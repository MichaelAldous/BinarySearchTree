package assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class BinarySearchTree {

	public static void main(String[] args) {
		//Creates Binary Search Trees
		Tree bst1 = new Tree();
		Tree bst2 = new Tree();
		Tree bst3 = new Tree();

		//Addresses to files to add to trees
		String file1 = "file1.txt";
		String file2 = "file2.txt";
		String file3 = "file3.txt";

		//Adds files into trees
		readData(bst1, file1);
		readData(bst2, file2);
		readData(bst3, file3);

		//Displays Tree data
		displayData(bst1);
		System.out.println("");
		displayData(bst2);
		System.out.println("Number of Prime Numbers in Tree 2: " + bst2.countPrimeNums(bst2.root));
		System.out.println("");
		displayData(bst3);
	}

	//Read in data files
	public static void readData(Tree tr,String f){
		File path = new File(f);
		try {
			Scanner sc = new Scanner(path);
			while(sc.hasNextInt()){
				Node p = new Node(sc.nextInt());
				tr.insert(p);
			}
			sc.close();
		} catch(IOException e){
			System.out.println("Can not find file: " + e.getMessage());
		}
		return;
	}//End of readData

	public static void displayData(Tree tr){
		//Print Size of Tree
		System.out.println("Size of Tree: "+tr.numOfNodes(tr.root));
		//Prints increasing order
		System.out.print("List in Increasing Order:");
		tr.prIncOrder(tr.root);
		System.out.print("\n");
		//Prints height of tree
		System.out.println("Tree Height: "+tr.findHeight(tr.root));
		//Prints 'level by level'
		System.out.println("Tree in Level by Level:");
		tr.printLevelByLevel();
		System.out.print("\n");
	}//End of displayData


}//End of class Binary Search Tree
