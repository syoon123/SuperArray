/*****************************
The Hamburglars -- Sarah Yoon, Gabriel Marks
APCS1 pd10
HW40 -- Array of Grade 316
2015-12-02

* class SuperArray --  A wrapper class for an array. 
* Maintains functionality:
* access value at index
* overwrite value at index
* Adds functionality to std Java array:
* resizability
* ability to print meaningfully

PHASE II additions:
* public void add(int newVal) {} //add item after last item
* public void add(int index, int newVal) {} //insert item at index, shift existing elements to the right
* public void remove(int index) {} //remove item at index, shift elements to the left to fill newly empty slot
* public int size() {} //returns number of menainful elements in _data
*****************************/

public class SuperArray {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
    	_data = new int[10];
    	_lastPos = -1;
    	_size = 0;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	    if(_size == 0) return "[]";
	    String ret = "[" + _data[0];
	    for(int i = 1; i <= _lastPos; i++) {
	        ret += "," + _data[i];
	    }
	    return ret + "]";
    }
    
    //throws an error and stops execution if index too big
	private void checkIndex(int index) {
	    if(index > _lastPos) throw new ArrayIndexOutOfBoundsException();
    }	
    
    //double capacity of this SuperArray
    private void expand() {
    	int[] newArr = new int[_data.length*2];
    	for(int i=0; i<=_lastPos; i++){
    	    newArr[i]=_data[i];
    	}
    	_data = newArr;
    }
		
    //accessor -- return value at specified index
    public int get( int index ) {
        checkIndex(index);
    	return _data[index];
    }
		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
        checkIndex(index);
	    int oldVal = _data[index];
	    _data[index] = newVal;
	    return oldVal;
    }

    //adds item after last item
    public void add(int newVal) {
        add(_lastPos+1, newVal);
    }
    
    //adds item at index, shifts existing elements to the right
    public void add(int index, int newVal) {
	checkIndex(index);
	if (_size == _data.length) {
            expand();
        }
        for(int i = _size; i>index; i--) {
            _data[i] = _data[i-1];
        }
        _data[index] = newVal;
        _lastPos += 1;
        _size += 1;
    }
    
    //removes specified item and shifts array, changes size and lastpos accordingly
    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < _lastPos;i++) {
            _data[i] = _data[i+1];
        }
        _data[_lastPos] = 0; //make sure all unused data is 0 to make adding stuff easier
        _lastPos -= 1;
        _size -= 1;
    }
    
    public int size() {
        return _size;
    }
    //main method for testing
    public static void main( String[] args ) {
	//*****INSERT ADEQUATE TEST CALLS HERE*****
    	SuperArray a = new SuperArray();
    	System.out.println(a._size);
    	System.out.println(a._lastPos);
    	System.out.println(a);
    	a.expand();
    	System.out.println(a);
    	//System.out.println(a.get(14)); should error
    	a._lastPos = 10; // we can do this because in SuperArray.java
    	//System.out.println(a.get(14)); //should error
    	System.out.println(a.get(7));
    	System.out.println(a);
    	System.out.println(a._lastPos);
    	a._data = new int[]{1,2,3,4,5,6,7,8};
    	a._lastPos = 4;
    	a._size = 5;
    	System.out.println(a);
    	a.remove(2);
    	System.out.println(a);
    	a.remove(3); //test for removing last element
    	System.out.println(a);
    	a.add(1,3);
    	System.out.println(a);
    	a.add(4,5);
    	System.out.println(a);
    	a.add(6);
    	System.out.println(a);
    	System.out.println(a.size());
    }//end main
		
}//end class
