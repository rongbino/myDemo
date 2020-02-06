package trong.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie.Hit;
import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;

import sizeof.agent.SizeOfAgent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;

public class HaNLP {

  public static void main(String[] args) {
    TreeMap<String, String> map = new TreeMap<>();
    String[] keyArray = new String[]
        {
            "hers",
            "his",
            "she",
            "he",
            "tommy"
        };

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rongbin/test.csv"));
      String line = bufferedReader.readLine();
      int lineNumber = 1;
      System.out.println("start : " + new Date());
      while (line != null) {
        lineNumber += 1;
        String[] strs = line.split(",");
        String word = strs[2].replace("\"", "");
//        System.out.println("word :" + word);
        map.put(word, word);
        line = bufferedReader.readLine();
        
        // limit 1 million
        if (lineNumber == 250000) {
        	break;
        }
      }
      bufferedReader.close();

      System.out.println("map done : " + new Date());
//      for (String key : keyArray) {
//        map.put(key, key);
//      }
      System.out.println(map.size());
      AhoCorasickDoubleArrayTrie<String> act = new AhoCorasickDoubleArrayTrie<>();
      act.build(map);
      
      final String text = "d442f1089bcddfsdfd";
      
      act.parseText("1234", new AhoCorasickDoubleArrayTrie.IHit<String>() {
        @Override
        public void hit(int begin, int end, String value) {
          System.out.printf("[%d:%d]=%s\n", begin, end, value);
        }
      });
      System.out.println("tree done : " + new Date());
      
      System.out.println("DoubleArrayTree Size :" + SizeOfAgent.fullSizeOf(1));
      System.out.println("DoubleArrayTree Size :" + SizeOfAgent.fullSizeOf(act));
      
      
      // wait for input to exit
      Scanner userInput = new Scanner(System.in);
      while(true) {
          System.out.println("Ready for a new command sir.");
          String input = userInput.nextLine();
          System.out.println("input is '" + input + "'");
          if (!input.isEmpty()) {
              break;
          }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
