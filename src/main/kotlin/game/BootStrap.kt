package game

import java.util.Random
import java.util.Scanner

const val startAsciiArt = """
               _.---._    /\\
            ./'       "--`\//
          ./              o \          .-----.
         /./\  )______   \__ \        ( hello!)
        ./  / /\ \   | \ \  \ \       /`-----'
           / /  \ \  | |\ \  \7--- ooo ooo ooo ooo ooo ooo
    """

fun main() {
    println(startAsciiArt)

    val scanner = Scanner(System.`in`)

    println("환영합니다.")
    println("섯다 게임입니다.")

    while (true) {

        println("카드를 섞는 중입니다...")
        //Thread.sleep(1000)
        println("3")
        //Thread.sleep(1000)
        println("2")
        //Thread.sleep(1000)
        println("1")
        //Thread.sleep(1000)

        println("====받은 카드=====")
        val c1 = Random().nextInt(10) //카드1
        val c2 = Random().nextInt(10) //카드2

        //Thread.sleep(1000)
        print("""
            +-------+   +-------+
            |   $c1   |   |   $c2   |
            +-------+   +-------+
        """.trimIndent())

        //Thread.sleep(1000)
        println()
        var confirm = 0
        while (confirm != 1) {
            println("====얼마를 배팅하겠습니까?====")
            println("현재 가진 금액: 100_000원")
            val batting = scanner.next()
            println("${batting}원을 배팅하겠습니까?")
            println("1: 예, 2: 재입력")
            confirm = scanner.nextInt()
        }
    }
}