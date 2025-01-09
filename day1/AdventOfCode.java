package day1;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AdventOfCode {
  public static void main(String... args) {
    String path = "./day1/day1.txt";
    Path filePath = Paths.get(path);
    AdventOfCode.part1(filePath);
    AdventOfCode.part2(filePath);
  }

  public static void part1(Path path) {
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();

    try (Stream<String> lines = Files.lines(path)) {
      lines.forEach(line -> {
        String[] parts = line.split(" ", 2);
        left.add(Integer.parseInt(parts[0].trim()));
        right.add(Integer.parseInt(parts[1].trim()));

      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(left);
    Collections.sort(right);
    int sum = 0;
    for (int i = 0; i < left.size(); i++) {

      sum += Math.abs(right.get(i) - left.get(i));
    }
    System.out.println("part 1: " + sum);
  }

  public static void part2(Path path) {
    Map<String, Integer> rightCount = new HashMap<>();
    List<Integer> left = new ArrayList<Integer>();

    try (Stream<String> lines = Files.lines(path)) {
      lines.forEach(line -> {
        String[] parts = line.split(" ", 2);
        left.add(Integer.parseInt(parts[0].trim()));

        if (rightCount.containsKey(parts[1].trim())) {
          rightCount.put(parts[1].trim(), rightCount.get(parts[1].trim()) + 1);
        } else {
          rightCount.put(parts[1].trim(), 1);
        }
      });

      int sum = 0;
      for (int i = 0; i < left.size(); i++) {
        if (rightCount.containsKey(Integer.toString(left.get(i)))) {
          sum += left.get(i) * rightCount.get(Integer.toString(left.get(i)));
        }
      }

      System.out.println("part 2: " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
