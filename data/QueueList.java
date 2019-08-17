package com.bridgelabz.oops;

public class QueueList<T>{
	int size;
	@SuppressWarnings("hiding")
	class Node<T>{   // creation of node
		T data;
		@SuppressWarnings("rawtypes")
		Node next;
	}
	
	@SuppressWarnings("rawtypes")
	Node front;		//front pointer
	@SuppressWarnings("rawtypes")
	Node rear;		//rear pointer
	
	public QueueList(int length) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void enqueue(T data)
	{
		
		Node node = new Node(); // new node to add element
		
		node.data=data;  	 //  assigning data to node
		node.next=null;		
		if( rear == null)	//comparing first node wether null or not
		{
			
			front=node;		// assigning first node as front 
			rear=node;		//assigning first node as rear
			size++;
		}
		else		
		{														
			Node n;
			n=front;
			while(n.next!=null)  // iteration to reach last node
			{
				n=n.next;
			}
			n.next=node;
			rear=node;
			size++;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public void print()						//to print the elements
	{
		Node n=front;
		
		while(n!=null)						// loop to reach the end
		{
			System.out.println(n.data);
			n=n.next;
		}

	}
	
	
	
	@SuppressWarnings({ "rawtypes" })
	public void dequeue()					// method to remove from list
	{
		Node n=front;						//reference of front node
		if(size==0)
		{
			System.out.println("stack empty");
		}else
		{
			System.out.println(n.data);
			n=n.next;
			front=n;
			size--;
		}
		
	}
	
	public boolean isEmpty()				//returns true if it is empty
	{
		if(size==0)							//comparing the size
		{
			return true;
		}else
			return false;
	}
	
	public int size()						//to return the size value
	{
		return size;
	}
	
}