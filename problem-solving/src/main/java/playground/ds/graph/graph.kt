package playground.ds.graph

import java.util.LinkedList
import java.util.Queue

class Connection(
    val node: Node,
    val weight: Int,
)

class Node(
    val name: String,
    val links: MutableList<Connection> = LinkedList(),
    var visited: Boolean = false
) {

    fun link(node: Node, weight: Int) {
        links.add(Connection(node = node, weight = weight))
    }

    fun visit() {
        this.visited = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String = this.name
}

fun main() {
    val a = Node(name = "A")
    val b = Node(name = "B")
    val c = Node(name = "C")
    val d = Node(name = "D")
    val e = Node(name = "E")

    a.link(d, 2)
    b.link(a, 5)
    b.link(c, 6)
    b.link(e, 4)
    c.link(b,6)
    d.link(c,2)
    e.link(d,3)

    val target = e

    val queue: Queue<Connection> = LinkedList()
    queue.offer(Connection(a, 0))

    while (!queue.isEmpty()) {
        val con = queue.poll()
        val n = con.node
        val weight = con.weight
        n.visit()

        println("$n($weight)")

        if (n == target) {
            println("FOUND!!")
            break
        }

        n.links.filter { !it.node.visited }
            .filter { !queue.contains(it) }
            .map { Connection(it.node, it.weight + weight) }
            .forEach { queue.offer(it) }
    }
}