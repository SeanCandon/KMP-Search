
public class KMPSearch {

  /*
   * Bus Service Questions:
   *
   * 1. How many total vehicles is there information on?
   *    987
   *
   * 2. Does the file contain information about the vehicle number 16555?
   *    Yes
   *
   * 3. Locate the first record about a bus heading to HAMPTON PARK
   *    19774
   *
   * 4. Does the file contain information about the vehicle number 9043409?
   *    No
   */
	
	private final static int depth = 256;
	
	private static int[][] createDFA(String pat) {
		
		int[][] dfa;
		int patLength = pat.length();
		dfa = new int[depth][patLength]; 
        dfa[pat.charAt(0)][0] = 1; 
        for (int x = 0, j = 1; j < patLength; j++) {
        	
            for (int y = 0; y < depth; y++) { 
                dfa[y][j] = dfa[y][x];   
            }
            
            dfa[pat.charAt(j)][j] = j+1;    
            x = dfa[pat.charAt(j)][x];      
        } 
        return dfa;
	}
	
   /*
    * The method checks whether a pattern pat occurs at least once in String txt.
    *
    */
	public static boolean contains(String txt, String pat) {
		
		if(txt.length()>0 && pat.length()>0) {
			int[][] dfa = createDFA(pat);
			int patLength = pat.length();
	        int txtLength = txt.length();
	        int i, j;
	        for (i = 0, j = 0; i < txtLength && j < patLength; i++) {
	            j = dfa[txt.charAt(i)][j];
	        }
	        if (j == patLength) return true;    // found
	        return false;
		}
		else {
			return false;
		}
		
	}
	
	/*
	* The method returns the index of the first ocurrence of a pattern pat in String txt.
	* It should return -1 if the pat is not present
	*/
	public static int searchFirst(String txt, String pat) {
		
		if(txt.length()>0 && pat.length()>0) {
			int[][] dfa = createDFA(pat);
			int patLength = pat.length();
	        int txtLength = txt.length();
	        int i, j;
	        for (i = 0, j = 0; i < txtLength && j < patLength; i++) {
	            j = dfa[txt.charAt(i)][j];
	        }
	        if (j == patLength) return i - patLength;    
	        return -1; 
		}
		else
			return -1;
		
	}
	
	/*
	* The method returns the number of non-overlapping occurences of a pattern pat in String txt.
	*/
	public static int searchAll(String txt, String pat) {
		
		if(txt.length()>0 && pat.length()>0) {
			int[][] dfa = createDFA(pat);
			int patLength = pat.length();
			int txtLength = txt.length();
			int i, j;
			int nextI = 0;
			int count = 0;
			boolean newFound = true;
			
			while(newFound && nextI<txtLength) {
				
				for (i = nextI, j = 0; i < txtLength && j < patLength; i++) {
		            j = dfa[txt.charAt(i)][j];
		        }
		        if (j == patLength) {
		        	count++;
		        	nextI = i;
		        }
		        else
		        	newFound = false; 
			}
			return count;
		}
		else
			return 0;
		
	}
	
	
}

