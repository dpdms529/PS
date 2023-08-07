package p3425;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        ArrayList<String> commands = getCommands();

        while (!commands.isEmpty()) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(br.readLine());
                calculate(commands, num);
            }

            br.readLine();
            bw.write("\n");

            commands = getCommands();
        }

        bw.flush();

    }

    static ArrayList<String> getCommands() throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        String command = br.readLine();

        if (command.equals("QUIT")) return commands;


        while (!command.equals("END")) {
            commands.add(command);
            command = br.readLine();
        }

        commands.add(command);

        return commands;
    }

    static void calculate(ArrayList<String> commands, long num) throws IOException {
        Stack<Long> stack = new Stack<>();
        stack.push(num);

        for (String command : commands) {
            try {
                if (command.contains("NUM")) {
                    stack.push(Long.parseLong(command.split(" ")[1]));
                } else if (command.equals("POP")) {
                    stack.pop();
                } else if (command.equals("INV")) {
                    stack.push(-stack.pop());
                } else if (command.equals("DUP")) {
                    stack.push(stack.peek());
                } else if (command.equals("SWP")) {
                    Queue<Long> queue = new LinkedList<>();
                    queue.offer(stack.pop());
                    queue.offer(stack.pop());
                    stack.push(queue.poll());
                    stack.push(queue.poll());
                } else if (command.equals("ADD")) {
                    long tmp = stack.pop();

                    long result = stack.pop() + tmp;

                    if (Math.abs(result) > 1e9) {
                        throw new Exception();
                    }

                    stack.push(result);
                } else if (command.equals("SUB")) {
                    long tmp = stack.pop();

                    long result = stack.pop() - tmp;

                    if (Math.abs(result) > 1e9) {
                        throw new Exception();
                    }

                    stack.push(result);
                } else if (command.equals("MUL")) {
                    long tmp = stack.pop();

                    long result = stack.pop() * tmp;

                    if (Math.abs(result) > 1e9) {
                        throw new Exception();
                    }

                    stack.push(result);
                } else if (command.equals("DIV")) {
                    long tmp = stack.pop();

                    long result = stack.pop() / tmp;

                    if (Math.abs(result) > 1e9) {
                        throw new Exception();
                    }

                    stack.push(result);
                } else if (command.equals("MOD")) {
                    long tmp = stack.pop();

                    long result = stack.pop() % tmp;

                    if (Math.abs(result) > 1e9) {
                        throw new Exception();
                    }

                    stack.push(result);
                } else if (command.equals("END")) {
                    if (stack.size() != 1) {
                        throw new Exception();
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                }
            } catch (Exception e) {
                bw.write("ERROR\n");
                return;
            }
        }
    }
}