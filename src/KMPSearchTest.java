import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

public class KMPSearchTest {

	  @Test
	  public void testEmpty(){
	    assertEquals("Empty text or pattern is invalid",-1,KMPSearch.searchFirst("",""));
	    assertEquals("Empty text or pattern is invalid",0,KMPSearch.searchAll("",""));
	    assertFalse("Empty text or pattern is invalid",KMPSearch.contains("",""));
	  }
	  
	  @Test
	  public void testNoOccurence() {
		  
		  String txt = "wdffegfhhghjjtmHELLOsdgsfh";
		  String pat = "Hello";
		  assertEquals("Test search first with text with no occurence of pattern", -1, KMPSearch.searchFirst(txt, pat));
		  assertEquals("Test search all with text with no occurence of pattern", 0, KMPSearch.searchAll(txt, pat));
		  assertFalse("Test contains with text with no occurence of pattern", KMPSearch.contains(txt, pat));
		  
	  }
	  
	  @Test
	  public void testOneOccurence() {
		  
		  String txt = "gthirthjgvHello";
		  String pat = "Hello";
		  assertEquals("Test search first with text with one occurence of pattern", 10, KMPSearch.searchFirst(txt, pat));
		  assertEquals("Test search all with text with one occurence of pattern", 1, KMPSearch.searchAll(txt, pat));
		  assertTrue("Test contains with text with one occurence of pattern", KMPSearch.contains(txt, pat));
		  
	  }
	  
	  @Test
	  public void testTwoOccurences() {
		  
		  String txt = "wdfgfhHelloghghghfgHellorehgh";
		  String pat = "Hello";
		  assertEquals("Test search first with text with two occurences of pattern", 6, KMPSearch.searchFirst(txt, pat));
		  assertEquals("Test search all with text with two occurences of pattern", 2, KMPSearch.searchAll(txt, pat));
		  assertTrue("Test contains with text with two occurences of pattern", KMPSearch.contains(txt, pat));
		  
	  }
	  
	  @Test
	  public void testOverlap() {
		  
		  String txt = "fjnfgohHAHAHAHAfbgfng";
		  String pat = "HAHAHA";
		  assertEquals("Test search first with text with overlapping occurences of pattern", 7, KMPSearch.searchFirst(txt, pat));
		  assertEquals("Test search all with text with overlapping occurences of pattern", 1, KMPSearch.searchAll(txt, pat));
		  assertTrue("Test contains with text with overlapping occurences of pattern", KMPSearch.contains(txt, pat));
		  
	  }
	  
	  
	  /*public static void main(String[] args) {
		  
		  
		  String txt = readFile("BUSES_SERVICE_0.json");
		  System.out.println(KMPSearch.searchAll(txt, "VehicleNo"));
		  System.out.println(KMPSearch.contains(txt, "16555"));
		  System.out.println(KMPSearch.searchFirst(txt, "HAMPTON PARK"));
		  System.out.println(KMPSearch.contains(txt, "9043409"));
	  }
	  
	  public static String readFile(String filename) {
		    String result = "";
		    try {
		        BufferedReader br = new BufferedReader(new FileReader(filename));
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            sb.append(line);
		            line = br.readLine();
		        }
		        result = sb.toString();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		    return result;
		}
  */
  
  
}
