// This class holds an array of coordinate objects.
package boundedwildcard;
public class Coords<T extends TwoD>
{
    T[] coords;
    Coords(T[] o)
    {
        coords = o;
    }
    
}
