package p3425.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = br.readLine();

        while (!command.equals("QUIT")) {
            Calculator calculator = new Calculator();

            while (!command.equals("END")) {
                calculator.addCommand(command);
                command = br.readLine();
            }

            int count = Integer.parseInt(br.readLine());

            for (int i = 0; i < count; i++) {
                calculator.calculate(Long.parseLong(br.readLine()));
            }

            System.out.println();

            br.readLine();
            command = br.readLine();
        }
    }

}

class Calculator {
    private List<String> commands = new ArrayList<>();

    void addCommand(String command) {
        commands.add(command);
    }

    void calculate(Long x) {
        Stack<Long> stack = new Stack<>();
        stack.push(x);

        try {
            for (String command : commands) {
                if (command.length() > 3) {
                    String[] NUM = command.split(" ");
                    stack.push(Long.parseLong(NUM[1]));
                } else {
                    Long tmp;

                    switch (command) {
                        case "POP":
                            stack.pop();
                            break;
                        case "INV":
                            stack.push(-stack.pop());
                            break;
                        case "DUP":
                            stack.push(stack.peek());
                            break;
                        case "SWP":
                            Queue<Long> queue = new LinkedList<>();
                            queue.offer(stack.pop());
                            queue.offer(stack.pop());
                            stack.push(queue.poll());
                            stack.push(queue.poll());
                            break;
                        case "ADD":
                            tmp = stack.pop();
                            Long add = stack.pop() + tmp;

                            if(Math.abs(add) > 1e9) {
                                throw new Exception();
                            }

                            stack.push(add);
                            break;
                        case "SUB":
                            tmp = stack.pop();
                            Long sub = stack.pop() - tmp;

                            if(Math.abs(sub) > 1e9) {
                                throw new Exception();
                            }

                            stack.push(sub);
                            break;
                        case "MUL":
                            tmp = stack.pop();
                            Long mul = stack.pop() * tmp;

                            if(Math.abs(mul) > 1e9) {
                                throw new Exception();
                            }

                            stack.push(mul);
                            break;
                        case "DIV":
                            tmp = stack.pop();
                            Long div = stack.pop() / tmp;

                            if(Math.abs(div) > 1e9) {
                                throw new Exception();
                            }

                            stack.push(div);
                            break;
                        case "MOD":
                            tmp = stack.pop();
                            Long mod = stack.pop() % tmp;

                            if(Math.abs(mod) > 1e9) {
                                throw new Exception();
                            }

                            stack.push(mod);
                            break;
                    }
                }
            }

            if (stack.size() != 1) {
                throw new Exception();
            }

            System.out.println(stack.pop());
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}
