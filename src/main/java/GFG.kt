import java.util.*


internal object GFG {

    fun check() {
        val adj: Vector<Vector<Int>> =
            Vector<Vector<Int>>(
                listOf(
                    Vector<Int>(listOf(5, 6)),
                    Vector<Int>(listOf()),
                    Vector<Int>(listOf(7))
                )
            )
        // our node values are Int
        // indices are always Int
        // adj[0][0] = 5
        // adj[node][indices]
        // two-depth therefore, two-d
    }

    // Function to print the parent of each node
    private fun printParents(
        node: Int, /* always starts from root node */
        adj: Vector<Vector<Int>>,
        starting: Int
    ) {
        // current node is Root, thus, has no parent
        if (starting == 0)
            println("$node->Root")
        else
            println("$node->$starting")

        //for leaf nodes this below loop doesn't apply as it never satisfies
        for (i in adj[node].indices) {
            //adj[1][0] = 2
            if (adj[node][i] != starting) {
                printParents(adj[node][i], adj, node)
            }
        }
    }

    // Function to print the children of each node
    private fun printChildren(
        node: Int, /* always starts from root node */
        adj: Vector<Vector<Int>>
    ) {

        // Queue for the BFS
        val q: Queue<Int> = LinkedList()

        // pushing the root
        q.add(node)

        // visit array to keep track of nodes that have been
        // visited
        val vis = IntArray(adj.size)
        Arrays.fill(vis, 0)

        // BFS
        while (q.size != 0) {
            val node = q.peek()
            q.remove()
            vis[node] = 1
            print("$node-> ")
            for (i in adj[node].indices) {
                if (vis[adj[node][i]] == 0) {
                    print(
                        adj[node][i]
                            .toString() + " "
                    )
                    q.add(adj[node][i])
                }
            }
            println()
        }
    }

    // Function to print the leaf nodes
    private fun printLeafNodes(
        node: Int, /* always starts from root node */
        adj: Vector<Vector<Int>>
    ) {

        // Leaf nodes have only one edge and are not the
        // root
        for (i in 1 until adj.size) if (adj[i].size == 1 && i != node) print("$i ")
        println()
    }

    // Function to print the degrees of each node
    private fun printDegrees(
        node: Int, /* always starts from root node */
        adj: Vector<Vector<Int>>
    ) {
        for (i in 1 until adj.size) {
            print("$i: ")

            // Root has no parent, thus, its degree is
            // equal to the edges it is connected to
            if (i == node) println(adj[i].size) else println(adj[i].size - 1)
        }
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {

        // Number of nodes
        val n = 7
        val root = 1

        // Adjacency list to store the tree
        val adj = Vector<Vector<Int>>()
        for (i in 0 until n + 1) {
            adj.add(Vector()) //like adding empty lists N+1 times≠
        }
        for (i in 0 until n + 1) {
            println("hi: $i")
        }
        //1 -> 2, 3, 4
        //2 -> 5, 6
        //3
        //4 -> 7

        // Creating the tree
        adj[1].add(2) //adj[1] means node 1. add node 2 in node 1
        adj[2].add(1) //why to add node 1 in node 2? this is to calculate degree of node

        adj[1].add(3)
        adj[3].add(1)

        adj[1].add(4)
        adj[4].add(1)

        adj[2].add(5)
        adj[5].add(2)

        adj[2].add(6)
        adj[6].add(2)

        adj[4].add(7)
        adj[7].add(4)

        // Printing the parents of each node
        println("The parents of each node are:")
        printParents(root, adj, 0)

        // Printing the children of each node
        println("The children of each node are:")
        printChildren(root, adj)

        // Printing the leaf nodes in the tree
        println("The leaf nodes of the tree are:")
        printLeafNodes(root, adj)

        // Printing the degrees of each node
        println("The degrees of each node are:")
        printDegrees(root, adj)
    }
}