package com.bridgelabz.oops;

public class StackList<T> 
{
@SuppressWarnings("rawtypes")
static Node head;
	
	public static class Node<T>
	{
		public T data;
		public Node<T> next;
		
		public Node(T d)
		{
			data=d;
			next=null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int size()
	{
		int count=0;
		Node<T> temp=head;
		
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		System.out.println("size:"+count);
		return count;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  T last(T new_data)
	{
		Node new_node=new Node(new_data);
		
		if(head==null)
		{
			head=new_node;
			//System.out.printf("%4d",new_node.data);
			//System.out.println(""+head.data);
			return null;
		}
		else
		{	
			new_node.next=null;
			Node last=head;
			//System.out.printf("%4 ",new_node.data);
			//System.out.println(""+new_node.data);
			while(last.next!=null)
			{
				last=last.next;
			}
			//System.out.printf("%4d",new_node.data);
			last.next=new_node;
			
		}
		return new_data;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T push(T new_data)
	{
		Node new_node=new Node(new_data);
		
		new_node.next=head;
		head=new_node;
		//System.out.println("push:"+new_node.data);
	
		return (T) new_node.data;
	}
	
	@SuppressWarnings("unchecked")
	public boolean find(String key)
	{

		Node<String> temp=head;
		while(temp!=null)
		{
			if(temp.data.compareTo(key)==0)
			return true;
			temp=temp.next;
		}
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T search(String key)
	{
		Node<String> temp=head;
		Node prev_node=head;
		
		while(temp.data.compareTo(key)!=0)
		{
			
			temp = temp.next;
			
		}
		
		while(prev_node.next != temp)
		{
			
			prev_node = prev_node.next;
		}
		prev_node.next=temp.next; 
		temp.next=null;
		return null;
	
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(T data)
	{
		Node temp = new Node(data);
		
		if(head==null)
		{
			head = temp;
			//System.out.println("List:"+head.data);
		}
		else
		{
			Node p;
			p = head;
			while(p.next != null)
			{
				p = p.next;
				
			}
			//System.out.println("list:"+p.data);
			p.next = temp;
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	public T print()
	{
		Node temp=head;
		
		//System.out.println("Stack linkedlist:");
		while(temp!=null)
		{
			
			System.out.println(temp.data);
			//System.out.println("----------------------------------------------");
			temp=temp.next;	
			
		}
		return null;
		
	}
	@SuppressWarnings("rawtypes")
	public void displayList()
	{
		Node temp;
			temp =head;
			while(temp!= null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		
	}
}