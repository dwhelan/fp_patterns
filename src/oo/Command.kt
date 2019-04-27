package oo

import Light
import Door

interface Command {
    fun execute(): Unit
}

class TurnOn(val light: Light) : Command {
    override fun execute() { light.on() }
}

class Open(val door: Door) : Command {
    override fun execute() { door.open() }
}

class Greet(val door: Door, val message: String) : Command {
    override fun execute() { door.greet(message) }
}

class Sequencer(val commands: List<Command>) : Command {
    override fun execute() { commands.forEach { command -> command.execute() } }
}
