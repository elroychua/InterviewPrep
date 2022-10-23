import java.util.*;

public class Solution {

  public static void main(String[] args) {
    System.out.println(solution("BAONXXOLL"));
  }

  public static String run_solution(int N) {
    // write your code in Java SE 8
    String answer = "";
    if (N % 2 == 1) {
      for (int i = 0; i < N; i++) answer += 'a';
    } else {
      for (int i = 0; i < N - 1; i++) {
        answer += 'a';
      }
      answer += 'b';
    }
    return answer;
  }

  public static int solution(String S) {
    //can use each char and text at most once, return max amt of balloons inside string.
    int[] char_count = new int[26];
    for (int i = 0; i < S.length(); i++) {
      //returns index in the array.
      char_count[S.charAt(i) - 'a']++;
    }
    //returns lowest occurence of BALLOONS.
    int min = char_count[1]; //B
    min = Math.min(min, char_count[0]); //A
    min = Math.min(min, char_count[11] / 2); // 2 Ls
    min = Math.min(min, char_count[14] / 2); //2 Os
    min = Math.min(min, char_count[13]); //N
    return min;
  }

  // Remember, all submissions are being checked for plagiarism.
  // Your recruiter will be informed in case suspicious activity is detected.
  // you can also use imports, for example:
  // you can write to stdout for debugging purposes, e.g.
  // System.out.println("this is a debug message");
  public int solution(int[] A) {
    //Use hashmap to hold keyvalue pairs
    Map<Integer, Integer> hash_map = new HashMap<>();
    int answer = -1;
    //iterate through array
    for (int temp : A) {
      //call for getSum func
      int sum = getSum(temp);
      //if it contains key sum, set answer to the max of both.
      if (hash_map.containsKey(sum)) answer =
        Math.max(answer, temp + hash_map.get(sum)); else hash_map.put(
        sum,
        Math.max(hash_map.getOrDefault(sum, 0), temp)
      );
    }
    return answer;
  }

  //method to getSum of digits.
  private int getSum(int num) {
    int result = 0;
    while (num > 0) {
      result += num % 10;
      num /= 10;
    }
    return result;
  }
}
