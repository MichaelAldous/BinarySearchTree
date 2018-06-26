package assignment3;

public class Node {
	public int num;
	public Node left;
	public Node right;

	Node(int num){this.num = num;}
	
	//Checks if numbers are prime
	public boolean isPrime()
	{
		boolean res = true;
		for (int i = 2; i <= Math.sqrt(num);i++){
			if(num%i==0){
				res = false;
				break;
			}
		}
		return(res);
	}//end of isPrime

}//End of Class Node

