//B implements the nested interface
package nestedinterface;
class B implements A.NestedIF
{
    @Override
    public boolean isNotNegative(int x)
    {
        return x >= 0;
    }    
}
