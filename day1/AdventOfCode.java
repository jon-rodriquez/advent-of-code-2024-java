package day1;

import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class AdventOfCode {
  public static void main(String... args) {
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    Path filePath = Paths.get("./day1/day1.txt");

    try (Stream<String> lines = Files.lines(filePath)) {
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
    System.out.println(sum);
  }
}
