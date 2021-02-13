/*
*  DAY 11:
* 
*  Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
*  return all strings in the set that have s as a prefix.
*
*  For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
*
*
*/

import java.util.*;

public class Day11 {
  public static void main(String[] args) {
    String searchWord = "de";
    String[] products = {"dog", "deer", "deal"};

    List<List<String>> results = suggestedProducts(products, searchWord);

    for (List<String> resultSet : results) {
      System.out.print("[");
      for (String result : resultSet) {
        System.out.print(" " + result + " ");
      }
      System.out.print("]");
    }
  }

  public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for (String p : products) {
      trie.insert(p);
    }

    List<List<String>> resultList = new ArrayList<>();

    for (int i = 0; i < searchWord.length(); i++) {
      String prefixSoFar = searchWord.substring(0, i + 1);
      List<String> resultsForPrefix = trie.searchForPrefix(prefixSoFar);
      resultList.add(resultsForPrefix);
    }

    return resultList;
  }

  static class Trie {
    TrieNode root;
    List<String> resultSet;

    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String rawStr) {
      TrieNode curr = root;
      String normalizedStr = rawStr.trim().toLowerCase();

      for (int i = 0; i < normalizedStr.length(); i++) {
        char c = normalizedStr.charAt(i);
        int trieIndex = c - 'a';

        TrieNode potentialNext = curr.children[trieIndex];

        if (potentialNext == null) {
          TrieNode newNode = new TrieNode();
          curr.children[trieIndex] = newNode;
          curr = newNode;
        } else {
          curr = potentialNext;
        }
      }

      curr.isWord = true;
    }

    public List<String> searchForPrefix(String prefix) {
      this.resultSet = new ArrayList<String>();
      TrieNode curr = this.root;
      String normalizedPrefix = prefix.trim().toLowerCase();

      for (int i = 0; i < normalizedPrefix.length(); i++) {
        char c = normalizedPrefix.charAt(i);
        int trieIndex = c - 'a';
        curr = curr.children[trieIndex];

        if (curr == null) {
          return this.resultSet;
        }
      }

      searchForPrefix(curr, prefix);

      List<String> resultsToReturn = new ArrayList<>(this.resultSet);
      this.resultSet.clear();
      return resultsToReturn;
    }

    public void searchForPrefix(TrieNode curr, String word) {
      if (curr == null) {
        return;
      }

      if (curr.isWord) {
        this.resultSet.add(word);
      }

      for (int i = 0; i < 26; i++) {
        if (resultSet.size() == 3) {
          break;
        }

        TrieNode potentialNext = curr.children[i];
        searchForPrefix(potentialNext, word + (char) ('a' + i));
      }
    }

    class TrieNode {
      TrieNode[] children;
      boolean isWord;

      public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
      }
    }
  }
}