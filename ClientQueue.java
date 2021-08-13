class ClientQueue{
    private Client head, curr, last;
    public ClientQueue(){
        head = null;
    }
    //Add new client
    public void enqueue(int t, int u){
        //Check if queue is empty
        if(isEmpty()){
            //Put first client in queue
            head = new Client(t, u);
            //Set last to head
            last = head;
            return;
        }
        //Set curr to last
        curr = last;
        //Add new client
        curr.next = new Client(t, u);
        //Set last to latest client
        last = curr.next;
        return;
    }
    //Remove first client in queue
    public void dequeue(){
        //Check if empty
        if(!(isEmpty())){
            //Dereference head
            Client tmp = head;
            //If not empty then remove the front
            head = head.next;
            tmp.next = null;
            if(isEmpty()){
                last = null;
            }
            return;
        }
        return;
    }
    //Return arrival time of client at front of queue
    public int peekArrive(){
        //Check for empty
        if(!(isEmpty())){
            //Return first client arrTime
            return head.arrTime;
        }
        return -1;
    }
    //Return the usage time of client at front of queue
    public int peekUsage(){
        //Check for empty
        if(!(isEmpty())){
            //Return first client useTime
            return head.useTime;
        }
        return -1;
    }
    //Returns whether or not the queue is empty
    public boolean isEmpty(){
        //Check for head
        if(head == null){
            return true;
        }
        //If head exists then return false
        return false;
    }
    //Return the length of the queue
    public int length(){
        //Start count
        int count = 0;
        //Set head
        curr = head;
        //Check if the curr is non null
        while(curr != null){
            //Increase count
            count++;
            //Set next client
            curr = curr.next;
        }
        return count;
    }
    class Client{
        int arrTime, useTime;
        Client next;
        public Client(int t, int u){
            arrTime = t;
            useTime = u;
        }
    }
}
