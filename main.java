public class MyClass {
    public static void main(String args[]) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(1);
        sl.add(-1);
        sl.add(3);
        sl.add(99);
        sl.add(5);
        sl.add(6);
        
        
        
        System.out.println("- - - - -  Start - - - - ");
        System.out.println("Test add, removeTail");
        sl.removeTail();
        sl.add(7);
           
        
        sl.print();
        
        System.out.println("Test removeGreaterThanValue");
        
        sl.removeGreaterThanValue(50);
        
        sl.print();
    }
}

class Node  {
	private int value ; 
	private Node nextRef ;
	
	
	public int getValue (){
		return value ; 
	}
	
	public void setValue(int value){
		this.value =  value ;
	}
	
	public Node getNextRef(){
		return this.nextRef ; 
	}
	
	public void setNextRef(Node nextRef){
		this.nextRef =  nextRef ; 
	}
}

 class SinglyLinkedList {
    private Node head ; 
    private Node tail ; 
    
    public void add(int  element){
        Node node = new Node();
        node.setValue(element);
        // case of linked list is empty 
        if(head == null){
            head = node ; 
            tail = node ; 
        } else {
            tail.setNextRef(node);
            tail =  node ; 
        }
    }
    
    public void removeTail () {
        Node prev =  null ; 
        
        if(head != null){
            // if nextRef == null, so this element is tail and make it null
            // make tail == prev element
            Node currentNode =  head ; 
            while(currentNode.getNextRef() != null){
                prev = currentNode ; 
                currentNode = currentNode.getNextRef();
            }
            tail = prev ; 
            tail.setNextRef(null);
            
        }
    }
    
    public void removeGreaterThanValue (int value) {
        Node prev =  null ; 
        Node currentNode = head ; 
        
        do{
            // check first elemnt 
            if(prev == null && currentNode.getValue() > value ){
                head =  currentNode.getNextRef();
            }
            
            // check middle element 
            else if(prev !=null && currentNode.getValue() > value  ){
                prev.setNextRef(currentNode.getNextRef());
            }
            // this node is valid make it next prev
            else{
                prev= currentNode ; 
            }
            
            
            
            // move to next elemnt 
            currentNode =  currentNode.getNextRef();
            
           
            
      
        }
        while(currentNode != null);
        
        // reassing tail
        tail =  prev ; 
        
    }
    
    
    
    
    public void print () {

            Node currentNode =  head ; 
            while(currentNode != null){
                System.out.println(currentNode.getValue());
                currentNode = currentNode.getNextRef();
            }
    }
    
}
