import java.util.HashMap;
import java.util.Map;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();

        for(int num:nums)
        {
            if(map.containsKey(num)==true)
            {
                return true;
            }
            map.put(num,true);
        }
        return false;
    }
}