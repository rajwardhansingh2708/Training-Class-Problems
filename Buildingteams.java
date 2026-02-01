//giving tle

// import java.util.*;

// public class Buildingteams {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Input edges
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();

//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }

//         // Color array
//         int[] color = new int[n + 1];

//         boolean possible = true;

//         // BFS queue
//         Queue<Integer> q = new LinkedList<>();

//         // Loop for disconnected components
//         for (int i = 1; i <= n; i++) {

//             if (color[i] != 0)
//                 continue;

//             // Start BFS from this node
//             color[i] = 1;
//             q.add(i);

//             while (!q.isEmpty()) {

//                 int node = q.poll();

//                 for (int neigh : adj.get(node)) {

//                     if (color[neigh] == 0) {
//                         color[neigh] = -color[node];
//                         q.add(neigh);
//                     }

//                     else if (color[neigh] == color[node]) {
//                         possible = false;
//                         break;
//                     }
//                 }

//                 if (!possible)
//                     break;
//             }

//             if (!possible)
//                 break;
//         }

//         if (!possible) {
//             System.out.println("IMPOSSIBLE");
//             return;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (color[i] == 1)
//                 System.out.print("1 ");
//             else
//                 System.out.print("2 ");
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class Buildingteams {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // Coloring array
        int[] color = new int[n + 1];
        boolean possible = true;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        // BFS on every component
        for (int i = 1; i <= n; i++) {

            if (color[i] != 0)
                continue;

            color[i] = 1;
            q.add(i);

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int neigh : adj.get(node)) {

                    if (color[neigh] == 0) {
                        color[neigh] = -color[node];
                        q.add(neigh);
                    }

                    else if (color[neigh] == color[node]) {
                        possible = false;
                        break;
                    }
                }

                if (!possible)
                    break;
            }

            if (!possible)
                break;
        }

        // Output
        if (!possible) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(color[i] == 1 ? "1 " : "2 ");
        }

        System.out.print(sb.toString());
    }
}
