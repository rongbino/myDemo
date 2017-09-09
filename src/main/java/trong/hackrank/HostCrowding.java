package trong.hackrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by tommy on 2017/9/10.
 */
public class HostCrowding {
  public static void main(String[] args) {

  }

  public static String[] paginate(int num, String[] results) {
    if (num == 0 || results == null || results.length ==0) {
      return null;
    }

    List<String> re = new ArrayList<String>();
    List<String> reList = Arrays.asList(results);

    HashSet<String> allHostId = new HashSet<>();
    for (int i = 0; i <= reList.size(); i++) {
      String t = reList.get(i);
      String[] a = t.split(",");
      allHostId.add(a[0]);
    }

    // save the already used host in the list
    HashSet<String> id = new HashSet<>();

    while (id.size() != reList.size()) {
      int pageSize = 0;
      HashSet<String> hostId = new HashSet<>();

      // find the unique hostid
      for (int i = 0; i <= reList.size()-1; i++) {
        if (id.contains(String.valueOf(i))) {
          continue;
        }
        if (allHostId.size() == id.size()) {
          re.add(reList.get(i));
          id.add(String.valueOf(i));
          pageSize++;
        } else {
          String tmp = reList.get(i);
          String[] tt = tmp.split(",");
          if (!hostId.contains(tt[0])) {
            // add this host into result list
            re.add(reList.get(i));
            // mark this host already used
            id.add(String.valueOf(i));
            hostId.add(tt[0]);
            // page size plus one
            pageSize++;
          }
          // if this page alreay be five
          if (pageSize == num) {
            break;
          }
        }
      }
      re.add("");
    }

    String[] rr = new String[re.size()];
    for (int i = 0; i <= re.size()-1; i++) {
      rr[i] = re.get(i);
    }
    return rr;
  }
}
