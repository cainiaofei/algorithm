package cn.nju.algorithm.hiho;

import java.util.Scanner;

class Node{
	int x,y;
	public Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public void process() {
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt();
		int testCaseCount = scan.nextInt();
		for(int i = 0; i < testCaseCount;i++) {
			int leftX = scan.nextInt();
			int leftY = scan.nextInt();
			int rightX = scan.nextInt();
			int rightY = scan.nextInt();
			int count = getNodesCountInRegion(leftX,leftY,rightX,rightY,height);
			System.out.println(count);
		}
		scan.close();
	}
	
	private int getNodesCountInRegion(int leftX, int leftY, int rightX, int rightY, int height) {
		Node root = new Node(0,0);
		return dfs(root,height,leftX,leftY,rightX,rightY,height);
	}
	
	private int dfs(Node root,int curHeight,int leftX, int leftY,
			int rightX, int rightY,int height) {
		if(curHeight==0) {
			return 0;
		}
		else {
			int sum = 0;
			if(nodeInRegion(root,leftX,leftY,rightX,rightY)) {
				sum = 1;
			}
			int base = 2 * stickCount(height,curHeight);
			Node leftNode = new Node(root.x+base,root.y-base);
			Node rightNode = new Node(root.x+base, root.y+base);
			sum += dfs(leftNode,curHeight-1,leftX,leftY,rightX,rightY,height);
			sum += dfs(rightNode,curHeight-1,leftX,leftY,rightX,rightY,height);
			return sum;
		}
	}

	private int stickCount(int height,int curHeight) {
		if(height<=3) {
			return height-1;
		}
		return (int)Math.pow(2, height-curHeight+2)+1;
	}
	
	private boolean nodeInRegion(Node root, int leftX, int leftY, int rightX, int rightY) {
		return root.x>=leftX&&root.x<=rightX&&root.y>=leftY&&root.y<=rightY;
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.process();
	}
}
