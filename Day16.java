/*
*  DAY 16:
* 
*  You run an e-commerce website and want to record the last N order ids in a log.
*  Implement a data structure to accomplish this, with the following API:
*
*  record(order_id): adds the order_id to the log
*  get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
*
*/

public class Day16 {
  public static void main(String[] args) {
    Log log = new Log(5);
    log.record(0);
    log.record(1);
    log.record(2);
    log.record(3);
    log.record(4);


    // Should print in reverse
    System.out.println(log.getLast(1));
    System.out.println(log.getLast(2));
    System.out.println(log.getLast(3));
    System.out.println(log.getLast(4));
    System.out.println(log.getLast(5));
  }

  public static class Log {
    private int[] log;
    private int nextLoc = 0;

    public Log(int size) {
      this.log = new int[size];
    }

    public void record(int orderId) {
      log[nextLoc] = orderId;
      nextLoc = (nextLoc + 1) % log.length;
    }

    public int getLast(int i) {
      return log[(nextLoc + log.length - i) % log.length];
    }

  }
}