package codetree.samsung2023_2_am.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, Q;
    static ChatRoom root = new ChatRoom(0, 0, true);
    static Map<Integer, ChatRoom> chatRoomMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Q; i++) {
            String[] cmd = br.readLine().split(" ");
            int c = 0;

            switch (cmd[0]) {
                case "100":
                    int[] parents = new int[N + 1];
                    int[] authority = new int[N + 1];

                    for (int j = 1; j <= N; j++) {
                        parents[j] = Integer.parseInt(cmd[j]);
                    }
                    for (int j = 1; j <= N; j++) {
                        authority[j] = Integer.parseInt(cmd[N + j]);
                    }

                    init(parents, authority);

                    break;
                case "200":
                    c = Integer.parseInt(cmd[1]);
                    switchAlarm(c);
                    break;
                case "300":
                    c = Integer.parseInt(cmd[1]);
                    int power = Integer.parseInt(cmd[2]);
                    changeAuthority(c, power);
                    break;
                case "400":
                    c = Integer.parseInt(cmd[1]);
                    int c2 = Integer.parseInt(cmd[2]);
                    changeParent(c, c2);
                    break;
                case "500":
                    c = Integer.parseInt(cmd[1]);
                    getAlarmCnt(c);
                    break;
            }
        }

    }

    static void init(int[] parents, int[] authority) {
        chatRoomMap.put(0, root);

        for (int i = 1; i <= N; i++) {
            ChatRoom parent = chatRoomMap.getOrDefault(parents[i], new ChatRoom(parents[i], authority[parents[i]], true));

            ChatRoom chatRoom = chatRoomMap.getOrDefault(i, new ChatRoom(i, authority[i], true));
            chatRoom.setParent(parent);

            if (parent.hasLeft()) parent.setRight(chatRoom);
            else parent.setLeft(chatRoom);

            chatRoomMap.put(parents[i], parent);
            chatRoomMap.put(i, chatRoom);
        }
    }

    static void switchAlarm(int c) {
        ChatRoom chatRoom = chatRoomMap.get(c);
        chatRoom.setAlarm();
        chatRoomMap.put(c, chatRoom);
    }

    static void changeAuthority(int c, int power) {
        ChatRoom chatRoom = chatRoomMap.get(c);
        chatRoom.setAuthority(power);
        chatRoomMap.put(c, chatRoom);
    }

    static void changeParent(int c1, int c2) {
        ChatRoom chatRoom1 = chatRoomMap.get(c1);
        ChatRoom chatRoom2 = chatRoomMap.get(c2);

        chatRoom1.changeParent(chatRoom2);

        chatRoomMap.put(c1, chatRoom1);
        chatRoomMap.put(c2, chatRoom2);
    }

    static void getAlarmCnt(int c) {
        ChatRoom chatRoom = chatRoomMap.get(c);
        int alarmCnt = chatRoom.getAlarmCnt(1);
        System.out.println(alarmCnt);
    }


    static class ChatRoom {
        ChatRoom parent;
        ChatRoom left;
        ChatRoom right;
        int idx;
        int authority;
        boolean alarm;

        public ChatRoom(int idx, int authority, boolean alarm) {
            this.idx = idx;
            this.authority = authority;
            this.alarm = alarm;
        }

        void setAlarm() {
            alarm = !alarm;
        }

        void setAuthority(int power) {
            authority = power;
        }

        void setParent(ChatRoom parent) {
            this.parent = parent;
        }

        void setLeft(ChatRoom left) {
            this.left = left;
        }

        void setRight(ChatRoom right) {
            this.right = right;
        }

        void changeParent(ChatRoom c) {
            if (parent.isLeft(this)) {
                parent.left = c;
            } else {
                parent.right = c;
            }

            if (c.parent.isLeft(c)) {
                c.parent.left = this;
            } else {
                c.parent.right = this;
            }

            ChatRoom tmp = parent;
            parent = c.parent;
            c.parent = tmp;

        }

        boolean isLeft(ChatRoom c) {
            return left.equals(c);
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean isAlarmOn() {
            return alarm;
        }

        int getAlarmCnt(int depth) {
            int cnt = 0;
            if (left != null && right != null && left.isAlarmOn() && right.isAlarmOn()){
                if(depth <= left.authority) cnt++;
                if(depth <= right.authority) cnt++;
                return left.getAlarmCnt(depth + 1) + right.getAlarmCnt(depth + 1) + cnt;
            } else if (left != null && left.isAlarmOn()) {
                if(depth <= left.authority) cnt++;
                return left.getAlarmCnt(depth + 1) + cnt;
            } else if (right != null && right.isAlarmOn()) {
                if(depth <= right.authority) cnt++;
                return right.getAlarmCnt(depth + 1) + cnt;
            } else return 0;
        }

        @Override
        public String toString() {
            String parent = this.parent == null ? "." : String.valueOf(this.parent.idx);
            String left = this.left == null ? "." : String.valueOf(this.left.idx);
            String right = this.right == null ? "." : String.valueOf(this.right.idx);

            return "ChatRoom{" +
                    "parent=" + parent +
                    ", left=" + left +
                    ", right=" + right +
                    ", idx=" + idx +
                    ", authority=" + authority +
                    ", alarm=" + alarm +
                    '}';
        }
    }
}
