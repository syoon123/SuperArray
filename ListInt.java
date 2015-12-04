/* Team Plebes -- Sarah Yoon, Nick Ng
   APCS1 pd10
   HW42 -- Array of Titanium
   2015-12-04 */

public interface ListInt {
    //adds item at index, shifts existing elements to the right
    void add(int index, int newVal);

    //adds item after last item
    void add(int newVal);

    //removes specifie item and shifts array, changes size and lastpos accordingly
    void remove(int index);

    //returns the number of meaningful elements
    int size();

    //changes value of element at index to newVal
    int set(int index, int newVal);

    //returns the value of the element at index
    int get(int index );
}
