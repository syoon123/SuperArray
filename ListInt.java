/* Team Plebes -- Sarah Yoon, Nick Ng
   APCS1 pd10
   HW42 -- Array of Titanium
   2015-12-04 */

public interface ListInt {
    void add(int index, int newVal);
    void add(int newVal);
    void remove(int index);
    int size();
    int set(int index, int newVal);
    int get(int index );
}
