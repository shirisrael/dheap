/**
 * D-Heap
 */

public class DHeap
{
	
    private int size, max_size, d;
    private DHeap_Item[] array;

	// Constructor
	// m_d >= 2, m_size > 0
    DHeap(int m_d, int m_size) {
               max_size = m_size;
			   d = m_d;
               array = new DHeap_Item[max_size];
               size = 0;
    }
	
	/**
	 * public int getSize()
	 * Returns the number of elements in the heap.
	 */
	public int getSize() {
		return size;
	}
	
  /**
     * public int arrayToHeap()
     *
     * The function builds a new heap from the given array.
     * Previous data of the heap should be erased.
     * preconidtion: array1.length() <= max_size
     * postcondition: isHeap()
     * 				  size = array.length()
     * Returns number of comparisons along the function run. 
	 */
    public int arrayToHeap(DHeap_Item[] array1) 
    {
        return; // just for illustration - should be replaced by student code
    }

    /**
     * public boolean isHeap()
     *
     * The function returns true if and only if the D-ary tree rooted at array[0]
     * satisfies the heap property or has size == 0.
     *   
     */
    public boolean isHeap() 
    {
    	//intuition: check the order of the keys in the heap
    	// meaning - if the children of each parent are bigger than the parent
    	// for each node we need to check if its children are in the tree
	// if they are, we need to check if they are bigger than their parent
	 // we need take in consideration parents that does not have d children
    	for (int i=0; i<size; i++){
		if (child(i,1,this.d)>=this.max_size){
			return true;
		}
		for (int j=1;j<=this.d; j++){
			if ((this.array[child(i,j,this.d)]!=null) && (this.array[child(i,j,this.d)].getKey()<this.array[i].getKey()){
				return false;
			}
		}
		return true;
	}

 /**
     * public static int parent(i,d), child(i,k,d)
     * (2 methods)
     *
     * precondition: i >= 0, d >= 2, 1 <= k <= d
     *
     * The methods compute the index of the parent and the k-th child of 
     * vertex i in a complete D-ary tree stored in an array. 
     * Note that indices of arrays in Java start from 0.
     */
    public static int parent(int i, int d) { 
    	if (i==0){
    		return -1;
    	}
    	if (d==1){
    		return i-1;
    	}
    	return ((i-1)/d);
    }
    public static int child (int i, int k, int d) {
    	if ((k<1) || (d<k)){
    		return -1;
    	}
    	if ((d==1) && (k==1)){
    		return i+1;
    	}
    	if(i*d +k<=this.max_size){
    		return (i*d +k);
    	}
    	return -1;
   } 

    /**
    * public int Insert(DHeap_Item item)
    *
	* Inserts the given item to the heap.
	* Returns number of comparisons during the insertion.
	*
    * precondition: item != null
    *               isHeap()
    *               size < max_size
    * 
    * postcondition: isHeap()
    */
    public int Insert(DHeap_Item item) 
    {        
    	if (item==null) {return -1;}
    	if ((this.isHeap()) && (getSize()<this.max_size)){
    		this.array[size]=item;
    	}
     	int changes = heapifyUp(this.array[getSize()-1]);
    	return changes;
    }
			    
 /**
    * public int Delete_Min()
    *
	* Deletes the minimum item in the heap.
	* Returns the number of comparisons made during the deletion.
    * 
	* precondition: size > 0
    *               isHeap()
    * 
    * postcondition: isHeap()
    */
    public int Delete_Min()
    {
     	// should be replaced by student code
    }


    /**
     * public DHeap_Item Get_Min()
     *
	 * Returns the minimum item in the heap.
	 *
     * precondition: heapsize > 0
     *               isHeap()
     *		size > 0
     * 
     * postcondition: isHeap()
     */
    public DHeap_Item Get_Min()
    {
	return null;// should be replaced by student code
    }
	
  /**
     * public int Decrease_Key(DHeap_Item item, int delta)
     *
	 * Decerases the key of the given item by delta.
	 * Returns number of comparisons made as a result of the decrease.
	 *
     * precondition: item.pos < size;
     *               item != null
     *               isHeap()
     * 
     * postcondition: isHeap()
     */
    public int Decrease_Key(DHeap_Item item, int delta)
    {
	return;// should be replaced by student code
    }
	
	  /**
     * public int Delete(DHeap_Item item)
     *
	 * Deletes the given item from the heap.
	 * Returns number of comparisons during the deletion.
	 *
     * precondition: item.pos < size;
     *               item != null
     *               isHeap()
     * 
     * postcondition: isHeap()
     */
    public int Delete(DHeap_Item item)
    {
	return;// should be replaced by student code
    }
	
	/**
	* Sort the input array using heap-sort (build a heap, and 
	* perform n times: get-min, del-min).
	* Sorting should be done using the DHeap, name of the items is irrelevant.
	* 
	* Returns the number of comparisons performed.
	* 
	* postcondition: array1 is sorted 
	*/
	public static int DHeapSort(int[] array1, int d) {
		int i=0;
		while (array1[i]==null){
				i++;
		}
		if (i==0){
			return 0;
		}
		int adjustments = 0;
		int local_adj = 0;
		int half_size=(int)Math.floor((double) (i/2));
		for (int j=half_size-1; j>=0; j--){
			local_adj = heapifyDown(array1,j);
			adjustments = adjustments + local_adj;
		}
		return adjustments;
	}
}
